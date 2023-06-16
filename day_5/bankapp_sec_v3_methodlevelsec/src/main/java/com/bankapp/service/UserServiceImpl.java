package com.bankapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.entity.UserEntity;
import com.bankapp.repo.UserRepo;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserEntity findByUsername(String username) {
		return userRepo.findByUsername(username);
	}

	@Override
	public void addUser(UserEntity userEntity) {
		userRepo.save(userEntity);
	}

}







