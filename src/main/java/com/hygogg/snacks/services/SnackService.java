package com.hygogg.snacks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hygogg.snacks.models.Snack;
import com.hygogg.snacks.repositories.SnackRepository;


@Service
public class SnackService {

	private final SnackRepository snackRepo;
	
	public SnackService(SnackRepository snackRepo) {
		this.snackRepo = snackRepo;
	}
	
	public Snack create(Snack s) {
		return snackRepo.save(s);
	}
	
	public List<Snack> getAll() {
		return (List<Snack>) snackRepo.findAll();
	}
	
	public Snack getOne(Long id) {
		Optional<Snack> snack = snackRepo.findById(id);
		if(snack.isPresent()) {
			return snack.get();
		} else {
			return null;
		}
	}
	
	public Snack update(Snack toUpdate, Long id) {
		if(toUpdate.getId() == null) {
			toUpdate.setId(id);
		}
		return snackRepo.save(toUpdate);
	}
	
	public void remove(Long id) {
		snackRepo.deleteById(id);
	}
	
	public List<Snack> search(String q) {
		return snackRepo.findByNameContaining(q);
	}
	
	public List<Snack> getHealthyOptions() {
		return snackRepo.top3LowCal();
	}
	
}
