package startek.ctrl;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import startek.entity.AppUser;
import startek.entity.Notifications;
import startek.entity.Role;
import startek.entity.WeddingPost;
import startek.entity.WorkRequest;
import startek.service.ImageHandler;
import startek.service.UserService;
import startek.service.VendorsService;

@Controller
public class VendorController {

	@Autowired
	private UserService userService;
	@Autowired
	VendorsService vendorService;

	@Autowired
	private ImageHandler imageHandler;

	@ModelAttribute("user")
	private AppUser construct() {
		return new AppUser();
	}

	@RequestMapping("/mywork")
	public String users(Model model, Principal principal) {
		model.addAttribute("current", "users");
		Integer pageNumber =1;
		if (principal == null) {
			return "redirect:/login.html?msg=not_allowed";
		}
		AppUser user = userService.findOneByUsername(principal.getName());
		if(user==null){
			return "redirect:/login.html?msg=not_allowed";
		}
		
		//...
		Page<WeddingPost> page = vendorService.findPostByAppUser(user,pageNumber);
		List<WeddingPost> items = vendorService.findListPostByAppUser(user,pageNumber);

	    int current = page.getNumber() + 1;
	    int begin = Math.max(1, current - 5);
	    int end = Math.min(begin + 10, page.getTotalPages());
	    
	    model.addAttribute("items", page);
	    model.addAttribute("list", items);
	    model.addAttribute("beginIndex", begin);
	    model.addAttribute("endIndex", end);
	    model.addAttribute("currentIndex", current);
		//...
		
		model.addAttribute("current", "users");
		model.addAttribute("user", user);
		model.addAttribute("frm_user", user);
		return "vendor-work";
	}
	
	@RequestMapping("/mywork/pages/{pageNumber}")
	public String users(Model model, 
			@PathVariable("pageNumber") Integer pageNumber,
			Principal principal) {
		model.addAttribute("current", "users");
		
		if (principal == null) {
			return "redirect:/login.html?msg=not_allowed";
		}
		AppUser user = userService.findOneByUsername(principal.getName());
		if(user==null){
			return "redirect:/login.html?msg=not_allowed";
		}
		
		//...
		
		Page<WeddingPost> page = vendorService.findPostByAppUser(user,pageNumber);
		List<WeddingPost> items = vendorService.findListPostByAppUser(user,pageNumber);
		
	    int current = page.getNumber() + 1;
	    int begin = Math.max(1, current - 5);
	    int end = Math.min(begin + 10, page.getTotalPages());

	    model.addAttribute("items", page);
	    model.addAttribute("list", items);
	    model.addAttribute("beginIndex", begin);
	    model.addAttribute("endIndex", end);
	    model.addAttribute("currentIndex", current);
		//...
		
		model.addAttribute("current", "users");
		model.addAttribute("user", user);
		model.addAttribute("frm_user", user);
		return "vendor-work";
	}

	
	/*The service request and Notifications
	 */
	@RequestMapping("/account/work-request/pages/{pageNumber}")
	public String userWorkRequests(Model model, Principal principal,
			@PathVariable("pageNumber") Integer pageNumber) {
		model.addAttribute("current", "users");
		pageNumber =pageNumber==0?1:pageNumber;
		
		if (principal == null) {
			return "redirect:/login.html?msg=not_allowed";
		}
		AppUser user = userService.findOneByUsername(principal.getName());
		if(user==null){
			return "redirect:/login.html?msg=not_allowed";
		}
		
		//...
		Page<WorkRequest> page = vendorService.findAllpageWorkRequestByUser(user, pageNumber, 10);
		List<WorkRequest> items = page.getContent();

	    int current = page.getNumber() + 1;
	    int begin = Math.max(1, current - 5);
	    int end = Math.min(begin + 10, page.getTotalPages());
	    
	    model.addAttribute("items", page);
	    model.addAttribute("list", items);
	    model.addAttribute("beginIndex", begin);
	    model.addAttribute("endIndex", end);
	    model.addAttribute("currentIndex", current);
		//...
		
		model.addAttribute("current", "users");
		model.addAttribute("user", user);
		model.addAttribute("frm_user", user);
		return "work-request";
	}
	
	
	@RequestMapping("/account/notifications/pages/{pageNumber}")
	public String userAccountNotifications(Model model, Principal principal,
			@PathVariable("pageNumber") Integer pageNumber) {
		model.addAttribute("current", "users");
		pageNumber =pageNumber==0?1:pageNumber;
		
		if (principal == null) {
			return "redirect:/login.html?msg=not_allowed";
		}
		AppUser user = userService.findOneByUsername(principal.getName());
		if(user==null){
			return "redirect:/login.html?msg=not_allowed";
		}
		
		//...
		Page<Notifications> page = vendorService.findAllPageNotificationByUser(user, pageNumber, 10);
		List<Notifications> items = page.getContent();

	    int current = page.getNumber() + 1;
	    int begin = Math.max(1, current - 5);
	    int end = Math.min(begin + 10, page.getTotalPages());
	    
	    model.addAttribute("items", page);
	    model.addAttribute("list", items);
	    model.addAttribute("beginIndex", begin);
	    model.addAttribute("endIndex", end);
	    model.addAttribute("currentIndex", current);
		//...
		
		model.addAttribute("current", "users");
		model.addAttribute("user", user);
		model.addAttribute("frm_user", user);
		return "notifications";
	}
	
	
	
