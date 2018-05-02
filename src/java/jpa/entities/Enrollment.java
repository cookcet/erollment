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
@Table(name = "ENROLLMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enrollment.findAll", query = "SELECT e FROM Enrollment e")
    , @NamedQuery(name = "Enrollment.findByEnrollmentid", query = "SELECT e FROM Enrollment e WHERE e.enrollmentid = :enrollmentid")
    , @NamedQuery(name = "Enrollment.findByEnrollmentgrade", query = "SELECT e FROM Enrollment e WHERE e.enrollmentgrade = :enrollmentgrade")
    , @NamedQuery(name = "Enrollment.findByEnrollmentseme", query = "SELECT e FROM Enrollment e WHERE e.enrollmentseme = :enrollmentseme")
    , @NamedQuery(name = "Enrollment.findByEnrollmentresult", query = "SELECT e FROM Enrollment e WHERE e.enrollmentresult = :enrollmentresult")})
public class Enrollment implements Serializable {

    @OneToMany(mappedBy = "enroll")
    private Collection<Home> homeCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ENROLLMENTID")
    private Integer enrollmentid;
    @Size(max = 40)
    @Column(name = "ENROLLMENTGRADE")
    private String enrollmentgrade;
    @Size(max = 40)
    @Column(name = "ENROLLMENTSEME")
    private String enrollmentseme;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ENROLLMENTRESULT")
    private Double enrollmentresult;
    @JoinColumn(name = "CLAS", referencedColumnName = "CLASSID")
    @ManyToOne
    private Clas clas;
    @JoinColumn(name = "STUDENT", referencedColumnName = "STUDENTID")
    @ManyToOne
    private Student student;

    public Enrollment() {
    }

    public Enrollment(Integer enrollmentid) {
        this.enrollmentid = enrollmentid;
    }

    public Integer getEnrollmentid() {
        return enrollmentid;
    }

    public void setEnrollmentid(Integer enrollmentid) {
        this.enrollmentid = enrollmentid;
    }

    public String getEnrollmentgrade() {
        return enrollmentgrade;
    }

    public void setEnrollmentgrade(String enrollmentgrade) {
        this.enrollmentgrade = enrollmentgrade;
    }

    public String getEnrollmentseme() {
        return enrollmentseme;
    }

    public void setEnrollmentseme(String enrollmentseme) {
        this.enrollmentseme = enrollmentseme;
    }

    public Double getEnrollmentresult() {
        return enrollmentresult;
    }

    public void setEnrollmentresult(Double enrollmentresult) {
        this.enrollmentresult = enrollmentresult;
    }

    public Clas getClas() {
        return clas;
    }

    public void setClas(Clas clas) {
        this.clas = clas;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enrollmentid != null ? enrollmentid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enrollment)) {
            return false;
        }
        Enrollment other = (Enrollment) object;
        if ((this.enrollmentid == null && other.enrollmentid != null) || (this.enrollmentid != null && !this.enrollmentid.equals(other.enrollmentid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Enrollment[ enrollmentid=" + enrollmentid + " ]";
    }

    @XmlTransient
    public Collection<Home> getHomeCollection() {
        return homeCollection;
    }

    public void setHomeCollection(Collection<Home> homeCollection) {
        this.homeCollection = homeCollection;
    }
    
}
