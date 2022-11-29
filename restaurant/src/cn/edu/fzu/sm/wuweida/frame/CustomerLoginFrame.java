package cn.edu.fzu.sm.wuweida.frame;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class CustomerLoginFrame extends JFrame {
    public CustomerLoginFrame() throws HeadlessException {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setSize(450,300);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        JLabel loginLabel=new JLabel("登录");
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginLabel.setBounds(50,25,100,50);
        loginLabel.setFont(new Font("微软雅黑",Font.PLAIN,30));
        this.add(loginLabel);


        JLabel usernameLabel=new JLabel("用户名:");
        usernameLabel.setBounds(100,100,100,25);
        usernameLabel.setFont(new Font("微软雅黑",Font.PLAIN,15));
        this.add(usernameLabel);


        JTextField usernameText=new JTextField();
        usernameText.setBounds(175,100,200,25);
        usernameText.setOpaque(false);
        usernameText.setFont(new Font("微软雅黑",Font.PLAIN,15));
        MatteBorder matteBorder=new MatteBorder(0,0,2,0,Color.BLACK);
        usernameText.setBorder(matteBorder);
        this.add(usernameText);


        JLabel passwordLabel=new JLabel("密码:");
        passwordLabel.setBounds(100,150,100,25);
        passwordLabel.setFont(new Font("微软雅黑",Font.PLAIN,15));
        this.add(passwordLabel);


        JTextField passwordText=new JTextField();
        passwordText.setBounds(175,150,200,25);
        passwordText.setOpaque(false);
        passwordText.setFont(new Font("微软雅黑",Font.PLAIN,15));
        MatteBorder matteBorder2=new MatteBorder(0,0,2,0,Color.BLACK);
        passwordText.setBorder(matteBorder2);
        this.add(passwordText);





        this.setVisible(true);
    }
}
