package com.java.basics;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator {
    //Create Scanner object as instance variable
	public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        //call the functions in the required sequence
    	 System.out.println("Enter a valid Phone Number (999)999-9999:");
  	     String phone = getInput();
  	
         int i = validatePhoneNumber(phone);
   	 
  	     displayResult(i);
  	     closeScanner();
  		
    }

    public static String getInput() {
        return in.nextLine();
    }

    public static void displayResult(int result) {
        //displays the result
    	System.out.println(result);
    }

    public static int validatePhoneNumber(String input) {
    	 
    	if (input == null) {
             return -1;
         }
         Pattern p = Pattern.compile("\\(\\d{3}\\)-\\d{3}-\\d{4}"); 
         for (int i = 0; i < input.length(); i++) {  
        	 String lc = String.valueOf(input.charAt(i));
        	 Matcher m = p.matcher(lc);
        	 if(m.matches()) {
        		 return 1;
        	 } else {
        		 return 0;
        	 }
        		 
         }
        return 0;
    }
    public static void closeScanner(){
        //close the Scanner object
    	in.close();
    }
}
