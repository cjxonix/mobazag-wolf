package startek.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import startek.entity.AppUser;
import startek.entity.Notifications;
import startek.entity.PostImage;
import startek.entity.WeddingPost;
import startek.entity.WorkRequest;
import startek.repositories.AppUserRepository;
import startek.repositories.NotificationRepository;
import startek.repositories.PostCategoryRepository;
import startek.repositories.PostImageRepository;
import startek.repositories.PostTagRepository;
import startek.repositories.RoleRepository;
import startek.repositories.WeddingPostRepository;
import startek.repositories.WorkRequestRepository;
 
@Service
@Transactional
public class VendorsService {

	@Autowired
	AppUserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	WeddingPostRepository weddingPostRepository;
	@Autowired
	PostImageRepository postImageRepository;
	@Autowired
	PostTagRepository postTagRepository;
	@Autowired
	PostCategoryRepository postCategoryRepository;
	


	@Autowired
	WorkRequestRepository workRequestRepository;
	

	@Autowired
	NotificationRepository notificationRepository;
	

	private static final int PAGE_SIZE = 10;

	public List<WeddingPost> findPostByAppUser(AppUser user, int from, int to) {
		// TODO Return all user post creation
		PageRequest request = new PageRequest(from, to);
		Page<WeddingPost> content = weddingPostRepository.findAllByPostowner(
				user, request);

		final List<WeddingPost> list = new ArrayList<>();
		for (WeddingPost p : content.getContent()) {
			List<PostImage> images = weddingPostRepository
					.findImageByAppUserID(p.getWeddingpostid());
			p.setImageinfo(images);
			list.add(p);
		}

		return list;
	}

	/**
	 * Get all post related to the user
	 * 
	 * @param user
	 * @return
	 */
	public Page<WeddingPost> findPostByAppUser(AppUser user, Integer pageNumber) {
		// TODO Return all user post creation
		PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE,
				Sort.Direction.DESC, "postviews");
		Page<WeddingPost> posts = weddingPostRepository.findAllByPostowner(
				user, request);
		return posts;
	}

	public List<WeddingPost> findListPostByAppUser(AppUser user, Integer pageNumber) {
		// TODO Return all user post creation
		PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.DESC, "postviews");
		Page<WeddingPost> posts = weddingPostRepository.findAllByPostowner( user, request);
		List<WeddingPost> content = posts.getContent();
		final List<WeddingPost> list = new ArrayList<>();
		for (WeddingPost p : content) {
			List<PostImage> images = weddingPostRepository.findImageByAppUserID(p.getWeddingpostid());
			p.setImageinfo(images);
			System.out.println((images == null ? "No images found" : "Foundt some " + images.size()));

			list.add(p);
		}

		return list;
	}



	public void saveNotification(AppUser user, Notifications nofication) {
		AppUser u = userRepository.findOne(user.getUserid());
		nofication.setAppuser(u);

	}

	public void saveWorkRequest(WorkRequest work, AppUser user) {
		AppUser u = userRepository.findOne(user.getUserid());
		work.setServiceprovider(u);
		workRequestRepository.save(work);
	}
	
	public long countNotificationsByVendor(AppUser user) {
		return notificationRepository.countByAppuser(user);
	}
	
	public long countAllNotifications() {
		return notificationRepository.count();
	}
	
	public long countWorkRequestsByVendor(AppUser user) {
		return workRequestRepository.countByServiceprovider(user);
	}
	
	public long countAllWorkRequests() {
		return workRequestRepository.count();
	}
	
	public List<Notifications> findAllNotificationByUser(AppUser user, Integer pageNumber, Integer pageSize) {
		Page<Notifications> page = notificationRepository.findAllByAppuser(user,new PageRequest(pageNumber-1, pageSize));
		if(page.hasContent())
			return page.getContent();
		return null; 
	}

	public List<WorkRequest> findAllWorkRequestByUser(AppUser user, Integer pageNumber, Integer pageSize) {
		Page<WorkRequest> page = workRequestRepository.findAllByServiceprovider(user,new PageRequest(pageNumber, pageSize));
		if(page.hasContent())
			return page.getContent();
		return null;
	}
	
	public Page<Notifications> findAllPageNotificationByUser(AppUser user, Integer pageNumber, Integer pageSize) {
		return notificationRepository.findAllByAppuser(user,new PageRequest(pageNumber-1, pageSize));
		 
	}

	public Page<WorkRequest> findAllpageWorkRequestByUser(AppUser user, Integer pageNumber, Integer pageSize) {
		return workRequestRepository.findAllByServiceprovider(user,new PageRequest(pageNumber - 1, pageSize));
		 
	}

}
