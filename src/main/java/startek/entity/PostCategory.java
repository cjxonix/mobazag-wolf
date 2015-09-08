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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Niwoogaba_Joel
 */
@SuppressWarnings("serial")
@XmlRootElement
@Entity
@Table(name = "wed_postcategory")
public class PostCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryid;
    private boolean active;
    private String categoryname;
    private String categorydescrption;
    private String posttype;//[Local Vendors,Dresses & Jewwly] Main Types.. FROM ENUM.
    private String categoryimage;

    //Trasient fields
    @Transient
    private long items_size;
    @Transient
    private int num_rows;

    public PostCategory(Long categoryid, String categoryname, String categorydescrption, long items_size, int num_rows) {
        this.categoryid = categoryid;
        this.categoryname = categoryname;
        this.categorydescrption = categorydescrption;
        this.items_size = items_size;
        this.num_rows = num_rows;
    }

    public PostCategory() {
    }

    public PostCategory(Long categoryid, String categoryname, String categorydescrption, String posttype) {
        this.categoryid = categoryid;
        this.categoryname = categoryname;
        this.categorydescrption = categorydescrption;
        this.posttype = posttype;
    }

    public PostCategory(String categoryname, String categorydescrption, String posttype) {
        this.categoryname = categoryname;
        this.categorydescrption = categorydescrption;
        this.posttype = posttype;
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

    public String getPosttype() {
        return posttype;
    }

    public void setPosttype(String posttype) {
        this.posttype = posttype;
    }

    public Long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }

    public long getItems_size() {
        return items_size;
    }

    public void setItems_size(long items_size) {
        this.items_size = items_size;
    }

    public int getNum_rows() {
        return num_rows;
    }

    public void setNum_rows(int num_rows) {
        this.num_rows = num_rows;
    }

}
