package cn.edu.fzu.sm.wuweida.frame;

import cn.edu.fzu.sm.wuweida.bean.Food;
import cn.edu.fzu.sm.wuweida.dao.JdbcImpl;
import cn.edu.fzu.sm.wuweida.util.ScrollBarCustom;
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


//        westPanel.add(timeLabel);

        JLabel popLabel = new JLabel("热销品");
//        popLabel.setBounds(0, 450, 200, 100);
//        popLabel.setSize(225,100);
        popLabel.setPreferredSize(new Dimension(225, 50));
        popLabel.setHorizontalAlignment(SwingConstants.CENTER);
        popLabel.setBackground(new Color(4, 15, 16));
        popLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
        popLabel.setForeground(Color.LIGHT_GRAY);
//        popLabel.setOpaque(true);
        popLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                CustomerMainFrame.this.setCursor(Cursor.HAND_CURSOR);
                popLabel.setForeground(Color.WHITE);
//                popLabel.setBackground(new Color(58, 23, 0));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                CustomerMainFrame.this.setCursor(Cursor.DEFAULT_CURSOR);
                popLabel.setForeground(Color.LIGHT_GRAY);
//                popLabel.setBackground(new Color(80, 26, 0));
            }
        });
        westPanel.add(popLabel);

        JLabel cantoneseLabel = new JLabel("粤菜");
//        cantoneseLabel.setBounds(0, 550, 200, 50);
//        cantoneseLabel.setSize(200,50);
        cantoneseLabel.setPreferredSize(new Dimension(225, 45));
        cantoneseLabel.setBackground(new Color(4, 15, 16));
        cantoneseLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
        cantoneseLabel.setForeground(Color.GRAY);
        cantoneseLabel.setHorizontalAlignment(SwingConstants.CENTER);
//        cantoneseLabel.setOpaque(true);
        cantoneseLabel.setBorder(null);
        cantoneseLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                CustomerMainFrame.this.setCursor(Cursor.HAND_CURSOR);
                cantoneseLabel.setForeground(Color.WHITE);
//                cantoneseLabel.setBackground(new Color(12, 24, 12));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                CustomerMainFrame.this.setCursor(Cursor.DEFAULT_CURSOR);
                cantoneseLabel.setForeground(Color.GRAY);
//                cantoneseLabel.setBackground(new Color(20, 47, 20));
            }
        });
        westPanel.add(cantoneseLabel);

        JLabel xiangLabel = new JLabel("湘菜");
//        xiangLabel.setBounds(0, 600, 200, 50);
//        xiangLabel.setSize(200,50);
        xiangLabel.setPreferredSize(new Dimension(225, 45));
        xiangLabel.setBackground(new Color(4, 15, 16));
        xiangLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
        xiangLabel.setForeground(Color.GRAY);
//        xiangLabel.setOpaque(true);
        xiangLabel.setHorizontalAlignment(SwingConstants.CENTER);
        xiangLabel.setBorder(null);
        xiangLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                CustomerMainFrame.this.setCursor(Cursor.HAND_CURSOR);
                xiangLabel.setForeground(Color.WHITE);
//                xiangLabel.setBackground(new Color(17, 34, 17));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                CustomerMainFrame.this.setCursor(Cursor.DEFAULT_CURSOR);
                xiangLabel.setForeground(Color.GRAY);
//                xiangLabel.setBackground(new Color(20, 44, 20));
            }
        });
        westPanel.add(xiangLabel);

        JLabel dessertLabel = new JLabel("甜品");
//        dessertLabel.setBounds(0, 650, 200, 50);
//        dessertLabel.setSize(200,50);
        dessertLabel.setPreferredSize(new Dimension(225, 45));
        dessertLabel.setBackground(new Color(4, 15, 16));
        dessertLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
        dessertLabel.setForeground(Color.GRAY);
//        dessertLabel.setOpaque(true);
        dessertLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dessertLabel.setBorder(null);
        dessertLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                CustomerMainFrame.this.setCursor(Cursor.HAND_CURSOR);
                dessertLabel.setForeground(Color.WHITE);
