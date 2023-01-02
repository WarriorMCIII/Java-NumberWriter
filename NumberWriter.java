package com.hasan.numberWriter;

/*
 * To be able to write bigger numbers, go to line 69
 */

public class NumberWriter {	
	public static String writeNumber(String input) {
		input = input.replace(" ", "");
		String output = "";
		int d3dig = 0;
		int categorie = 0;
		boolean isNegative = false;
		
		if(Character.compare(input.charAt(0), '-') == 0) {
			isNegative = true;
			input = input.substring(1);
		}
		while(input.length() > 0) {
			int startPos = Math.max(0, input.length() - 3);
			d3dig = Integer.valueOf(input.substring(startPos));
			input = input.substring(0, startPos);
			if(d3dig != 0) {
				output = writeHundreds(d3dig, output) + " " + Numbers.categories[categorie] + output;
			}
			categorie++;
		}
		if(output == "") {
			output = "Zero";
		}
		if(isNegative) {
			output = "Minus " + output;
		}
		return output.trim();
	}
	
	private static String writeTens(long input, String output) {
		if(input%100 == 00) {
			return output;
		}
		if(input >= 100) {
			output += " and ";
		}
		if(input%100 < 20) {
			output += Numbers.numbersTo20[(int) (input%100)];
			return output;
		}
		output += Numbers.tens[(int) (input / 10 % 10)];
		if(input % 10 != 0) {
			output += "-";
			output += Numbers.numbersTo20[(int) (input%10)];
		}
		return output;
	}
	private static String writeHundreds(long input, String output) {
		String output2 = "";
		if(input / 100 % 10 != 0) {
			output2 += Numbers.numbersTo20[(int) (input / 100 % 10)] + " Hundred";
		}
		output = writeTens(input, output2);
		return output;
	}
}

class Numbers {
	public static final String numbersTo20[] = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	public static final String tens[] = {"Zero", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	public static final String categories[] = {"", "Thousand ", "Million ", "Billion ", "Trillion ", "Quadrillion ", "Quintillion ", "Sextillion ", "Septillion ", "Octillion ", "Nonillion ", "Decillion "};
	//To add bigger numbers, just add the label of the number at the end of the categories array(example: thousand, million, etc...)
}
