package com.redesocial.RedeSocial.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redesocial.RedeSocial.models.PostModel;
import com.redesocial.RedeSocial.repositories.PostRepository;

/**
 * 
 * @author Lauro
 * @Since 1.0
 */

@RestController
@RequestMapping("/post")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostController {

	@Autowired
	private PostRepository repository;

	@GetMapping
	public ResponseEntity<List<PostModel>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<PostModel> getById(@PathVariable Long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/name/{name}")
	public ResponseEntity<List<PostModel>> getByDescriptionPost(@PathVariable String descriptionpost) {
		return ResponseEntity.ok(repository.findAllByDescriptionPostContainingIgnoreCase(descriptionpost));
	}

	@PostMapping
	public ResponseEntity<PostModel> post(@Valid @RequestBody PostModel post) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(post));
	}

	@PutMapping
	public ResponseEntity<PostModel> put(@Valid @RequestBody PostModel post) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(post));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);

	}

}