//                dessertLabel.setBackground(new Color(23, 54, 56));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                CustomerMainFrame.this.setCursor(Cursor.DEFAULT_CURSOR);
                dessertLabel.setForeground(Color.GRAY);
//                dessertLabel.setBackground(new Color(31, 90, 92));
            }
        });
        westPanel.add(dessertLabel);


        //菜式选择监听
        popLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                foodList = jdbcImpl.getFoodList("pop");
                contentPanel.remove(2);
                scrollPanelProcess();
            }
        });
        cantoneseLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                foodList = jdbcImpl.getFoodList("粤菜");
                contentPanel.remove(2);
                scrollPanelProcess();
            }
        });
        xiangLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                foodList = jdbcImpl.getFoodList("湘菜");
                contentPanel.remove(2);
                scrollPanelProcess();
            }
        });
        dessertLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                foodList = jdbcImpl.getFoodList("甜品");
                contentPanel.remove(2);
                scrollPanelProcess();
            }
        });


        JLabel cartLabel = new JLabel("购物车");
//        cartLabel.setBounds(0, 700, 200, 50);
//        cartLabel.setBackground(new Color(4, 15, 16));
        cartLabel.setPreferredSize(new Dimension(225, 50));
        cartLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
        cartLabel.setForeground(Color.GRAY);
//        cartLabel.setOpaque(true);
        cartLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cartLabel.setBorder(null);
        cartLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                CustomerMainFrame.this.setCursor(Cursor.HAND_CURSOR);
                cartLabel.setForeground(Color.WHITE);
//                cartLabel.setBackground(new Color(17, 27, 41));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                CustomerMainFrame.this.setCursor(Cursor.DEFAULT_CURSOR);
                cartLabel.setForeground(Color.GRAY);
//                cartLabel.setBackground(new Color(32, 45, 69));
            }
        });
        westPanel.add(cartLabel);


        JLabel quitLabel = new JLabel("退出");
//        quitLabel.setBounds(0, 750, 100, 50);
        quitLabel.setPreferredSize(new Dimension(225, 45));
        quitLabel.setHorizontalAlignment(SwingConstants.CENTER);
        quitLabel.setBackground(new Color(71, 72, 71));
        quitLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
        quitLabel.setForeground(Color.GRAY);
        quitLabel.setBorder(null);
//        quitLabel.setOpaque(true);
        quitLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                CustomerMainFrame.this.setCursor(Cursor.HAND_CURSOR);
                quitLabel.setForeground(Color.WHITE);
                quitLabel.setBackground(new Color(46, 47, 46));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                CustomerMainFrame.this.setCursor(Cursor.DEFAULT_CURSOR);
                quitLabel.setForeground(Color.GRAY);
                quitLabel.setBackground(new Color(71, 72, 71));
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
//        confirmLabel.setBounds(100, 750, 100, 50);
        confirmLabel.setPreferredSize(new Dimension(225, 45));
        confirmLabel.setBackground(new Color(16, 36, 57));
        confirmLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
        confirmLabel.setForeground(Color.GRAY);
        confirmLabel.setHorizontalAlignment(SwingConstants.CENTER);
//        confirmLabel.setOpaque(true);
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


        JPanel statusPanel = new JPanel();
        statusPanel.setBounds(0, 720 - 20 - 10 - 10, 225, 20 + 10 + 10);
        statusPanel.setBackground(new Color(18, 44, 18));
        JLabel statusLabel = new JLabel();
        statusLabel.setIcon(new ImageIcon("image/open.png"));
        statusLabel.setBounds(200, 0, 25, 25);
        statusPanel.add(statusLabel);
        statusPanel.setToolTipText("正在营业");
        contentPanel.add(statusPanel);


        JLabel logoLabel = new JLabel(new ImageIcon("image/minilogo.png"));
        logoLabel.setBounds(5, 7, 30, 30);

        JLabel nameLabel = new JLabel("粤湘之家");
        nameLabel.setBounds(45, 0, 80, 44);
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));

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


        JPanel northPanel = new JPanel();
