package com.tcs.spring.service;

import java.util.List;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.spring.dao.ContactDao;
import com.tcs.spring.model.Contact;

@Service
public class ContactServiceImpl implements ContactService {

	private ContactDao contactdao;
	public void setContactdao(ContactDao contactdao) {
		this.contactdao = contactdao;
	}
	@Override
	@Transactional
	public void addContact(Contact c) {
		this.contactdao.addContact(c);
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void updatePontact(Contact c) {
		this.contactdao.updatePontact(c);
		
	}

	@Override
	@Transactional
	public List<Contact> listcontacts() {
		// TODO Auto-generated method stub
		return this.contactdao.listcontacts();
	}

	@Override
	@Transactional
	public Contact getContactById(int id) {
		// TODO Auto-generated method stub
		return this.contactdao.getContactById(id);
	}

	@Override
	@Transactional
	public void removeContact(int id) {
		this.contactdao.removeContact(id);
		// TODO Auto-generated method stub
		
	}

}
