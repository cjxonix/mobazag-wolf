/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startek.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import startek.entity.AppUser;
import startek.entity.WorkRequest;

/**
 *
 * @author Niwoogaba_Joel
 */
public interface WorkRequestRepository extends JpaRepository<WorkRequest, Long>{

	long countByServiceprovider(AppUser user);

	Page<WorkRequest> findAllByServiceprovider(AppUser user, Pageable pageRequest);  

}
