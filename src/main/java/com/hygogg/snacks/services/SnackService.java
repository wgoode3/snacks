package com.hygogg.snacks.services;

import java.util.List;

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
	
}
