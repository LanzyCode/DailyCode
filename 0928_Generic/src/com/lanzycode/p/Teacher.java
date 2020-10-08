package com.lanzycode.p;

public class Teacher {
    private String name;
    private Integer chinese;
    private Integer math;

    public Teacher() {
    }

    public Teacher(String name, Integer chinese, Integer math) {
        this.name = name;
        this.chinese = chinese;
        this.math = math;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Teacher{");
        sb.append("name='").append(name).append('\'');
        sb.append(", chinese=").append(chinese);
        sb.append(", math=").append(math);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        if (name != null ? !name.equals(teacher.name) : teacher.name != null) return false;
        if (chinese != null ? !chinese.equals(teacher.chinese) : teacher.chinese != null) return false;
        return math != null ? math.equals(teacher.math) : teacher.math == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (chinese != null ? chinese.hashCode() : 0);
        result = 31 * result + (math != null ? math.hashCode() : 0);
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getChinese() {
        return chinese;
    }

    public void setChinese(Integer chinese) {
        this.chinese = chinese;
    }

    public Integer getMath() {
        return math;
    }

    public void setMath(Integer math) {
        this.math = math;
    }
}
