package harisgusinac.com.recipesolution.model;

import java.util.Objects;

public class RecipeInstruction {
    private  String id;
    private String Instruction;

    public RecipeInstruction() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInstruction() {
        return Instruction;
    }

    public void setInstruction(String instruction) {
        Instruction = instruction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeInstruction that = (RecipeInstruction) o;
        return Objects.equals(id, that.id) && Objects.equals(Instruction, that.Instruction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Instruction);
    }
}
