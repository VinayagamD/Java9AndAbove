package com.vinaylogics.hibernate_tutorial.hql.criteria_query;

import com.vinaylogics.hibernate_tutorial.core_test_module.base_test_class.BaseTestClass;
import com.vinaylogics.hibernate_tutorial.hql.criteria_query.models.Address;
import com.vinaylogics.hibernate_tutorial.hql.criteria_query.models.Author;
import com.vinaylogics.hibernate_tutorial.hql.criteria_query.models.Book;
import com.vinaylogics.hibernate_tutorial.hql.criteria_query.models.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

class DataGeneratorTest extends BaseTestClass {
    public static final String EMPLOYEE = "Employee";
    public static final String FIRST = EMPLOYEE + "_First";
    public static final String LAST = EMPLOYEE + "_Last";
    public static final String ADDRESS = EMPLOYEE + "_Address";
    public static final String CITY = "Bangalore";
    public static final String COUNTRY = "India";
    public static final String PIN_CODE = "56000";

    @Override
    protected File getFile() {
        return new File(DataGeneratorTest.class.getClassLoader().getResource("hibernate.cfg.xml").getFile());
    }

    @Test
    public void testGenerateData(){
        generateEmployee();
        generateBooks();
    }

    private void generateBooks() {
        Transaction t = session.beginTransaction();
        IntStream.rangeClosed(1, 20).forEach(i->{
            int random = ThreadLocalRandom.current().nextInt(1,3);
            if(random == 1){
                generateOneBook();
            }else if(random == 2){
                generateTwoBook();
            }else {
                generateThreeBook();
            }
        });
        t.commit();
    }

    private void generateThreeBook() {
        Book book1 = new Book();
        book1.setPublishedDate(LocalDateTime.now());
        book1.setTitle(UUID.randomUUID().toString());
        book1.setVersion(getInteger());
        session.save(book1);
        Book book2 = new Book();
        book2.setPublishedDate(LocalDateTime.now());
        book2.setTitle(UUID.randomUUID().toString());
        book2.setVersion(getInteger());
        session.save(book2);
        Book book3 = new Book();
        book3.setPublishedDate(LocalDateTime.now());
        book3.setTitle(UUID.randomUUID().toString());
        book3.setVersion(getInteger());
        session.save(book3);
        Author author = new Author();
        author.setName(UUID.randomUUID().toString());
        author.setVersion(getInteger());
        author.addBook(book1);
        author.addBook(book2);
        author.addBook(book3);
        book1.addAuthor(author);
        book2.addAuthor(author);
        book3.addAuthor(author);
        session.update(book1);
        session.update(book2);
    }

    private void generateTwoBook() {
        Book book1 = new Book();
        book1.setPublishedDate(LocalDateTime.now());
        book1.setTitle(UUID.randomUUID().toString());
        book1.setVersion(getInteger());
        session.save(book1);
        Book book2 = new Book();
        book2.setPublishedDate(LocalDateTime.now());
        book2.setTitle(UUID.randomUUID().toString());
        book2.setVersion(getInteger());
        session.save(book2);
        Author author = new Author();
        author.setName(UUID.randomUUID().toString());
        author.setVersion(getInteger());
        author.addBook(book1);
        author.addBook(book2);
        book1.addAuthor(author);
        book2.addAuthor(author);
        session.update(book1);
        session.update(book2);
    }

    private void generateOneBook() {
        Book book1 = new Book();
        book1.setPublishedDate(LocalDateTime.now());
        book1.setTitle(UUID.randomUUID().toString());
        book1.setVersion(getInteger());
        session.save(book1);
        Author author = new Author();
        author.setName(UUID.randomUUID().toString());
        author.setVersion(getInteger());
        author.addBook(book1);
        session.save(book1);
        book1.addAuthor(author);
        session.update(book1);
    }

    private Integer getInteger(){
        return ThreadLocalRandom.current().nextInt(1,100);
    }

    private void generateEmployee() {
        Transaction t = session.beginTransaction();
        IntStream.rangeClosed(1, 20).forEach(i -> {
            Employee employee = new Employee();
            employee.setFirstName(FIRST+"_"+i);
            employee.setLastName(LAST+"_"+i);
            Address address = new Address();
            address.setCity(CITY);
            address.setCountry(COUNTRY);
            address.setPinCode(Integer.parseInt(PIN_CODE + (i < 10 ? "8"+i :  i)));
            employee.setAddress(address);
            session.save(employee);
        });
        t.commit();
        System.out.println("Data Generation Successful");
    }
}