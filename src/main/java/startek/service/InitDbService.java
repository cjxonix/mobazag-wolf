/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startek.service;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import startek.entity.AppUser;
import startek.entity.Role;
import startek.repositories.AppUserRepository;
import startek.repositories.RoleRepository;

/**
 *
 * @author Niwoogaba_Joel
 */
@Transactional
@Service
public class InitDbService {

	private VelocityEngine velocityEngine;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private AppUserRepository appUserRepository;

	@PostConstruct
	public void init() {

		/*Role roleAdmin = new Role();
		roleAdmin.setRoleName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);

		Role roleUser = new Role();
		roleUser.setRoleName("ROLE_USER");
		roleRepository.save(roleUser);

		// Wedding Permission
		Role roleVendor = new Role();
		roleVendor.setRoleName("ROLE_VENDOR");
		roleRepository.save(roleVendor);

		// CONTENT_EDITOR,VENDOR_EDITOR,NORMAL,VENDOR,ADMIN
		Role roleVendorEditor = new Role();
		roleVendorEditor.setRoleName("VENDOR_EDITOR");
		roleRepository.save(roleVendorEditor);

		Role roleArticleEditor = new Role();
		roleArticleEditor.setRoleName("ARTICLE_EDITOR");
		roleRepository.save(roleArticleEditor);

		AppUser user = new AppUser("niwoogaba@zoo.com", "0676866555", "joekingxonix",
				"joe", "king", "user.png", "Uganda", "Kampala", "I feel Great",
				"ADMIN", "joekingxonix", new Long(0), true, true);

		List<Role> roles = new ArrayList<Role>();
		roles.add(roleAdmin);
		roles.add(roleUser);
		user.setRoles(roles);
		appUserRepository.save(user);*/

		/*AppUser vendor = new AppUser("niwoogabav12@zoo.com", "0787866767",
				"vendor", "Joe", "King", "user.png", "Uganda", "Kampala",
				"I feel Great", "ADMIN", "vendor", new Long(0), true, true);
		List<Role> rolesVendor = new ArrayList<Role>();
		rolesVendor.add(roleVendor);
		rolesVendor.add(roleUser);
		vendor.setRoles(rolesVendor);
		appUserRepository.save(vendor);*/

	}

	public String getTextMsg(String string) {
		String path = "velocity/hello.vm";

		// Get file from resources folder
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(path).getFile());

		VelocityContext velocityContext = new VelocityContext();
		velocityContext.put("firstName", "Yashwant");
		velocityContext.put("lastName", "Chavan");
		velocityContext.put("name", "Joel Niwogaba");

		String text = null;
		Template template = velocityEngine.getTemplate(file.getPath());
		StringWriter stringWriter = new StringWriter();

		template.merge(velocityContext, stringWriter);

		text = stringWriter.toString();

		return text;
	}
}
