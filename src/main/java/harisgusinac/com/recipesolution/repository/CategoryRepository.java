package harisgusinac.com.recipesolution.repository;

import harisgusinac.com.recipesolution.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, String> {
    @Query("SELECT  c FROM Category c WHERE UPPER(c.category) = upper(:category)")
    Optional<Category> findByCategory(String category);



}