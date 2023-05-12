package com.sci.dao;

import com.sci.config.DBConfig;
import com.sci.models.Jobs;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
public class DBJobs {

    public List<Jobs> get(String s) {

        try (Session  session = DBConfig.SESSION_FACTORY.openSession()) {
            // return session.createQuery("From Departments").list();
            return session.createSQLQuery("Select * from jobs where job_title = '"+s+"' ").addEntity(Jobs.class).list();
        } catch (Exception ex) {
            System.err.println("DB exception " + ex.getMessage());
            return new ArrayList<>();
        }


    }
    public void updateJobs(String jobTitle, Integer salary) {

        Transaction transaction = null;

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            transaction = session.beginTransaction();
            List<Jobs> ss = session.createSQLQuery("Select * from jobs where job_title = '"+jobTitle+"' ").addEntity(Jobs.class).list();
           for (Jobs k : ss)
           {
               k.setMaxSalary(salary);
               session.update(k);
           }

            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(ex.getMessage());
        }
    }

}
