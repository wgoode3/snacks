package com.hygogg.snacks.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hygogg.snacks.models.Snack;


@Repository
public interface SnackRepository extends CrudRepository<Snack, Long> {}
