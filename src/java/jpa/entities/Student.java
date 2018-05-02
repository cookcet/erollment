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
@Table(name = "STUDENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
    , @NamedQuery(name = "Student.findByStudentid", query = "SELECT s FROM Student s WHERE s.studentid = :studentid")
    , @NamedQuery(name = "Student.findByStdname", query = "SELECT s FROM Student s WHERE s.stdname = :stdname")
    , @NamedQuery(name = "Student.findByStdlname", query = "SELECT s FROM Student s WHERE s.stdlname = :stdlname")
    , @NamedQuery(name = "Student.findByStdadd", query = "SELECT s FROM Student s WHERE s.stdadd = :stdadd")
    , @NamedQuery(name = "Student.findByStdtel", query = "SELECT s FROM Student s WHERE s.stdtel = :stdtel")
    , @NamedQuery(name = "Student.findByStdfam", query = "SELECT s FROM Student s WHERE s.stdfam = :stdfam")
    , @NamedQuery(name = "Student.findByStdblood", query = "SELECT s FROM Student s WHERE s.stdblood = :stdblood")
    , @NamedQuery(name = "Student.findByStdciticode", query = "SELECT s FROM Student s WHERE s.stdciticode = :stdciticode")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "STUDENTID")
    private Integer studentid;
    @Size(max = 40)
    @Column(name = "STDNAME")
    private String stdname;
    @Size(max = 40)
    @Column(name = "STDLNAME")
    private String stdlname;
    @Size(max = 100)
    @Column(name = "STDADD")
    private String stdadd;
    @Size(max = 20)
    @Column(name = "STDTEL")
    private String stdtel;
    @Size(max = 50)
    @Column(name = "STDFAM")
    private String stdfam;
    @Size(max = 5)
    @Column(name = "STDBLOOD")
    private String stdblood;
    @Column(name = "STDCITICODE")
    private Integer stdciticode;
    @OneToMany(mappedBy = "student")
    private Collection<Enrollment> enrollmentCollection;

    public Student() {
    }

    public Student(Integer studentid) {
        this.studentid = studentid;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public String getStdname() {
        return stdname;
    }

    public void setStdname(String stdname) {
        this.stdname = stdname;
    }

    public String getStdlname() {
        return stdlname;
    }

    public void setStdlname(String stdlname) {
        this.stdlname = stdlname;
    }

    public String getStdadd() {
        return stdadd;
    }

    public void setStdadd(String stdadd) {
        this.stdadd = stdadd;
    }

    public String getStdtel() {
        return stdtel;
    }

    public void setStdtel(String stdtel) {
        this.stdtel = stdtel;
    }

    public String getStdfam() {
        return stdfam;
    }

    public void setStdfam(String stdfam) {
        this.stdfam = stdfam;
    }

    public String getStdblood() {
        return stdblood;
    }

    public void setStdblood(String stdblood) {
        this.stdblood = stdblood;
    }

    public Integer getStdciticode() {
        return stdciticode;
    }

    public void setStdciticode(Integer stdciticode) {
        this.stdciticode = stdciticode;
    }

    @XmlTransient
    public Collection<Enrollment> getEnrollmentCollection() {
        return enrollmentCollection;
    }

    public void setEnrollmentCollection(Collection<Enrollment> enrollmentCollection) {
        this.enrollmentCollection = enrollmentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentid != null ? studentid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.studentid == null && other.studentid != null) || (this.studentid != null && !this.studentid.equals(other.studentid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "jpa.entities.Student[ studentid=" + studentid + " ]";
        return stdname +" "+ stdlname;
    }
    
}
