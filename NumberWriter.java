package com.hasan.numberWriter;

public class NumberWriter {	
	public static String writeNumber(long input) {
		String output = "";
		
		if(input == 0) {
			System.out.println("Zero");
		}
		else {
			int categorie = 0;
			while(input > 0) {
				long d3dig = input % 1000;
				if(d3dig != 0) {
					output = writeHundreds(d3dig, output) + " " + Numbers.categories[categorie] + output;
				}
				categorie++;
				input /= 1000;
			}
		}
		return output;
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
}
