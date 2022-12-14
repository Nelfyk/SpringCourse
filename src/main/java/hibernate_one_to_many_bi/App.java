package hibernate_one_to_many_bi;

import hibernate_one_to_many_bi.entity.Department;
import hibernate_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session = null;
        try {


            session = factory.getCurrentSession();
            session.beginTransaction();
            Department dep = new Department("HR",500,1200);
            Employee emp1 = new Employee("Ruslan","Burduzhan",350);
            Employee emp2 = new Employee("Sanya","Gendalf",1100);
            dep.addEmployeeToDepartment(emp1);
            dep.addEmployeeToDepartment(emp2);
            session.save(dep);

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
