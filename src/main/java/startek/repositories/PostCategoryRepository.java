/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startek.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import startek.entity.PostCategory;

/**
 *
 * @author Niwoogaba_Joel
 */
public interface PostCategoryRepository extends JpaRepository<PostCategory, Long>{
}
