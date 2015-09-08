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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "wed_weddingpost")
public class WeddingPost implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long weddingpostid;
	private String posttitle;
	private String postsubtitle;
	private String pricerange;
	private long maxprice;
	private long minprice;

	@Column(columnDefinition = "LONGTEXT")
	private String postdescription;
	@OneToMany(cascade = CascadeType.ALL)
	private List<PostImage> imageinfo = new ArrayList<>();// atleast one image.

	@OneToOne
	private PostCategory postcategory;// [Djs,Venues etc]
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date dateposted;
	private Long postviews;
	private Long postlikes;

	@ManyToMany
	private List<PostTag> posttags = new ArrayList<>();
	@OneToOne
	private AppUser postowner;

	// offer information
	private String itemoffer;// [20% off]
	private boolean offered;
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date offered_start_date;
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date offered_start_end;

	private int bookedbefore;// [months]
	private boolean active;
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date expiry_date;

	// Trasient fields
	@Transient
	private long items_size;
	@Transient
	private int num_rows;

	private boolean sponsored;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date sponsored_start_date;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date sponsored_end_date;

	private boolean video;
	private boolean show_articles;
	private String video_id;
	public boolean isShow_articles() {
		return show_articles;
	}

	public void setShow_articles(boolean show_articles) {
		this.show_articles = show_articles;
	}

	public boolean isVideo() {
		return video;
	}

	public void setVideo(boolean video) {
		this.video = video;
	}

	public String getVideo_id() {
		return video_id;
	}

	public void setVideo_id(String video_id) {
		this.video_id = video_id;
	}

	public Date getSponsored_start_date() {
		return sponsored_start_date;
	}

	public Date getSponsored_end_date() {
		return sponsored_end_date;
	}

	public void setSponsored_end_date(Date sponsored_end_date) {
		this.sponsored_end_date = sponsored_end_date;
	}

	public Date getOffered_start_date() {
		return offered_start_date;
	}

	public void setOffered_start_date(Date offered_start_date) {
		this.offered_start_date = offered_start_date;
	}

	public Date getOffered_start_end() {
		return offered_start_end;
	}

	public void setOffered_start_end(Date offered_start_end) {
		this.offered_start_end = offered_start_end;
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

	public Date getExpiry_date() {
		return expiry_date;
	}

	public void setExpiry_date(Date expiry_date) {
		this.expiry_date = expiry_date;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getItemoffer() {
		return itemoffer;
	}

	public void setItemoffer(String itemoffer) {
		this.itemoffer = itemoffer;
	}

	public boolean isOffered() {
		return offered;
	}

	public void setOffered(boolean offered) {
		this.offered = offered;
	}

	public int getBookedbefore() {
		return bookedbefore;
	}

	public void setBookedbefore(int bookedbefore) {
		this.bookedbefore = bookedbefore;
	}

	public WeddingPost() {
		this.posttags = null;
	}

	public WeddingPost(String posttitle, String postdescription, Date dateposted) {
		this.posttitle = posttitle;
		this.postdescription = postdescription;
		this.dateposted = dateposted;
	}

	public WeddingPost(Long weddingpostid, String posttitle,
			String postdescription, PostCategory postcategory, Date dateposted,
			Long postviews, Long postlikes, AppUser postowner) {
		this.weddingpostid = weddingpostid;
		this.posttitle = posttitle;
		this.postdescription = postdescription;
		this.postcategory = postcategory;
		this.dateposted = dateposted;
		this.postviews = postviews;
		this.postlikes = postlikes;
		this.postowner = postowner;
		this.posttags = null;
	}

	public AppUser getPostowner() {
		return postowner;
	}

	public void setPostowner(AppUser postowner) {
		this.postowner = postowner;
	}

	public Long getWeddingpostid() {
		return weddingpostid;
	}

	public void setWeddingpostid(Long weddingpostid) {
		this.weddingpostid = weddingpostid;
	}

	public String getPosttitle() {
		return posttitle;
	}

	public void setPosttitle(String posttitle) {
		this.posttitle = posttitle;
	}

	public String getPostdescription() {
		return postdescription;
	}

	public void setPostdescription(String postdescription) {
		this.postdescription = postdescription;
	}

	public List<PostImage> getImageinfo() {
		return imageinfo;
	}

	public void setImageinfo(List<PostImage> imageinfo) {
		this.imageinfo = imageinfo;
	}

	public PostCategory getPostcategory() {
		return postcategory;
	}

	public void setPostcategory(PostCategory postcategory) {
		this.postcategory = postcategory;
	}

	public Date getDateposted() {
		return dateposted;
	}

	public void setDateposted(Date dataposted) {
		this.dateposted = dataposted;
	}

	public Long getPostviews() {
		return postviews;
	}

	public void setPostviews(Long postviews) {
		this.postviews = postviews;
	}

	public Long getPostlikes() {
		return postlikes;
	}

	public void setPostlikes(Long postlikes) {
		this.postlikes = postlikes;
	}

	@XmlTransient
	@JsonIgnore
	public List<PostTag> getPosttags() {
		return posttags;
	}

	public void setPosttags(List<PostTag> posttags) {
		this.posttags = posttags;
	}

	public String getPostsubtitle() {
		return postsubtitle;
	}

	public void setPostsubtitle(String postsubtitle) {
		this.postsubtitle = postsubtitle;
	}

	public String getPricerange() {
		return pricerange;
	}

	public void setPricerange(String pricerange) {
		this.pricerange = pricerange;
	}

	public long getMaxprice() {
		return maxprice;
	}

	public void setMaxprice(long maxprice) {
		this.maxprice = maxprice;
	}

	public long getMinprice() {
		return minprice;
	}

	public void setMinprice(long minprice) {
		this.minprice = minprice;
	}

}
