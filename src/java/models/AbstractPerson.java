

package models;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractPerson {
    private int age;
    private String name;

    public AbstractPerson() {
    }

    
    
    public AbstractPerson(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
   
}
