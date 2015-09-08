/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startek.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Niwoogaba_Joel
 */
@SuppressWarnings("serial")
@XmlRootElement
@Entity
@Table(name = "wed_articlecategory")
public class ArticleCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryid;
    private boolean active;
    private String categoryname;
    private String categorydescrption;
    private String categoryimage;

    public ArticleCategory() {
    }

    public ArticleCategory(Long categoryid, String categoryname, String categorydescrption) {
        this.categoryid = categoryid;
        this.categoryname = categoryname;
        this.categorydescrption = categorydescrption;
    }

    public ArticleCategory(String categoryname, String categorydescrption, String posttype) {
        this.categoryname = categoryname;
        this.categorydescrption = categorydescrption;
    }

    public String getCategoryimage() {
        return categoryimage;
    }

    public void setCategoryimage(String categoryimage) {
        this.categoryimage = categoryimage;
    }

    
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public String getCategorydescrption() {
        return categorydescrption;
    }

    public void setCategorydescrption(String categorydescrption) {
        this.categorydescrption = categorydescrption;
    }


    public Long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }
    
    

}
