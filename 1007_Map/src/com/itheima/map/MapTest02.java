package com.itheima.map;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;
import java.util.TreeMap;

public class MapTest02 {
    public static void main(String[] args) {
        TreeMap<Student, Integer> studentIntegerTreeMap = new TreeMap<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int result = o1.getScore() - o2.getScore();
                if (result == 0) {
                    result = o1.getAge() - o2.getAge();
                }
                if (result == 0) {
                    Collator collator = Collator.getInstance(Locale.CHINA);
                    result = collator.compare(o1.getName(), o2.getName());
                }
                return result;
            }
        });
        studentIntegerTreeMap.put(new Student("张三", 20, 99), 1);
        studentIntegerTreeMap.put(new Student("李四", 20, 60), 1);
        studentIntegerTreeMap.put(new Student("王五", 20, 87), 1);
        studentIntegerTreeMap.put(new Student("张三", 20, 100), 1);

        System.out.println(studentIntegerTreeMap);
    }
}
