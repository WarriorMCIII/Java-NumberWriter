package com.hasan.numberWriter;

public class NumberWriter {
	public static String writeNumber(int input) {
		String output = "";
		
		if(input < 20) {
			Numbers numbers = new Numbers();
			output = numbers.numbersTo20[input];
		}
		else {
			if(input < 100) {
				output = writeTens(input, output);
			}
			else if(input < 1000) {
				output = writeHundreds(input, output);
			}
			else if(input < 1000000) {
				output = writeThousands(input, output);
			}
			else if(input < 1000000000) {
				output = writeMillions(input, output);
			}
		}
		return output;
	}
	
	private static String writeTens(int input, String output) {
		Numbers numbers = new Numbers();
		if(input%100 == 00) {
			return output;
		}
		if(input >= 100) {
			output += "and ";
		}
		if(input%100 < 20) {
			output += numbers.numbersTo20[input%100];
			return output;
		}
		output += numbers.tens[input / 10 % 10];
		if(input % 10 != 0) {
			output += "-";
			output += numbers.numbersTo20[input%10];
		}
		return output;
	}
	private static String writeHundreds(int input, String output) {
		String output2 = "";
		Numbers numbers = new Numbers();
		if(input / 100 % 10 != 0) {
			output2 += numbers.numbersTo20[input / 100 % 10] + " Hundred ";
		}
		output += writeTens(input, output2);
		return output;
	}
	private static String writeThousands(int input, String output) {
		String tOutput = "";
		Numbers numbers = new Numbers();
		if(input >= 1000) {
			if(input >= 10000) {
				if(input >= 100000) {
					tOutput += writeHundreds(input / 1000 % 1000, tOutput);
				}
				else {
					if(input / 1000 % 100 < 20) {
						tOutput += numbers.numbersTo20[input / 1000 % 100];
					}
					else {
						tOutput += writeTens(input / 1000 % 100, tOutput);
					}
				}
			}
			else {
				tOutput += numbers.numbersTo20[input / 1000 % 10];
			}
		}
		if(input / 1000 % 1000 != 0) {
			tOutput += " Thousand ";
		}
		output += writeHundreds(input, tOutput);
		return output;
	}
	private static String writeMillions(int input, String output) {
		String mOutput = "";
		Numbers numbers = new Numbers();
		if(input >= 1000000) {
			if(input >= 10000000) {
				if(input >= 100000000) {
					mOutput += writeHundreds(input / 1000000 % 1000, mOutput);
				}
				else {
					if(input / 1000000 % 100 < 20) {
						mOutput += numbers.numbersTo20[input / 1000000 % 100];
					}
					else {
						mOutput += writeTens(input / 1000000 % 100, mOutput);
					}
				}
			}
			else {
				mOutput += numbers.numbersTo20[input / 1000000 % 10];
			}
		}
		if(input / 1000000 % 1000 != 0) {
			mOutput += " Millions ";
		}
		output += writeThousands(input, mOutput);
		return output;
	}
}

class Numbers {
	String numbersTo20[] = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	String tens[] = {"Zero", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
}
