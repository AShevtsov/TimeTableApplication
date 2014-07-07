

package models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Students")
public class Student extends AbstractPerson implements Serializable{
    private Long id;
    private GroupOfStudents group;

    public Student() {
    }

    public Student(GroupOfStudents group, int age, String name) {
        super(age, name);
        this.group = group;
    }

    @OneToOne
    public GroupOfStudents getGroup() {
        return group;
    }

    public void setGroup(GroupOfStudents group) {
        this.group = group;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.group);
        hash = 97 * hash + Objects.hashCode(this.getAge());
        hash = 97 * hash + Objects.hashCode(this.getName());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (!Objects.equals(this.group, other.group)) {
            return false;
        }
        if (!Objects.equals(this.getName(), other.getName())){
            return false;
        }
        if (!Objects.equals(this.getAge(), other.getAge())){
            return false;
        }
        return true;
    }
    
    
}
