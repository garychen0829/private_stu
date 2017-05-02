package com.xstream.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * Created by garychen on 2017/4/28.
 */
@XStreamAlias("teacher")
public class TeacherBean {
    @XStreamAlias("name")
    @XStreamAsAttribute
    private String teachName;
    @XStreamAlias("age")
    private int teachAge;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TeacherBean{");
        sb.append("teachName='").append(teachName).append('\'');
        sb.append(", teachAge=").append(teachAge);
        sb.append('}');
        return sb.toString();
    }

    public String getTeachName() {
        return teachName;
    }

    public void setTeachName(String teachName) {
        this.teachName = teachName;
    }

    public int getTeachAge() {
        return teachAge;
    }

    public void setTeachAge(int teachAge) {
        this.teachAge = teachAge;
    }
}
