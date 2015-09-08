/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startek.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Niwoogaba_Joel
 */
@SuppressWarnings("serial")
@XmlRootElement
@Entity
@Table(name = "wed_user")
public class AppUser implements Serializable {

	@ManyToMany
	@JoinTable
	private List<Role> roles;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userid;
	private String email;
	private String phone;
	private String password;
	private String fbid;
	private String lname;
	private String fname;
	private String thumb;
	private String country;
	private String city;
	private String about;

	private String cando;
	private Double lotd;
	private Double latd;
	private String keycode;
	private boolean verified;
	private String username;
	private Long profileviews;
	// socail information call
	private String fb_;
	private String tw_;
	private String gp_;
	private String li_;
	private String ig_;
	private String website;

	// Trasient fields
	@Transient
	private long items_size;
	@Transient
	private int num_rows;
	private boolean sponsored;
	private boolean active;
	private boolean activate;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date sponsored_start_date;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date sponsored_start_end;

	@Column(name = "created_at")
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date createdAt;
	@Column(name = "updated_at")
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date updatedAt;

	public AppUser(String email, String phone, String password, String lname,
			String fname, String thumb, String country, String city,
			String about, String cando, String username, Long profileviews,
			boolean active,boolean activate) {
		super();
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.lname = lname;
		this.fname = fname;
		this.thumb = thumb;
		this.country = country;
		this.city = city;
		this.about = about;
		this.cando = cando;
		this.username = username;
		this.profileviews = profileviews;
		this.active = active;
		this.activate =activate;
	}

	public boolean isActivate() {
		return activate;
	}

	public void setActivate(boolean activate) {
		this.activate = activate;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Date getSponsored_start_date() {
		return sponsored_start_date;
	}

	public void setSponsored_start_date(Date sponsored_start_date) {
		this.sponsored_start_date = sponsored_start_date;
	}

	public Date getSponsored_start_end() {
		return sponsored_start_end;
	}

	public void setSponsored_start_end(Date sponsored_start_end) {
		this.sponsored_start_end = sponsored_start_end;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isSponsored() {
		return sponsored;
	}

	public void setSponsored(boolean sponsored) {
		this.sponsored = sponsored;
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

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getFb_() {
		return fb_;
	}

	public void setFb_(String fb_) {
		this.fb_ = fb_;
	}

	public String getTw_() {
		return tw_;
	}

	public void setTw_(String tw_) {
		this.tw_ = tw_;
	}

	public String getGp_() {
		return gp_;
	}

	public void setGp_(String gp_) {
		this.gp_ = gp_;
	}

	public String getLi_() {
		return li_;
	}

	public void setLi_(String li_) {
		this.li_ = li_;
	}

	public String getIg_() {
		return ig_;
	}

	public void setIg_(String ig_) {
		this.ig_ = ig_;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public Long getProfileviews() {
		return profileviews;
	}

	public void setProfileviews(Long profileviews) {
		this.profileviews = profileviews;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@OneToMany
	@JoinTable(name = "wed_user_wishlist", joinColumns = @JoinColumn(name = "userid"), inverseJoinColumns = @JoinColumn(name = "weddingpostid"))
	private List<WeddingPost> wishlist = new ArrayList<>();

	@Embedded
	private WeddingBusiness businessinfo;

	public AppUser() {
	}

	public AppUser(String email, String phone, String password, String fbid,
			String lname, String fname, String thumb, String country,
			String city, String cando, Double lotd, Double latd) {
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.fbid = fbid;
		this.lname = lname;
		this.fname = fname;
		this.thumb = thumb;
		this.country = country;
		this.city = city;
		this.cando = cando;
		this.lotd = lotd;
		this.latd = latd;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	@JsonIgnore
	@XmlTransient
	public List<WeddingPost> getWishlist() {
		return wishlist;
	}

	public void setWishlist(List<WeddingPost> wishlist) {
		this.wishlist = wishlist;
	}

	public String getKeycode() {
		return keycode;
	}

	public void setKeycode(String keycode) {
		this.keycode = keycode;
	}

	public Double getLotd() {
		return lotd;
	}

	public void setLotd(Double lotd) {
		this.lotd = lotd;
	}

	public Double getLatd() {
		return latd;
	}

	public void setLatd(Double latd) {
		this.latd = latd;
	}

	public String getCando() {
		return cando;
	}

	public void setCando(String cando) {
		this.cando = cando;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public WeddingBusiness getBusinessinfo() {
		return businessinfo;
	}

	public void setBusinessinfo(WeddingBusiness businessinfo) {
		this.businessinfo = businessinfo;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFbid() {
		return fbid;
	}

	public void setFbid(String fbid) {
		this.fbid = fbid;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

}
