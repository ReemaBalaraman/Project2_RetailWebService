package dao;

import java.util.List;


import model.customer.Customer;
import model.order.Order;
import model.order.ProductOrder;
import model.product.Product;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class CustomerDAO {

	public void addCustomer(Customer customer){
		  try
		    {
		Configuration configuration = new Configuration().configure();
	    configuration.configure("hibernate.cfg.xml");
	    configuration.addAnnotatedClass(Customer.class);
	    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    System.out.println("Hibernate Configuration loaded");
	    
	    
		// opens a new session from the session factory
       Session session = sessionFactory.openSession();
       org.hibernate.Transaction t =  session.beginTransaction();
       
	        session.save(customer);                              
	        session.save(customer);
	 
	      session.flush(); // stmt.executeBatch()
	      t.commit(); // con.commit();
	      System.out.println("Records inserted");

		   
	}catch (Throwable ex) {
    // Make sure you log the exception, as it might be swallowed
    System.err.println("Initial SessionFactory creation failed." + ex);
    throw new ExceptionInInitializerError(ex);
    }
}
	
	public Customer fetchCustomer(String email){
		  try
		    {
		Configuration configuration = new Configuration().configure();
	    configuration.configure("hibernate.cfg.xml");
	    configuration.addAnnotatedClass(Customer.class);
	    configuration.addAnnotatedClass(Order.class);
	    configuration.addAnnotatedClass(Product.class);
	    configuration.addAnnotatedClass(ProductOrder.class);
	    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    System.out.println("Hibernate Configuration loaded");
	    	    
		// opens a new session from the session factory
     Session session = sessionFactory.openSession();
     org.hibernate.Transaction t =  session.beginTransaction();
     String hql = "FROM Customer c WHERE c.email = :email";
     Query query = session.createQuery(hql);
     query.setParameter("email",email);
     List results = query.list();
     Customer customer = (Customer)results.get(0);
     
    // Customer customer = (Customer) session.get(Customer.class, email);
	 
	      session.flush(); // stmt.executeBatch()
	      t.commit(); // con.commit();
	      System.out.println("Records inserted");
       return  customer;  
       
	}catch (Throwable ex) {
  // Make sure you log the exception, as it might be swallowed
  System.err.println("Initial SessionFactory creation failed." + ex);
  throw new ExceptionInInitializerError(ex);
  }
}	
}
