/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startek.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Niwoogaba_Joel
 */
@SuppressWarnings("serial")
@XmlRootElement
@Entity
@Table(name = "wed_vendor_review")
public class VendorReview implements Serializable {

    /**
	 * 
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reviewid;
    private String reviewtitle;
    @Column(columnDefinition = "LONG_TEXT")
    private String reviewdescription;
    private Double rating;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date createdon;
    @OneToOne
    private AppUser appuser;

    public VendorReview() {
    }

    public VendorReview(String reviewtitle, String reviewdescription, Double rating, Date createdon) {
        this.reviewtitle = reviewtitle;
        this.reviewdescription = reviewdescription;
        this.rating = rating;
        this.createdon = createdon;
    }
    
    

    public Long getReviewid() {
        return reviewid;
    }

    public void setReviewid(Long reviewid) {
        this.reviewid = reviewid;
    }

    public String getReviewtitle() {
        return reviewtitle;
    }

    public void setReviewtitle(String reviewtitle) {
        this.reviewtitle = reviewtitle;
    }

    public String getReviewdescription() {
        return reviewdescription;
    }

    public void setReviewdescription(String reviewdescription) {
        this.reviewdescription = reviewdescription;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Date getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Date createdon) {
        this.createdon = createdon;
    }

    public AppUser getAppuser() {
        return appuser;
    }

    public void setAppuser(AppUser appuser) {
        this.appuser = appuser;
    }
    
    

}
