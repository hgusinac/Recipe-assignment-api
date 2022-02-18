package harisgusinac.com.recipesolution.repository;

import harisgusinac.com.recipesolution.model.RecipeInstruction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeInstructionRepository extends JpaRepository<RecipeInstruction, String> {
}