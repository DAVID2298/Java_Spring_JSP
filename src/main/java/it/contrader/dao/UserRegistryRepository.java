package it.contrader.dao;

import it.contrader.dto.UserRegistryDTO;
import it.contrader.model.UserRegistry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRegistryRepository extends CrudRepository<UserRegistry, Long> {

    UserRegistry findByUserId(Long userId);

//    public UserRegistry updateUserRegistry(Long id);
}