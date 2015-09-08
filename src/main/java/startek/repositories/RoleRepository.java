/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startek.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import startek.entity.AppUser;
import startek.entity.Role;

/**
 *
 * @author Niwoogaba_Joel
 */
public interface RoleRepository extends JpaRepository<Role, Long>{

	Role findOneByRoleName(String string); 
	List<Role> findAllByAppusers(AppUser user);
	
	List<Role> findByRoleNameNotIn(List<String> roles);
    
	List<Role> findAllByAppusersAndRoleid(AppUser user,Long roleid);
	
	long countByAppusersAndRoleid(AppUser user,Long roleid);
}
