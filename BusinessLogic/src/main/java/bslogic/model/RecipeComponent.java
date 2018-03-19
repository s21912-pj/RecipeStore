package bslogic.model;

//to ignore
import com.fasterxml.jackson.annotation.JsonIgnore;

public class RecipeComponent {

	private int component_id;
	private String componentName;
	private double componentWeight;
	@JsonIgnore
	private int recipe_id;
	private String componentDescription;
	private double componentCalories;

	public RecipeComponent() {

	}
	
	

	public RecipeComponent(int component_id, String componentName, double componentWeight, int recipe_id,
			String componentDescription, double componentCalories) {
		super();
		this.component_id = component_id;
		this.componentName = componentName;
		this.componentWeight = componentWeight;
		this.recipe_id = recipe_id;
		this.componentDescription = componentDescription;
		this.componentCalories = componentCalories;
	}



	public int getComponent_id() {
		return component_id;
	}

	public void setComponent_id(int component_id) {
		this.component_id = component_id;
	}

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public double getComponentWeight() {
		return componentWeight;
	}

	public void setComponentWeight(double componentWeight) {
		this.componentWeight = componentWeight;
	}

	public int getRecipe_id() {
		return recipe_id;
	}

	public void setRecipe_id(int recipe_id) {
		this.recipe_id = recipe_id;
	}

	public String getComponentDescription() {
		return componentDescription;
	}

	public void setComponentDescription(String componentDescription) {
		this.componentDescription = componentDescription;
	}

	public double getComponentCalories() {
		return componentCalories;
	}

	public void setComponentCalories(double componentCalories) {
		this.componentCalories = componentCalories;
	}

	@Override
	public String toString() {
		return "ComponentId: " + this.component_id + "NameOfComponent" + this.componentName + ", component_weight: "
				+ this.componentWeight + ", component_description" + this.componentDescription
				+ ", component_calories: " + this.componentCalories;
	}

}
