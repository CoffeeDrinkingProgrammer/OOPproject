/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Dave
 */
public class GUI {
    public GUI(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        
        panel.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
        panel.setLayout(new GridLayout(0,1));
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Test");
        frame.pack();
        frame.setVisible(true);
        panel.setBackground(new Color(37,13,84));
        panel.setPreferredSize(new Dimension(520, 520));
        panel.setMinimumSize(new Dimension(100, 100));
        panel.setMaximumSize(new Dimension(1000, 1000));
        
        
    }
}
