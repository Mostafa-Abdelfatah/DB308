package com.sci;

import com.sci.dao.DBDepartments;
import com.sci.models.Departments;

import java.util.List;

public class TestDep {
    public static void main(String[] args) {

        // select * from departments
        DBDepartments  dep = new DBDepartments();
        List<Departments> list = dep.get();
        for (Departments i : list)
        {
            System.out.println(i);
        }

        System.out.println("####################################################");

        //        to insert

        Departments depInsert = new Departments();
        depInsert.setDepartmentName("TestInsert");
        depInsert.setManagerId(114);
        depInsert.setLocationId(1700);

        System.out.println(dep.insert(depInsert));

        System.out.println("####################################################");

        // select a certain department by id

        System.out.println(dep.get(210));

        System.out.println("####################################################");

        // to update
        Departments depUpdate = dep.get(310);
        depUpdate.setDepartmentName("TestUpdate");
        dep.update(depUpdate);

        System.out.println("####################################################");

        // to delete

        dep.delete(310);

    }
}
