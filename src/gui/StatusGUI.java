package gui;

import javax.swing.*;
import java.awt.*;

public class StatusGUI extends JFrame {
    public StatusGUI() {
        setTitle("Status");
        var panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        {
            var label = new JLabel("Maxime Scharwath GOLD");
            label.setForeground(Color.orange);
            panel.add(label);
        }
        {
            var label = new JLabel("Nicolas Crausaz SILVER");
            label.setForeground(Color.gray);
            panel.add(label);
        }
        add(panel);
        pack();
    }
}
