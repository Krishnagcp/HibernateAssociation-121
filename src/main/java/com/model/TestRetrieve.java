package com.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class TestRetrieve {

	public static void main(String[] args) {
		Transaction tr;
		try (Session ses = HBUtil.getSessionFactory().openSession()){
			tr = ses.beginTransaction();
			Query<Employee> qry =  ses.createQuery("from Employee",Employee.class);
			List<Employee> li= qry.list();
			for(Employee e :li) {
				System.out.println(e.getEmpid()+"\t"+e.getName()+"\t"+e.getEmail());
				Address ad=e.getAddr();
				System.out.println("Address is "+ad.getLine1()+ad.getLine2()+ad.getCity()+ad.getState());
			}
			tr.commit();
			ses.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
