package com.karandodeja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.karandodeja.model.Recipe;
import com.karandodeja.model.User;
import com.karandodeja.repository.UserRepository;
import com.karandodeja.service.RecipeService;
import com.karandodeja.service.UserService;

@RestController
public class RecipeController {
	
	@Autowired
	private RecipeService recipeService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/api/recipe/user/userId")
	public Recipe createRecipe(@RequestBody Recipe recipe, @PathVariable Long userId ) throws Exception {
		User user  = userService.findUserById(userId);	
		Recipe createRecipe = recipeService.createRecipe(recipe, user);
		return createRecipe;
	}
	
	
}
