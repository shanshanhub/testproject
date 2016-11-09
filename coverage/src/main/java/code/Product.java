package code;

import java.util.Random;

/**
 * @author WanChuanLai
 * @create 4/21/16.
 */
public class Product {
    public static void main(String [] args){
        Random rand = new Random();
        int randNum  = rand.nextInt(0-1);
        System.out.print(randNum);
    }

}
