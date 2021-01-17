package org.example.bean;

/**
 * @author xianpeng.xia
 * on 2021/1/17 12:41 下午
 */
public class Person {

    private String name;

    public Person(String name) {
        this.name = name;
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
}
