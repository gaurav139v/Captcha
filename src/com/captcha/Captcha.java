package com.captcha;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;


 public class Captcha {
	/*
	 * THIS CLASS IS THE TOP CLASS WHICH IS USED TO CREATE THE CAPTCHA OBJECT
	 * Contain the two Instanse variable 
	 * capt : Store the captcha real value
	 * imageData : Store the captcha image data in base64 format
	 * 
	 * */
	 
	private String capt;
	private String imageData;
	
	public Captcha(){
		this.capt = null;
		this.imageData = null;
	}
	
	public String getCapt() {
		return capt;
	}
	
	public String getImageData() {
		return imageData;
	}
	
	public void setCapt(String capt) {
		this.capt = capt;
	}
	
	public void setImageData(String imageData) {
		this.imageData = imageData;
	}
	
	public BufferedImage createSimpleBufferedImage(String str) {
		/*
		 * THIS METHOD CREATE THE IMAGE FOR THE STRING PASSED TO IT
		 * Used to create the captcha image
		 * */
		
		// create the sample image 
		// since the fontMetric is based on graphic so we need to create a tempory image
		// so we can insert the width and height to the final image
		
		BufferedImage image = new BufferedImage(1,1,BufferedImage.TYPE_INT_ARGB);
		Graphics2D graphic = image.createGraphics();
		Font font = new Font("Arial", Font.PLAIN, 48);
		graphic.setFont(font);
		FontMetrics f = graphic.getFontMetrics();
		int width = f.stringWidth(str);
		int height = f.getHeight();
		graphic.dispose();
		
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		graphic = image.createGraphics();
		graphic.setFont(font);
		graphic.setColor(Color.BLACK);
		graphic.drawString(str, 0, f.getAscent());
		graphic.dispose();
		
		return image;
	}
	
	public String generateCaptchaImage(String str, int type) {
		/*
		 * THIS MEHTOD CONVERT THE BUFFERED IMAGE OBJECT INTO THE BASE64
		 * So image can be displayed in the jsp page
		 * Take two Argument first one in the string
		 * second in type of the image need to be created
		 */
		String imgData;		
			
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		byte[] imageInByteArray = null;
		
		try {
			switch(type) {
			case 1:
				ImageIO.write(createSimpleBufferedImage(str), "jpg", b);				
			}
			
			b.flush();
			imageInByteArray = b.toByteArray();
			b.close();			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		imgData = javax.xml.bind.DatatypeConverter.printBase64Binary(imageInByteArray);
		
		return imgData;							
	}
	
	public int createCaptcha() {
		// Override
		return 1;
	}
	
	public int createCaptcha(int chr) {	
		// Override
		return 1;
	}
	
}
