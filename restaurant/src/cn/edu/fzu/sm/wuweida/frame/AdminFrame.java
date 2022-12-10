package cn.edu.fzu.sm.wuweida.frame;

import cn.edu.fzu.sm.wuweida.bean.Food;
import cn.edu.fzu.sm.wuweida.dao.JdbcImpl;
import cn.edu.fzu.sm.wuweida.util.Spinner;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;


public class AdminFrame extends JFrame {

    private List<Food> foodList;
    private JdbcImpl jdbc=new JdbcImpl();
    private JPanel contentPanel;


    public AdminFrame() throws HeadlessException {
        this.setUndecorated(true);
        this.setSize(500,600);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setIconImage(new ImageIcon("image/admin.png").getImage());
        this.setBackground(new Color(26,36,43));

        //动态菜品列表
        foodList=jdbc.getFoodList("pop");

        //获取此frame的内容面板
        contentPanel=(JPanel)this.getContentPane();
        MoveListener moveListener=new MoveListener();
        contentPanel.addMouseListener(moveListener);
        contentPanel.addMouseMotionListener(moveListener);

        //北部面板
        JPanel northPanel=new JPanel();
        northPanel.setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
        northPanel.setBounds(0,0,500,50);
        northPanel.setBorder(new MatteBorder(0,0,1,0,Color.BLACK));
        contentPanel.add(northPanel);



        //北部面板元素
        //热销品标签
        JLabel popLabel = new JLabel("热销品");
        popLabel.setPreferredSize(new Dimension(125, 50));
        popLabel.setHorizontalAlignment(SwingConstants.CENTER);
        popLabel.setBackground(new Color(7, 25, 27));
        popLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
        popLabel.setForeground(Color.LIGHT_GRAY);
        popLabel.setOpaque(true);
        popLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                AdminFrame.this.setCursor(Cursor.HAND_CURSOR);
                popLabel.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                AdminFrame.this.setCursor(Cursor.DEFAULT_CURSOR);
                popLabel.setForeground(Color.LIGHT_GRAY);
            }
        });
        northPanel.add(popLabel);

        //粤菜标签
        JLabel cantoneseLabel = new JLabel("粤菜");
        cantoneseLabel.setPreferredSize(new Dimension(125, 50));
        cantoneseLabel.setBackground(new Color(7, 25, 27));
        cantoneseLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
        cantoneseLabel.setForeground(Color.GRAY);
        cantoneseLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cantoneseLabel.setBorder(null);
        cantoneseLabel.setOpaque(true);
        cantoneseLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                AdminFrame.this.setCursor(Cursor.HAND_CURSOR);
                cantoneseLabel.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                AdminFrame.this.setCursor(Cursor.DEFAULT_CURSOR);
                cantoneseLabel.setForeground(Color.GRAY);
            }
        });
        northPanel.add(cantoneseLabel);

        //湘菜标签
        JLabel xiangLabel = new JLabel("湘菜");
        xiangLabel.setPreferredSize(new Dimension(125, 50));
        xiangLabel.setBackground(new Color(7, 25, 27));
        xiangLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
        xiangLabel.setForeground(Color.GRAY);
        xiangLabel.setHorizontalAlignment(SwingConstants.CENTER);
        xiangLabel.setBorder(null);
        xiangLabel.setOpaque(true);
        xiangLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                AdminFrame.this.setCursor(Cursor.HAND_CURSOR);
                xiangLabel.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                AdminFrame.this.setCursor(Cursor.DEFAULT_CURSOR);
                xiangLabel.setForeground(Color.GRAY);
            }
        });
        northPanel.add(xiangLabel);

        //甜品标签
        JLabel dessertLabel = new JLabel("甜品");
        dessertLabel.setPreferredSize(new Dimension(75, 50));
        dessertLabel.setBackground(new Color(7, 25, 27));
        dessertLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
        dessertLabel.setForeground(Color.GRAY);
        dessertLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dessertLabel.setBorder(null);
        dessertLabel.setOpaque(true);
        dessertLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                AdminFrame.this.setCursor(Cursor.HAND_CURSOR);
                dessertLabel.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                AdminFrame.this.setCursor(Cursor.DEFAULT_CURSOR);
                dessertLabel.setForeground(Color.GRAY);
            }
        });
        northPanel.add(dessertLabel);


        //右上角退出键
        JLabel closeLabel = new JLabel("╳");
        closeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        closeLabel.setVerticalAlignment(SwingConstants.CENTER);
        closeLabel.setForeground(Color.GRAY);
        closeLabel.setPreferredSize(new Dimension(50,50));
        closeLabel.setOpaque(true);
        closeLabel.setBackground(new Color(20, 28, 34));
        closeLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                AdminFrame.this.dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                AdminFrame.this.setCursor(Cursor.HAND_CURSOR);
                closeLabel.setBackground(new Color(133, 37, 0));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                AdminFrame.this.setCursor(Cursor.DEFAULT_CURSOR);
                closeLabel.setBackground(new Color(20, 28, 34));
            }
        });

        //监听标签点击(菜单切换)
        popLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                foodList = jdbc.getFoodList("pop");
                contentPanel.remove(3);//第四个面板是滚动面板下的面板
                scrollPanelProcess();
            }
        });
        cantoneseLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                foodList = jdbc.getFoodList("粤菜");
                contentPanel.remove(3);
                scrollPanelProcess();
            }
        });
        xiangLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                foodList = jdbc.getFoodList("湘菜");
                contentPanel.remove(3);
                scrollPanelProcess();
            }
        });
        dessertLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                foodList = jdbc.getFoodList("甜品");
                contentPanel.remove(3);
                scrollPanelProcess();
            }
        });

        //菜品单元面板的元素 img name price type isPop
        JLabel imgLabel,nameLabel,priceLabel,typeLabel,isPopLabel;




        //承载滚动面板的面板
        JPanel panelUnderScrollPanel=new JPanel();





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
        contentPanelForScroll.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
        int foodCount = foodList.size();
        for (int i = 0; i < foodCount; i++) {

            //内容面板里 每个菜品所属的元面板
            JPanel foodPanel = new JPanel();
            foodPanel.setPreferredSize(new Dimension(1270 - 225, 100));
            foodPanel.setBackground(new Color(26, 36, 43));
            foodPanel.setBorder(new MatteBorder(0, 0, 1, 0, new Color(134, 134, 134)));
            foodPanel.setLayout(null);


            //序号
            JLabel numberLabel = new JLabel(i + 1 + ".");
            numberLabel.setForeground(Color.LIGHT_GRAY);
            numberLabel.setBounds(40, 0, 40, 100);
            foodPanel.add(numberLabel);

            //菜式图片
            ImageIcon imageIcon = new ImageIcon("dishImg/" + foodList.get(i).getFoodName() + ".jpg");
            JLabel imageLabel = new JLabel();
            imageLabel.setIcon(imageIcon);
            imageLabel.setOpaque(true);
            imageLabel.setBounds(120, 25 / 2, 100, 75);
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
            if (chosenFoodList.containsKey(foodList.get(i).getFoodName())) {
                spinner.setValue(chosenFoodList.get(foodList.get(i).getFoodName()));
            } else {
                spinner.setValue(0);
            }
            spinner.setBounds(225 + 400 + 100 + 100 + 50, 25, 60, 50);
            spinner.setLabelText("数量:");
            foodPanel.add(spinner);
            spinner.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    Spinner thisPinner = (Spinner) e.getSource();
                    if ((Integer) thisPinner.getValue() == -1) {
                        thisPinner.setValue(0);
                    }

                    JPanel thisFoodPanel = (JPanel) thisPinner.getParent();
                    JLabel foodNameLabel = (JLabel) thisFoodPanel.getComponent(2);
                    String foodName = foodNameLabel.getText();
                    if ((Integer) thisPinner.getValue() == 0) {
                        if (chosenFoodList.containsKey(foodName)) {
                            chosenFoodList.remove(foodName);
                        }
                    } else {
                        chosenFoodList.put(foodName, (Integer) thisPinner.getValue());
                    }
                }
            });


            //元面板触动变色
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

    //内部类,菜品操作选择弹窗
    class actionDialog extends JDialog{
        public actionDialog() {

        }
    }

    // 为了实现窗口拖拽
    class MoveListener extends MouseAdapter {
        private Point pressedPoint;
        private Rectangle frameBounds;

        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            this.frameBounds = AdminFrame.this.getBounds();
            this.pressedPoint = e.getPoint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            super.mouseReleased(e);
            moveJFrame(e);
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            super.mouseDragged(e);
            moveJFrame(e);
        }

        private void moveJFrame(MouseEvent event) {
            Point endPoint = event.getPoint();

            int xDiff = endPoint.x - pressedPoint.x;
            int yDiff = endPoint.y - pressedPoint.y;
            frameBounds.x += xDiff;
            frameBounds.y += yDiff;
            AdminFrame.this.setBounds(frameBounds);
        }
    }

}
