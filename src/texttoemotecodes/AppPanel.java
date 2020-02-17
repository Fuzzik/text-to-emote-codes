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
    private GridBagConstraints gbc;
    
    public AppPanel() {
        listen = new ButtonListener();
        
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20);
        gbc.fill = GridBagConstraints.BOTH;
        
        setLayout(new BorderLayout());
        
        panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        
        convertLabel = new JLabel("Message to convert:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel1.add(convertLabel, gbc);
        
        messageField = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel1.add(messageField, gbc);
        
        newLabel = new JLabel("Converted message:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel1.add(newLabel, gbc);
        
        newArea = new JTextArea();
        newArea.setEditable(false);
        newArea.setLineWrap(true);
        newPane = new JScrollPane(newArea);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        panel1.add(newPane, gbc);
        
        convertButton = new JButton("Convert");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.fill = GridBagConstraints.NONE;
        panel1.add(convertButton, gbc);
        
        copyButton = new JButton("Copy message");
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel1.add(copyButton, gbc);
        
        add(panel1, BorderLayout.CENTER);
        
        convertButton.addActionListener(listen);
        copyButton.addActionListener(listen);
    }
    
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == convertButton) {
                newArea.setText(Convert.toEmotes(messageField.getText()));
            }
            
            if (e.getSource() == copyButton) {
                StringSelection stringSelection = new StringSelection(newArea.getText());
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
            }
        }
    }
}
