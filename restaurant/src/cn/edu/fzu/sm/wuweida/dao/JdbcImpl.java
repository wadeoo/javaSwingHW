package cn.edu.fzu.sm.wuweida.dao;

import cn.edu.fzu.sm.wuweida.bean.CustomerUser;
import cn.edu.fzu.sm.wuweida.bean.Food;

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
            connection= DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean doUsernameExist(CustomerUser enteredUser){
        try {
            preparedStatement=connection.prepareStatement("SELECT * FROM customeruser WHERE username=?");
            preparedStatement.setString(1,enteredUser.getUsername());
            resultSet=preparedStatement.executeQuery();if(resultSet.next()){
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean doUserExist(CustomerUser enteredUser){
        try {
            preparedStatement=connection.prepareStatement("SELECT * FROM customeruser WHERE username=? AND password=?");
            preparedStatement.setString(1,enteredUser.getUsername());
            preparedStatement.setString(2,enteredUser.getPassword());
            resultSet=preparedStatement.executeQuery();if(resultSet.next()){
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Food> getAllFood(){
        try{
            preparedStatement=connection.prepareStatement("SELECT * FROM food");
            resultSet=preparedStatement.executeQuery();
            List<Food> allFoodList=new ArrayList<>();
            while(resultSet.next()){
                Food food=new Food();
                food.setFoodName(resultSet.getString(2));
                food.setFoodPrice(resultSet.getDouble(3));
                food.setFoodType(resultSet.getString(4));
                Blob imgBlob=resultSet.getBlob(5);
                InputStream inputStream=imgBlob.getBinaryStream();
                try {
                    OutputStream outputStream=new FileOutputStream("dishImg/"+resultSet.getString(2)+".jpg");
                    byte[] buffer=new byte[1024];
                    int len=0;
                    while ((len=inputStream.read(buffer))!=-1){
                        outputStream.write(buffer,0,len);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                food.setIsPop(resultSet.getInt(6));
                allFoodList.add(food);
            }

            return allFoodList;
        }catch (SQLException e ){
            e.printStackTrace();
            return null;
        }
    }

}
