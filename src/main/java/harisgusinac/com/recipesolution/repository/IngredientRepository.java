package harisgusinac.com.recipesolution.repository;

import harisgusinac.com.recipesolution.model.Ingredient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IngredientRepository extends JpaRepository<Ingredient, String> {

    @Query("SELECT  i from Ingredient  i where upper(i.ingredientName) = upper(i.ingredientName) ")
    Optional<Ingredient> findByIngredientName (@Param("ingredientName") String ingredientName);

    @Query ("select  i from Ingredient i where upper(i.ingredientName) like upper(concat(:search,'%'))")
    Page<Ingredient> searchByIngredientName (@Param("search") String search, Pageable pageable);


}