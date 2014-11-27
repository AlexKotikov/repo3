package com.example.tests;

import static org.testng.AssertJUnit.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;
 


import com.example.fw.Contact;

public class TestCreateContacts extends TestBase {

	
	
	//@Test   
	// ������� ������� 
	public void testCreateContact() throws InterruptedException {		
		Contact contact = new Contact().withName("nametester").withSurname("Surtester");
		
		app.getContactHelper().createContact(contact);		
		
		Contact newcontact = app.getContactHelper().readFirstContact();
		//System.out.println(newcontact.toString());
		Assert.assertEquals(newcontact,contact );
		
		//Thread.sleep(5000);	
	}
	
	
	@Test   
	// ������� ������� 
	public void testDeleteContact() throws InterruptedException {		
		
		//�������
		Contact contact = new Contact().withName("namedel").withSurname("Surndel");
		//�������� ����� � ���������
	    app.getContactHelper().createContact(contact);		
		
		// ������ ������� ������
	     app.getContactHelper().DeleteFirst();
		
		//���������� �� ������� � �������� �������� ������� none\none
	
	     Contact newcontact = app.getContactHelper().readFirstContact();
		//���� � ��� ���������� ��������� ������ � ������ none �� ����� ������� ��� � ������� �����
 	
		Assert.assertEquals(newcontact, new Contact().withName("none").withSurname("none") );
		
		Thread.sleep(1000);	
	}
	
	
	
}
