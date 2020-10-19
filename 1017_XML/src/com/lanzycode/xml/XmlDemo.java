package com.lanzycode.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class XmlDemo {
    public static void main(String[] args) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document dc = saxReader.read(new File("1017_XML/src/com/lanzycode/xml/demo.xml"));
        Element rootElement = dc.getRootElement();
//        ArrayList<Student> studentArrayList=new ArrayList<>();

        List<Element> list = rootElement.elements("student");
        for (Element element : list) {
            String id = element.attribute("id").getValue();
            String name = element.element("name").getText();
            String age = element.element("age").getText();
            String hobby = element.elementText("hobby");
            System.out.println(id + name + age + hobby);
//            Student student=new Student(id,name,Integer.parseInt(age));
        }
    }
}
