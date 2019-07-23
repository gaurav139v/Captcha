package com.captcha;

import java.util.Random;

public class AlphaNumericType extends Captcha{
		/*
		 * THIS CLASS USED TO CREATE THE CAPTCHA OF ALPHA NUMERIC TYPE
		 * 
		 * */

		private final String randStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		
		public AlphaNumericType() {
			super();
		}
		
		public String generateNumberString(int characters) {
			/*
			 * THIS METHOD GENERATE THE RANDOM ALPHA NUMERIC STRING
			 * Take one argument contain number of character in the CAPTCHA
			 * 
			 * */
			Random rand = new Random();				
			StringBuilder val = new StringBuilder();
			
			while(characters-- != 0) {
				Integer value = rand.nextInt(randStr.length());
				val.append(randStr.charAt(value));
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
			 * THIS METHOD CREATE THE CAPTCHA OBJECT AND ASSIGN THE VALUE TO THE INSTANCE VARIABLE
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
