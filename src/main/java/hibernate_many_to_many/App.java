package hibernate_many_to_many;

import hibernate_many_to_many.entity.Child;
import hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();

//            Section section1 = new Section("Football");
//            Child child1 = new Child("Ruslan",7);
//            Child child2 = new Child("Masha",7);
//            Child child3 = new Child("Aleksandr",6);
//            section1.addChildToSection(child1);
//            section1.addChildToSection(child2);
//            section1.addChildToSection(child3);
//// **********************************************************************

            session.beginTransaction();
//            Section section1 = new Section("Football");
//            Child child1 = new Child("Ruslan",7);
//            Child child2 = new Child("Masha",7);
//            Child child3 = new Child("Aleksandr",6);
//            section1.addChildToSection(child1);
//            section1.addChildToSection(child2);
//            section1.addChildToSection(child3);
//
//            session.persist(section1);

//// **********************************************************************
//            List<Child> childList = session.createQuery("from Child").getResultList();
//            for(Child q:childList){
//                if(q.getSectionList()==null || q.getSectionList().size()==0){
//                    session.delete(q);
//                }
//            }

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
