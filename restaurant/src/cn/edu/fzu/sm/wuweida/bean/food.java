package cn.edu.fzu.sm.wuweida.bean;

import java.sql.Blob;

enum foodType_enum{
    粤菜,
    湘菜,
    甜品,
    火爆

}
public class food {
    private String foodName;
    private double foodPrice;
    private foodType_enum foodType;
    private Blob foodImg;

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public foodType_enum getFoodType() {
        return foodType;
    }

    public void setFoodType(foodType_enum foodType) {
        this.foodType = foodType;
    }

    public Blob getFoodImg() {
        return foodImg;
    }

    public void setFoodImg(Blob foodImg) {
        this.foodImg = foodImg;
    }

}
