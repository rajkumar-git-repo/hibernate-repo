package com.hibernate;

import com.hibernate.daoUtil.HibernateUtil;
import com.hibernate.model.AddressModel;
import com.hibernate.model.EmployeeModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateMain {
    public static void main(String[] args) {
        System.out.printf("Welcome to hibernate tutorials");


        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session  = sessionFactory.getCurrentSession();

        Transaction transaction = session.beginTransaction();

        //session.save(EmployeeModel.getEmployee());
        session.save(AddressModel.getAddress());
        transaction.commit();

        sessionFactory.close();
        session.close();
    }
}