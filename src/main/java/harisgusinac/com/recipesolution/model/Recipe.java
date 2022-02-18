package harisgusinac.com.recipesolution.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Recipes")
public class Recipe {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false,name = "id")
    private String id;
    @Column(name = "recipe_title")
    private String recipeTitle;
    @Lob
    @Basic (fetch = FetchType.LAZY)
    @Column(length = 1000, name = "recipe_instruction")



    private String recipeInstruction;
    private LocalDateTime lastUpdate;
    @OneToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            fetch = FetchType.LAZY,
            mappedBy = "recipe",
            orphanRemoval = true
    )
    private List<RecipeInstruction> recipeInstructions;

    @OneToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            fetch = FetchType.LAZY,
            mappedBy = "recipe",
            orphanRemoval = true
    )
    private List<RecipeIngredient> recipeIngredients;


    @ManyToMany(
            cascade = {CascadeType.DETACH,CascadeType.REFRESH,CascadeType.PERSIST
            },fetch = FetchType.LAZY
    )
    @JoinTable(
            name = "recipe_category",
            joinColumns = @JoinColumn(name = "fk_recipe_id",table = "recipe_category"),
            inverseJoinColumns = @JoinColumn(name = "fk_category_id",table = "recipe_category")
    )
    private Set<Category> categories;



    public Recipe(String id, String recipeTitle, String recipeInstruction, LocalDateTime lastUpdate, List<RecipeInstruction> recipeInstructions, Set<Category> categories, List<RecipeIngredient> recipeIngredients) {

        this.id = id;
        this.recipeTitle = recipeTitle;
        this.recipeInstruction = recipeInstruction;
        this.lastUpdate = lastUpdate;
        this.recipeInstructions = recipeInstructions;
        this.categories = categories;
        this.recipeIngredients = recipeIngredients;
    }

    public Recipe() {
    }

    public List<RecipeInstruction> getRecipeInstructions() {
        return recipeInstructions;
    }

    public void setRecipeInstructions(List<RecipeInstruction> recipeInstructions) {
        this.recipeInstructions = recipeInstructions;
    }

    public Set<Category> getCategories() {
        if (categories == null) categories = new HashSet<>();
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public List<RecipeIngredient> getRecipeIngredients() {
       if(recipeIngredients == null) recipeIngredients = new ArrayList<>();
       return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRecipeTitle() {
        return recipeTitle;
    }

    public void setRecipeTitle(String recipeTitle) {
        this.recipeTitle = recipeTitle;
    }

    public String getRecipeInstruction() {
        return recipeInstruction;
    }

    public void setRecipeInstruction(String recipeInstruction) {
        this.recipeInstruction = recipeInstruction;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
