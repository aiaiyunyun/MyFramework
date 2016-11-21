package com.wbhhc.myutils;

import org.hibernate.*;
import org.hibernate.context.internal.JTASessionContext;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HibernateUtilities {

    private static final SessionFactory sessionFactory;
    
    
    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
        	//sessionFactory = new Configuration().configure().buildSessionFactory();
            ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
            sessionFactory=ctx.getBean("sessionFactory1",SessionFactory.class);
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}