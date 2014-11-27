package com.example.fw;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class ApplicationManager {
	 
	private  Properties props;
	private ContactsHelper contactsHelper;
	private ProccessHelper proccessHelper;
	private AutoItHelper autoItHelper;
	private static  ApplicationManager appman;	
	
	
	
 
	
	public static ApplicationManager getApMan(Properties props) throws IOException{
		if (appman == null) {
			appman = new ApplicationManager();
		    appman.setProperties(props);
		    appman.start();
		   }
		return 	appman;
	}
	
	
	private void setProperties(Properties props2) {
		 
		this.props = props2;
	}


	public void stop() {
		// посылаем приложению сингал о корректном завершении
		// чтобы оно сохранило свои данные.
		getProccessHelper().stopApp();
	}
	
	
	public void start() throws IOException {
		getProccessHelper().startApp();	 
	}
	

 
	public ContactsHelper getContactHelper() {
		 if (contactsHelper == null) {
			 contactsHelper = new ContactsHelper(this);
		} 	 
		return contactsHelper;
	}
 
	public AutoItHelper getAutoItHelper() {
		 if (autoItHelper == null) {
			 autoItHelper = new AutoItHelper(this);
		} 	 
		return autoItHelper;
	}
	
	
	
	public ProccessHelper getProccessHelper() {
		 if (proccessHelper == null) {
			 proccessHelper = new ProccessHelper(this);} 
    return proccessHelper;
	}
	
	public String getProperty(String string) {
		 
		return this.props.getProperty("app.path");
	}

	
 

	 

	
}