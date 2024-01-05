package com.karandodeja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.karandodeja.model.Recipe;
import com.karandodeja.service.RecipeService;

@RestController
public class RecipeController {
	
	@Autowired
	private RecipeService recipeService;
	
	public Recipe createRecipe()
	
}
