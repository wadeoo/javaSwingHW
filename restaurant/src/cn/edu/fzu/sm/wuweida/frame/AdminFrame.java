package cn.edu.fzu.sm.wuweida.frame;

import cn.edu.fzu.sm.wuweida.bean.Food;
import cn.edu.fzu.sm.wuweida.dao.JdbcImpl;
import cn.edu.fzu.sm.wuweida.util.ModernScrollBarUI;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class AdminFrame extends JFrame {
    private JPanel contentPanel;
    private JdbcImpl jdbcImpl=new JdbcImpl();
    private List<Food> foodList=jdbcImpl.getFoodList("pop");

    public AdminFrame() {

        this.setSize(400, 800);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setIconImage(new ImageIcon("image/admin.png").getImage());

        // 獲取主窗體内容面板
        contentPanel=(JPanel) this.getContentPane();
        contentPanel.setBackground(new Color(26, 36, 43));



        //菜單
        JMenuBar mainMenuBar=new JMenuBar();
        mainMenuBar.setPreferredSize(new Dimension(400,40));
        mainMenuBar.setBorder(null);
        mainMenuBar.setBackground(new Color(47, 70, 78));
        this.setJMenuBar(mainMenuBar);
        JMenu mainMenu=new JMenu("菜单操作");
        mainMenu.setForeground(Color.LIGHT_GRAY);
        mainMenuBar.add(mainMenu);
        JMenuItem popItem=new JMenuItem("热销菜品");
        JMenuItem cantoneseItem=new JMenuItem("粤菜");
        JMenuItem xiangItem=new JMenuItem("湘菜");
        JMenuItem dessertItem=new JMenuItem("甜品");
        mainMenu.add(popItem);
        mainMenu.add(cantoneseItem);
        mainMenu.add(xiangItem);
        mainMenu.add(dessertItem);


        popItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                foodList=jdbcImpl.getFoodList("pop");
                contentPanel.remove(0);
                scrollPanelProcess();
            }
        });
        cantoneseItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                foodList=jdbcImpl.getFoodList("粤菜");
                contentPanel.remove(0);
                scrollPanelProcess();
            }
        });
        xiangItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                foodList=jdbcImpl.getFoodList("湘菜");
                contentPanel.remove(0);
                scrollPanelProcess();
            }
        });
        dessertItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                foodList=jdbcImpl.getFoodList("甜品");
                contentPanel.remove(0);
                scrollPanelProcess();
            }
        });


        scrollPanelProcess();



        this.setVisible(true);
    }

    public  void scrollPanelProcess(){

        //滚动面板下的面板
        JPanel panelUnderScrollPanel=new JPanel();
        panelUnderScrollPanel.setBounds(0, 40, 400, 600);

        //滾動面板内的内容面板
        JPanel contentPanelForScrollPanel=new JPanel();
        contentPanelForScrollPanel.setPreferredSize(new Dimension(400,50*foodList.size()));
        contentPanelForScrollPanel.setLayout(new FlowLayout(FlowLayout.LEADING,0,0));

        //菜品元面板
        for (Food food:foodList) {
            String foodName=food.getFoodName();
            double foodPrice=food.getFoodPrice();
            String foodType=food.getFoodType();
            ImageIcon foodImg=new ImageIcon("dishImg/"+foodName+".jpg");

            //標簽
            JLabel nameLabel=new JLabel(foodName);
            JLabel priceLabel=new JLabel("种类: "+foodPrice);
            JLabel typeLabel=new JLabel(foodType);
            JLabel imgLabel=new JLabel(foodImg);

//            nameLabel.setBounds(0,0,100,100);
//            priceLabel.setBounds(0,0,100,100);
//            typeLabel.setBounds(0,0,100,100);
//            imgLabel.setBounds(0,0,100,100);
            nameLabel.setPreferredSize( new Dimension(100,100));
            priceLabel.setPreferredSize( new Dimension(100,100));
            typeLabel.setPreferredSize( new Dimension(100,100));
            imgLabel.setPreferredSize( new Dimension(100,100));

            nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
            nameLabel.setFont(new Font("楷体", Font.PLAIN, 15));
            nameLabel.setForeground(Color.LIGHT_GRAY);

            priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
            priceLabel.setFont(new Font("楷体", Font.PLAIN, 15));
            priceLabel.setForeground(Color.LIGHT_GRAY);

            typeLabel.setHorizontalAlignment(SwingConstants.CENTER);
            typeLabel.setFont(new Font("楷体", Font.PLAIN, 15));
            typeLabel.setForeground(Color.LIGHT_GRAY);

            imgLabel.setOpaque(true);




            //元面板触动变色
            JPanel foodPanel=new JPanel();
            foodPanel.setPreferredSize(new Dimension(400, 100));
            foodPanel.setBackground(new Color(26, 36, 43));
            foodPanel.setBorder(new MatteBorder(0, 0, 1, 0, new Color(134, 134, 134)));
            foodPanel.setLayout(null);
            foodPanel.add(nameLabel);
            foodPanel.add(priceLabel);
            foodPanel.add(typeLabel);
            foodPanel.add(imgLabel);
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

                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);
                    AdminFrame.this.dispose();

                }
            });

            contentPanelForScrollPanel.add(foodPanel);
        }

        //展示所有菜品的滾動面板
        JScrollPane scrollPanel = new JScrollPane(contentPanelForScrollPanel);
        JScrollBar customScrollBar = new JScrollBar();
        customScrollBar.setUI(new ModernScrollBarUI());
        customScrollBar.setPreferredSize(new Dimension(8, 8));
        customScrollBar.setForeground(new Color(26, 36, 43));
        customScrollBar.setBackground(new Color(14, 25, 32));
        customScrollBar.setOrientation(Adjustable.VERTICAL);
        scrollPanel.setVerticalScrollBar(customScrollBar);
        scrollPanel.setPreferredSize(new Dimension(400, 600));
        scrollPanel.setBounds(0, 40, 400, 600);
        scrollPanel.setBackground(new Color(26, 36, 43));
        scrollPanel.getHorizontalScrollBar().setOpaque(false);
        scrollPanel.setBorder(null);
        scrollPanel.remove(scrollPanel.getHorizontalScrollBar());


        panelUnderScrollPanel.add(scrollPanel);
        contentPanel.add(panelUnderScrollPanel);
    }



    //内部類,菜品操作選擇彈窗
    class actionDialog extends JDialog{
        public actionDialog() {

        }
    }

}
