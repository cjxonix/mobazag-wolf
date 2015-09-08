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
@Table(name = "wed_pageslider")
public class MainSliderPosts implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sliderid;
    private String slidertitle;
    private String sliderdetails;
    @OneToOne
    private WeddingPost weddingpost;
    private boolean active;
    private boolean viewstate;
    private int views;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date postdata;

    public MainSliderPosts() {
    }

    public Long getSliderid() {
        return sliderid;
    }

    public void setSliderid(Long sliderid) {
        this.sliderid = sliderid;
    }

    public String getSlidertitle() {
        return slidertitle;
    }

    public void setSlidertitle(String slidertitle) {
        this.slidertitle = slidertitle;
    }

    public String getSliderdetails() {
        return sliderdetails;
    }

    public void setSliderdetails(String sliderdetails) {
        this.sliderdetails = sliderdetails;
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

    public Date getPostdata() {
        return postdata;
    }

    public void setPostdata(Date postdata) {
        this.postdata = postdata;
    }

}
