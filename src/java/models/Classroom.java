

package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "classrooms")
public class Classroom {
    private Long id;
    private int number;
    private String comment;

    public Classroom(int number, String comment) {
        this.number = number;
        this.comment = comment;
    }

    public Classroom() {
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

    @Column(name = "number")
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.number;
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
        final Classroom other = (Classroom) obj;
        if (this.number != other.number) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classroom{" + "number=" + number + ", comment=" + comment + '}';
    }
    
}
