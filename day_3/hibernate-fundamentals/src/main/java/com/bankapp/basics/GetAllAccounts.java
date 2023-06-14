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
import java.util.List;

public class GetAllAccounts {
    public static void main(String[] args) {

    	SessionFactory factory=HibernateSessionFactory.getSessionFactory();
    	
    	Session session=factory.openSession();
    	
    	//i want all the accounts
//    	List<Account> accounts=session.createQuery
//    			("select a from Account a",Account.class).getResultList();
//    	
//    	accounts.forEach(a->System.out.println(a));
//    	
    	
    	List<AccountData> accountDatas=session.createQuery
    			("select new com.bankapp.basics.AccountData( a.name,a.balance) from Account a",
    					AccountData.class).getResultList();
    	
    	accountDatas.forEach(a-> System.out.println(a));
    	
    	
    	session.close();
    	
    	factory.close();



    }

}