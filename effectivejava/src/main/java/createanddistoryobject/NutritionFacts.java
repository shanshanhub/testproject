package createanddistoryobject;

/**
 * @author WanChuanLai
 * @create 9/26/16.
 * 营养成分
 * Builder Pattern
 */
public class NutritionFacts {
    private final int servingSize;//实用分量
    private final int servings;//建议量
    private final int calories;//卡路里
    private final int fat;
    private final int sodium;//钠
    private final int carbohydrate;//碳水化合物,糖水

    public static class Builder {
        private final int servingSize;//实用分量
        private final int servings;//建议量
        private int calories = 0;//卡路里
        private int fat = 0;
        private int sodium = 0;//钠
        private int carbohydrate = 0;//碳水化合物,糖水

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            this.calories = val;
            return this;
        }

        public Builder fat(int val){
            this.fat=val;
            return this;
        }

        public Builder sodium(int val){
            this.sodium=val;
            return this;
        }

        public Builder carbohydrate(int val){
            this.carbohydrate=val;
            return this;
        }

        public  NutritionFacts build(){
            return new NutritionFacts(this);
        }
    }
    private NutritionFacts(Builder builder){
        this.calories=builder.calories;
        this.carbohydrate=builder.carbohydrate;
        this.fat=builder.fat;
        this.servings=builder.servings;
        this.servingSize=builder.servingSize;
        this.sodium=builder.sodium;
    }


    public static void main(String [] args){
        //客户端调用
        NutritionFacts nutritionFacts=new NutritionFacts.Builder(240,8).calories(1).build();
    }

}
