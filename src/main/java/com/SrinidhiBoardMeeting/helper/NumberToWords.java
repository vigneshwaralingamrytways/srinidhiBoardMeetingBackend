package com.SrinidhiBoardMeeting.helper;

import org.springframework.stereotype.Component;

@Component
public class NumberToWords {

	private static final String[] units = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
			"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
			"Nineteen" };

	private static final String[] tens = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
			"Ninety" };

	/** MAIN METHOD: Converts Rupees + Paisa + adds "Only" */
	public static String convertAmount(double amount) {
		long rupees = (long) amount;
		int paisa = (int) Math.round((amount - rupees) * 100);

//		String rupeeWords = convertToWords(rupees);
		String rupeeWords = (rupees == 0) ? "" : convert(rupees).trim();

//		String finalWords;
//		if (rupees > 0) {
//			String rupeeSuffix = (rupees == 1) ? " Rupee" : " Rupees";
//			finalWords = rupeeWords + rupeeSuffix;
//		}
//		if (paisa > 0) {
//			String paisaWords = convertPaisa(paisa);
//			
//			finalWords = rupeeWords + " and " + paisaWords;
//		} else {
//			finalWords = rupeeWords;
//		}
		String finalWords = "";

		if (rupees > 0) {
			String rupeeSuffix = (rupees == 1) ? " Rupee" : " Rupees";
			finalWords = rupeeWords + rupeeSuffix;
		}

		if (paisa > 0) {
			String paisaWords = convert(paisa).trim() + " Paise";
			if (rupees > 0) {
				finalWords += " and " + paisaWords;
			} else {
				finalWords = paisaWords;
			}
		} else if (rupees == 0) {
			return "Zero Rupees Only";

		}

		return finalWords.trim() + " Only";
	}

	/** Convert only rupees */
	public static String convertToWords(long number) {
		if (number == 0)
			return "Zero Rupees";

		return convert(number).trim();
	}

	/** Convert Paisa to words */
	public static String convertPaisa(int paisa) {
		return convert(paisa).trim() + " Paise";
	}

	/** INTERNAL number conversion logic */
	private static String convert(long number) {
		if (number < 20) {
			return units[(int) number];
		} else if (number < 100) {
			return tens[(int) number / 10] + " " + units[(int) number % 10];
		} else if (number < 1000) {
			return units[(int) number / 100] + " Hundred " + convert(number % 100);
		} else if (number < 100000) {
			return convert(number / 1000) + " Thousand " + convert(number % 1000);
		} else if (number < 10000000) {
			return convert(number / 100000) + " Lakh " + convert(number % 100000);
		} else {
			return convert(number / 10000000) + " Crore " + convert(number % 10000000);
		}
	}

	/** MAIN METHOD: USD amount to words */
	public static String convertUSD(long amount) {
		if (amount == 0) {
			return "Zero Only";
		}
		return convertForUsd(amount).trim() + " Only";
	}

	/** INTERNAL conversion logic (International system) */
	private static String convertForUsd(long number) {
		if (number < 20) {
			return units[(int) number];
		} else if (number < 100) {
			return tens[(int) number / 10] + " " + units[(int) number % 10];
		} else if (number < 1000) {
			return units[(int) number / 100] + " Hundred " + convert(number % 100);
		} else if (number < 1_000_000) {
			return convert(number / 1000) + " Thousand " + convert(number % 1000);
		} else if (number < 1_000_000_000) {
			return convert(number / 1_000_000) + " Million " + convert(number % 1_000_000);
		} else {
			return convert(number / 1_000_000_000) + " Billion " + convert(number % 1_000_000_000);
		}
	}
	
	// ocnvert to the ind format of number 
	public static String toIndianFormat(Double amount) {
	    if (amount == null) return "0.00";
	    long intPart = amount.longValue();
	    String decimal = String.format(".%02d", Math.round((amount - intPart) * 100));
	    String s = Long.toString(intPart);
	    if (s.length() <= 3) return s + decimal;
	    String result = s.substring(s.length() - 3);
	    s = s.substring(0, s.length() - 3);
	    while (s.length() > 2) {
	        result = s.substring(s.length() - 2) + "," + result;
	        s = s.substring(0, s.length() - 2);
	    }
	    return (s.length() > 0 ? s + "," : "") + result + decimal;
	}

}
