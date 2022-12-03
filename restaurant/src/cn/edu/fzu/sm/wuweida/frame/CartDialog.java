package cn.edu.fzu.sm.wuweida.frame;

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
import java.util.HashMap;

import static java.awt.Cursor.*;

public class CartDialog extends JDialog {

    private JdbcImpl jdbcImpl=new JdbcImpl();

    public CartDialog(HashMap<String, Integer> chosenFoodHashMap) {
        this.setAlwaysOnTop(true);
        this.setUndecorated(true);
        this.setSize(300, 600);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        JPanel contentPanelForCartDialog = (JPanel) this.getContentPane();
        contentPanelForCartDialog.setBackground(new Color(20, 28, 33));


        //左上角标签
        JLabel jLabel = new JLabel("  您的购物车");
        jLabel.setBounds(0, 0, 50, 50);
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel.setVerticalAlignment(SwingConstants.CENTER);
        jLabel.setForeground(Color.LIGHT_GRAY);
        jLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        this.add(jLabel);

        //右上角退出键
        JLabel closeLabel2 = new JLabel("╳");
        closeLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        closeLabel2.setVerticalAlignment(SwingConstants.CENTER);
        closeLabel2.setForeground(Color.GRAY);
        closeLabel2.setBounds(250, 0, 50, 50);
        closeLabel2.setOpaque(true);
        closeLabel2.setBackground(new Color(20, 28, 33));
        closeLabel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                CartDialog.this.dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                CartDialog.this.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
                closeLabel2.setBackground(new Color(133, 37, 0));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                CartDialog.this.setCursor(Cursor.getPredefinedCursor(DEFAULT_CURSOR));
                closeLabel2.setBackground(new Color(20, 28, 34));
            }
        });
        this.add(closeLabel2);


        //滚动面板
        JScrollPane scrollPanel = new JScrollPane();
        JScrollBar customScrollBar = new JScrollBar();
        customScrollBar.setUI(new ModernScrollBarUI());
        customScrollBar.setPreferredSize(new Dimension(8, 8));
        customScrollBar.setForeground(new Color(26, 36, 43));
        customScrollBar.setBackground(new Color(14, 25, 32));
        customScrollBar.setOrientation(Adjustable.VERTICAL);
        scrollPanel.setVerticalScrollBar(customScrollBar);
        scrollPanel.setPreferredSize(new Dimension(300, 400));
        scrollPanel.setBounds(0, 50, 300, 400);
        scrollPanel.setBackground(new Color(26, 36, 43));
        scrollPanel.getHorizontalScrollBar().setOpaque(false);
        scrollPanel.setBorder(null);
        scrollPanel.remove(scrollPanel.getHorizontalScrollBar());
        this.add(scrollPanel);


        //滚动面板的内容面板
        JPanel contentPanelForScroll = new JPanel();
        contentPanelForScroll.setPreferredSize(new Dimension(300, 400));
        contentPanelForScroll.setBackground(new Color(26, 36, 43));
        contentPanelForScroll.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));


        //列出购物车清单
        int i = 1;
        if (!chosenFoodHashMap.isEmpty()) {
            for (String key : chosenFoodHashMap.keySet()) {

                //内容面板里 每个菜品所属的元面板
                JPanel foodPanel = new JPanel();
                foodPanel.setPreferredSize(new Dimension(300, 50));
                foodPanel.setBackground(new Color(26, 36, 43));
                foodPanel.setBorder(new MatteBorder(0, 0, 1, 0, new Color(134, 134, 134)));
                foodPanel.setLayout(null);

                //序号
                JLabel numberLabel = new JLabel((i++) + ".");
                numberLabel.setForeground(Color.LIGHT_GRAY);
                numberLabel.setBounds(10, 0, 40, 50);
                foodPanel.add(numberLabel);

                //菜式名称
                JLabel nameLabel = new JLabel(chosenFoodHashMap.get(key) + "");
                nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
                nameLabel.setFont(new Font("楷体", Font.PLAIN, 10));
                nameLabel.setForeground(Color.LIGHT_GRAY);
                nameLabel.setBounds(80, 0, 30, 50);
                foodPanel.add(nameLabel);

                //菜式价格
                JLabel priceLabel = new JLabel(jdbcImpl.getFoodPrice(key) + "人民币");
                priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
                priceLabel.setFont(new Font("楷体", Font.PLAIN, 10));
                priceLabel.setForeground(Color.LIGHT_GRAY);
                priceLabel.setBounds(200, 0, 30, 50);
                foodPanel.add(priceLabel);


                //数量选择器
                Spinner spinner = new Spinner();
                spinner.setBounds(250, 0, 40, 50);
                spinner.setValue(chosenFoodHashMap.get(key));
                spinner.setLabelText("数量:");
                foodPanel.add(spinner);
                spinner.addChangeListener(new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        Spinner thisPinner = (Spinner) e.getSource();
                        if ((Integer) thisPinner.getValue() == -1) {
                            thisPinner.setValue(0);
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
        }
        scrollPanel.setViewportView(contentPanelForScroll);

        this.setVisible(true);
    }
}
