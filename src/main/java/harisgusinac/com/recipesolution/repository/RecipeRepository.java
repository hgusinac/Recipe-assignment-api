package harisgusinac.com.recipesolution.repository;

import harisgusinac.com.recipesolution.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, String> {
}