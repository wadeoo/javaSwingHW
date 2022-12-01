package cn.edu.fzu.sm.wuweida.frame;

import cn.edu.fzu.sm.wuweida.bean.Food;
import cn.edu.fzu.sm.wuweida.dao.JdbcImpl;
import cn.edu.fzu.sm.wuweida.util.Spinner;
import cn.edu.fzu.sm.wuweida.util.SpinnerUI;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CustomerMainFrame extends JFrame {
    private JLabel timeLabel;
    private SimpleDateFormat timeFormat;
    private JdbcImpl jdbcImpl = new JdbcImpl();
    private List<Food> allFoodList = new ArrayList<>();
    private JPanel contentPanel;

    public CustomerMainFrame() throws HeadlessException {
        this.setUndecorated(true);
        this.setSize(699, 799);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setIconImage(new ImageIcon("image/logo.png").getImage());
        this.setBackground(new Color(26, 36, 43));


        contentPanel = (JPanel) this.getContentPane();

        MoveListener moveListener = new MoveListener();
        contentPanel.addMouseListener(moveListener);
        contentPanel.addMouseMotionListener(moveListener);

        JPanel westPanel = new JPanel();
        westPanel.setLayout(null);
        westPanel.setBounds(0, 0, 200, 800);
        westPanel.setBackground(new Color(20, 26, 47));
        contentPanel.add(westPanel);


        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setForeground(new Color(9, 9, 20));
        timeLabel.setBackground(new Color(24, 45, 70));
        timeLabel.setBounds(0, 200, 200, 100);
        timeLabel.setOpaque(true);
        //报时线程
        MyThreadRunnable target = new MyThreadRunnable(timeFormat,timeLabel);
        Thread setTimeThread = new Thread(target);
        setTimeThread.start();
        westPanel.add(timeLabel);

        JLabel popLabel = new JLabel("热销品");
        popLabel.setBounds(0, 450, 200, 100);
        popLabel.setHorizontalAlignment(SwingConstants.CENTER);
        popLabel.setBackground(new Color(80, 26, 0));
        popLabel.setFont(new Font("宋体", Font.BOLD, 20));
        popLabel.setForeground(Color.LIGHT_GRAY);
        popLabel.setOpaque(true);
        popLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                CustomerMainFrame.this.setCursor(Cursor.HAND_CURSOR);
                popLabel.setForeground(Color.WHITE);
                popLabel.setBackground(new Color(58, 23, 0));
                popLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                CustomerMainFrame.this.setCursor(Cursor.DEFAULT_CURSOR);
                popLabel.setForeground(Color.LIGHT_GRAY);
                popLabel.setBackground(new Color(80, 26, 0));
                popLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
            }
        });
        westPanel.add(popLabel);

        JLabel cantoneseLabel = new JLabel("粤菜");
        cantoneseLabel.setBounds(0, 550, 200, 50);
        cantoneseLabel.setBackground(new Color(31, 59, 92));
        cantoneseLabel.setFont(new Font("宋体", Font.BOLD, 20));
        cantoneseLabel.setForeground(Color.GRAY);
        cantoneseLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cantoneseLabel.setOpaque(true);
        cantoneseLabel.setBorder(null);
        cantoneseLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                CustomerMainFrame.this.setCursor(Cursor.HAND_CURSOR);
                cantoneseLabel.setForeground(Color.WHITE);
                cantoneseLabel.setBackground(new Color(30, 34, 66));
                cantoneseLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                CustomerMainFrame.this.setCursor(Cursor.DEFAULT_CURSOR);
                cantoneseLabel.setForeground(Color.GRAY);
                cantoneseLabel.setBackground(new Color(31, 59, 92));
                cantoneseLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
            }
        });
        westPanel.add(cantoneseLabel);

        JLabel xiangLabel = new JLabel("湘菜");
        xiangLabel.setBounds(0, 600, 200, 50);
        xiangLabel.setBackground(new Color(31, 73, 92));
        xiangLabel.setFont(new Font("宋体", Font.BOLD, 20));
        xiangLabel.setForeground(Color.GRAY);
        xiangLabel.setOpaque(true);
        xiangLabel.setHorizontalAlignment(SwingConstants.CENTER);
        xiangLabel.setBorder(null);
        xiangLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                CustomerMainFrame.this.setCursor(Cursor.HAND_CURSOR);
                xiangLabel.setForeground(Color.WHITE);
                xiangLabel.setBackground(new Color(22, 46, 62));
                xiangLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                CustomerMainFrame.this.setCursor(Cursor.DEFAULT_CURSOR);
                xiangLabel.setForeground(Color.GRAY);
                xiangLabel.setBackground(new Color(31, 73, 92));
                xiangLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
            }
        });
        westPanel.add(xiangLabel);

        JLabel dessertLabel = new JLabel("甜品");
        dessertLabel.setBounds(0, 650, 200, 50);
        dessertLabel.setBackground(new Color(31, 90, 92));
        dessertLabel.setFont(new Font("宋体", Font.BOLD, 20));
        dessertLabel.setForeground(Color.GRAY);
        dessertLabel.setOpaque(true);
        dessertLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dessertLabel.setBorder(null);
        dessertLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                CustomerMainFrame.this.setCursor(Cursor.HAND_CURSOR);
                dessertLabel.setForeground(Color.WHITE);
                dessertLabel.setBackground(new Color(23, 54, 56));
                dessertLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                CustomerMainFrame.this.setCursor(Cursor.DEFAULT_CURSOR);
                dessertLabel.setForeground(Color.GRAY);
                dessertLabel.setBackground(new Color(31, 90, 92));
                dessertLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
            }
        });
        westPanel.add(dessertLabel);

        JLabel cartLabel = new JLabel("购物车");
        cartLabel.setBounds(0, 700, 200, 50);
        cartLabel.setBackground(new Color(32, 45, 69));
        cartLabel.setFont(new Font("宋体", Font.BOLD, 20));
        cartLabel.setForeground(Color.GRAY);
        cartLabel.setOpaque(true);
        cartLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cartLabel.setBorder(null);
        cartLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                CustomerMainFrame.this.setCursor(Cursor.HAND_CURSOR);
                cartLabel.setForeground(Color.WHITE);
                cartLabel.setBackground(new Color(17, 27, 41));
                cartLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                CustomerMainFrame.this.setCursor(Cursor.DEFAULT_CURSOR);
                cartLabel.setForeground(Color.GRAY);
                cartLabel.setBackground(new Color(32, 45, 69));
                cartLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
            }
        });
        westPanel.add(cartLabel);


        JLabel quitLabel = new JLabel("退出");
        quitLabel.setBounds(0, 750, 100, 50);
        quitLabel.setHorizontalAlignment(SwingConstants.CENTER);
        quitLabel.setBackground(new Color(71, 72, 71));
        quitLabel.setFont(new Font("宋体", Font.BOLD, 15));
        quitLabel.setForeground(Color.GRAY);
        quitLabel.setBorder(null);
        quitLabel.setOpaque(true);
        quitLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                CustomerMainFrame.this.setCursor(Cursor.HAND_CURSOR);
                quitLabel.setForeground(Color.WHITE);
                quitLabel.setBackground(new Color(46, 47, 46));
                quitLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                CustomerMainFrame.this.setCursor(Cursor.DEFAULT_CURSOR);
                quitLabel.setForeground(Color.GRAY);
                quitLabel.setBackground(new Color(71, 72, 71));
                quitLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (JOptionPane.showConfirmDialog(CustomerMainFrame.this, "确定要退出吗?", null, JOptionPane.WARNING_MESSAGE) == 0) {
                    CustomerMainFrame.this.dispose();
                }
            }
        });

        westPanel.add(quitLabel);

        JLabel confirmLabel = new JLabel("确定\n订单");
        confirmLabel.setBounds(100, 750, 100, 50);
        confirmLabel.setBackground(new Color(16, 36, 57));
        confirmLabel.setFont(new Font("宋体", Font.BOLD, 15));
        confirmLabel.setForeground(Color.GRAY);
        confirmLabel.setHorizontalAlignment(SwingConstants.CENTER);
        confirmLabel.setOpaque(true);
        confirmLabel.setBorder(null);
        confirmLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                CustomerMainFrame.this.setCursor(Cursor.HAND_CURSOR);
                confirmLabel.setForeground(Color.WHITE);
                confirmLabel.setBackground(new Color(14, 22, 44));
                confirmLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                CustomerMainFrame.this.setCursor(Cursor.DEFAULT_CURSOR);
                confirmLabel.setForeground(Color.GRAY);
                confirmLabel.setBackground(new Color(16, 36, 57));
                confirmLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
            }
        });
        westPanel.add(confirmLabel);


        JLabel logoLabel = new JLabel(new ImageIcon("image/logo.png"));
        logoLabel.grabFocus();
        logoLabel.setBounds(20, 20, 160, 160);
        westPanel.add(logoLabel);

        JPanel northPanel = new JPanel();
        northPanel.setLayout(null);
        northPanel.setBounds(200, 0, 500, 100);
        northPanel.setBackground(new Color(20, 28, 34));
        contentPanel.add(northPanel);

        JTextField searchText = new JTextField();
        searchText.setBounds(50, 30, 350, 40);
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
        northPanel.add(searchText);

        JLabel searchLogoLabel = new JLabel(new ImageIcon("image/search.png"));
        searchLogoLabel.setBounds(420, 30, 40, 40);
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
        northPanel.add(searchLogoLabel);


        //获取所有菜式
        allFoodList = jdbcImpl.getAllFood();


        scrollPanelProcess();

        this.setVisible(true);
    }

    private void scrollPanelProcess() {


        JPanel panelUnderScroll = new JPanel();
        panelUnderScroll.setBounds(200, 95, 500, 705);

//        JPanel test=new JPanel(){
//            public void paintComponent(Graphics g)
//            {
//                Graphics2D g2d=(Graphics2D)g;
//                int red=(int)(Math.random()*255);
//                int blue=(int)(Math.random()*255);
//                int green=(int)(Math.random()*255);
//                Color startColor=new Color(red,green,blue);
//                red=(int)(Math.random()*255);
//                blue=(int)(Math.random()*255);
//                green=(int)(Math.random()*255);
//                Color endColor=new Color(red,green,blue);
//                GradientPaint gradient=new GradientPaint(70,70,startColor,100,100,endColor);
//                g2d.setPaint(gradient);
//                g2d.drawRect(0,0,100,1000);
//            }
//        };
//        test.setPreferredSize(new Dimension(100,1000));
//        test.setBounds(20,20,100,1000);
//        test.setBackground(Color.BLACK);

        JPanel contentPanelForScroll = new JPanel();
        contentPanelForScroll.setPreferredSize(new Dimension(500, 1200));
        contentPanelForScroll.setBackground(new Color(26, 36, 43));
        contentPanelForScroll.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));
        int foodCount = allFoodList.size();
        for (int i = 0; i < 8; i++) {
            JPanel foodPanel = new JPanel();
            foodPanel.setPreferredSize(new Dimension(479, 100));
            foodPanel.setBackground((i % 2 == 0) ? new Color(38, 48, 56) : new Color(30, 42, 43));
            foodPanel.setLayout(null);

            //图片
            ImageIcon imageIcon = new ImageIcon("dishImg/剁椒鱼头.jpg");
            JLabel imageLabel = new JLabel();
            imageLabel.setIcon(imageIcon);
            imageLabel.setOpaque(true);
            imageLabel.setBounds(0, 0, 150, 100);
            foodPanel.add(imageLabel);

            //名称
            JLabel nameLabel = new JLabel("剁椒鱼头");
            nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
            nameLabel.setFont(new Font("楷体", Font.PLAIN, 20));
            nameLabel.setForeground(Color.LIGHT_GRAY);
            nameLabel.setBounds(160, 0, 90, 100);
            foodPanel.add(nameLabel);

            //价格
            JLabel priceLabel = new JLabel("35元");
            priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
            priceLabel.setFont(new Font("楷体", Font.PLAIN, 20));
            priceLabel.setForeground(Color.LIGHT_GRAY);
            priceLabel.setBounds(250, 0, 90, 100);
            foodPanel.add(priceLabel);


            //数量
            JLabel quantityLabel = new JLabel("数量:1");
            quantityLabel.setHorizontalAlignment(SwingConstants.CENTER);
            quantityLabel.setFont(new Font("楷体", Font.PLAIN, 20));
            quantityLabel.setForeground(Color.LIGHT_GRAY);
            quantityLabel.setBounds(330, 0, 90, 100);
            foodPanel.add(quantityLabel);

            //spinner
//            JSpinner jSpinner = new JSpinner();
//            jSpinner.setBounds(420, 0, 60, 100);
//            foodPanel.add(jSpinner);
            Spinner spinner=new Spinner();
            spinner.setBounds(300,0,60,100);
            spinner.setLabelText("数量");
            System.out.println(spinner.getEditor().getComponentCount());
//            spinner.getEditor().getComponent(0).setBackground(Color.green);
            foodPanel.add(spinner);
            contentPanelForScroll.add(foodPanel);
        }

        JScrollPane jScrollPane = new JScrollPane(contentPanelForScroll);
        jScrollPane.setPreferredSize(new Dimension(500, 700));
        jScrollPane.setBounds(200, 95, 500, 705);
        jScrollPane.setBackground(new Color(26, 36, 43));
        jScrollPane.getHorizontalScrollBar().setOpaque(false);
        jScrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jScrollPane.remove(jScrollPane.getVerticalScrollBar());
        jScrollPane.remove(jScrollPane.getHorizontalScrollBar());

        panelUnderScroll.add(jScrollPane);
        contentPanel.add(panelUnderScroll);


    }

    // 为了实现窗口拖拽
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


    //创建线程可执行目标
    class MyThreadRunnable implements Runnable {
        private SimpleDateFormat timeFormat_local;
        private JLabel timeLabel_local;
        public MyThreadRunnable(SimpleDateFormat timeFormat,JLabel timeLabel) {
            timeFormat_local=timeFormat;
            timeLabel_local=timeLabel;
        }

        @Override
        public void run() {
            while (true) {
                String time;
                time = timeFormat_local.format(Calendar.getInstance().getTime());
                timeLabel_local.setText(time);
                System.out.println(time);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }



}
