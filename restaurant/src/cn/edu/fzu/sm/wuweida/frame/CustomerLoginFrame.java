package cn.edu.fzu.sm.wuweida.frame;

import cn.edu.fzu.sm.wuweida.bean.CustomerUser;
import cn.edu.fzu.sm.wuweida.dao.JdbcConfig;
import cn.edu.fzu.sm.wuweida.dao.JdbcImpl;
import cn.edu.fzu.sm.wuweida.util.PasswordField;
import cn.edu.fzu.sm.wuweida.util.TextField;
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
        this.setLayout(null);
        this.setSize( 300,450);
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon("image/logo.png").getImage());


        JPanel contentPanel=(JPanel) this.getContentPane();
        contentPanel.setBounds(0,0,300,450);
        contentPanel.setBackground(new Color(20, 26, 47));





//        JLabel loginLabel=new JLabel("登录");
        JLabel loginLabel=new JLabel();
        loginLabel.setIcon(new ImageIcon("image/loginLogo.png"));
//        loginLabel.setBounds(190,25,100,50);
        loginLabel.setBounds(100,40,100,100);
        loginLabel.setFont(new Font("草书",Font.ITALIC,30));
        contentPanel.add(loginLabel);


//        JLabel usernameLabel=new JLabel("用户名:");
//        usernameLabel.setBounds(75,100,100,25);
//        usernameLabel.setForeground(new Color(220,220,220));
//        usernameLabel.setFont(new Font("微软雅黑",Font.PLAIN,18));
//        this.add(usernameLabel);


        TextField usernameText=new TextField();
        usernameText.setLabelText("用户名");
//        usernameText.setBounds(175,100,200,20);
        usernameText.setBounds(50,170,200,20);
        usernameText.setOpaque(false);
        usernameText.setForeground(Color.WHITE);
        usernameText.setFont(new Font("微软雅黑",Font.PLAIN,10));
        usernameText.setBorder(new MatteBorder(0,0,1,0,Color.WHITE));
