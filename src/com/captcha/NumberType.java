package com.captcha;

import java.util.Random;

public class NumberType extends Captcha{
	/*
	 * THIS CLASS USED TO CREATE THE CAPTCHA OF NUMBER TYPE
	 * 
	 * */
	
	private final String randInts = "0123456789";
	public NumberType(){
		super();
	}
	
	public String generateNumberString(int characters) {
		/*
		 * THIS METHOD GENERATE THE RANDOM NUMBER
		 * Take one argument contain number of character in the CAPTCHA
		 * 
		 * */
		Random rand = new Random();				
		StringBuilder val = new StringBuilder();
		
		while(characters-- != 0) {
			Integer value = rand.nextInt(randInts.length());
			val.append(randInts.charAt(value));
		}
		
		return val.toString();
	}
	
	public int createCaptcha() {
		/*
		 * THIS METHOD CREATE THE CAPTCHA OBJECT AND ASSIGN THE VALUE TO THE INSTANCE VARIABLE
		 * By default it create the 6 character captcha
		 * 
		 * */
		String capt = generateNumberString(6);
		this.setCapt(capt);
		
		String imgData = generateCaptchaImage(capt, 1);
		this.setImageData(imgData);
		
		return 1;
	}
	
	public int createCaptcha(int chr) {
		/*
		 * THIS METHOD CREATE THE CAPTCHA OBJECT AND ASSIG THE VALUE TO THE INSTANCE VARIABLE
		 * Take the one argument show the number of character in the captcha
		 * 
		 *  */
		String capt = generateNumberString(chr);
		this.setCapt(capt);
		
		String imgData = generateCaptchaImage(capt, 1);
		this.setImageData(imgData);
		return 1;
	}
}
