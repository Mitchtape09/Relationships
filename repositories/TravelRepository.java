package com.javastack.spring.safetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javastack.spring.safetravels.models.Travel;

@Repository
public interface TravelRepository extends CrudRepository<Travel, Long>  {
	List<Travel> findAll();
}
