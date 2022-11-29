package cn.edu.fzu.sm.wuweida.frame;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.*;

public class CustomerMainFrame extends JFrame {
    public CustomerMainFrame() throws HeadlessException {
        this.setUndecorated(true);
        this.setSize(700, 800);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setIconImage(new ImageIcon("image/logo.png").getImage());

        JPanel contentPanel = (JPanel) this.getContentPane();
        contentPanel.setBackground(new Color(26, 36, 43));
        MoveListener moveListener = new MoveListener();
        contentPanel.addMouseListener(moveListener);
        contentPanel.addMouseMotionListener(moveListener);

        JPanel westPanel = new JPanel();
        westPanel.setLayout(null);
        westPanel.setBounds(0, 0, 200, 800);
        westPanel.setBackground(new Color(36, 52, 72));
        contentPanel.add(westPanel, BorderLayout.WEST);

        JButton popFoodBtn=new JButton("热销品");
        popFoodBtn.setBounds(0,200,200,100);
        popFoodBtn.setBackground(new Color(80, 26,0));
        popFoodBtn.setFont(new Font("宋体",Font.BOLD,30));
        popFoodBtn.setForeground(Color.LIGHT_GRAY);
        popFoodBtn.setFocusPainted(false);
        popFoodBtn.setBorder(null);
        popFoodBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                CustomerMainFrame.this.setCursor(Cursor.HAND_CURSOR);
                popFoodBtn.setForeground(Color.WHITE);
                popFoodBtn.setBackground(new Color(58, 23,0));
                popFoodBtn.setFont(new Font("微软雅黑",Font.PLAIN,30));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                CustomerMainFrame.this.setCursor(Cursor.DEFAULT_CURSOR);
                popFoodBtn.setForeground(Color.LIGHT_GRAY);
                popFoodBtn.setBackground(new Color(80, 26,0));
                popFoodBtn.setFont(new Font("微软雅黑",Font.BOLD,30));
            }
        });
        westPanel.add(popFoodBtn);

        JButton cantoneseBtn=new JButton("粤菜");
        cantoneseBtn.setBounds(0,300,200,100);
        cantoneseBtn.setBackground(new Color(172, 208, 194));
        cantoneseBtn.setFont(new Font("宋体",Font.BOLD,30));
        cantoneseBtn.setForeground(Color.GRAY);
        cantoneseBtn.setFocusPainted(false);
        cantoneseBtn.setBorder(null);
        cantoneseBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                CustomerMainFrame.this.setCursor(Cursor.HAND_CURSOR);
                cantoneseBtn.setForeground(Color.WHITE);
                cantoneseBtn.setBackground(new Color(111, 144, 131));
                cantoneseBtn.setFont(new Font("微软雅黑",Font.PLAIN,30));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                CustomerMainFrame.this.setCursor(Cursor.DEFAULT_CURSOR);
                cantoneseBtn.setForeground(Color.GRAY);
                cantoneseBtn.setBackground(new Color(172, 208, 194));
                cantoneseBtn.setFont(new Font("微软雅黑",Font.BOLD,30));
            }
        });
        westPanel.add(cantoneseBtn);

        JButton xiangBtn=new JButton("湘菜");
        xiangBtn.setBounds(0,400,200,100);
        xiangBtn.setBackground(new Color(160, 228, 203));
        xiangBtn.setFont(new Font("宋体",Font.BOLD,30));
        xiangBtn.setForeground(Color.GRAY);
        xiangBtn.setFocusPainted(false);
        xiangBtn.setBorder(null);
        xiangBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                CustomerMainFrame.this.setCursor(Cursor.HAND_CURSOR);
                xiangBtn.setForeground(Color.WHITE);
                xiangBtn.setBackground(new Color(73, 104, 95));
                xiangBtn.setFont(new Font("微软雅黑",Font.PLAIN,30));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                CustomerMainFrame.this.setCursor(Cursor.DEFAULT_CURSOR);
                xiangBtn.setForeground(Color.GRAY);
                xiangBtn.setBackground(new Color(160, 228, 203));
                xiangBtn.setFont(new Font("微软雅黑",Font.BOLD,30));
            }
        });
        westPanel.add(xiangBtn);

        JButton dessertBtn=new JButton("甜品");
        dessertBtn.setBounds(0,500,200,100);
        dessertBtn.setBackground(new Color(89, 193, 189));
        dessertBtn.setFont(new Font("宋体",Font.BOLD,30));
        dessertBtn.setForeground(Color.GRAY);
        dessertBtn.setFocusPainted(false);
        dessertBtn.setBorder(null);
        dessertBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                CustomerMainFrame.this.setCursor(Cursor.HAND_CURSOR);
                dessertBtn.setForeground(Color.WHITE);
                dessertBtn.setBackground(new Color(50, 101, 97));
                dessertBtn.setFont(new Font("微软雅黑",Font.PLAIN,30));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                CustomerMainFrame.this.setCursor(Cursor.DEFAULT_CURSOR);
                dessertBtn.setForeground(Color.GRAY);
                dessertBtn.setBackground(new Color(89, 193, 189));
                dessertBtn.setFont(new Font("微软雅黑",Font.BOLD,30));
            }
        });
        westPanel.add(dessertBtn);

        JButton cartBtn=new JButton("购物车");
        cartBtn.setBounds(0,600,200,100);
        cartBtn.setBackground(new Color(13, 76, 146));
        cartBtn.setFont(new Font("宋体",Font.BOLD,30));
        cartBtn.setForeground(Color.GRAY);
        cartBtn.setFocusPainted(false);
        cartBtn.setBorder(null);
        cartBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                CustomerMainFrame.this.setCursor(Cursor.HAND_CURSOR);
                cartBtn.setForeground(Color.WHITE);
                cartBtn.setBackground(new Color(8, 33, 66));
                cartBtn.setFont(new Font("微软雅黑",Font.PLAIN,30));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                CustomerMainFrame.this.setCursor(Cursor.DEFAULT_CURSOR);
                cartBtn.setForeground(Color.GRAY);
                cartBtn.setBackground(new Color(13, 76, 146));
                cartBtn.setFont(new Font("微软雅黑",Font.BOLD,30));
            }
        });
        westPanel.add(cartBtn);


