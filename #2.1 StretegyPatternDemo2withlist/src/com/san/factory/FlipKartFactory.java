package com.san.factory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import com.san.comp.Couriar;
import com.san.comp.FlipKart;


public class FlipKartFactory {
	static Couriar couriar;
	static FlipKart flipkart;
	static Properties props;
	 static{
			InputStream is=null;
			try {
				//Locate Properties using streams
				is=new FileInputStream("src/com/san/commons/myinfo.properties");
				//Load Properties file into java.util.Properties object
				props=new Properties();
				props.load(is);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}//stati block
	
    
   
  public static FlipKart getinstance() throws ClassNotFoundException, InstantiationException, IllegalAccessException
  {
	  
	  couriar=(Couriar)Class.forName(props.getProperty("sdp.dependent")).newInstance();
	  flipkart=new FlipKart(couriar);
	  return flipkart;
  }
}
