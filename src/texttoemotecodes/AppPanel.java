package texttoemotecodes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import javax.swing.*;

public class AppPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private JButton convertButton, copyButton;
    private JPanel panel1;
    private JLabel convertLabel, newLabel;
    private JTextField messageField;
    private JTextArea newArea;
    private JScrollPane newPane;
    private ButtonListener listen;
    private Logic logic;
    private GridBagConstraints c;
    
    public AppPanel() {
        listen = new ButtonListener();
        
        c = new GridBagConstraints();
        c.insets = new Insets(20, 20, 20, 20);
        c.fill = GridBagConstraints.BOTH;
        
        setLayout(new BorderLayout());
        
        panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        
        convertLabel = new JLabel("Message to convert:");
        c.gridx = 0;
        c.gridy = 0;
        panel1.add(convertLabel, c);
        
        messageField = new JTextField();
        c.gridx = 1;
        c.gridy = 0;
        panel1.add(messageField, c);
        
        newLabel = new JLabel("Converted message:");
        c.gridx = 0;
        c.gridy = 1;
        panel1.add(newLabel, c);
        
        newArea = new JTextArea();
        newArea.setEditable(false);
        newArea.setLineWrap(true);
        newPane = new JScrollPane(newArea);
        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        panel1.add(newPane, c);
        
        convertButton = new JButton("Convert");
        c.gridx = 0;
        c.gridy = 2;
        c.weightx = 0.0;
        c.weighty = 0.0;
        c.fill = GridBagConstraints.NONE;
        panel1.add(convertButton, c);
        
        copyButton = new JButton("Copy message");
        c.gridx = 1;
        c.gridy = 2;
        panel1.add(copyButton, c);
        
        add(panel1, BorderLayout.CENTER);
        
        logic = new Logic();
        
        convertButton.addActionListener(listen);
        copyButton.addActionListener(listen);
    }
    
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == convertButton) {
                newArea.setText(logic.toEmotes(messageField.getText()));
            }
            
            if (e.getSource() == copyButton) {
                StringSelection stringSelection = new StringSelection(newArea.getText());
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
            }
        }
    }
}
