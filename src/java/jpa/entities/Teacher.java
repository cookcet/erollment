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
@Table(name = "TEACHER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Teacher.findAll", query = "SELECT t FROM Teacher t")
    , @NamedQuery(name = "Teacher.findByTeacherid", query = "SELECT t FROM Teacher t WHERE t.teacherid = :teacherid")
    , @NamedQuery(name = "Teacher.findByTeaname", query = "SELECT t FROM Teacher t WHERE t.teaname = :teaname")
    , @NamedQuery(name = "Teacher.findByTealname", query = "SELECT t FROM Teacher t WHERE t.tealname = :tealname")
    , @NamedQuery(name = "Teacher.findByTeaadd", query = "SELECT t FROM Teacher t WHERE t.teaadd = :teaadd")
    , @NamedQuery(name = "Teacher.findByTeatel", query = "SELECT t FROM Teacher t WHERE t.teatel = :teatel")
    , @NamedQuery(name = "Teacher.findByTeaciticode", query = "SELECT t FROM Teacher t WHERE t.teaciticode = :teaciticode")})
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TEACHERID")
    private Integer teacherid;
    @Size(max = 40)
    @Column(name = "TEANAME")
    private String teaname;
    @Size(max = 40)
    @Column(name = "TEALNAME")
    private String tealname;
    @Size(max = 100)
    @Column(name = "TEAADD")
    private String teaadd;
    @Size(max = 20)
    @Column(name = "TEATEL")
    private String teatel;
    @Column(name = "TEACITICODE")
    private Integer teaciticode;
    @OneToMany(mappedBy = "teacher")
    private Collection<Clas> clasCollection;

    public Teacher() {
    }

    public Teacher(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public String getTeaname() {
        return teaname;
    }

    public void setTeaname(String teaname) {
        this.teaname = teaname;
    }

    public String getTealname() {
        return tealname;
    }

    public void setTealname(String tealname) {
        this.tealname = tealname;
    }

    public String getTeaadd() {
        return teaadd;
    }

    public void setTeaadd(String teaadd) {
        this.teaadd = teaadd;
    }

    public String getTeatel() {
        return teatel;
    }

    public void setTeatel(String teatel) {
        this.teatel = teatel;
    }

    public Integer getTeaciticode() {
        return teaciticode;
    }

    public void setTeaciticode(Integer teaciticode) {
        this.teaciticode = teaciticode;
    }

    @XmlTransient
    public Collection<Clas> getClasCollection() {
        return clasCollection;
    }

    public void setClasCollection(Collection<Clas> clasCollection) {
        this.clasCollection = clasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teacherid != null ? teacherid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teacher)) {
            return false;
        }
        Teacher other = (Teacher) object;
        if ((this.teacherid == null && other.teacherid != null) || (this.teacherid != null && !this.teacherid.equals(other.teacherid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "jpa.entities.Teacher[ teacherid=" + teacherid + " ]";
        return teaname +" "+ tealname;
    }
    
}
