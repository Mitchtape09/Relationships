package com.javastack.spring.safetravels.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.javastack.spring.safetravels.models.Travel;
import com.javastack.spring.safetravels.repositories.TravelRepository;

@Service
public class TravelService {

	private final TravelRepository travelRepo;
	
	public TravelService(TravelRepository travelRepo) {
		this.travelRepo = travelRepo;
	}
	
	public List<Travel> allTravels() {
		return travelRepo.findAll();
	}
	
	public Travel addTravel(Travel travel) {
		return travelRepo.save(travel);
	}
	
	public Travel findTravel(Long id) {
		Optional<Travel> optionalTravel = travelRepo.findById(id);
		if(optionalTravel.isPresent()) {
			return optionalTravel.get();
		}
		return null;
	}
	
	public Travel updateTravel(Travel travel) {
		return travelRepo.save(travel);
	}
	
	public void deleteTravel(Travel travel) {
		travelRepo.delete(travel);
	}
	
	public void deleteTravelById(Long id) {
		travelRepo.deleteById(id);
	}
}
