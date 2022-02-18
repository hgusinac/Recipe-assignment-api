package harisgusinac.com.recipesolution.repository;

import harisgusinac.com.recipesolution.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, String> {
}