package design.mode.prototype.pattern;

import lombok.Cleanup;
import lombok.SneakyThrows;

import java.io.*;

/**
 * 学生类
 */
class Student implements Cloneable, Serializable {
    private String name;
    private Achievement achievement; //成绩

    public Student(String name, Achievement achievement) {
        this.name = name;
        this.achievement = achievement;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAchievement(Achievement achievement) {
        this.achievement = achievement;
    }

    public Achievement getAchievement() {
        return achievement;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", achievement=" + achievement +
                '}';
    }

    @Override
    protected Student clone() throws CloneNotSupportedException {
        //浅克隆
//       return (Student) super.clone();

        //深克隆 1
//        Student student = (Student) super.clone();
//        Achievement achievement = student.getAchievement().clone();
//        student.setAchievement(achievement);
//        return student;

        //深克隆 2 [需要实现接口 Serializable]
        return (Student) this.deepClone();
    }

    @SneakyThrows
    private Object deepClone() {
        @Cleanup ByteArrayOutputStream bos = new ByteArrayOutputStream();
        @Cleanup ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        @Cleanup ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        @Cleanup ObjectInputStream ois = new ObjectInputStream(bis);

        return ois.readObject();
    }
}