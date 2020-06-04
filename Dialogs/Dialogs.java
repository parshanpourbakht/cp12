package Dialogs;

import javax.swing.*;

public class Dialogs {
    static JFrame frame = new JFrame();

    public static void showDialog(String text) {
        JOptionPane.showMessageDialog(frame, text);
    }

    public static String showInputDialog(String text) {
        return JOptionPane.showInputDialog(text);
    }
}
