package com.hygogg.snacks.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hygogg.snacks.models.Snack;


@Repository
public interface SnackRepository extends CrudRepository<Snack, Long> {
	
	List<Snack> findByNameContaining(String search);
	
	@Query(value="SELECT * FROM snacks ORDER BY calories LIMIT 3", nativeQuery=true)
	List<Snack> top3LowCal();
	
}