//        northPanel.setLayout(new BorderLayout());
        northPanel.setLayout(null);
        northPanel.setBounds(0, 0, 1270, 45);
        northPanel.setBorder(new MatteBorder(0, 0, 1, 0, Color.GRAY));
        northPanel.setBackground(new Color(20, 28, 34));
        northPanel.add(logoLabel);
        northPanel.add(nameLabel);
        northPanel.add(timeLabel);
        northPanel.add(cancelLabel);
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
//        northPanel.add(searchText);

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
//        northPanel.add(searchLogoLabel);


        scrollPanelProcess();

        this.setVisible(true);
    }


    private void scrollPanelProcess() {


        JPanel panelUnderScroll = new JPanel();
        panelUnderScroll.setBounds(225, 40, 1045, 720 - 45 + 5 + 1);

        JPanel contentPanelForScroll = new JPanel();
        contentPanelForScroll.setPreferredSize(new Dimension(1045, 720 - 45 + 500));
        contentPanelForScroll.setBackground(new Color(26, 36, 43));
        contentPanelForScroll.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));
        int foodCount = foodList.size();
        for (int i = 0; i < foodCount; i++) {
            JPanel foodPanel = new JPanel();
            foodPanel.setPreferredSize(new Dimension(479, 100));
//            foodPanel.setBackground((i % 2 == 0) ? new Color(38, 48, 56) : new Color(30, 42, 43));
            foodPanel.setBackground(new Color(26, 36, 43));
            foodPanel.setLayout(null);

            //图片
            ImageIcon imageIcon = new ImageIcon("dishImg/" + foodList.get(i).getFoodName() + ".jpg");
            JLabel imageLabel = new JLabel();
            imageLabel.setIcon(imageIcon);
            imageLabel.setOpaque(true);
            imageLabel.setBounds(0, 0, 150, 100);
            foodPanel.add(imageLabel);

            //名称
            JLabel nameLabel = new JLabel(foodList.get(i).getFoodName());
            nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
            nameLabel.setFont(new Font("楷体", Font.PLAIN, 20));
            nameLabel.setForeground(Color.LIGHT_GRAY);
            nameLabel.setBounds(160, 0, 90, 100);
            foodPanel.add(nameLabel);

            //价格
            JLabel priceLabel = new JLabel(foodList.get(i).getFoodPrice() + "");
            priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
            priceLabel.setFont(new Font("楷体", Font.PLAIN, 20));
            priceLabel.setForeground(Color.LIGHT_GRAY);
            priceLabel.setBounds(250, 0, 90, 100);
            foodPanel.add(priceLabel);


            //spinner
            Spinner spinner = new Spinner();
            SpinnerNumberModel spinnerNumberModel = new SpinnerNumberModel();
            spinnerNumberModel.setMinimum(0);
            spinner.setModel(spinnerNumberModel);
            spinner.setBounds(300, 0, 100, 100);
            spinner.setLabelText("数量");
            foodPanel.add(spinner);
            contentPanelForScroll.add(foodPanel);
        }

        JScrollPane scrollPanel = new JScrollPane(contentPanelForScroll);
        ScrollBarCustom scrollBarCustom = new ScrollBarCustom();
        scrollBarCustom.setOrientation(Adjustable.VERTICAL);
        scrollPanel.setVerticalScrollBar(scrollBarCustom);
        scrollPanel.setPreferredSize(new Dimension(1045, 720 - 45 + 5 + 1));
        scrollPanel.setBounds(0, 0, 1045, 720 - 45 + 5 + 1);
        scrollPanel.setBackground(new Color(26, 36, 43));
        scrollPanel.getHorizontalScrollBar().setOpaque(false);
        scrollPanel.setBorder(null);
//        scrollPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        scrollPanel.remove(scrollPanel.getVerticalScrollBar());
        scrollPanel.remove(scrollPanel.getHorizontalScrollBar());

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
//                if(Calendar.getInstance().getTime().getDay()==6){
                if (Calendar.getInstance().getTime().getSeconds() %2 ==0) {
                    statusPanel.setToolTipText("已打烊");
                    statusLabel.setIcon(new ImageIcon("image/closed.png"));
                    statusPanel.setBackground(new Color(101, 39,0));
                } else {
                    statusPanel.setToolTipText("营业中");
                    statusLabel.setIcon(new ImageIcon("image/open.png"));
                    statusPanel.setBackground(new Color(18, 44, 18));
                }
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
