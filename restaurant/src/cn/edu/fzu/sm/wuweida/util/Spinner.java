package cn.edu.fzu.sm.wuweida.util;

import javax.swing.*;
import java.awt.*;

import static javax.swing.SwingConstants.CENTER;

public class Spinner extends JSpinner {

    public void setLabelText(String text) {
        SpinnerUI.Editor editor = (SpinnerUI.Editor) getEditor();
        editor.setLabelText(text);
    }

    public String getLabelText() {
        SpinnerUI.Editor editor = (SpinnerUI.Editor) getEditor();
        return editor.getLabelText();
    }

    public Spinner() {
//        setOpaque(false);
        setOpaque(true);
        setUI(new SpinnerUI());
    }
}
