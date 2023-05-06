package com.sci.dao;

import com.sci.config.DBConfig;
import com.sci.models.Departments;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DBDepartments {
    public List<Departments> get() {

        try (Session  session = DBConfig.SESSION_FACTORY.openSession()) {
            // return session.createQuery("From Departments").list();
            return session.createSQLQuery("Select * from departments").addEntity(Departments.class).list();
        } catch (Exception ex) {
            System.err.println("DB exception " + ex.getMessage());
            return new ArrayList<>();
        }


    }

    public Departments get(Integer departmentId) {

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            return session.get(Departments.class, departmentId);

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        return null;
    }

    public Integer insert(Departments dep) {

        Transaction transaction = null;
        int departmentsId = 0;

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            transaction = session.beginTransaction();

            departmentsId = (Integer) session.save(dep);

            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(ex.getMessage());
        }

        return departmentsId;
    }

    public void update(Departments dep) {

        Transaction transaction = null;

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            transaction = session.beginTransaction();

            session.update(dep);

            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(ex.getMessage());
        }
    }

    public void delete(Integer departmentId) {

        Transaction transaction = null;

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            transaction = session.beginTransaction();

            Departments dep = get(departmentId);

            session.delete(dep);

            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(ex.getMessage());
        }
    }
}
