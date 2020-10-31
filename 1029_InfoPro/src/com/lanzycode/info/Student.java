package com.lanzycode.info;

import java.util.Arrays;
import java.util.Objects;

public class Student {
    private String username;
    private String age;
    private String[] hobby;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("username='").append(username).append('\'');
        sb.append(", age='").append(age).append('\'');
        sb.append(", hobby=").append(hobby == null ? "null" : Arrays.asList(hobby).toString());
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(username, student.username) &&
                Objects.equals(age, student.age) &&
                Arrays.equals(hobby, student.hobby);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(username, age);
        result = 31 * result + Arrays.hashCode(hobby);
        return result;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public Student() {
    }

    public Student(String username, String age, String[] hobby) {
        this.username = username;
        this.age = age;
        this.hobby = hobby;
    }
}
