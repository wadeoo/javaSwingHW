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
}
