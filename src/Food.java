public class Food {
    private String foodName;
    private float water;
    private float fat;
    private float protein;
    private float carbs;
    private float calories;

    public static Food initFromParams(String[] paramsArr) {
        Food food = new Food();
        food.setFoodName(paramsArr[0]);
        food.setWater(Float.parseFloat(paramsArr[1]));
        food.setFat(Float.parseFloat(paramsArr[2]));
        food.setProtein(Float.parseFloat(paramsArr[3]));
        food.setCarbs(Float.parseFloat(paramsArr[4]));
        food.setCalories(Float.parseFloat(paramsArr[5]));
        return food;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public float getWater() {
        return water;
    }

    public void setWater(float water) {
        this.water = water;
    }

    public float getFat() {
        return fat;
    }

    public void setFat(float fat) {
        this.fat = fat;
    }

    public float getProtein() {
        return protein;
    }

    public void setProtein(float protein) {
        this.protein = protein;
    }

    public float getCarbs() {
        return carbs;
    }

    public void setCarbs(float carbs) {
        this.carbs = carbs;
    }

    public float getCalories() {
        return calories;
    }

    public void setCalories(float calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "Food{" +
                "foodName = '" + foodName + '\'' +
                ", water = " + water +
                ", fat = " + fat +
                ", protein = " + protein +
                ", carbs = " + carbs +
                ", calories = " + calories +
                '}';
    }
}
