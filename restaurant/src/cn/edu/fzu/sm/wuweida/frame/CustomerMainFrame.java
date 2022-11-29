package cn.edu.fzu.sm.wuweida.frame;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class CustomerMainFrame extends JFrame {
    public CustomerMainFrame() throws HeadlessException {
        this.setUndecorated(true);
        this.setSize(700,800);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        JPanel contentPanel=(JPanel) this.getContentPane();
        contentPanel.setBackground(new Color(26, 36, 43));
        MoveListener moveListener=new MoveListener();
        contentPanel.addMouseListener(moveListener);
        contentPanel.addMouseMotionListener(moveListener);

        JPanel westPanel=new JPanel();
        westPanel.setBounds(0,0,200,800);
        westPanel.setBackground(new Color(36, 52, 72));
        contentPanel.add(westPanel,BorderLayout.WEST);


        JLabel logoLabel=new JLabel(new ImageIcon("image/logo.png"));
        logoLabel.setBounds(20,20,160,160);
        westPanel.add(logoLabel);

        JTextField searchText=new JTextField();
        searchText.setBounds(300,30,300,40);
        searchText.setBorder(null);
        searchText.setBackground(new Color(42, 57, 65));
        searchText.setForeground(Color.LIGHT_GRAY);
        searchText.setFont(new Font("正楷",Font.PLAIN,20));
        searchText.setBorder(BorderFactory.createCompoundBorder( searchText.getBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        contentPanel.add(searchText);

        JLabel searchLogoLabel=new JLabel(new ImageIcon("image/search.png"));
        searchLogoLabel.setBounds(620,30,40,40);
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
