package cn.itcast.mongodb;

import cn.itcast.mongodb.spring.PersonDao;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
public class TestSpringPerson {
    @Autowired
    private PersonDao personDao;
    @Test
    public void testSave(){
        Person person = new Person(ObjectId.get(), "刘德华", 50,
                new Address("紫金花", "香港", "999999"));
        this.personDao.savePerson(person);
    }
    @Test
    public void testQuery() {
        List<Person> personList = this.personDao.queryPersonListByName("张三");
        for (Person person : personList) {
            System.out.println(person);
        }
    }
}
