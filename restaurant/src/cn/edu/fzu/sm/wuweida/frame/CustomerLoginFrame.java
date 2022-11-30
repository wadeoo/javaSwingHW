package cn.edu.fzu.sm.wuweida.frame;

import cn.edu.fzu.sm.wuweida.bean.CustomerUser;
import cn.edu.fzu.sm.wuweida.dao.JdbcConfig;
import cn.edu.fzu.sm.wuweida.dao.JdbcImpl;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.*;

public class CustomerLoginFrame extends JFrame {
    JdbcImpl jdbcImpl=new JdbcImpl();

    public CustomerLoginFrame() throws HeadlessException {
        this.setUndecorated(true);
        this.setSize(450,300);
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon("image/logo.png").getImage());

        JLabel loginLabel=new JLabel("登录");
        loginLabel.setBounds(50,25,100,50);
        loginLabel.setForeground(new Color(200,200,200));
        loginLabel.setFont(new Font("草书",Font.ITALIC,30));
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
                if(!usernameText.isFocusOwner()){
                    usernameText.setBorder(new MatteBorder(0,0,1,0,Color.LIGHT_GRAY));
                }
            }
        });
        usernameText.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                usernameText.setBorder(new MatteBorder(0,0,2,0,Color.WHITE));
            }

            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                usernameText.setBorder(new MatteBorder(0,0,1,0,Color.LIGHT_GRAY));
            }
        });
        usernameLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                usernameText.grabFocus();
            }

            @Override
            public void mouseEntered(MouseEvent e){
                super.mouseEntered(e);
                usernameLabel.setForeground(Color.WHITE);
                CustomerLoginFrame.this.setCursor(Cursor.HAND_CURSOR);
            }

            @Override
            public void mouseExited(MouseEvent e){
                super.mouseExited(e);
                usernameLabel.setForeground(Color.LIGHT_GRAY);
                CustomerLoginFrame.this.setCursor(Cursor.DEFAULT_CURSOR);
            }
        });
        this.add(usernameText);


        JLabel passwordLabel=new JLabel("密码:");
        passwordLabel.setBounds(75,150,100,25);
        passwordLabel.setForeground(new Color(220,220,220));
        passwordLabel.setFont(new Font("微软雅黑",Font.PLAIN,18));
        this.add(passwordLabel);


        JPasswordField passwordText=new JPasswordField();
        passwordText.setBounds(175,150,200,25);
        passwordText.setOpaque(false);
        passwordText.setForeground(Color.WHITE);
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
                if(!passwordText.isFocusOwner()){
                    passwordText.setBorder(new MatteBorder(0,0,1,0,Color.LIGHT_GRAY));
                }
            }
        });
        passwordText.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                passwordText.setBorder(new MatteBorder(0,0,2,0,Color.WHITE));
            }

            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                passwordText.setBorder(new MatteBorder(0,0,1,0,Color.LIGHT_GRAY));
            }
        });
        passwordLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                passwordText.grabFocus();
            }

            @Override
            public void mouseEntered(MouseEvent e){
                super.mouseEntered(e);
                passwordLabel.setForeground(Color.WHITE);
                CustomerLoginFrame.this.setCursor(Cursor.HAND_CURSOR);
            }

            @Override
            public void mouseExited(MouseEvent e){
                super.mouseExited(e);
                passwordLabel.setForeground(Color.LIGHT_GRAY);
                CustomerLoginFrame.this.setCursor(Cursor.DEFAULT_CURSOR);
            }
        });
        this.add(passwordText);


        //注册
        JButton registerBtn=new JButton("未有账号? 点击此处注册");
        registerBtn.setContentAreaFilled(false);
        registerBtn.setBounds(150,200,150,50);
        registerBtn.setBorder(null);
        registerBtn.setForeground(Color.LIGHT_GRAY);
        registerBtn.setFont(new Font("宋体",Font.PLAIN,12));
        registerBtn.setFocusPainted(false);
        registerBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                CustomerLoginFrame.this.setCursor(Cursor.HAND_CURSOR);
                registerBtn.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                CustomerLoginFrame.this.setCursor(Cursor.DEFAULT_CURSOR);
                registerBtn.setForeground(Color.LIGHT_GRAY);
            }
        });
        this.add(registerBtn);

        //确定按钮
        JLabel okLabel=new JLabel("登录");
        okLabel.setFont(new Font("微软雅黑",Font.PLAIN,20));
        okLabel.setBounds(0,250,225,50);
        okLabel.setBackground(new Color(0, 106, 110));
        okLabel.setBorder(null);
        okLabel.setOpaque(true);
        okLabel.setHorizontalAlignment(SwingConstants.CENTER);
        okLabel.setForeground(Color.LIGHT_GRAY);
        okLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                CustomerLoginFrame.this.setCursor(Cursor.HAND_CURSOR);
                okLabel.setForeground(Color.WHITE);
                okLabel.setBackground(new Color(0, 66, 70));
                okLabel.setFont(new Font("微软雅黑",Font.BOLD,20));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                CustomerLoginFrame.this.setCursor(Cursor.DEFAULT_CURSOR);
                okLabel.setForeground(Color.LIGHT_GRAY);
                okLabel.setBackground(new Color(0, 106, 110));
                okLabel.setFont(new Font("微软雅黑",Font.PLAIN,20));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                String text1=usernameText.getText();
                String text2=passwordText.getText();
                if(text1.equals(null)||text1.equals("")){
                    JOptionPane.showMessageDialog(CustomerLoginFrame.this,"请输入用户名",null,JOptionPane.WARNING_MESSAGE);
                }else if(text2.equals(null)||text2.equals("")){
                    JOptionPane.showMessageDialog(CustomerLoginFrame.this,"请输入密码",null,JOptionPane.WARNING_MESSAGE);
                }else{
                    CustomerUser enteredUser=new CustomerUser();
                    enteredUser.setUsername(text1);
                    enteredUser.setPassword(text2);
                    if(!jdbcImpl.doUsernameExist(enteredUser)){
                        JOptionPane.showMessageDialog(CustomerLoginFrame.this,"用户名不存在",null,JOptionPane.WARNING_MESSAGE);
                    }else if (!jdbcImpl.doUserExist(enteredUser)){
                        JOptionPane.showMessageDialog(CustomerLoginFrame.this,"密码错误",null,JOptionPane.WARNING_MESSAGE);
                    }else{
                        CustomerLoginFrame.this.dispose();
                        CustomerMainFrame customerMainFrame=new CustomerMainFrame();
                    }
                }
            }
        });
        this.add(okLabel);

        //取消按钮
        JLabel cancelLabel=new JLabel("取消");
        cancelLabel.setFont(new Font("微软雅黑",Font.PLAIN,20));
        cancelLabel.setBounds(225,250,225,50);
        cancelLabel.setBackground(new Color(0, 54, 103));
        cancelLabel.setBorder(null);
        cancelLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cancelLabel.setOpaque(true);
        cancelLabel.setForeground(Color.LIGHT_GRAY);
        cancelLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                CustomerLoginFrame.this.setCursor(Cursor.HAND_CURSOR);
                cancelLabel.setForeground(Color.WHITE);
                cancelLabel.setBackground(new Color(0, 35, 78));
                cancelLabel.setFont(new Font("微软雅黑",Font.BOLD,20));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                CustomerLoginFrame.this.setCursor(Cursor.DEFAULT_CURSOR);
                cancelLabel.setForeground(Color.LIGHT_GRAY);
                cancelLabel.setBackground(new Color(0, 54, 103));
                cancelLabel.setFont(new Font("微软雅黑",Font.PLAIN,20));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                CustomerLoginFrame.this.dispose();
            }
        });
        this.add(cancelLabel);



        class MoveListener implements MouseListener, MouseMotionListener {

            private Point pressedPoint;
            private Rectangle frameBounds;

            @Override
            public void mouseClicked(MouseEvent event) {
            }

            @Override
            public void mousePressed(MouseEvent event) {
                this.frameBounds = CustomerLoginFrame.this.getBounds();
                this.pressedPoint = event.getPoint();
            }

            @Override
            public void mouseReleased(MouseEvent event) {
                moveJFrame(event);
            }

            @Override
            public void mouseEntered(MouseEvent event) {
            }

            @Override
            public void mouseExited(MouseEvent event) {
            }

            @Override
            public void mouseDragged(MouseEvent event) {
                moveJFrame(event);
            }

            @Override
            public void mouseMoved(MouseEvent event) {
            }

            private void moveJFrame(MouseEvent event) {
                Point endPoint = event.getPoint();

                int xDiff = endPoint.x - pressedPoint.x;
                int yDiff = endPoint.y - pressedPoint.y;
                frameBounds.x += xDiff;
                frameBounds.y += yDiff;
                CustomerLoginFrame.this.setBounds(frameBounds);
            }

        }
        ImagePanel imagePanel=new ImagePanel("image/loginBG.jpg");
        MoveListener listener=new MoveListener();
        imagePanel.addMouseListener(listener);
        imagePanel.addMouseMotionListener(listener);
        this.add(imagePanel);



        this.setVisible(true);
    }
}
