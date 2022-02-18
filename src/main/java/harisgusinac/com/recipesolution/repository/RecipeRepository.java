package harisgusinac.com.recipesolution.repository;

import harisgusinac.com.recipesolution.model.Recipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, String> {

    @Query("select r from Recipe r where upper(r.recipeTitle) = upper(:title) ")
    List<Recipe> findByTitle(@Param("title") String title);

    @Query("select r from Recipe r join fetch r.recipeIngredients AS ri where upper(ri.ingredient.ingredientName) like upper(concat('%',:ingredientName,'%'))")
    Page<Recipe> searchByIngredientName(@Param("ingredientName") String ingredientName,Pageable pageable);


    @Query ("select r from Recipe r join  fetch r.categories as c where  upper(c.category) = upper(:category) ")
    Page<Recipe> searchByCategory(@Param("category") String category,Pageable pageable);

    @Query("select r from Recipe  r join  fetch  r.categories as c where upper(c.category) in :categories")
    Page<Recipe> searchByCategoriesIn(@Param("categories") List<String> categories,Pageable pageable);
}