	/*The service request and Notifications
	 */
	@RequestMapping("/admin/work-request/{username}/pages/{pageNumber}")
	public String adminWorkRequests(Model model,
			@PathVariable("username") String username,
			@PathVariable("pageNumber") Integer pageNumber) {
		model.addAttribute("current", "users");
		pageNumber =pageNumber==0?1:pageNumber;
		
		if (username == null) {
			return "redirect:/login.html?msg=not_allowed";
		}
		AppUser user = userService.findOneByUsername(username);
		if(user==null){
			return "redirect:/login.html?msg=not_allowed";
		}
		
		//...
		Page<WorkRequest> page = vendorService.findAllpageWorkRequestByUser(user, pageNumber, 10);
		List<WorkRequest> items = page.getContent();

	    int current = page.getNumber() + 1;
	    int begin = Math.max(1, current - 5);
	    int end = Math.min(begin + 10, page.getTotalPages());
	    
	    model.addAttribute("items", page);
	    model.addAttribute("list", items);
	    model.addAttribute("beginIndex", begin);
	    model.addAttribute("endIndex", end);
	    model.addAttribute("currentIndex", current);
		//...
		
		model.addAttribute("current", "users");
		model.addAttribute("user", user);
		model.addAttribute("frm_user", user);
		return "work-request";
	}
	
	
	@RequestMapping("/admin/notifications/{username}/pages/{pageNumber}")
	public String adminAccountNotifications(Model model, 
			@PathVariable("username") String username,
			@PathVariable("pageNumber") Integer pageNumber) {
		model.addAttribute("current", "users");
		pageNumber =pageNumber==0?1:pageNumber;
		
		if (username == null) {
			return "redirect:/login.html?msg=not_allowed";
		}
		AppUser user = userService.findOneByUsername(username);
		if(user==null){
			return "redirect:/login.html?msg=not_allowed";
		}
		
		//...
		Page<Notifications> page = vendorService.findAllPageNotificationByUser(user, pageNumber, 10);
		List<Notifications> items = page.getContent();

	    int current = page.getNumber() + 1;
	    int begin = Math.max(1, current - 5);
	    int end = Math.min(begin + 10, page.getTotalPages());
	    
	    model.addAttribute("items", page);
	    model.addAttribute("list", items);
	    model.addAttribute("beginIndex", begin);
	    model.addAttribute("endIndex", end);
	    model.addAttribute("currentIndex", current);
		//...
		
		model.addAttribute("current", "users");
		model.addAttribute("user", user);
		model.addAttribute("frm_user", user);
		return "notifications";
	}
	
	
	
	@RequestMapping("/myarticles")
	public String myArticles(Model model, Principal principal) {
		List<AppUser> users = userService.findAllAppUser(0, 100);
		model.addAttribute("current", "users");
		model.addAttribute("users", users);
		return "users";
	}

