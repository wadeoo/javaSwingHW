package cn.edu.fzu.sm.wuweida.frame;

import javax.swing.*;
import java.awt.*;

public class CustomerMainFrame extends JFrame {
    public CustomerMainFrame() throws HeadlessException {
        this.setUndecorated(true);
        this.setSize(700,800);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        JPanel contentPanel=(JPanel) this.getContentPane();
        contentPanel.setBackground(new Color(26, 36, 43));

        JLabel logoLabel=new JLabel(new ImageIcon("image/logo.png"));
        logoLabel.setBounds(0,5,100,100);
        contentPanel.add(logoLabel);


        this.setVisible(true);
    }
}
