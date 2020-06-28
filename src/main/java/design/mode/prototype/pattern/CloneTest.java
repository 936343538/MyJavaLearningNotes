package design.mode.prototype.pattern;

public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
//        Person person = new Person(22,"LiLei");
//        Person newPerson = person.clone();
//        person.setAge(21);
//        person.setName("HanMeimei");
//        System.out.println(person.toString());
//        System.out.println(newPerson.toString());
        //即在克隆出新的对象后，修改被克隆对象的基本属性，并不会影响克隆出来的对象。但当被克隆的对象的属性引用其他对象时，此时会有不同的结果。



        Achievement achievement = new Achievement(100,100,100);
        Student student = new Student("LiLei",achievement);
        // 克隆出一个对象
        Student newStudent = student.clone();

        // 修改原有对象的属性
        student.setName("HanMeimei");
        student.getAchievement().setChinese(90);
        student.getAchievement().setEnglish(90);
        student.getAchievement().setMath(90);

        System.out.println(newStudent);
        System.out.println(student);
        //以上现象表明，上述克隆方式为浅克隆，并不会克隆对象的属性引用的对象，当修改被克隆对象的成绩时，
        //克隆出来的对象也会跟着改变，即两个对象的属性引用指向的是同一个对象。

        //值得一提的是，上文所说的浅拷贝只会克隆基本数据属性，而不会克隆引用其他对象的属性，但String对象又不属于基本属性，这又是为什么呢？
        //这是因为String对象是不可修改的对象，每次修改其实都是新建一个新的对象，而不是在原有的对象上修改，所以当修改String属性时其实是新开辟一个空间存储String对象，并把引用指向该内存，而克隆出来的对象的String属性还是指向原有的内存地址，所以String对象在浅克隆中也表现得与基本属性一样。
    }
}