	@RequestMapping("/account/edit")
	public String showEditingUserProfile(Model model, Principal principal) {

		model.addAttribute("current", "users");

		if (principal == null) {
			return "redirect:/login.html?msg=not_allowed";
		}

		AppUser user = userService.findOneByUsername(principal.getName());

		// List All Permissions
		List<Role> otherRoles = null;
		List<String> currentRoles = new ArrayList<>();
		if (user != null) {
			if (user.getRoles() == null) {
				System.out.println(">>The Role are found");
				for (Role x : user.getRoles()) {
					currentRoles.add(x.getRoleName());
				}
				if (currentRoles != null && currentRoles.size() > 0) {
					otherRoles = userService.findByRoleNameNotIn(currentRoles);
				}
			} else {
				System.out.println(">>The Role are not found");
				if (user.getCando().equalsIgnoreCase("VENDOR")) {
					userService.assignRole("ROLE_VENDOR", user.getUserid());
				} else if (user.getCando().equalsIgnoreCase("ADMIN")) {
					userService.assignRole("ROLE_ADMIN", user.getUserid());
				} else if (user.getCando().equalsIgnoreCase("ARTICLE_EDITOR")) {
					userService.assignRole("ARTICLE_EDITOR", user.getUserid());
				} else if (user.getCando().equalsIgnoreCase("VENDOR_EDITOR")) {
					userService.assignRole("VENDOR_EDITOR", user.getUserid());
				} else if (user.getCando().equalsIgnoreCase("")
						|| user.getCando() == null
						|| user.getCando().equalsIgnoreCase("NORMAL")) {
					userService
							.assignRoleDefualt("ROLE_USER", user.getUserid());
				}
			}

		}
		// processed roles

		model.addAttribute("currentRoles", currentRoles);
		model.addAttribute("otherRoles", otherRoles);
		model.addAttribute("u_", user);
		model.addAttribute("frm_user", user);
		return "user-edit";
	}

	@RequestMapping(value = "/account/edit-action", method = RequestMethod.POST)
	public String editPersonalAccount(Model model, @ModelAttribute("user") AppUser user,
			Principal principal) {
		model.addAttribute("current", "users");
		if (principal == null) {
			return "redirect:/login.html?msg=not_allowed";
		}
		AppUser u = userService.findOneByUsername(principal.getName());

		if (u != null) {
			u.setActivate(true);
			u.setActive(true);
			u.setUpdatedAt(new Date());
			u.setFname(user.getFname());
			u.setLname(user.getLname());
			u.setAbout(user.getAbout());
			u.setEmail(user.getEmail());
			u.setPhone(user.getPhone());
			userService.saveAppUser(u);
			return "redirect:/user/edit/" + u.getUserid() + "/"
					+ u.getUsername() + ".html";
		} else {
			return "redirect:/dashboard.html";
		}

	}

	/**
	 * The Logged user private account details
	 * 
	 * @param model
	 * @param username
	 * @param principal
	 * @return
	 */
	@RequestMapping("/account/{username}")
	public String showUserProfileAccount(Model model,
			@PathVariable("username") String username, Principal principal) {

		model.addAttribute("current", "account");
		model.addAttribute("accountpage", 1);

		if (principal == null) {
			return "redirect:/dashboard.html";
		}
		
		AppUser user = userService.findOneByUsername(principal.getName());
		// List All Permissions
		List<Role> otherRoles = null;
		List<String> currentRoles = new ArrayList<>();
		if (user != null) {
			if (user.getRoles() == null) {
				System.out.println(">>The Role are found");
				for (Role x : user.getRoles()) {
					currentRoles.add(x.getRoleName());
				}
			} else {
				System.out.println(">>The Role are not found . .  Magic happening");
				if (user.getCando().equalsIgnoreCase("VENDOR")) {
					userService.assignRole("ROLE_VENDOR", user.getUserid());
				} else if (user.getCando().equalsIgnoreCase("ADMIN")) {
					userService.assignRole("ROLE_ADMIN", user.getUserid());
				} else if (user.getCando().equalsIgnoreCase("ARTICLE_EDITOR")) {
					userService.assignRole("ARTICLE_EDITOR", user.getUserid());
				} else if (user.getCando().equalsIgnoreCase("VENDOR_EDITOR")) {
					userService.assignRole("VENDOR_EDITOR", user.getUserid());
				} else if (user.getCando().equalsIgnoreCase("")
						|| user.getCando() == null
						|| user.getCando().equalsIgnoreCase("NORMAL")) {
					userService
							.assignRoleDefualt("ROLE_USER", user.getUserid());
				}
			}

		}
		// processed roles

		model.addAttribute("currentRoles", currentRoles);
		model.addAttribute("otherRoles", otherRoles);
		model.addAttribute("user", user);
		model.addAttribute("frm_user", user);
		return "user-profile";
	}

}
