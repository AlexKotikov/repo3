package com.example.fw;

import java.io.IOException;
import java.util.Properties;

public class ProccessHelper extends HelperBase {
	
	private Process process;

	public ProccessHelper(ApplicationManager applicationManager) {
		super(applicationManager);
	}

	public void startApp() throws IOException {
		// String command  = "C:\\Program Files (x86)\\TestAddressbook\\AddressBook.exe"  ;
		String command = manager.getProperty("app.path") ;
		//System.out.println("command= "+ command);
		process = Runtime.getRuntime().exec(command);
	}
  
	public void stopApp() {
		process.destroy();
	}
}
