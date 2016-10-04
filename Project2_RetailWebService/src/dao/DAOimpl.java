package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


import model.Customer;
import model.ManageOrder;
import model.Partners;
import model.Product;
import model.ProductOrder;

public class DAOimpl {

	private static String dbUrl = "jdbc:mysql://127.0.0.1:8080/lsmarketplace";
	private static String dbUsername = "reema";
	private static String dbPassword = "root123";

	private Statement statement = null;

	public Product searchProduct(int productID)
	{
		// loads configuration and creates a session factory
		try
		{
	    Configuration configuration = new Configuration().configure();
	   configuration.configure("hibernate.cfg.xml");
			 configuration.addAnnotatedClass(Product.class);
	    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    System.out.println("Hibernate Configuration loaded");
	    
	    
		// opens a new session from the session factory
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    
	    Product product = (Product) session.load(Product.class, new Integer(productID));
	    session.close();
	    return product ;
	   
		}
		catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
	}

	
	

	
	
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
	
	public void addPartner(Partners partner) {
		 try
		    {
		Configuration configuration = new Configuration().configure();
	    configuration.configure("hibernate.cfg.xml");
	    configuration.addAnnotatedClass(Partners.class);
	    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    System.out.println("Hibernate Configuration loaded");
	    
	    
		// opens a new session from the session factory
    Session session = sessionFactory.openSession();
    org.hibernate.Transaction t =  session.beginTransaction();
	 
	        session.save(partner);                              
	        session.save(partner);
	 
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
	    configuration.addAnnotatedClass(ManageOrder.class);
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
	
	public void placeOrder(ManageOrder mo , Map<Product, Integer> productEligible) {
		 try
		    {
		Configuration configuration = new Configuration().configure();
	    configuration.configure("hibernate.cfg.xml");
	   
	    configuration.addAnnotatedClass(Product.class);
	    configuration.addAnnotatedClass(ManageOrder.class);
	    configuration.addAnnotatedClass(Customer.class);
	    configuration.addAnnotatedClass(ProductOrder.class);
	    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    System.out.println("Hibernate Configuration loaded");
	    
	    
		// opens a new session from the session factory
   Session session = sessionFactory.openSession();
   org.hibernate.Transaction t =  session.beginTransaction();
   ProductOrder po = new ProductOrder();
   for(Map.Entry<Product, Integer> entry : productEligible.entrySet())
   {
	   po.setOrder(mo);
	   po.setOrderQuantity(entry.getValue());
	   po.setProduct(entry.getKey());
	   session.save(po);   
   }
	 
	      session.flush(); // stmt.executeBatch()
	      t.commit(); // con.commit();
	      System.out.println("Records inserted");
	    

	}catch (Throwable ex) {
// Make sure you log the exception, as it might be swallowed
System.err.println("Initial SessionFactory creation failed." + ex);
throw new ExceptionInInitializerError(ex);
}
	}
}
