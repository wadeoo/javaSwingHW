package cn.edu.fzu.sm.wuweida.frame;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.*;

public class CustomerLoginFrame extends JFrame {
    public CustomerLoginFrame() throws HeadlessException {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setSize(450,300);
        this.setLocationRelativeTo(null);
//        this.setLayout(null);

        JLabel loginLabel=new JLabel("登录");
        loginLabel.setBounds(50,25,100,50);
        loginLabel.setForeground(new Color(200,200,200));
        loginLabel.setFont(new Font("微软雅黑",Font.PLAIN,30));
        this.add(loginLabel);


        JLabel usernameLabel=new JLabel("用户名:");
        usernameLabel.setBounds(75,100,100,25);
        usernameLabel.setForeground(new Color(220,220,220));
        usernameLabel.setFont(new Font("微软雅黑",Font.PLAIN,18));
        this.add(usernameLabel);


        JTextField usernameText=new JTextField();
        usernameText.setBounds(175,100,200,25);
        usernameText.setOpaque(false);
        usernameText.setForeground(Color.WHITE);
        usernameText.setFont(new Font("微软雅黑",Font.PLAIN,15));
        usernameText.setBorder(new MatteBorder(0,0,1,0,Color.LIGHT_GRAY));
        usernameText.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                usernameText.setBorder(new MatteBorder(0,0,2,0,Color.WHITE));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                usernameText.setBorder(new MatteBorder(0,0,1,0,Color.LIGHT_GRAY));
            }
        });

        this.add(usernameText);


        JLabel passwordLabel=new JLabel("密码:");
        passwordLabel.setBounds(75,150,100,25);
        passwordLabel.setForeground(new Color(220,220,220));
        passwordLabel.setFont(new Font("微软雅黑",Font.PLAIN,18));
        this.add(passwordLabel);


        JTextField passwordText=new JTextField();
        passwordText.setBounds(175,150,200,25);
        passwordText.setOpaque(false);
        usernameText.setForeground(Color.WHITE);
        passwordText.setFont(new Font("微软雅黑",Font.PLAIN,15));
        passwordText.setBorder(new MatteBorder(0,0,1,0,Color.LIGHT_GRAY));
        passwordText.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                passwordText.setBorder(new MatteBorder(0,0,2,0,Color.WHITE));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                passwordText.setBorder(new MatteBorder(0,0,1,0,Color.LIGHT_GRAY));
            }
        });
        this.add(passwordText);


        //注册
        JButton registerBtn=new JButton("未有账号? 点击此处注册");
        registerBtn.setContentAreaFilled(false);
        registerBtn.setBounds(150,175,150,50);
        registerBtn.setBorder(null);
        registerBtn.setForeground(Color.LIGHT_GRAY);
        registerBtn.setFont(new Font("宋体",Font.PLAIN,12));
        registerBtn.setFocusPainted(false);
        this.add(registerBtn);

        //确定按钮
        JButton okBtn=new JButton("登录");
        okBtn.setFont(new Font("微软雅黑",Font.BOLD,20));
        okBtn.setBounds(0,250,225,50);
        okBtn.setBackground(new Color(0, 110, 73));
        okBtn.setBorder(null);
        okBtn.setFocusPainted(false);
        this.add(okBtn);


        this.add(new ImagePanel("image/loginBG.jpg"));



        this.setVisible(true);
    }
}
