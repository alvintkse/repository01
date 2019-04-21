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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author User
 */
@Entity
@Table(name = "MEAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Meal.findAll", query = "SELECT m FROM Meal m")
    , @NamedQuery(name = "Meal.findByMealid", query = "SELECT m FROM Meal m WHERE m.mealid = :mealid")
    , @NamedQuery(name = "Meal.findByMealname", query = "SELECT m FROM Meal m WHERE m.mealname = :mealname")
    , @NamedQuery(name = "Meal.findByMealtype", query = "SELECT m FROM Meal m WHERE m.mealtype = :mealtype")
    , @NamedQuery(name = "Meal.findByMealcreditpoints", query = "SELECT m FROM Meal m WHERE m.mealcreditpoints = :mealcreditpoints")})
public class Meal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "MEALID")
    private String mealid;
    @Size(max = 50)
    @Column(name = "MEALNAME")
    private String mealname;
    @Size(max = 10)
    @Column(name = "MEALTYPE")
    private String mealtype;
    @Column(name = "MEALCREDITPOINTS")
    private Integer mealcreditpoints;
    @OneToMany(mappedBy = "mealname")
    private Collection<Mealorder> mealorderCollection;
    @OneToMany(mappedBy = "mealid")
    private Collection<Mealorderb> mealorderbCollection;
    @JoinColumn(name = "BEVERAGENAME", referencedColumnName = "BEVERAGENAME")
    @ManyToOne
    private Beverage beveragename;
    @JoinColumn(name = "FOODNAME", referencedColumnName = "FOODNAME")
    @ManyToOne
    private Food foodname;

    public Meal() {
    }

    public Meal(String mealid) {
        this.mealid = mealid;
    }

    public String getMealid() {
        return mealid;
    }

    public void setMealid(String mealid) {
        this.mealid = mealid;
    }

    public String getMealname() {
        return mealname;
    }

    public void setMealname(String mealname) {
        this.mealname = mealname;
    }

    public String getMealtype() {
        return mealtype;
    }

    public void setMealtype(String mealtype) {
        this.mealtype = mealtype;
    }

    public Integer getMealcreditpoints() {
        return mealcreditpoints;
    }

    public void setMealcreditpoints(Integer mealcreditpoints) {
        this.mealcreditpoints = mealcreditpoints;
    }

    @XmlTransient
    public Collection<Mealorder> getMealorderCollection() {
        return mealorderCollection;
    }

    public void setMealorderCollection(Collection<Mealorder> mealorderCollection) {
        this.mealorderCollection = mealorderCollection;
    }

    @XmlTransient
    public Collection<Mealorderb> getMealorderbCollection() {
        return mealorderbCollection;
    }

    public void setMealorderbCollection(Collection<Mealorderb> mealorderbCollection) {
        this.mealorderbCollection = mealorderbCollection;
    }

    public Beverage getBeveragename() {
        return beveragename;
    }

    public void setBeveragename(Beverage beveragename) {
        this.beveragename = beveragename;
    }

    public Food getFoodname() {
        return foodname;
    }

    public void setFoodname(Food foodname) {
        this.foodname = foodname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mealid != null ? mealid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Meal)) {
            return false;
        }
        Meal other = (Meal) object;
        if ((this.mealid == null && other.mealid != null) || (this.mealid != null && !this.mealid.equals(other.mealid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Meal[ mealid=" + mealid + " ]";
    }
    
}