//        JButton quitBtn=new JButton("退出");
//        quitBtn.setBounds(0,700,100,100);
//        quitBtn.setBackground(new Color(196, 108, 46));
//        quitBtn.setFont(new Font("宋体",Font.BOLD,20));
//        quitBtn.setForeground(Color.GRAY);
//        quitBtn.setFocusPainted(false);
//        quitBtn.setBorder(null);
//        quitBtn.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                super.mouseEntered(e);
//                CustomerMainFrame.this.setCursor(Cursor.HAND_CURSOR);
//                quitBtn.setForeground(Color.WHITE);
//                quitBtn.setBackground(new Color(139, 62, 0));
//                quitBtn.setFont(new Font("微软雅黑",Font.PLAIN,20));
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                super.mouseExited(e);
//                CustomerMainFrame.this.setCursor(Cursor.DEFAULT_CURSOR);
//                quitBtn.setForeground(Color.GRAY);
//                quitBtn.setBackground(new Color(196, 108, 46));
//                quitBtn.setFont(new Font("微软雅黑",Font.BOLD,20));
//            }
//        });
//        westPanel.add(quitBtn);

        JLabel quitBtn=new JLabel("退出");
        quitBtn.setBounds(0,700,100,100);
        quitBtn.setHorizontalAlignment(SwingConstants.CENTER);
        quitBtn.setBackground(new Color(196, 108, 46));
        quitBtn.setFont(new Font("宋体",Font.BOLD,20));
        quitBtn.setForeground(Color.GRAY);
        quitBtn.setBorder(null);
        quitBtn.setOpaque(true);
        quitBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                CustomerMainFrame.this.setCursor(Cursor.HAND_CURSOR);
                quitBtn.setForeground(Color.WHITE);
                quitBtn.setBackground(new Color(139, 62, 0));
                quitBtn.setFont(new Font("微软雅黑",Font.PLAIN,20));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                CustomerMainFrame.this.setCursor(Cursor.DEFAULT_CURSOR);
                quitBtn.setForeground(Color.GRAY);
                quitBtn.setBackground(new Color(196, 108, 46));
                quitBtn.setFont(new Font("微软雅黑",Font.BOLD,20));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(JOptionPane.showConfirmDialog(CustomerMainFrame.this,"确定要退出吗?",null,JOptionPane.WARNING_MESSAGE)==0){
                    CustomerMainFrame.this.dispose();
                }
            }
        });

        westPanel.add(quitBtn);

        JButton confirmBtn=new JButton("确定\n订单");
        confirmBtn.setBounds(100,700,100,100);
        confirmBtn.setBackground(new Color(0, 34, 74));
        confirmBtn.setFont(new Font("宋体",Font.BOLD,20));
        confirmBtn.setForeground(Color.GRAY);
        confirmBtn.setFocusPainted(false);
        confirmBtn.setBorder(null);
        confirmBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                CustomerMainFrame.this.setCursor(Cursor.HAND_CURSOR);
                confirmBtn.setForeground(Color.WHITE);
                confirmBtn.setBackground(new Color(0, 24, 55));
                confirmBtn.setFont(new Font("微软雅黑",Font.PLAIN,20));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                CustomerMainFrame.this.setCursor(Cursor.DEFAULT_CURSOR);
                confirmBtn.setForeground(Color.GRAY);
                confirmBtn.setBackground(new Color(0, 34, 74));
                confirmBtn.setFont(new Font("微软雅黑",Font.BOLD,20));
            }
        });
        westPanel.add(confirmBtn);

        JLabel logoLabel = new JLabel(new ImageIcon("image/logo.png"));
        logoLabel.grabFocus();
        logoLabel.setBounds(20, 20, 160, 160);
        westPanel.add(logoLabel);

        JTextField searchText = new JTextField();
        searchText.setBounds(300, 30, 300, 40);
        searchText.setBorder(null);
        searchText.setBackground(new Color(42, 57, 65));
        searchText.setForeground(Color.LIGHT_GRAY);
        searchText.setFont(new Font("正楷", Font.PLAIN, 20));
        searchText.setBorder(BorderFactory.createCompoundBorder(searchText.getBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        searchText.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                searchText.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                searchText.setBorder(null);
            }
        });
        contentPanel.add(searchText);

        JLabel searchLogoLabel = new JLabel(new ImageIcon("image/search.png"));
        searchLogoLabel.setBounds(620, 30, 40, 40);
        searchLogoLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                CustomerMainFrame.this.setCursor(Cursor.HAND_CURSOR);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                CustomerMainFrame.this.setCursor(Cursor.DEFAULT_CURSOR);
            }
        });
        contentPanel.add(searchLogoLabel);


        this.setVisible(true);
    }

    class MoveListener implements MouseListener, MouseMotionListener {

        private Point pressedPoint;
        private Rectangle frameBounds;

        @Override
        public void mouseClicked(MouseEvent event) {
        }

        @Override
        public void mousePressed(MouseEvent event) {
            this.frameBounds = CustomerMainFrame.this.getBounds();
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
            CustomerMainFrame.this.setBounds(frameBounds);
        }

    }

}
