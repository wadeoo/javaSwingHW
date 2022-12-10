package cn.edu.fzu.sm.wuweida.frame;

import cn.edu.fzu.sm.wuweida.bean.Food;
import cn.edu.fzu.sm.wuweida.dao.JdbcImpl;

import javax.swing.*;
import javax.swing.border.MatteBorder;
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
        dessertLabel.setPreferredSize(new Dimension(125, 50));
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


        //菜品单元面板的元素 img name price type isPop
        JLabel imgLabel,nameLabel,priceLabel,typeLabel,isPopLabel;




        //承载滚动面板的面板
        JPanel panelUnderScrollPanel=new JPanel();





        this.setVisible(true);
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
