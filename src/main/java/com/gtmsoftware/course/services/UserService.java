package com.gtmsoftware.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gtmsoftware.course.entities.User;
import com.gtmsoftware.course.repositories.UserRepository;
import com.gtmsoftware.course.services.exceptions.DatabaseException;
import com.gtmsoftware.course.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> user = repository.findById(id);
		
		return user.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User user) {
		return repository.save(user);
	}
	
	public void delete(Long id) {
		if(!repository.existsById(id)) {
			throw new ResourceNotFoundException(id);
		}
		
		try {
			repository.deleteById(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User userUpdate) {
		try {
			User entity = repository.getReferenceById(id);
			updateData(entity, userUpdate);
			
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
	}

	private void updateData(User entity, User userUpdate) {
		entity.setName(userUpdate.getName());
		entity.setEmail(userUpdate.getEmail());
		entity.setPhone(userUpdate.getPhone());
	}

}
