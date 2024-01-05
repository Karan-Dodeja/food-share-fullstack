package com.karandodeja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karandodeja.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

}
