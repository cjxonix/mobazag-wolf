/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startek.entity;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "wed_sponsoredposts")
public class MainSponsoredPosts implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postid;
    private String posttitle;
    private String postdetails;
    @OneToOne
    private WeddingPost weddingpost;
    private boolean active;
    private boolean viewstate;
    private int views;
    /*Time Design of the Post,[weeks,months,year]*/
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date startpostdata;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date endpostdata;

    public MainSponsoredPosts() {
    }

    public Long getPostid() {
        return postid;
    }

    public void setPostid(Long postid) {
        this.postid = postid;
    }

    public String getPosttitle() {
        return posttitle;
    }

    public void setPosttitle(String posttitle) {
        this.posttitle = posttitle;
    }

    public String getPostdetails() {
        return postdetails;
    }

    public void setPostdetails(String postdetails) {
        this.postdetails = postdetails;
    }

    public WeddingPost getWeddingpost() {
        return weddingpost;
    }

    public void setWeddingpost(WeddingPost weddingpost) {
        this.weddingpost = weddingpost;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isViewstate() {
        return viewstate;
    }

    public void setViewstate(boolean viewstate) {
        this.viewstate = viewstate;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public Date getStartpostdata() {
        return startpostdata;
    }

    public void setStartpostdata(Date startpostdata) {
        this.startpostdata = startpostdata;
    }

    public Date getEndpostdata() {
        return endpostdata;
    }

    public void setEndpostdata(Date endpostdata) {
        this.endpostdata = endpostdata;
    }

}
