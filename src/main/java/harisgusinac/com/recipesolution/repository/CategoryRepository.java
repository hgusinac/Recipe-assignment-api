package harisgusinac.com.recipesolution.repository;

import harisgusinac.com.recipesolution.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}