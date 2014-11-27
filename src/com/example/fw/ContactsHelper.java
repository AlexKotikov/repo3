package com.example.fw;

public class ContactsHelper extends HelperBase {

	
	
	
	public ContactsHelper(ApplicationManager applicationManager) {
		super(applicationManager);
	}

	public void createContact(Contact contact) {
		contactInit();		
		contactSendKeys(contact);
		contactSave();
	}

	private void contactSave() {
		manager.getAutoItHelper()
		.click("Save");
		//.winWaitAndActivate("AddressBook Portable", "", 5000)
		
	}

	private void contactSendKeys(Contact contact) {
		manager.getAutoItHelper()
		.send("TDBEdit11", contact.getSurname())
		.send("TDBEdit12", contact.getName());
	}

	private void contactInit() {
		manager.getAutoItHelper()
		.winWaitAndActivate("AddressBook Portable", "", 5000)
		.click("Add")
		.winWaitAndActivate("Add Contact", "", 5000);
	}

	public Contact readFirstContact() {
		
		Contact contact = new Contact();
		
		manager.getAutoItHelper()
		.winWaitAndActivate("AddressBook Portable", "", 5);
		
		manager.getAutoItHelper().focus("TListView1") // таким образом мы акцентируем
		//внимание на этом дельфи компоненте
		.send("{DOWN} "); //как будто бы пользователь нажал и чекбок отметился. типо хитрость такая
 		
		manager.getAutoItHelper().click("Edit");	
		
		if (manager.getAutoItHelper().isWindow("Update Contact", "", 2) !=false)
		{	
					manager.getAutoItHelper().winWaitAndActivate("Update Contact", "", 5);		 
					contact.setName(manager.getAutoItHelper().getText("TDBEdit12")); 
					contact.setSurname(manager.getAutoItHelper().getText("TDBEdit11"));
					
					manager.getAutoItHelper().winWaitAndActivate("Update Contact", "", 5);
					manager.getAutoItHelper().click("Cancel");
					manager.getAutoItHelper().winWaitAndActivate("AddressBook Portable", "", 5);
		}
		else 
			if (manager.getAutoItHelper().isWindow("Information", "", 2) ==true)  
			
			{
			
			manager.getAutoItHelper().winWaitAndActivate("Information", "", 2);
			manager.getAutoItHelper().click("TButton1"); // Click Ok	
			manager.getAutoItHelper().winWaitAndActivate("AddressBook Portable", "", 5);		
			return new Contact().withName("none").withSurname("none") ;
			
	
		 
			}
		
		return contact;
	}


	public void DeleteFirst() {		
		Contact contact = new Contact();
		manager.getAutoItHelper().winWaitAndActivate("AddressBook Portable", "", 5)
		.focus("TListView1")  
		 
		.send("{DOWN} ");  
		
		manager.getAutoItHelper().click("Delete");

		manager.getAutoItHelper().winWaitAndActivate("Confirm", "", 3);
		manager.getAutoItHelper().click("TButton2"); //click Yes
	
		
	}

}
