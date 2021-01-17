package org.example.bean;

/**
 * @author xianpeng.xia
 * on 2021/1/17 12:41 下午
 */
public class Person implements Comparable<Person> {

    private String name;
    private int age;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Person p = (Person) obj;
        return this.name.equals(p.name);
    }

    @Override
    public int compareTo(Person o) {
        return o.age - this.age;
    }

    @Override
    public String toString() {
        return "Person{" +
            "name='" + name + '\'' +
            ", age=" + age +
            '}';
    }
}
