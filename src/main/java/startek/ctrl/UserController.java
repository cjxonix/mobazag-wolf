package startek.ctrl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import startek.entity.AppUser;
import startek.entity.Role;
import startek.service.ImageHandler;
import startek.service.UserService;
import startek.service.VendorsService;
import startek.util.EN_SchoolRole;
import startek.util.Util;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private ImageHandler imageHandler;
	@Autowired
	private VendorsService vendorsService;

	@ModelAttribute("user")
	private AppUser construct() {
		return new AppUser();
	}

	
	@RequestMapping("/users")
	public String users(Model model) {
		List<AppUser> users = userService.findAllAppUser(0, 100);
		model.addAttribute("current", "users");
		model.addAttribute("users", users);
		return "users";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Model model, @ModelAttribute("user") AppUser user) {
		List<Role> roles = new ArrayList<Role>();
		// Assign Default Roles
		Role r = userService.findOneByRoleName(EN_SchoolRole.ROLE_USER
				.toString());
		roles.add(r);
		user.setRoles(roles);
		user.setActive(true);
		user.setCreatedAt(new Date());
		user.setUpdatedAt(new Date());
		user.setThumb("user.png");

		userService.saveAppUser(user);
		model.addAttribute("current", "users");

		return "new-user";
	}

	@RequestMapping("/register")
	public String doRegister(Model model) {
		model.addAttribute("current", "users");
		return "new-user";
	}

	@RequestMapping("/user-profile/{userid}/{username}")
	public String showUserProfile(Model model,
			@PathVariable("userid") Long userid,
			@PathVariable("username") String username) {

		model.addAttribute("current", "users");

		AppUser user = userService.findOneByUseridAndUsername(userid, username);
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
				System.out
						.println(">>The Role are not found . .  Magic happening");
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
		return "user-profile";
	}

	@RequestMapping("/user/edit/{userid}/{username}")
	public String showEditingUserProfile(Model model,
			@PathVariable("userid") Long userid,
			@PathVariable("username") String username) {

		model.addAttribute("current", "users");

		AppUser user = userService.findOneByUseridAndUsername(userid, username);

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
		return "user-edit";
	}

	@RequestMapping(value = "/user/edit-action", method = RequestMethod.POST)
	public String register(Model model, @ModelAttribute("user") AppUser user,
			@RequestParam("userid") Long userid) {
		AppUser u = userService.findOneAppUser(userid);
		model.addAttribute("current", "users");
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

	@RequestMapping(value = "/edit-password", method = RequestMethod.POST)
	public String editUserPassword(@RequestParam("userid") Long userid,
			@RequestParam("accountpage") Long accountpage,
			@RequestParam("username") String username,
			@RequestParam("password") String password, HttpServletRequest hreq) {

		if (password != null) {
			try {
				userService.updateUserPassword(userid, password);

				if (accountpage == 1) {
					return "redirect:/account/" + username + ".html?msg=true";
				} else {
					return "redirect:/user-profile/" + userid + "/" + username
							+ ".html?msg=true";
				}

			} catch (Exception e) {
				if (accountpage == 1) {
					return "redirect:/account/" + username + ".html?img=false";
				} else {
					return "redirect:/user-profile/" + userid + "/" + username
							+ ".html?msg=false";
				}
			}
		} else {
			if (accountpage == 1) {
				return "redirect:/account/" + username + ".html?msg=false";
			} else {
				return "redirect:/user-profile/" + userid + "/" + username
						+ ".html?msg=false";
			}
		}
	}

	@RequestMapping(value = "/user-profile-img", method = RequestMethod.POST)
	public String createUserProfileImageUpload(
			@RequestParam("file") MultipartFile file,
			@RequestParam("userid") Long userid,
			@RequestParam("accountpage") Long accountpage,

			@RequestParam("username") String username, HttpServletRequest hreq) {
		final String path = hreq.getSession().getServletContext()
				.getRealPath("/up_/users/")
				+ File.separator;
		// TODO Create the user profile
		File fileSrc = null;
		String name = null;
		String newName = null;
		accountpage = accountpage == null ? new Long(0) : accountpage;
		if (!file.isEmpty()) {
			try {

				String exe = FilenameUtils.getExtension(file
						.getOriginalFilename());

				newName = RandomStringUtils.randomAlphanumeric(20);
				newName += "." + exe;
				name = newName;

				fileSrc = new File(path + newName);

				System.out.println("File name " + name + " exe " + exe);

				if (!exe.equalsIgnoreCase("png")
						&& !exe.equalsIgnoreCase("jpg")) {
					return "redirect:/user-profile/" + userid + "/" + username
							+ ".html?img=false";
				}

				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(fileSrc));
				stream.write(bytes);
				stream.close();

				// create 200px
				imageHandler.resizeImage(200, fileSrc, new File(path
						+ Util.ImageSize._x200 + newName));
				File x100 = imageHandler.resizeImage(100, fileSrc, new File(
						path + Util.ImageSize._x100 + newName));
				imageHandler.cropSquareImage(100, 100, x100, new File(path
						+ Util.ImageSize._s100 + newName));

				userService.updateUserProfile(userid, name);

				if (accountpage == 1) {
					return "redirect:/account/" + username + ".html?img=true";
				} else {
					return "redirect:/user-profile/" + userid + "/" + username
							+ ".html?img=true";
				}

			} catch (Exception e) {
				if (accountpage == 1) {
					return "redirect:/account/" + username + ".html?img=false";
				} else {
					return "redirect:/user-profile/" + userid + "/" + username
							+ ".html?img=false";
				}
			}
		} else {
			if (accountpage == 1) {
				return "redirect:/account/" + username + ".html?img=false";
			} else {
				return "redirect:/user-profile/" + userid + "/" + username
						+ ".html?img=false";
			}
		}
	}

}
