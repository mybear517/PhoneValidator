package com.java.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator {
    //Create Scanner object as instance variable
	public static InputStreamReader input = new InputStreamReader(System.in);

    public static void main(String[] args) {
        //call the functions in the required sequence
        String phone = getInput();
  	
         int i = validatePhoneNumber(phone);
   	 
  	     displayResult(i);
  	     closeScanner();
  		
    }

    public static String getInput() {
        BufferedReader br = new BufferedReader(input);
        String sInput = null;
        try {
			sInput = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return sInput;
    }

    public static void displayResult(int result) {
        //displays the result
    	if(result == 1) {
    		System.out.println("VALID");
    	} else if(result == -1) {
    		System.out.println("EMPTY STRING");
    	} else {
    		System.out.println("INVALID");
    	}
    		
    }
  
    public static int validatePhoneNumber(String input) {
    	
    	if (input == null || input.trim().length() == 0) {
            return -1;
    	}
    	Pattern p = Pattern.compile("^([0-9]+-)*[0-9]+$");
    	Matcher m = p.matcher(input);
    	int numCount = 0;
    	
    	for(int i = 0; i < input.length();i++)
        {
        	if(Character.isDigit(input.charAt(i)) == true)
        	{
        		numCount++;
        	}
        }
        
        if(numCount < 10 || numCount > 10)
        {
        	return 0;
        }
    	

         if(m.matches()) {
        	 return 1;
         } else {
        	 return 0;
         }
      
    }
 
    public static void closeScanner(){
        //close the Scanner object 
    	System.out.println("Scanner Close");
    	try {
			input.close();
		} catch (IOException e) {
            System.out.println("scanner exception");
			e.printStackTrace();
		}
    }
}
