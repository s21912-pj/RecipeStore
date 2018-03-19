package bslogic.staticdata;

public class SqlComponentStaticData {
	public static final String sAllComponents = "select * from public.recipe_components";
	public static final String sSingleComponentById = "select * from public.recipe_components where c_id=?";
	public static final String sSingleComponentByRecipeId = "select * from public.recipe_components where c_recipe_id=?";
	public static final String sUpdateComponentByRecipeId = "UPDATE public.recipe_components "+
			"SET c_name=?, c_weight=?, c_calories=?, c_description=? WHERE c_id=?";
}
