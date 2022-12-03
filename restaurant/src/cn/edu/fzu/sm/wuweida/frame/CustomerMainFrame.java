package cn.edu.fzu.sm.wuweida.frame;

import cn.edu.fzu.sm.wuweida.bean.Food;
import cn.edu.fzu.sm.wuweida.dao.JdbcImpl;
import cn.edu.fzu.sm.wuweida.util.ModernScrollBarUI;
import cn.edu.fzu.sm.wuweida.util.Spinner;

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
    private List<Food> foodList = new ArrayList<>();
    private JPanel contentPanel;

    public CustomerMainFrame() throws HeadlessException {
        this.setUndecorated(true);
        this.setSize(1270, 720);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setIconImage(new ImageIcon("image/logo.png").getImage());
        this.setBackground(new Color(26, 36, 43));

        foodList = jdbcImpl.getFoodList("pop");

        contentPanel = (JPanel) this.getContentPane();

        MoveListener moveListener = new MoveListener();
        contentPanel.addMouseListener(moveListener);
        contentPanel.addMouseMotionListener(moveListener);


        //西部面板
        JPanel westPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(37, 37, 37));
                g.drawLine(20, 190, 205, 190);
            }
        };
        westPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
        westPanel.setBounds(0, 45, 225, 675 - 20 - 10 - 10);
        westPanel.setBorder(new MatteBorder(1, 0, 0, 1, new Color(4, 15, 16)));
        westPanel.setBackground(new Color(4, 15, 16));
        contentPanel.add(westPanel);



        //西部面板元素
        //热销品标签
        JLabel popLabel = new JLabel("热销品");
        popLabel.setPreferredSize(new Dimension(225, 50));
        popLabel.setHorizontalAlignment(SwingConstants.CENTER);
        popLabel.setBackground(new Color(4, 15, 16));
        popLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
        popLabel.setForeground(Color.LIGHT_GRAY);
        popLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                CustomerMainFrame.this.setCursor(Cursor.HAND_CURSOR);
                popLabel.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                CustomerMainFrame.this.setCursor(Cursor.DEFAULT_CURSOR);
                popLabel.setForeground(Color.LIGHT_GRAY);
            }
        });
        westPanel.add(popLabel);

        //粤菜标签
        JLabel cantoneseLabel = new JLabel("粤菜");
        cantoneseLabel.setPreferredSize(new Dimension(225, 45));
        cantoneseLabel.setBackground(new Color(4, 15, 16));
        cantoneseLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
        cantoneseLabel.setForeground(Color.GRAY);
        cantoneseLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cantoneseLabel.setBorder(null);
        cantoneseLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                CustomerMainFrame.this.setCursor(Cursor.HAND_CURSOR);
                cantoneseLabel.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                CustomerMainFrame.this.setCursor(Cursor.DEFAULT_CURSOR);
                cantoneseLabel.setForeground(Color.GRAY);
            }
        });
        westPanel.add(cantoneseLabel);


        //湘菜标签
        JLabel xiangLabel = new JLabel("湘菜");
        xiangLabel.setPreferredSize(new Dimension(225, 45));
        xiangLabel.setBackground(new Color(4, 15, 16));
        xiangLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
        xiangLabel.setForeground(Color.GRAY);
        xiangLabel.setHorizontalAlignment(SwingConstants.CENTER);
        xiangLabel.setBorder(null);
        xiangLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                CustomerMainFrame.this.setCursor(Cursor.HAND_CURSOR);
                xiangLabel.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                CustomerMainFrame.this.setCursor(Cursor.DEFAULT_CURSOR);
                xiangLabel.setForeground(Color.GRAY);
            }
        });
        westPanel.add(xiangLabel);

        //甜品标签
        JLabel dessertLabel = new JLabel("甜品");
        dessertLabel.setPreferredSize(new Dimension(225, 45));
        dessertLabel.setBackground(new Color(4, 15, 16));
        dessertLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
        dessertLabel.setForeground(Color.GRAY);
        dessertLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dessertLabel.setBorder(null);
        dessertLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                CustomerMainFrame.this.setCursor(Cursor.HAND_CURSOR);
                dessertLabel.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                CustomerMainFrame.this.setCursor(Cursor.DEFAULT_CURSOR);
                dessertLabel.setForeground(Color.GRAY);
            }
        });
        westPanel.add(dessertLabel);


        //监听标签点击(菜单切换)
        popLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                foodList = jdbcImpl.getFoodList("pop");
                contentPanel.remove(3);//第四个面板是滚动面板下的面板
                scrollPanelProcess();
            }
        });
        cantoneseLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                foodList = jdbcImpl.getFoodList("粤菜");
                contentPanel.remove(3);
                scrollPanelProcess();
            }
        });
        xiangLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                foodList = jdbcImpl.getFoodList("湘菜");
                contentPanel.remove(3);
                scrollPanelProcess();
            }
        });
        dessertLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                foodList = jdbcImpl.getFoodList("甜品");
                contentPanel.remove(3);
                scrollPanelProcess();
            }
        });

        //购物车标签
        JLabel cartLabel = new JLabel("购物车");
        cartLabel.setPreferredSize(new Dimension(225, 50));
        cartLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
        cartLabel.setForeground(Color.GRAY);
        cartLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cartLabel.setBorder(null);
        cartLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                CustomerMainFrame.this.setCursor(Cursor.HAND_CURSOR);
                cartLabel.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                CustomerMainFrame.this.setCursor(Cursor.DEFAULT_CURSOR);
                cartLabel.setForeground(Color.GRAY);
            }
        });
        westPanel.add(cartLabel);


        //确定标签
        JLabel confirmLabel = new JLabel("确定\n订单");
        confirmLabel.setPreferredSize(new Dimension(225, 45));
        confirmLabel.setBackground(new Color(16, 36, 57));
        confirmLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
        confirmLabel.setForeground(Color.GRAY);
        confirmLabel.setHorizontalAlignment(SwingConstants.CENTER);
        confirmLabel.setBorder(null);
        confirmLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                CustomerMainFrame.this.setCursor(Cursor.HAND_CURSOR);
                confirmLabel.setForeground(Color.WHITE);
                confirmLabel.setBackground(new Color(14, 22, 44));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                CustomerMainFrame.this.setCursor(Cursor.DEFAULT_CURSOR);
                confirmLabel.setForeground(Color.GRAY);
                confirmLabel.setBackground(new Color(16, 36, 57));
            }
        });
        westPanel.add(confirmLabel);


        //餐厅营业状态显示
        JPanel statusPanel = new JPanel();
        statusPanel.setBounds(0, 720 - 20 - 10 - 10, 225, 20 + 10 + 10);
        statusPanel.setBackground(new Color(18, 44, 18));
        JLabel statusLabel = new JLabel();
        statusLabel.setIcon(new ImageIcon("image/open.png"));
        statusLabel.setBounds(200, 0, 25, 25);
        statusPanel.add(statusLabel);
        statusPanel.setToolTipText("正在营业");
        contentPanel.add(statusPanel);


        //北部面板元素
        //小logo
        JLabel logoLabel = new JLabel(new ImageIcon("image/minilogo.png"));
        logoLabel.setBounds(5, 7, 30, 30);
        //餐厅名称显示
        JLabel nameLabel = new JLabel("粤湘之家");
        nameLabel.setBounds(45, 0, 80, 44);
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));

        //事件显示
        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setForeground(new Color(157, 157, 157));
        timeLabel.setBounds(1270 / 2 - 100, 0, 200, 45);
        //报时线程
        MyThreadRunnable target = new MyThreadRunnable(timeFormat, timeLabel, statusPanel);
        Thread setTimeThread = new Thread(target);
        setTimeThread.start();

        //右上角退出键
        JLabel cancelLabel = new JLabel("╳");
        cancelLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cancelLabel.setVerticalAlignment(SwingConstants.CENTER);
        cancelLabel.setForeground(Color.GRAY);
        cancelLabel.setBounds(1270 - 50, 8, 50, 45 - 5 - 10 - 1);
        cancelLabel.setOpaque(true);
        cancelLabel.setBackground(new Color(20, 28, 34));
        cancelLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                CustomerMainFrame.this.dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                CustomerMainFrame.this.setCursor(Cursor.HAND_CURSOR);
                cancelLabel.setBackground(new Color(133, 37, 0));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                CustomerMainFrame.this.setCursor(Cursor.DEFAULT_CURSOR);
                cancelLabel.setBackground(new Color(20, 28, 34));
            }
        });




        //北部面板
        JPanel northPanel = new JPanel();
        northPanel.setLayout(null);
        northPanel.setBounds(0, 0, 1270, 45);
        northPanel.setBorder(new MatteBorder(0, 0, 1, 0, new Color(39, 39, 39)));
        northPanel.setBackground(new Color(20, 28, 34));
        northPanel.add(logoLabel);
        northPanel.add(nameLabel);
        northPanel.add(timeLabel);
        northPanel.add(cancelLabel);
        contentPanel.add(northPanel);


        scrollPanelProcess();

        this.setVisible(true);
    }


    private void scrollPanelProcess() {


        //滚动面板下的基础面板
        JPanel panelUnderScroll = new JPanel();
        panelUnderScroll.setBounds(225, 40, 1045, 720 - 45 + 5 + 1);

        //滚动面版的内容面板
        JPanel contentPanelForScroll = new JPanel();
        contentPanelForScroll.setPreferredSize(new Dimension(1045, 720 - 45 + 500));
        contentPanelForScroll.setBackground(new Color(26, 36, 43));
        contentPanelForScroll.setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
        int foodCount = foodList.size();
        for (int i = 0; i < foodCount; i++) {

            //内容面板里 每个菜品所属的元面板
            JPanel foodPanel = new JPanel();
            foodPanel.setPreferredSize(new Dimension(1270-225, 100));
            foodPanel.setBackground(new Color(26, 36, 43));
            foodPanel.setBorder(new MatteBorder(0,0,1,0,new Color(134, 134, 134)));
            foodPanel.setLayout(null);

            //菜式图片
            ImageIcon imageIcon = new ImageIcon("dishImg/" + foodList.get(i).getFoodName() + ".jpg");
            JLabel imageLabel = new JLabel();
            imageLabel.setIcon(imageIcon);
            imageLabel.setOpaque(true);
            imageLabel.setBounds(120, 25/2, 100, 75);
            foodPanel.add(imageLabel);

            //菜式名称
            JLabel nameLabel = new JLabel(foodList.get(i).getFoodName());
            nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
            nameLabel.setFont(new Font("楷体", Font.PLAIN, 20));
            nameLabel.setForeground(Color.LIGHT_GRAY);
            nameLabel.setBounds(300, 0, 90, 100);
            foodPanel.add(nameLabel);

            //菜式价格
            JLabel priceLabel = new JLabel(foodList.get(i).getFoodPrice() + "人民币");
            priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
            priceLabel.setFont(new Font("楷体", Font.PLAIN, 15));
            priceLabel.setForeground(Color.LIGHT_GRAY);
            priceLabel.setBounds(500, 0, 90, 100);
            foodPanel.add(priceLabel);


            //数量选择器
            Spinner spinner = new Spinner();
            SpinnerNumberModel spinnerNumberModel = new SpinnerNumberModel();
            spinnerNumberModel.setMinimum(0);
            spinner.setModel(spinnerNumberModel);
            spinner.setBounds(225+400+100+100, 25, 100, 50);
            spinner.setLabelText("数量");
            foodPanel.add(spinner);
            foodPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);
                    foodPanel.setBackground(new Color(39, 53, 64));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    super.mouseExited(e);
                    foodPanel.setBackground(new Color(26, 36, 43));
                }
            });
            contentPanelForScroll.add(foodPanel);
        }


        //滚动面板
        JScrollPane scrollPanel = new JScrollPane(contentPanelForScroll);
        JScrollBar customScrollBar=new JScrollBar();
        customScrollBar.setUI(new ModernScrollBarUI());
        customScrollBar.setPreferredSize(new Dimension(8,8));
        customScrollBar.setForeground(new Color(26, 36, 43));
        customScrollBar.setBackground(new Color(14, 25, 32));
        customScrollBar.setOrientation(Adjustable.VERTICAL);
        scrollPanel.setVerticalScrollBar(customScrollBar);
        scrollPanel.setPreferredSize(new Dimension(1045, 720 - 45 + 5 + 1));
        scrollPanel.setBounds(0, 0+5, 1045, 720 - 45 + 5 + 1);
        scrollPanel.setBackground(new Color(26, 36, 43));
        scrollPanel.getHorizontalScrollBar().setOpaque(false);
        scrollPanel.setBorder(null);
        scrollPanel.remove(scrollPanel.getHorizontalScrollBar());
        scrollPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                JScrollPane theScroll = (JScrollPane) (e.getSource());
                theScroll.getVerticalScrollBar().setForeground(new Color(36, 72, 38));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                JScrollPane theScroll = (JScrollPane) (e.getSource());
                theScroll.getVerticalScrollBar().setForeground(new Color(26,36,43));
            }
        });


        panelUnderScroll.add(scrollPanel);
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
        private JPanel statusPanel;

        public MyThreadRunnable(SimpleDateFormat timeFormat, JLabel timeLabel, JPanel statusPanel) {
            timeFormat_local = timeFormat;
            timeLabel_local = timeLabel;
            this.statusPanel = statusPanel;
        }

        @Override
        public void run() {
            while (true) {
                String time;
                time = timeFormat_local.format(Calendar.getInstance().getTime());
                timeLabel_local.setText(time);
                JLabel statusLabel = (JLabel) statusPanel.getComponent(0);
                System.out.println(time);
//                if(Calendar.getInstance().getTime().getDay()==6){
                if (Calendar.getInstance().getTime().getSeconds() % 2 == 0) {
                    statusPanel.setToolTipText("已打烊");
                    statusLabel.setIcon(new ImageIcon("image/closed.png"));
                    statusPanel.setBackground(new Color(101, 39, 0));
                } else {
                    statusPanel.setToolTipText("营业中");
                    statusLabel.setIcon(new ImageIcon("image/open.png"));
                    statusPanel.setBackground(new Color(18, 44, 18));
                }
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
