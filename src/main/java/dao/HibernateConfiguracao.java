package dao;

import model.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.util.xml.Origin;
import org.hibernate.internal.util.xml.XmlDocument;
import org.hibernate.service.ServiceRegistry;

public class HibernateConfiguracao 
{
    private static SessionFactory sessionFactory;
    
    public HibernateConfiguracao() 
    {
    }
    
    public Session openSession() 
    {
        if (sessionFactory == null) 
        {
            criaSessionFactory();
        }
        return sessionFactory.openSession();
    }
    
    public void criaSessionFactory() 
    {
        
//        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
//        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    	try	
    	{
    		sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    	}
    	catch(HibernateException exception)
    	{
    		exception.printStackTrace();
    	}
    	
    }
}