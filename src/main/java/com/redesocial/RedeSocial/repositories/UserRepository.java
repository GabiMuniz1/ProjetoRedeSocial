package com.redesocial.RedeSocial.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redesocial.RedeSocial.models.UserModel;

/**
 * 
 * @author Laiane Karla
 * @since 1.0
 */

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

	public Optional<UserModel> findByNameContainingIgnoreCase(String name);
	public Optional<UserModel> findByEmail(String email);
}
