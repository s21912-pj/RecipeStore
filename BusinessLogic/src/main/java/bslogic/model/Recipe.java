package bslogic.model;

import java.util.Date;
import java.util.List;




public class Recipe {

	private int recipe_id;
	private String recipeName;
	private double weight;
	private double aproxPrice;
	private int raiting;
	private int caloriesCat;
	private int foodCat;
	private double calories;
	private int user_id;
	private Date publishDate;
	private List<RecipeComponent> recipeComponents;

	public Recipe() {

	}
	
	

	public Recipe(int recipe_id, String recipeName, double weight, double aproxPrice, int raiting, int caloriesCat,
			int foodCat, double calories, int user_id, Date publishDate, List<RecipeComponent> recipeComponents) {
		
		this.recipe_id = recipe_id;
		this.recipeName = recipeName;
		this.weight = weight;
		this.aproxPrice = aproxPrice;
		this.raiting = raiting;
		this.caloriesCat = caloriesCat;
		this.foodCat = foodCat;
		this.calories = calories;
		this.user_id = user_id;
		this.publishDate = publishDate;
		this.recipeComponents = recipeComponents;
	}



	public Recipe(Integer id, String string, String string2, double double1, double double2, int int1, double double3,
			int int2, int int3, int int4, java.sql.Date date) {
		// TODO Auto-generated constructor stub
	}



	public int getRecipe_id() {
		return recipe_id;
	}

	public void setRecipe_id(int recipe_id) {
		this.recipe_id = recipe_id;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getAproxPrice() {
		return aproxPrice;
	}

	public void setAproxPrice(double aproxPrice) {
		this.aproxPrice = aproxPrice;
	}

	public int getRaiting() {
		return raiting;
	}

	public void setRaiting(int raiting) {
		this.raiting = raiting;
	}

	public int getCaloriesCat() {
		return caloriesCat;
	}

	public void setCaloriesCat(int caloriesCat) {
		this.caloriesCat = caloriesCat;
	}

	public int getFoodCat() {
		return foodCat;
	}

	public void setFoodCat(int foodCat) {
		this.foodCat = foodCat;
	}

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public List<RecipeComponent> getRecipeComponents() {
		return recipeComponents;
	}

	public void setRecipeComponents(List<RecipeComponent> recipeComponents) {
		this.recipeComponents = recipeComponents;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	@Override
	public String toString() {
		return "id:" + this.recipe_id + ", Name: " + this.recipeName + " , calories: " + this.calories + ", weight:"
				+ this.weight + ", aproxPrice: " + this.aproxPrice + ", raiting: " + this.raiting + ", user_id "
				+ this.user_id + ", food category: " + this.foodCat + ", calories category " + this.caloriesCat
				+ ", publishDate: " + this.publishDate + ", CompList:" + this.recipeComponents;
	}

}
