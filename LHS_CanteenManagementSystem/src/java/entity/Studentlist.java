/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "STUDENTLIST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Studentlist.findAll", query = "SELECT s FROM Studentlist s")
    , @NamedQuery(name = "Studentlist.findByStudentid", query = "SELECT s FROM Studentlist s WHERE s.studentid = :studentid")
    , @NamedQuery(name = "Studentlist.findByStudentname", query = "SELECT s FROM Studentlist s WHERE s.studentname = :studentname")})
public class Studentlist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "STUDENTID")
    private String studentid;
    @Size(max = 50)
    @Column(name = "STUDENTNAME")
    private String studentname;

    public Studentlist() {
    }

    public Studentlist(String studentid) {
        this.studentid = studentid;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
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
        if (!(object instanceof Studentlist)) {
            return false;
        }
        Studentlist other = (Studentlist) object;
        if ((this.studentid == null && other.studentid != null) || (this.studentid != null && !this.studentid.equals(other.studentid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Studentlist[ studentid=" + studentid + " ]";
    }
    
}
