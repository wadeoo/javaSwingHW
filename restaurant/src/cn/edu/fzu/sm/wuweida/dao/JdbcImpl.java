package cn.edu.fzu.sm.wuweida.dao;

import cn.edu.fzu.sm.wuweida.bean.CustomerUser;
import cn.edu.fzu.sm.wuweida.bean.Food;
import cn.edu.fzu.sm.wuweida.bean.Order;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcImpl implements JdbcConfig {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public JdbcImpl() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean doUsernameExist(CustomerUser enteredUser) {
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM customeruser WHERE username=?");
            preparedStatement.setString(1, enteredUser.getUsername());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean doUserExist(CustomerUser enteredUser) {
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM customeruser WHERE username=? AND password=?");
            preparedStatement.setString(1, enteredUser.getUsername());
            preparedStatement.setString(2, enteredUser.getPassword());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Food> getFoodList(String foodType) {
        try {
            if (foodType=="pop") {
                preparedStatement = connection.prepareStatement("SELECT * FROM food WHERE isPop=1");
            } else {
                preparedStatement = connection.prepareStatement("SELECT * FROM food" + " WHERE foodType='" + foodType+"'");
            }
            resultSet = preparedStatement.executeQuery();
            List<Food> FoodList = new ArrayList<>();
            while (resultSet.next()) {
                Food food = new Food();
                food.setFoodName(resultSet.getString(2));
                food.setFoodPrice(resultSet.getDouble(3));
                food.setFoodType(resultSet.getString(4));
                Blob imgBlob = resultSet.getBlob(5);
                InputStream inputStream = imgBlob.getBinaryStream();
                try {
                    OutputStream outputStream = new FileOutputStream("dishImg/" + resultSet.getString(2) + ".jpg");
                    byte[] buffer = new byte[1024];
                    int len = 0;
                    while ((len = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, len);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                food.setIsPop(resultSet.getInt(6));
                FoodList.add(food);
            }

            return FoodList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public double getFoodPrice(String foodName){
        try{
            preparedStatement=connection.prepareStatement("SELECT foodPrice FROM food WHERE foodName=?");
            preparedStatement.setString(1,foodName);
            resultSet=preparedStatement.executeQuery();
            if (resultSet.next()){
                return resultSet.getDouble(1);
            }else{
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int getFoodId(String foodName){
        try{
            preparedStatement=connection.prepareStatement("SELECT foodId FROM foodd WHERE foodName=?");
            preparedStatement.setString(1,foodName);
            resultSet=preparedStatement.executeQuery();
            if (resultSet.next()){
                return resultSet.getInt(1);
            }else {
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void addOrder(Order toBeAddedOrder){
        try{
            preparedStatement=connection.prepareStatement("INSERT INTO order (username, foodId, quantity, orderTime) VALUES (?,?,?,?)");
            preparedStatement.setString(1,toBeAddedOrder.getUsername());
            preparedStatement.setInt(2,toBeAddedOrder.getFoodId());
            preparedStatement.setInt(3,toBeAddedOrder.getQuantity());
            preparedStatement.setDate(4,toBeAddedOrder.getOrderTime());
            int result=preparedStatement.executeUpdate();
            if (result!=0){
                System.out.println("订单添加成功");
            }else {
                System.out.println("订单添加失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
