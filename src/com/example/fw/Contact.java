package com.example.fw;


public class Contact  {

	private String Surname;
	private String Name;

	public Contact withName(String string) {

		   this.Name = string;
		
		return this;
	}

	public Contact withSurname(String string) {

        this.Surname = string;
		
		return this;
	}
	
	@Override
	public String toString() {
		return "Contact [Surname=" + Surname + ", Name=" + Name + "]";
	}

	public String getSurname() {
		return this.Surname;
	}

	public void setSurname(String surname) {
		Surname = surname;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getName() {
		return this.Name   ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + ((Surname == null) ? 0 : Surname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		if (Surname == null) {
			if (other.Surname != null)
				return false;
		} else if (!Surname.equals(other.Surname))
			return false;
		return true;
	}
	
	
	
	
}
