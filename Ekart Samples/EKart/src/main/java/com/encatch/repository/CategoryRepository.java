package com.encatch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.encatch.model.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	
	 @Query("SELECT c FROM Category c order by c.id asc")
	 public List<Category> findAllByCategoryIdAsc();
     Optional<Category> findById(Long categoryId);
}
