package com.redesocial.RedeSocial.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redesocial.RedeSocial.models.PostModel;

/**
 * 
 * @author Washington Brochardt
 * @since 1.0
 */

@Repository
public interface PostRepository extends JpaRepository<PostModel, Long> {

	public List<PostModel> findAllByDescriptionPostContainingIgnoreCase(String descriptionPost);

}
