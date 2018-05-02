/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "HOME")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Home.findAll", query = "SELECT h FROM Home h")
    , @NamedQuery(name = "Home.findByHomeid", query = "SELECT h FROM Home h WHERE h.homeid = :homeid")})
public class Home implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "HOMEID")
    private Integer homeid;
    @JoinColumn(name = "ENROLL", referencedColumnName = "ENROLLMENTID")
    @ManyToOne
    private Enrollment enroll;

    public Home() {
    }

    public Home(Integer homeid) {
        this.homeid = homeid;
    }

    public Integer getHomeid() {
        return homeid;
    }

    public void setHomeid(Integer homeid) {
        this.homeid = homeid;
    }

    public Enrollment getEnroll() {
        return enroll;
    }

    public void setEnroll(Enrollment enroll) {
        this.enroll = enroll;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (homeid != null ? homeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Home)) {
            return false;
        }
        Home other = (Home) object;
        if ((this.homeid == null && other.homeid != null) || (this.homeid != null && !this.homeid.equals(other.homeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Home[ homeid=" + homeid + " ]";
    }
    
}
