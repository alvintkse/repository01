/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "STUDENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findByStudentidAndStudentpassword", query = "SELECT s FROM Student s WHERE s.studentid = :studentid and s.studentpassword = :studentpassword")
    , @NamedQuery(name = "Student.findByStudentidAndStudentcreditpoints", query = "SELECT s FROM Student s WHERE s.studentid = :studentid and s.studentcreditpoints = :studentcreditpoints")
    , @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
    , @NamedQuery(name = "Student.findByStudentid", query = "SELECT s FROM Student s WHERE s.studentid = :studentid")
    , @NamedQuery(name = "Student.findByStudentname", query = "SELECT s FROM Student s WHERE s.studentname = :studentname")
    , @NamedQuery(name = "Student.findByStudentpassword", query = "SELECT s FROM Student s WHERE s.studentpassword = :studentpassword")
    , @NamedQuery(name = "Student.findByStudentemail", query = "SELECT s FROM Student s WHERE s.studentemail = :studentemail")
    , @NamedQuery(name = "Student.findByStudentcreditpoints", query = "SELECT s FROM Student s WHERE s.studentcreditpoints = :studentcreditpoints")
    , @NamedQuery(name = "Student.findByStudentphoneno", query = "SELECT s FROM Student s WHERE s.studentphoneno = :studentphoneno")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "STUDENTID")
    private String studentid;
    @Size(max = 100)
    @Column(name = "STUDENTNAME")
    private String studentname;
    @Size(max = 50)
    @Column(name = "STUDENTPASSWORD")
    private String studentpassword;
    @Size(max = 50)
    @Column(name = "STUDENTEMAIL")
    private String studentemail;
    @Column(name = "STUDENTCREDITPOINTS")
    private Integer studentcreditpoints;
    @Size(max = 12)
    @Column(name = "STUDENTPHONENO")
    private String studentphoneno;
    @OneToMany(mappedBy = "studentid")
    private Collection<Mealorder> mealorderCollection;

    public Student() {
    }

    public Student(String studentid) {
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

    public String getStudentpassword() {
        return studentpassword;
    }

    public void setStudentpassword(String studentpassword) {
        this.studentpassword = studentpassword;
    }

    public String getStudentemail() {
        return studentemail;
    }

    public void setStudentemail(String studentemail) {
        this.studentemail = studentemail;
    }

    public Integer getStudentcreditpoints() {
        return studentcreditpoints;
    }

    public void setStudentcreditpoints(Integer studentcreditpoints) {
        this.studentcreditpoints = studentcreditpoints;
    }

    public String getStudentphoneno() {
        return studentphoneno;
    }

    public void setStudentphoneno(String studentphoneno) {
        this.studentphoneno = studentphoneno;
    }
    
    public int addCreditPoints(int amount){
        return studentcreditpoints += amount;
    }

    @XmlTransient
    public Collection<Mealorder> getMealorderCollection() {
        return mealorderCollection;
    }

    public void setMealorderCollection(Collection<Mealorder> mealorderCollection) {
        this.mealorderCollection = mealorderCollection;
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
        return "entity.Student[ studentid=" + studentid + " ]";
    }
    
}
