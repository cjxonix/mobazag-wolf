/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startek.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import startek.entity.AppUser;
import startek.entity.PostImage;
import startek.entity.WeddingPost;

/**
 *
 * @author Niwoogaba_Joel
 */

public interface WeddingPostRepository extends JpaRepository<WeddingPost, Long>{
	Page<WeddingPost> findAll(Pageable request);
	
	Page<WeddingPost>  findAllByPostowner(AppUser user,Pageable request);
	
	//List<PostImage> findImageByPostID(Long postind);
	@Query("SELECT img_ FROM WeddingPost ps_ JOIN ps_.imageinfo img_ JOIN ps_.postowner u_ WHERE ps_.weddingpostid=?1")
	List<PostImage>findImageByAppUserID(Long postind); 
	
	
	public long countByPostowner(AppUser user);
	
	@Query("SELECT sum(ps_.postviews) FROM WeddingPost ps_  JOIN ps_.postowner u_ WHERE u_.userid=?1")
	public long sumUpAllPostViews(Long userid);
	
	@Query("SELECT sum(ps_.postviews) FROM WeddingPost ps_  JOIN ps_.postowner u_")
	public long sumUpGeneralPostViews();
	
}
