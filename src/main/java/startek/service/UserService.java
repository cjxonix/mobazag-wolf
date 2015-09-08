/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startek.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import startek.entity.AppUser;
import startek.entity.Role;
import startek.repositories.AppUserRepository;
import startek.repositories.RoleRepository;

/**
 *
 * @author Niwoogaba_Joel
 */
@Service
@Transactional
public class UserService {

	@Autowired
	AppUserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;

	@Transactional
	public AppUser findOneByUsername(String name) {
		AppUser user = userRepository.findOneByUsername(name);
		if (user == null) {
			return null;
		}
		List<Role> roles = roleRepository.findAllByAppusers(user);
		user.setRoles(roles);
		return user;
	}

	/**
	 * All User Listings
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	public List<AppUser> findAllAppUser(int page, int size) {
		Page<AppUser> all = userRepository.findAll(new PageRequest(page, size));
		return all.getContent();
	}

	public void saveAppUser(AppUser user) {
		userRepository.save(user);
	}

	public Role findOneByRoleName(String roleName) {
		return roleRepository.findOneByRoleName(roleName);

	}
	public AppUser findOneAppUser(Long userid) {
		AppUser user = userRepository.findOne(userid);
		return user;
	}


	public AppUser findOneByUseridAndUsername(Long userid, String username) {
		AppUser user = userRepository.findOneByUseridAndUsername(userid,
				username);
		if (user == null) {
			return null;
		}
		List<Role> roles = roleRepository.findAllByAppusers(user);
		user.setRoles(roles);

		return user;
	}

	/**
	 * Find the roles that are not in the AppUsers Roles
	 * 
	 * @param roles
	 * @return
	 */
	public List<Role> findByRoleNameNotIn(List<String> roles) {
		if (roles == null) {
			return null;
		}
		return roleRepository.findByRoleNameNotIn(roles);

	}

	public void updateUserProfile(Long userid, String profileImage) {
		AppUser student = userRepository.findOne(userid);
		student.setThumb(profileImage);

	}
	
	public void updateUserPassword(Long userid, String password) {
		AppUser student = userRepository.findOne(userid);
		student.setPassword(password);
		student.setUpdatedAt(new Date());

	}


	@Transactional
	public void assignRole(String roleName, Long userid) {
		AppUser user = userRepository.findOne(userid);
		if (user == null)
			return;
		Role role = roleRepository.findOneByRoleName(roleName);
		Role mainRole = roleRepository.findOneByRoleName("ROLE_USER");
		
		if (role != null) {
			boolean hasRole = userHasRole(user, role.getRoleid());
			if(!hasRole){
				List<Role> x = new ArrayList<Role>();
				x.add(role);
				if(mainRole!=null ){
					if(!userHasRole(user, mainRole.getRoleid())){
						x.add(mainRole);
					}
				}
				user.setRoles(x);
				userRepository.save(user);
			}
		} else {
			return;
		}

	}
	
	/**
	 * Assigns a role directly by checking if the user has it
	 * without the Default role pair
	 * @param roleName
	 * @param userid
	 */
	public void assignRoleDefualt(String roleName, Long userid) {
		AppUser user = userRepository.findOne(userid);
		if (user == null)
			return;
		Role role = roleRepository.findOneByRoleName(roleName);		
		if (role != null) {
			boolean hasRole = userHasRole(user, role.getRoleid());
			if(!hasRole){
				List<Role> x = new ArrayList<Role>();
				x.add(role);
				user.setRoles(x);
				userRepository.save(user);
			}
		} else {
			return;
		}

	}

	/**
	 * Check if the user has this role
	 * 
	 * @param userid
	 * @param roleid
	 * @return
	 */
	private boolean userHasRole(AppUser user, Long roleid) {
		long count = roleRepository.countByAppusersAndRoleid(user, roleid);
		return count>0;
	}
}
