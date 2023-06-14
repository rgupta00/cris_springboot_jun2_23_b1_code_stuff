package com.bankapp.basics;


import com.bankapp.factory.HibernateSessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.math.BigDecimal;
import java.util.Date;

public class UpdateAccount {
    public static void main(String[] args) {

    	SessionFactory factory=HibernateSessionFactory.getSessionFactory();
    	
    	Session session=factory.openSession();
    	
    	Transaction tx=session.getTransaction();
    	try {
    		
    		tx.begin();
         
    			Account accountToUpdate= session.get(Account.class, 1);
    			
    			accountToUpdate.setBalance(accountToUpdate.getBalance()
    					.add(BigDecimal.valueOf(1000)));
    			
    			session.update(accountToUpdate);
    			
    			
    		tx.commit();
    	}catch(HibernateException ex) {
    		ex.printStackTrace();
    		tx.rollback();
    	}
    			
     
    	session.close();
    	
    	factory.close();



    }

}