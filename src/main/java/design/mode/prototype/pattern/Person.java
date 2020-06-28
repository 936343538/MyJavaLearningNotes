package design.mode.prototype.pattern;

class Person implements Cloneable{

    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    protected Person clone() throws CloneNotSupportedException {  
        return (Person)super.clone();   //调用父类的clone方法
    }
}