package texttoemotecodes;

import javax.swing.*;

public class AppFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Text to Emote Codes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        AppPanel panel = new AppPanel();
        frame.add(panel);
        frame.setSize(600, 400);
        frame.setVisible(true);
    }
}
