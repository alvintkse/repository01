/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.*;
import javax.xml.bind.annotation.*;

/**
 *
 * @author user
 */
@Entity
@Table(name = "BEVERAGE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Beverage.findAll", query = "SELECT b FROM Beverage b")
    , @NamedQuery(name = "Beverage.findByBeverageid", query = "SELECT b FROM Beverage b WHERE b.beverageid = :beverageid")
    , @NamedQuery(name = "Beverage.findByBeveragename", query = "SELECT b FROM Beverage b WHERE b.beveragename = :beveragename")
    , @NamedQuery(name = "Beverage.findByBeveragecreditpoints", query = "SELECT b FROM Beverage b WHERE b.beveragecreditpoints = :beveragecreditpoints")
    , @NamedQuery(name = "Beverage.findByBeveragequantity", query = "SELECT b FROM Beverage b WHERE b.beveragequantity = :beveragequantity")
    , @NamedQuery(name = "Beverage.findByBeverageidAsc", query = "SELECT b FROM Beverage b ORDER BY b.beverageid")})
public class Beverage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "BEVERAGEID")
    private String beverageid;
    @Size(max = 50)
    @Column(name = "BEVERAGENAME")
    private String beveragename;
    @Column(name = "BEVERAGECREDITPOINTS")
    private Integer beveragecreditpoints;
    @Column(name = "BEVERAGEQUANTITY")
    private Integer beveragequantity;
    @OneToMany(mappedBy = "beveragename", cascade = CascadeType.ALL)
    private Collection<Meal> mealCollection;

    public Beverage() {
    }

    public Beverage(String beverageid) {
        this.beverageid = beverageid;
    }

    public String getBeverageid() {
        return beverageid;
    }

    public void setBeverageid(String beverageid) {
        this.beverageid = beverageid;
    }

    public String getBeveragename() {
        return beveragename;
    }

    public void setBeveragename(String beveragename) {
        this.beveragename = beveragename;
    }

    public Integer getBeveragecreditpoints() {
        return beveragecreditpoints;
    }

    public void setBeveragecreditpoints(Integer beveragecreditpoints) {
        this.beveragecreditpoints = beveragecreditpoints;
    }

    public Integer getBeveragequantity() {
        return beveragequantity;
    }

    public void setBeveragequantity(Integer beveragequantity) {
        this.beveragequantity = beveragequantity;
    }
    
    public void addMeal(Meal meal){
        this.mealCollection.add(meal);
        meal.setBeveragename(this);
    }
    
    @XmlTransient
    public Collection<Meal> getMealCollection() {
        return mealCollection;
    }

    public void setMealCollection(Collection<Meal> mealCollection) {
        this.mealCollection = mealCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (beverageid != null ? beverageid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Beverage)) {
            return false;
        }
        Beverage other = (Beverage) object;
        if ((this.beverageid == null && other.beverageid != null) || (this.beverageid != null && !this.beverageid.equals(other.beverageid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Beverage[ beverageid=" + beverageid + " ]";
    }
    
}
