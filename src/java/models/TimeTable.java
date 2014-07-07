

package models;

import java.sql.Time;
import java.time.DayOfWeek;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "timetables")
public class TimeTable {
    private Long id;
    private DayOfWeek dayOfWeek;
    private Time time;
    private Set<GroupOfStudents> groupsOfStudent = 
            new LinkedHashSet<GroupOfStudents>();
    private Classroom classroom;
    private Course course;

    public TimeTable() {
    }

    public TimeTable(DayOfWeek dayOfWeek, Time time, Classroom classroom, Course course) {
        this.dayOfWeek = dayOfWeek;
        this.time = time;
        this.classroom = classroom;
        this.course = course;
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

    @Column(name = "dayofweek")
    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @Column(name = "time")
    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @OneToMany
    public Set<GroupOfStudents> getGroupsOfStudent() {
        return groupsOfStudent;
    }

    public void setGroupsOfStudent(Set<GroupOfStudents> groupsOfStudent) {
        this.groupsOfStudent = groupsOfStudent;
    }

    @OneToOne
    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    @OneToOne
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    
    public void deleteGroupOfStudent(GroupOfStudents group){
        groupsOfStudent.remove(group);
    }
    
    public void addGroupOfStudent(GroupOfStudents group){
        groupsOfStudent.add(group);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.dayOfWeek);
        hash = 73 * hash + Objects.hashCode(this.time);
        hash = 73 * hash + Objects.hashCode(this.classroom);
        hash = 73 * hash + Objects.hashCode(this.course);
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
        final TimeTable other = (TimeTable) obj;
        if (this.dayOfWeek != other.dayOfWeek) {
            return false;
        }
        if (!Objects.equals(this.time, other.time)) {
            return false;
        }
        if (!Objects.equals(this.classroom, other.classroom)) {
            return false;
        }
        if (!Objects.equals(this.course, other.course)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TimeTable{" + "dayOfWeek=" + dayOfWeek + ", time=" + time
                + ", groupsOfStudent=" + groupsOfStudent + ", classroom=" +
                classroom + ", course=" + course.getName() + '}';
    }
      
}
