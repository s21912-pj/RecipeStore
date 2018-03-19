package bslogic.staticdata;

public class SqlRecipeStaticData {
    public final static String sGetRecipeBsyId = "select r_id,r_name,r_weight,r_aprox_price,r_raiting,r_calories,r_user_id,"
            + "r_kcategory_id,r_fcategory_id,r_published_date from public.recipe_store where r_id=?";
    //Update
    public static final String sUpdateRecipe = "update recipe_store SET r_name=?,r_weight=?,r_aprox_price=?,r_raiting=?,"
            + "r_calories=?,r_kcategory_id=?,r_fcategory_id=? WHERE r_id=?";
    //search
    public static final String sSearchAllRecipesByName = "select r_id,r_name,r_weight,r_aprox_price,r_raiting,r_calories,r_user_id,r_kcategory_id,"
            + "r_fcategory_id,r_published_date,c_id, c_name,c_weight,c_description,"
            + "c_calories,c_recipe_id from public.recipe_store LEFT JOIN public.recipe_components ON "
            + "(public.recipe_store.r_id=public.recipe_components.c_recipe_id) WHERE r_name like ?";
    public static String sGetAllRecipes = "SELECT * FROM public.recipe_store";
    public static String sGetAllRecipesByUserId = "select r_id,r_name,r_weight,r_aprox_price,r_raiting,r_calories,r_user_id,r_kcategory_id,"
            + "r_fcategory_id,r_published_date,c_id, c_name,c_weight,c_description,"
            + "c_calories,c_recipe_id from public.recipe_store INNER JOIN public.recipe_components ON "
            + "(public.recipe_store.r_id=public.recipe_components.c_recipe_id) WHERE r_user_id=?";
    public static String sGetAllRecipesWithSingleQuery = "select r_id,r_name,r_weight,r_aprox_price,r_raiting,r_calories,r_user_id,r_kcategory_id,"
            + "r_fcategory_id,r_published_date,c_id, c_name,c_weight,c_description,"
            + "c_calories,c_recipe_id from public.recipe_store LEFT JOIN public.recipe_components ON "
            + "(public.recipe_store.r_id=public.recipe_components.c_recipe_id)";
    public static String sGetRecipesWithSingleQueryById = "select r_id,r_name,r_weight,r_aprox_price,r_raiting,r_calories,r_user_id,r_kcategory_id,"
            + "r_fcategory_id,r_published_date,c_id, c_name,c_weight,c_description,"
            + "c_calories,c_recipe_id from public.recipe_store LEFT JOIN public.recipe_components ON "
            + "(public.recipe_store.r_id=public.recipe_components.c_recipe_id) WHERE r_id=?";
    //find all by calories category
    public static String sGetRecipeWithCompByCaloriesId = "select r_id,r_name,r_weight,r_aprox_price,r_raiting,r_calories,r_user_id,r_kcategory_id,"
            + "r_fcategory_id,r_published_date,c_id, c_name,c_weight,c_description,"
            + "c_calories,c_recipe_id from public.recipe_store LEFT JOIN public.recipe_components ON "
            + "(public.recipe_store.r_id=public.recipe_components.c_recipe_id) WHERE r_kcategory_id=?";
    //find all by food category
    public static String sGetRecipeWithCompByFoodCategoryId = "select r_id,r_name,r_weight,r_aprox_price,r_raiting,r_calories,r_user_id,r_kcategory_id,"
            + "r_fcategory_id,r_published_date,c_id, c_name,c_weight,c_description,"
            + "c_calories,c_recipe_id from public.recipe_store LEFT JOIN public.recipe_components ON "
            + "(public.recipe_store.r_id=public.recipe_components.c_recipe_id) WHERE r_fcategory_id=?";

    //create
    public static String sCreateRecipeWithComponents = "WITH rows AS(" + "INSERT INTO recipe_store(r_name,r_weight,r_aprox_price,r_raiting,r_calories,r_user_id,r_kcategory_id,r_fcategory_id)" + "VALUES(?,?,?,?,?,?,?,?) RETURNING r_id)" + "INSERT INTO recipe_components(c_name,c_weight,c_calories,c_description,c_recipe_id) VALUES (?,?,?,?,(SELECT r_id FROM rows))";
    public static String sCreateRecipeWithoutComponents = "INSERT INTO recipe_store(r_name,r_weight,r_aprox_price,r_raiting,r_calories,r_user_id,r_kcategory_id,r_fcategory_id)\" + \"VALUES(?,?,?,?,?,?,?,?)";
    //delete
    public static String sDeleteRecipe = "DELETE from recipe_store WHERE r_id=?";

}
