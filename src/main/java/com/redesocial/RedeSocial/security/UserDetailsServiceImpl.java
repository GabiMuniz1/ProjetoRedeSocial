package com.redesocial.RedeSocial.security;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.redesocial.RedeSocial.models.UserModel;
import com.redesocial.RedeSocial.repositories.UserRepository;

/**
 * 
 * @author Laiane Karla
 * @since 1.0
 *
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired 
	private UserRepository userRepository;

	@Override 
	public UserDetails loadUserByUsername (String name) throws UsernameNotFoundException {
	Optional<UserModel> user = userRepository.findByNameContainingIgnoreCase(name);
	if (user.isPresent()) {
		return new UserDetailsImpl(user.get());
	} else {
		throw new UsernameNotFoundException(name + " Not found! ");
	}

	}
	
}
