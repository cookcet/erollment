/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "CLAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clas.findAll", query = "SELECT c FROM Clas c")
    , @NamedQuery(name = "Clas.findByClassid", query = "SELECT c FROM Clas c WHERE c.classid = :classid")
    , @NamedQuery(name = "Clas.findByClasseme", query = "SELECT c FROM Clas c WHERE c.classeme = :classeme")
    , @NamedQuery(name = "Clas.findByClassec", query = "SELECT c FROM Clas c WHERE c.classec = :classec")})
public class Clas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CLASSID")
    private Integer classid;
    @Size(max = 40)
    @Column(name = "CLASSEME")
    private String classeme;
    @Column(name = "CLASSEC")
    private Integer classec;
    @OneToMany(mappedBy = "clas")
    private Collection<Enrollment> enrollmentCollection;
    @JoinColumn(name = "COURSE", referencedColumnName = "COURSEID")
    @ManyToOne
    private Course course;
    @JoinColumn(name = "TEACHER", referencedColumnName = "TEACHERID")
    @ManyToOne
    private Teacher teacher;

    public Clas() {
    }

    public Clas(Integer classid) {
        this.classid = classid;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public String getClasseme() {
        return classeme;
    }

    public void setClasseme(String classeme) {
        this.classeme = classeme;
    }

    public Integer getClassec() {
        return classec;
    }

    public void setClassec(Integer classec) {
        this.classec = classec;
    }

    @XmlTransient
    public Collection<Enrollment> getEnrollmentCollection() {
        return enrollmentCollection;
    }

    public void setEnrollmentCollection(Collection<Enrollment> enrollmentCollection) {
        this.enrollmentCollection = enrollmentCollection;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (classid != null ? classid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clas)) {
            return false;
        }
        Clas other = (Clas) object;
        if ((this.classid == null && other.classid != null) || (this.classid != null && !this.classid.equals(other.classid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "jpa.entities.Clas[ classid=" + classid + " ]";
        return classeme;
    }
    
}
