package harisgusinac.com.recipesolution.repository;

import harisgusinac.com.recipesolution.model.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, String> {
}