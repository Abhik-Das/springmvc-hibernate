package com.tcs.spring.dao;

import java.util.*;
import com.tcs.spring.model.*;
public interface ContactDao {
	public void addContact(Contact c);
	public void updatePontact(Contact c);
	public List<Contact> listcontacts();
	public Contact getContactById(int id);
	public void removeContact(int id);
	

}
