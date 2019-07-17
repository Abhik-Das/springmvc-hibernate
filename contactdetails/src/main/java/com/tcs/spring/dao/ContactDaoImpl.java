package com.tcs.spring.dao;
import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.tcs.spring.model.Contact;

@Repository
public class ContactDaoImpl implements ContactDao {
	private static final Logger logger = LoggerFactory.getLogger(ContactDaoImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addContact(Contact c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(c);
		logger.info("Contact saved successfully, Person Details="+c);
		
	}

	@Override
	public void updatePontact(Contact c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(c);
		logger.info("Contact updated successfully, Person Details="+c);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> listcontacts() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Contact> contactsList = session.createQuery("from Contact").list();
		for(Contact c : contactsList){
			logger.info("Contact List::"+c);
		}
		return contactsList;
	}

	@Override
	public Contact getContactById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Contact c = (Contact) session.load(Contact.class, new Integer(id));
		logger.info("Contact loaded successfully, Person details="+c);
		return c;
	}

	@Override
	public void removeContact(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Contact c = (Contact) session.load(Contact.class, new Integer(id));
		if(null != c){
			session.delete(c);
		}
		logger.info("Contact deleted successfully, person details="+c);
	}

}
