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
        popFoodBtn.setBackground(new Color(102, 26,0));
        popFoodBtn.setFont(new Font("宋体",Font.BOLD,30));
        popFoodBtn.setForeground(Color.LIGHT_GRAY);
        popFoodBtn.setFocusPainted(false);
        popFoodBtn.setBorder(null);
        popFoodBtn.addMouseListener(new MouseAdapter() {
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
        westPanel.add(popFoodBtn);

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
