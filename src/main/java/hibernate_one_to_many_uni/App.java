package hibernate_one_to_many_uni;

import hibernate_one_to_many_uni.entity.Department;
import hibernate_one_to_many_uni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Department.class)
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        Session session = null;
        try{
            session = factory.getCurrentSession();
//            Department dep = new Department("HR",500,1200);
//            Employee emp1 = new Employee("Roma","White",350);
//            Employee emp2 = new Employee("Sanya","Gendalf",1100);
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);

            session.beginTransaction();
//            session.save(dep);
            Department dep = session.get(Department.class,10);
            session.delete(dep);

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
