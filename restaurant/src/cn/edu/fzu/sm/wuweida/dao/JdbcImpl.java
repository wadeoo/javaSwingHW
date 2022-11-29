package cn.edu.fzu.sm.wuweida.dao;

import cn.edu.fzu.sm.wuweida.bean.CustomerUser;

import java.sql.*;

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

}
