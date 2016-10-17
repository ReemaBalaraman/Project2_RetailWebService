package dao;

import java.sql.Statement;

import model.product.Product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ProductDAO {

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

	
	
}
