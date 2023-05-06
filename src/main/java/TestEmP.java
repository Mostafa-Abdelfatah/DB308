import com.sci.dao.DBDepartments;
import com.sci.dao.DBEmployee;
import com.sci.models.Departments;
import com.sci.models.Employee;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class TestEmP {
    public static void main(String[] args) {
        //select * from employees
        DBEmployee db = new DBEmployee();
        List<Employee> list = db.get();
        for(Employee employee : list) {
            System.out.println(employee);
        }
        System.out.println("#####################################################################################");

        //                insert into employees
        DBEmployee db1 = new DBEmployee();
        Employee emp = new Employee();
        emp.setFirstName("Mostafa");
        emp.setLastName("Elwishy");
        emp.setEmail("mo@gmail.com");
        emp.setJobId("AD_VP");
        emp.setSalary(6700);
        emp.setDepartmentId(50);
        emp.setHireDate(new Date());
        System.out.println(db1.insert(emp));

        System.out.println("#####################################################################################");
    }
}
