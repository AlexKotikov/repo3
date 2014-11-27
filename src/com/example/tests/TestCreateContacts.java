package com.example.tests;

import static org.testng.AssertJUnit.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;
 


import com.example.fw.Contact;

public class TestCreateContacts extends TestBase {

	
	
	//@Test   
	// Создать контакт 
	public void testCreateContact() throws InterruptedException {		
		Contact contact = new Contact().withName("nametester").withSurname("Surtester");
		
		app.getContactHelper().createContact(contact);		
		
		Contact newcontact = app.getContactHelper().readFirstContact();
		//System.out.println(newcontact.toString());
		Assert.assertEquals(newcontact,contact );
		
		//Thread.sleep(5000);	
	}
	
	
	@Test   
	// Удалить контакт 
	public void testDeleteContact() throws InterruptedException {		
		
		//Создаем
		Contact contact = new Contact().withName("namedel").withSurname("Surndel");
		//Отослали форму и сохранили
	    app.getContactHelper().createContact(contact);		
		
		// Теперь удоляем первый
	     app.getContactHelper().DeleteFirst();
		
		//Обращаемся за списком в ожидании получить контакт none\none
	
	     Contact newcontact = app.getContactHelper().readFirstContact();
		//если в эту переменную записался объект с именем none то будем считать что в таблице пусто
 	
		Assert.assertEquals(newcontact, new Contact().withName("none").withSurname("none") );
		
		Thread.sleep(1000);	
	}
	
	
	
}
