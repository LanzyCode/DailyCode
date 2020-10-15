package com.lanzycode.domain;

import java.util.Objects;

/*
新建一个类Student -> String name,Integer chineseScore,Integer mathScore,Integer englishScore.
[GET/SET/有参/无参/toString/equals]
*/
public class Student {
    private String name;
    private Integer chineseScore;
    private Integer mathScore;
    private Integer englishScore;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) &&
                Objects.equals(chineseScore, student.chineseScore) &&
                Objects.equals(mathScore, student.mathScore) &&
                Objects.equals(englishScore, student.englishScore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, chineseScore, mathScore, englishScore);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("name='").append(name).append('\'');
        sb.append(", chineseScore=").append(chineseScore);
        sb.append(", mathScore=").append(mathScore);
        sb.append(", englishScore=").append(englishScore);
        sb.append('}');
        return sb.toString();
    }

    public Student(String name, Integer chineseScore, Integer mathScore, Integer englishScore) {
        this.name = name;
        this.chineseScore = chineseScore;
        this.mathScore = mathScore;
        this.englishScore = englishScore;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getChineseScore() {
        return chineseScore;
    }

    public void setChineseScore(Integer chineseScore) {
        this.chineseScore = chineseScore;
    }

    public Integer getMathScore() {
        return mathScore;
    }

    public void setMathScore(Integer mathScore) {
        this.mathScore = mathScore;
    }

    public Integer getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(Integer englishScore) {
        this.englishScore = englishScore;
    }
}
