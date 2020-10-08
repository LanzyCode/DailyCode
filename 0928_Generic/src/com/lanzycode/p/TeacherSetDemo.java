package com.lanzycode.p;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;
import java.util.TreeSet;

public class TeacherSetDemo {
    public static void main(String[] args) {
        TreeSet<Teacher> teachers = new TreeSet<Teacher>(new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                int result = (o1.getChinese() + o1.getMath()) - (o2.getChinese() + o2.getMath());
                result = result == 0 ? o1.getChinese() - o2.getChinese() : result;
                result = result == 0 ? o1.getMath() - o2.getMath() : result;
                Collator collator = Collator.getInstance(Locale.CHINA);
                collator.compare(o1.getName(), o2.getName());
                return result;
            }
        });

        teachers.add(new Teacher("张三", 90, 100));
        teachers.add(new Teacher("李四", 100, 70));
        teachers.add(new Teacher("王五", 80, 100));
        teachers.add(new Teacher("王五", 70, 60));

        System.out.println(teachers);
    }

}
