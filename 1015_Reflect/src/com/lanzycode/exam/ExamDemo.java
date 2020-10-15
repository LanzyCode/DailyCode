package com.lanzycode.exam;

import com.lanzycode.domain.Student;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.Collator;
import java.util.*;

/*
标准版:
新建一个类Student -> String name,Integer chineseScore,Integer mathScore,Integer englishScore.
[GET/SET/有参/无参/toString/equals]
使用键盘录入三个学生的数据 -> 12次,通过反射封装三个学生对象.
存储到ArrayList中,将ArrayList中的数据按照主要条件:总分 次要条件:语文 次要:数学进行排序(升序/降序无所谓) 默认所有学生均不重复.
将ArrayList中的数据按照 姓名:xxx 总分:xxx 语文:xxx 数学:xxx 英语:xxx 一个学生一行写入到当前模块下的student.txt中.

升级版: 加上Socket
客户端 ->
新建一个类Student -> String name,Integer chineseScore,Integer mathScore,Integer englishScore.
[GET/SET/有参/无参/toString/equals]
使用键盘录入三个学生的数据 -> 12次,通过反射封装三个学生对象.
存储到ArrayList中,将ArrayList中的数据按照主要条件:总分 次要条件:语文 次要:数学进行排序(升序/降序无所谓) 默认所有学生均不重复.
将ArrayList序列化到当前模块下的student.txt文件中,然后将student.txt文件上传到服务器端.
服务器端:
接收到这个数据之后,进行反序列化,将学生排序信息打印到控制台.
*/
public class ExamDemo {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, IOException, NoSuchMethodException, InvocationTargetException {
        Scanner sc = new Scanner(System.in);
        Class<?> cs = Student.class;
        ArrayList<Student> list=new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            System.out.println("请输入第"+i+"同学的姓名");
            String name=sc.next();
            System.out.println("请输入语文成绩");
            int chinese=sc.nextInt();
            System.out.println("请输入数学成绩");
            int math=sc.nextInt();
            System.out.println("请输入英语成绩");
            int english=sc.nextInt();
            Constructor<?> constructor = cs.getDeclaredConstructor(String.class, int.class, int.class, int.class);
            constructor.setAccessible(true);
            Student student = (Student) constructor.newInstance(name, chinese, math, english);
            list.add(student);
        }
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int i = (o1.getChineseScore() + o1.getMathScore() + o1.getEnglishScore()) - (o2.getChineseScore() + o2.getMathScore() + o2.getEnglishScore());
                i = i==0? o1.getChineseScore()-o2.getChineseScore():i;
                i = i==0? o1.getMathScore()-o2.getMathScore():i;
                if (i==0){
                    i=Collator.getInstance(Locale.CHINA).compare(o1.getName(),o2.getName());
                }
                return i;
            }
        });
        BufferedWriter fw=new BufferedWriter(new FileWriter(new File("1015_Reflect/student.txt"),true));
        for (Student student : list) {
            fw.write(String.valueOf(student));
            fw.newLine();
            fw.flush();
        }

    }
}

