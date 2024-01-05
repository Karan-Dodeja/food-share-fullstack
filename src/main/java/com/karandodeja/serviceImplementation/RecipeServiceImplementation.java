package com.karandodeja.serviceImplementation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.karandodeja.model.Recipe;
import com.karandodeja.model.User;
import com.karandodeja.repository.RecipeRepository;
import com.karandodeja.service.RecipeService;

public class RecipeServiceImplementation implements RecipeService {
	@Autowired
	private RecipeRepository recipeRepository;

	@Override
	public Recipe createRecipe(Recipe recipe, User user) {

		Recipe createdRecipe = new Recipe();
		createdRecipe.setTitle(recipe.getTitle());
		createdRecipe.setImge(recipe.getImge());
		createdRecipe.setDesc(recipe.getDesc());
		createdRecipe.setUser(recipe.getUser());
		createdRecipe.setCreatedAt(LocalDateTime.now());
		return recipeRepository.save(createdRecipe);

	}

	@Override
	public Recipe findRecipeById(Long id) throws Exception {

		Optional<Recipe> opt = recipeRepository.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		throw new Exception("Recipe not found.");

	}

	@Override
	public void deleteRecipe(Long id) throws Exception {
		findRecipeById(id);
		recipeRepository.deleteById(id);
	}

	@Override
	public Recipe updateRecipe(Recipe recipe, Long Id) throws Exception {
		Recipe oldRecipe = findRecipeById(Id);
		if (recipe.getTitle() != null) {
			oldRecipe.setTitle(recipe.getTitle());
		}
		if (recipe.getImge() != null) {
			oldRecipe.setImge(recipe.getImge());
		}
		if (recipe.getDesc() != null) {
			oldRecipe.setDesc(recipe.getDesc());
		}
		return recipeRepository.save(oldRecipe);
	}

	@Override
	public List<Recipe> findAllrecipe() {
		//
		return null;
	}

	@Override
	public Recipe likeRecipe(Long recipeId, User user) throws Exception {
		Recipe recipe = findRecipeById(recipeId);
		if (recipe.getLinked().contains(user.getId())) {
			recipe.getLinked().remove(user.getId());
		} else {
			recipe.getLinked().add(user.getId());
		}
		return recipe;
	}

}
