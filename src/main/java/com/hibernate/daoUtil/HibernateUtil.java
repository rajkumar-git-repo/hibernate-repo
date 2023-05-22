package com.hibernate.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.annotation.Resource;
import java.io.File;

public class HibernateUtil {

    private static SessionFactory SESSION_FACTORY = null;

    private static StandardServiceRegistry registry = null;


    private static synchronized SessionFactory getInstance() {
        if (SESSION_FACTORY == null) {
            synchronized (HibernateUtil.class) {
                if (SESSION_FACTORY == null) {
                    try {
                        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
                        Metadata meta = new MetadataSources(registry).getMetadataBuilder().build();
                        SESSION_FACTORY = meta.getSessionFactoryBuilder().build();
                    } catch (Exception exception) {
                        exception.printStackTrace();
                        if (registry != null) {
                            StandardServiceRegistryBuilder.destroy(registry);
                        }

                    }

                }
            }
        }
        return SESSION_FACTORY;
    }

    public static SessionFactory getSessionFactory(){
        return getInstance();
    }
}
