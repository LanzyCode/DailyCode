package com.lanzycode.exam1;

public class Student {
    private String name;
    private Integer chineseScore;
    private Integer mathScore;
    private Integer englishScore;

    public int getSumScore() {
        return chineseScore + mathScore + englishScore;
    }

    public String getString() {
        StringBuilder sb = new StringBuilder("姓名:");
        sb.append(name).append(getSumScore()).append(" 语文:").append(chineseScore).append(" 数学:").append(mathScore).append(" 英语:").append(englishScore);
        return sb.toString();
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

    public Student() {
    }

    public Student(String name, Integer chineseScore, Integer mathScore, Integer englishScore) {
        this.name = name;
        this.chineseScore = chineseScore;
        this.mathScore = mathScore;
        this.englishScore = englishScore;
    }
}
