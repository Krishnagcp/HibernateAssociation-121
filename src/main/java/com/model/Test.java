package com.model;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test {
	public static void main(String[]args) {
		Transaction tr = null;
		try(Session ses = HBUtil.getSessionFactory().openSession()){
			tr= ses.beginTransaction();
			Employee e= new Employee();
			e.setName("");
			e.setEmail("ramesh@gmail.com");
			Address a= new Address();
			a.setLine1("no:7, 4th cross street");
			a.setLine2("thindivanam");
			a.setCity("chennai");
			a.setState("tamilnadu");
			e.setAddr(a);
			a.setE(e);
			ses.persist(e);
			ses.persist(a);
			tr.commit();
			ses.close();
			
			}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
