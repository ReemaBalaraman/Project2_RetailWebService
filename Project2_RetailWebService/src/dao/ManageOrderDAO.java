package dao;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


import model.customer.Customer;
import model.customer.CustomerAddress;
import model.customer.CustomerPhone;
import model.order.Order;
import model.order.ProductOrder;
import model.partner.Partners;
import model.product.Product;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ManageOrderDAO {
	Configuration configuration = new Configuration().configure();

	public void dbConnection()
	{
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Customer.class);
		configuration.addAnnotatedClass(CustomerAddress.class);
		configuration.addAnnotatedClass(CustomerPhone.class);
		configuration.addAnnotatedClass(Order.class);
		configuration.addAnnotatedClass(ProductOrder.class);
		configuration.addAnnotatedClass(Product.class);
		
	}
	public String placeOrder(Order mo , Set<ProductOrder> productEligible) {
		 try
		    {
			 dbConnection();
	    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    System.out.println("Hibernate Configuration loaded");
	    
	    
		// opens a new session from the session factory
  Session session = sessionFactory.openSession();
  org.hibernate.Transaction t =  session.beginTransaction();
  ProductOrder po = new ProductOrder();
  for(ProductOrder poEntry : productEligible)
  {
	   po.setOrder(mo);
	   po.setOrderQuantity(poEntry.getOrderQuantity());
	   po.setProduct(poEntry.getProduct());
	   session.save(po);   
  }
	 
	      session.flush(); // stmt.executeBatch()
	      t.commit(); // con.commit();
	      System.out.println("Records inserted");
String status = "Order Created";
return status;

	}catch (Throwable ex) {
//Make sure you log the exception, as it might be swallowed
System.err.println("Initial SessionFactory creation failed." + ex);
throw new ExceptionInInitializerError(ex);
}
		
	}
	public Order fetchOrder(String id){
		try
		{
			dbConnection();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			System.out.println("Hibernate Configuration loaded");	
			// opens a new session from the session factory
			Session session = sessionFactory.openSession();
			org.hibernate.Transaction t =  session.beginTransaction();
			String hql = "FROM Order 0 WHERE o.orderID = :identifier";
				Query query = session.createQuery(hql);
				int idInt = Integer.parseInt(id);
				query.setParameter("identifier",idInt);

		

			List results = query.list();
			Order order = (Order)results.get(0);

			session.flush(); // stmt.executeBatch()
			t.commit(); // con.commit();
			System.out.println("Records fetched");
			return  order;  

		}catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}	
	
	public Set<Order> fetchAllOrders(){
		try
		{
			dbConnection();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			System.out.println("Hibernate Configuration loaded");	
			// opens a new session from the session factory
			Session session = sessionFactory.openSession();
			org.hibernate.Transaction t =  session.beginTransaction();
			String hql = "FROM Order o";
				Query query = session.createQuery(hql);

			List results = query.list();
			Set<Order> orders = new HashSet<Order>();
			for(Object result : results)
			{
				Order order = new Order(); 
				order = (Order)result;
				orders.add(order);
			}
			

			session.flush(); // stmt.executeBatch()
			t.commit(); // con.commit();
			System.out.println("Records fetched");
			return  orders;  

		}catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}	
	
}
