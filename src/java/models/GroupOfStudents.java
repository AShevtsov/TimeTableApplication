

package models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "groups")
public class GroupOfStudents implements Serializable {
    private Long id;
    private String speciality;
    private Faculty faculty;
    private int yearOfStudy;
    private int numberOfGroup;
    
    public GroupOfStudents() {
    }

    public GroupOfStudents(String speciality, Faculty faculty, int yearOfStudy, int numberOfGroup) {
        this.speciality = speciality;
        this.faculty = faculty;
        this.yearOfStudy = yearOfStudy;
        this.numberOfGroup = numberOfGroup;
    }

    @Column(name = "number")
    public int getNumberOfGroup() {
        return numberOfGroup;
    }

    public void setNumberOfGroup(int numberOfGroup) {
        this.numberOfGroup = numberOfGroup;
    }
    
    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GroupOfStudents other = (GroupOfStudents) obj;
        if (!Objects.equals(this.speciality, other.speciality)) {
            return false;
        }
        if (!Objects.equals(this.faculty, other.faculty)) {
            return false;
        }
        if (this.yearOfStudy != other.yearOfStudy) {
            return false;
        }
        return this.numberOfGroup == other.numberOfGroup;
    }

    @Column(name = "speciality")
    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @OneToOne
    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @Column(name = "yearofstudy")
    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    @Override
    public String toString() {
        return "GroupOfStudents{" + "speciality=" + speciality + 
                ", faculty=" + faculty.getName() + ", yearOfStudy=" + yearOfStudy + '}';
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
       
}
