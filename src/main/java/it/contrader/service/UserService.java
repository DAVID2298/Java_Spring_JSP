package it.contrader.service;

import it.contrader.dto.UserRegistryDTO;
import it.contrader.model.UserRegistry;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.UserConverter;
import it.contrader.dao.UserRepository;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService extends AbstractService<User, UserDTO> {

	@Autowired
	private UserConverter converter;
	@Autowired
	private UserRepository repository;

	public UserDTO findByUsernameAndPassword(String username, String password) {
		return converter.toDTO(repository.findByUsernameAndPassword(username, password));
	}





}
