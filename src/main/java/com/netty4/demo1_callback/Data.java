package com.netty4.demo1_callback;

import java.util.Objects;

/**
 * Created by garychen on 2017/5/19.
 */
public class Data {
    private String name;
    private int age;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Data{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return age == data.age &&
                Objects.equals(name, data.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