//        usernameText.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                super.mouseEntered(e);
//                usernameText.setBorder(new MatteBorder(0,0,2,0,Color.WHITE));
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                super.mouseExited(e);
//                if(!usernameText.isFocusOwner()){
//                    usernameText.setBorder(new MatteBorder(0,0,1,0,Color.LIGHT_GRAY));
//                }
//            }
//        });
//        usernameText.addFocusListener(new FocusAdapter() {
//            @Override
//            public void focusGained(FocusEvent e) {
//                super.focusGained(e);
//                usernameText.setBorder(new MatteBorder(0,0,2,0,Color.WHITE));
//            }
//
//            @Override
//            public void focusLost(FocusEvent e) {
//                super.focusLost(e);
//                usernameText.setBorder(new MatteBorder(0,0,1,0,Color.LIGHT_GRAY));
//            }
//        });
//        usernameLabel.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mousePressed(MouseEvent e) {
//                super.mouseClicked(e);
//                usernameText.grabFocus();
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e){
//                super.mouseEntered(e);
//                usernameLabel.setForeground(Color.WHITE);
//                CustomerLoginFrame.this.setCursor(Cursor.HAND_CURSOR);
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e){
//                super.mouseExited(e);
//                usernameLabel.setForeground(Color.LIGHT_GRAY);
//                CustomerLoginFrame.this.setCursor(Cursor.DEFAULT_CURSOR);
//            }
//        });
        contentPanel.add(usernameText);


//        JLabel passwordLabel=new JLabel("密码:");
//        passwordLabel.setBounds(75,150,100,25);
//        passwordLabel.setForeground(new Color(220,220,220));
//        passwordLabel.setFont(new Font("微软雅黑",Font.PLAIN,18));
//        this.add(passwordLabel);


//        JPasswordField passwordText=new JPasswordField();
        PasswordField passwordText=new PasswordField();
        passwordText.setLabelText("密码");
        passwordText.setLineColor(new Color(3, 104, 158));
        passwordText.setShowAndHide(true);
        passwordText.setBounds(50,220,200,20);
        passwordText.setOpaque(false);
        passwordText.setForeground(Color.WHITE);
        passwordText.setFont(new Font("微软雅黑",Font.PLAIN,10));
        passwordText.setBorder(new MatteBorder(0,0,1,0,Color.LIGHT_GRAY));
//        passwordText.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                super.mouseEntered(e);
//                passwordText.setBorder(new MatteBorder(0,0,2,0,Color.WHITE));
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                super.mouseExited(e);
//                if(!passwordText.isFocusOwner()){
//                    passwordText.setBorder(new MatteBorder(0,0,1,0,Color.LIGHT_GRAY));
//                }
//            }
//        });
//        passwordText.addFocusListener(new FocusAdapter() {
//            @Override
//            public void focusGained(FocusEvent e) {
//                super.focusGained(e);
//                passwordText.setBorder(new MatteBorder(0,0,2,0,Color.WHITE));
//            }
//
//            @Override
//            public void focusLost(FocusEvent e) {
//                super.focusLost(e);
//                passwordText.setBorder(new MatteBorder(0,0,1,0,Color.LIGHT_GRAY));
//            }
//        });
//        passwordLabel.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mousePressed(MouseEvent e) {
//                super.mouseClicked(e);
//                passwordText.grabFocus();
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e){
//                super.mouseEntered(e);
//                passwordLabel.setForeground(Color.WHITE);
//                CustomerLoginFrame.this.setCursor(Cursor.HAND_CURSOR);
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e){
//                super.mouseExited(e);
//                passwordLabel.setForeground(Color.LIGHT_GRAY);
//                CustomerLoginFrame.this.setCursor(Cursor.DEFAULT_CURSOR);
//            }
//        });
        contentPanel.add(passwordText);


        //注册
        JButton registerBtn=new JButton("未有账号? 点击此处注册");
        registerBtn.setContentAreaFilled(false);
        registerBtn.setBounds(75,400,150,20);
        registerBtn.setBorder(null);
        registerBtn.setForeground(Color.LIGHT_GRAY);
        registerBtn.setFont(new Font("宋体",Font.PLAIN,10));
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
        contentPanel.add(registerBtn);

        //确定按钮
        JLabel okLabel=new JLabel("登录");
        okLabel.setFont(new Font("微软雅黑",Font.PLAIN,10));
//        okLabel.setBounds(0,250,225,50);
        okLabel.setBounds(75,275,150,25);
        okLabel.setBackground(new Color(0, 65, 87));
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
                okLabel.setFont(new Font("微软雅黑",Font.BOLD,10));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                CustomerLoginFrame.this.setCursor(Cursor.DEFAULT_CURSOR);
                okLabel.setForeground(Color.LIGHT_GRAY);
                okLabel.setBackground(new Color(0, 65, 87));
                okLabel.setFont(new Font("微软雅黑",Font.PLAIN,10));
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
        contentPanel.add(okLabel);

        //取消按钮
        JLabel cancelLabel=new JLabel("取消");
        cancelLabel.setFont(new Font("微软雅黑",Font.PLAIN,10));
//        cancelLabel.setBounds(225,250,225,50);
        cancelLabel.setBounds(75,325,150,25);
        cancelLabel.setBackground(new Color(4, 44, 80));
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
                cancelLabel.setFont(new Font("微软雅黑",Font.BOLD,10));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                CustomerLoginFrame.this.setCursor(Cursor.DEFAULT_CURSOR);
                cancelLabel.setForeground(Color.LIGHT_GRAY);
                cancelLabel.setBackground(new Color(4, 44, 80));
                cancelLabel.setFont(new Font("微软雅黑",Font.PLAIN,10));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                CustomerLoginFrame.this.dispose();
            }
        });
        contentPanel.add(cancelLabel);



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
//        ImagePanel imagePanel=new ImagePanel("image/loginBG.jpg");
        MoveListener listener=new MoveListener();
        this.addMouseListener(listener);
        this.addMouseMotionListener(listener);
//        this.add(imagePanel);



        this.setVisible(true);
    }
}
