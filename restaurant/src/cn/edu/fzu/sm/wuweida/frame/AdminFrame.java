package cn.edu.fzu.sm.wuweida.frame;

import cn.edu.fzu.sm.wuweida.bean.Food;
import cn.edu.fzu.sm.wuweida.dao.JdbcImpl;
import cn.edu.fzu.sm.wuweida.util.ModernScrollBarUI;
import cn.edu.fzu.sm.wuweida.util.Spinner;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;


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

        this.addMouseListener(moveListener);
        this.addMouseMotionListener(moveListener);

        //北部面板
        JPanel northPanel=new JPanel();
        northPanel.setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
        northPanel.setBounds(0,0,500,55);
        northPanel.setBackground(new Color(7,25,27));
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
        closeLabel.setPreferredSize(new Dimension(50,55));
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
        northPanel.add(closeLabel);

        //监听标签点击(菜单切换)
        popLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                foodList = jdbc.getFoodList("pop");
                contentPanel.remove(1);
                scrollPanelProcess();
            }
        });
        cantoneseLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                foodList = jdbc.getFoodList("粤菜");
                contentPanel.remove(1);
                scrollPanelProcess();
            }
        });
        xiangLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                foodList = jdbc.getFoodList("湘菜");
                contentPanel.remove(1);
                scrollPanelProcess();
            }
        });
        dessertLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                foodList = jdbc.getFoodList("甜品");
                contentPanel.remove(1);
                scrollPanelProcess();
            }
        });


        scrollPanelProcess();
        this.setVisible(true);
    }

    private void scrollPanelProcess() {


        //滚动面板下的基础面板
        JPanel panelUnderScroll = new JPanel();
        panelUnderScroll.setBounds(0, 50, 500, 550);

        //滚动面版的内容面板
        JPanel contentPanelForScroll = new JPanel();
        contentPanelForScroll.setPreferredSize(new Dimension(500, 1000));
        contentPanelForScroll.setBackground(new Color(26, 36, 43));
        contentPanelForScroll.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
        int foodCount = foodList.size();
        for (int i = 0; i < foodCount; i++) {

            //内容面板里 每个菜品所属的元面板
            JPanel foodPanel = new JPanel();
            foodPanel.setPreferredSize(new Dimension(500, 100));
            foodPanel.setBackground(new Color(26, 36, 43));
            foodPanel.setBorder(new MatteBorder(0, 0, 1, 0, new Color(134, 134, 134)));
            foodPanel.setLayout(null);

            //序号
            JLabel numberLabel = new JLabel(i + 1 + ".");
            numberLabel.setForeground(Color.LIGHT_GRAY);
            numberLabel.setHorizontalAlignment(SwingConstants.CENTER);
            numberLabel.setFont(new Font("楷体",Font.PLAIN,15));
            numberLabel.setBounds(0, 0, 100, 100);
            foodPanel.add(numberLabel);

            //菜式图片
            ImageIcon imageIcon = new ImageIcon("dishImg/" + foodList.get(i).getFoodName() + ".jpg");
            JLabel imageLabel = new JLabel();
            imageLabel.setIcon(imageIcon);
            imageLabel.setOpaque(true);
            imageLabel.setBounds(100, 25/2, 100, 75);
            foodPanel.add(imageLabel);

            //菜式名称
            String foodName=foodList.get(i).getFoodName();
            JLabel nameLabel = new JLabel(foodList.get(i).getFoodName());
            nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
            nameLabel.setFont(new Font("楷体", Font.PLAIN, 20));
            nameLabel.setForeground(Color.LIGHT_GRAY);
            nameLabel.setBounds(200, 0, 100, 100);
            foodPanel.add(nameLabel);

            //菜式价格
            JLabel priceLabel = new JLabel(foodList.get(i).getFoodPrice() + "人民币");
            priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
            priceLabel.setFont(new Font("楷体", Font.PLAIN, 15));
            priceLabel.setForeground(Color.LIGHT_GRAY);
            priceLabel.setBounds(300, 0, 100, 100);
            foodPanel.add(priceLabel);

            //是否热销?
            int isPop=foodList.get(i).getIsPop();
            String isPopString=(isPop==1?"热销":"不热销");
            JLabel isPopLabel = new JLabel(isPopString);
            isPopLabel.setHorizontalAlignment(SwingConstants.CENTER);
            isPopLabel.setFont(new Font("楷体", Font.PLAIN, 15));
            isPopLabel.setForeground(Color.LIGHT_GRAY);
            isPopLabel.setBounds(400, 0, 100, 100);
            foodPanel.add(isPopLabel);


            //元面板触动变色
            foodPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);
                    foodPanel.setBackground(new Color(33, 45, 54));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    super.mouseExited(e);
                    foodPanel.setBackground(new Color(26, 36, 43));
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);
                    actionDialog actionDialog=new actionDialog(foodName);
                }
            });

            contentPanelForScroll.add(foodPanel);
        }


        //滚动面板
        JScrollPane scrollPanel = new JScrollPane(contentPanelForScroll);
        JScrollBar customScrollBar = new JScrollBar();
        customScrollBar.setUI(new ModernScrollBarUI());
        customScrollBar.setPreferredSize(new Dimension(8, 8));
        customScrollBar.setForeground(new Color(26, 36, 43));
        customScrollBar.setBackground(new Color(14, 25, 32));
        customScrollBar.setOrientation(Adjustable.VERTICAL);
        scrollPanel.setVerticalScrollBar(customScrollBar);
        scrollPanel.setPreferredSize(new Dimension(500, 550));
        scrollPanel.setBounds(0, 0, 500, 550);
        scrollPanel.setBackground(new Color(26, 36, 43));
        scrollPanel.getHorizontalScrollBar().setOpaque(false);
        scrollPanel.setBorder(null);
        scrollPanel.remove(scrollPanel.getHorizontalScrollBar());


        panelUnderScroll.add(scrollPanel);
        contentPanel.add(panelUnderScroll);

    }

    //内部类,菜品操作选择弹窗
    class actionDialog extends JDialog{
        String chosenFoodName;
        public actionDialog(String chosenFoodName) {
            actionDialog.this.setAlwaysOnTop(true);
            actionDialog.this.setUndecorated(true);
            actionDialog.this.setSize(200,500);
            actionDialog.this.setLayout(null);
            actionDialog.this.setLocationRelativeTo(null);
            JPanel contentPanelOfDialog=(JPanel)actionDialog.this.getContentPane();
            contentPanelOfDialog.setBackground(new Color(20, 28, 33));

            actionDialog.this.chosenFoodName=chosenFoodName;
            Food chosenFood=jdbc.getFood(chosenFoodName);

            //菜式图片
            ImageIcon imageIcon = new ImageIcon("dishImg/" + chosenFood.getFoodName() + ".jpg");
            JLabel imageLabel = new JLabel();
            imageLabel.setIcon(imageIcon);
            imageLabel.setOpaque(true);
            imageLabel.setBounds(50, 25, 100, 75);
            contentPanelOfDialog.add(imageLabel);

            //name
            JLabel nameLabel = new JLabel("菜名:");
            nameLabel.setForeground(Color.LIGHT_GRAY);
            nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
            nameLabel.setFont(new Font("楷体",Font.PLAIN,15));
            nameLabel.setBounds(25, 125, 50, 50);
            contentPanelOfDialog.add(nameLabel);
            //name tf
            JTextField nameTextField=new JTextField(chosenFoodName);
            nameTextField.setBounds(100,125,75,50);
            contentPanelOfDialog.add(nameTextField);

            //price
            JLabel priceLabel = new JLabel("价格:");
            priceLabel.setForeground(Color.LIGHT_GRAY);
            priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
            priceLabel.setFont(new Font("楷体",Font.PLAIN,15));
            priceLabel.setBounds(25, 200, 50, 50);
            contentPanelOfDialog.add(priceLabel);
            //price tf
            JTextField priceTextField=new JTextField(chosenFood.getFoodPrice()+"");
            priceTextField.setBounds(100,200,75,50);
            contentPanelOfDialog.add(priceTextField);

            //type
            JLabel typeLabel = new JLabel("种类:");
            typeLabel.setForeground(Color.LIGHT_GRAY);
            typeLabel.setHorizontalAlignment(SwingConstants.CENTER);
            typeLabel.setFont(new Font("楷体",Font.PLAIN,15));
            typeLabel.setBounds(25, 275, 50, 50);
            contentPanelOfDialog.add(typeLabel);
            //选择
            Vector<String> typeModel=new Vector<>();
            typeModel.add("粤菜");
            typeModel.add("湘菜");
            typeModel.add("甜品");
            JComboBox typeComboBox=new JComboBox(typeModel);
            typeComboBox.setSelectedIndex(typeModel.indexOf(chosenFood.getFoodType()));
            typeComboBox.setBounds(100,275,75,50);
            contentPanelOfDialog.add(typeComboBox);

            //ispop
            JLabel isPopLabel=new JLabel("热销?");
            isPopLabel.setForeground(Color.LIGHT_GRAY);
            isPopLabel.setHorizontalAlignment(SwingConstants.CENTER);
            isPopLabel.setFont(new Font("楷体",Font.PLAIN,15));
            isPopLabel.setBounds(25,350,50,50);
            contentPanelOfDialog.add(isPopLabel);
            //isPop checkbox
            JCheckBox isPopCheckBox=new JCheckBox();
            isPopCheckBox.setSelected(chosenFood.getIsPop()==1);
            isPopCheckBox.setBounds(125,350,25,25);
            contentPanelOfDialog.add(isPopCheckBox);


            //ok
            JLabel okLabel = new JLabel("确定");
            okLabel.setForeground(Color.LIGHT_GRAY);
            okLabel.setHorizontalAlignment(SwingConstants.CENTER);
            okLabel.setFont(new Font("楷体",Font.PLAIN,15));
            okLabel.setBounds(25,425, 75, 50);
            contentPanelOfDialog.add(okLabel);
            okLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);

                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);
                    AdminFrame.this.setCursor(Cursor.HAND_CURSOR);
                    okLabel.setForeground(Color.WHITE);
                    okLabel.setBackground(new Color(14, 22, 44));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    super.mouseExited(e);
                    AdminFrame.this.setCursor(Cursor.DEFAULT_CURSOR);
                    okLabel.setForeground(Color.GRAY);
                    okLabel.setBackground(new Color(16, 36, 57));
                }
            });


            //cancel
            JLabel cancelLabel = new JLabel("取消");
            cancelLabel.setForeground(Color.LIGHT_GRAY);
            cancelLabel.setHorizontalAlignment(SwingConstants.CENTER);
            cancelLabel.setFont(new Font("楷体",Font.PLAIN,15));
            cancelLabel.setBounds(125,425, 50, 50);
            cancelLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);
                    actionDialog.this.dispose();
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);
                    AdminFrame.this.setCursor(Cursor.HAND_CURSOR);
                    cancelLabel.setForeground(Color.WHITE);
                    cancelLabel.setBackground(new Color(14, 22, 44));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    super.mouseExited(e);
                    AdminFrame.this.setCursor(Cursor.DEFAULT_CURSOR);
                    cancelLabel.setForeground(Color.GRAY);
                    cancelLabel.setBackground(new Color(16, 36, 57));
                }
            });
            contentPanelOfDialog.add(cancelLabel);





            actionDialog.this.setVisible(true);
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
