package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import comp_decomp.compressor;
import comp_decomp.decompressor;

import java.awt.*;
import java.io.File;

public class AppFrame extends JFrame implements ActionListener{
	

	private static final long serialVersionUID = 1L;
	JButton compressButton;
	JButton decompressButton;
	
	AppFrame(String name){
        //set the window title
        this.setTitle(name);

        Container c = this.getContentPane();
        c.setLayout(new BorderLayout());

        // panel for the heading inside the window
        JPanel headingPanel = new JPanel();
        headingPanel.setBackground(new Color(100, 150, 200)); // Set background color 
        headingPanel.setPreferredSize(new Dimension(getWidth(),60));
        
        // label for the heading
        JLabel headingLabel = new JLabel("Compressor & Decompressor");
        headingLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headingLabel.setForeground(Color.black); // Set text color
        headingPanel.add(headingLabel); // Add the heading label to the heading panel

        JPanel buttonPanel = new JPanel(); // Create a panel for the buttons
        buttonPanel.setBackground(new Color(50, 50, 159)); // Set background color
        buttonPanel.setPreferredSize(new Dimension(getWidth(),270)); // Set preferred size

        compressButton = new JButton("Select File To Compress");
        decompressButton = new JButton("Select File To Decompress");
        compressButton.setBackground(new Color(50, 50, 100)); // Set button background color
        decompressButton.setBackground(new Color(50, 50, 100)); // Set button background color
        compressButton.setForeground(new Color(103, 114, 155)); // Set button text color
        decompressButton.setForeground(new Color(103, 114, 155)); // Set button text color


        buttonPanel.add(compressButton);
        buttonPanel.add(decompressButton);

        c.add(headingPanel, BorderLayout.NORTH); // Add the heading panel to the top
        c.add(buttonPanel, BorderLayout.CENTER); // Add the button panel to the center

        compressButton.addActionListener(this);
        decompressButton.addActionListener(this);

        this.setSize(500, 300);
        this.setResizable(true);

        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.getContentPane().setBackground(Color.black); // Set background color for the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); // Center the frame on the screen
        this.setVisible(true);

    }


    //Overriding the actionPerformed method from the ActionListener interface
	@Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == compressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try{
                    compressor.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null,ee.toString());
                }
            }
        }

        if(e.getSource() == decompressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try{
                    decompressor.method(file);
                }
                catch (Exception ee){
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }
    }

}

	
