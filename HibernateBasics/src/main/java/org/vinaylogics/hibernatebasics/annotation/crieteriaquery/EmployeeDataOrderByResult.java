package org.vinaylogics.hibernatebasics.annotation.crieteriaquery;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.vinaylogics.hibernatebasics.annotation.crieteriaquery.model.MyEmployee;
import org.vinaylogics.hibernatebasics.annotation.hql.models.Employee;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;
import java.io.File;

public class EmployeeDataOrderByResult {

    public static final String EMPLOYEE = "Employee";
    public static final String FIRST = EMPLOYEE + "_First";
    public static final String LAST = EMPLOYEE + "_Last";
    public static final String ADDRESS = EMPLOYEE + "_Address";
    public static final String CITY = "Bangalore";
    public static final String COUNTRY = "India";
    public static final String PIN_CODE = "56008";

    public static void main(String[] args) {
        File file = new File(EmployeeDataOrderByResult.class.getClassLoader().getResource("hibernate_crietria.cfg.xml").getFile());
        SessionFactory sessionFactory = new Configuration().configure(file)
                .buildSessionFactory();
        EntityManager entityManager = sessionFactory.createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<MyEmployee> cq = cb.createQuery(MyEmployee.class);
        Root<MyEmployee> root = cq.from(MyEmployee.class);
        CriteriaQuery<MyEmployee> select = cq.select(root);
        cq.orderBy(cb.asc(root.get("id")));
        System.out.println("Save Successful");
        sessionFactory.close();
        entityManager.close();
    }
}
