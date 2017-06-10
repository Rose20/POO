package view;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;
 
public class ImageSwap implements ActionListener {
    JLabel label;
    public List<ImageIcon> imRay = new ArrayList<ImageIcon>();
 
    public void actionPerformed(ActionEvent e) {
        int index = ((JComboBox)e.getSource()).getSelectedIndex();
        label.setIcon(imRay.get(index));
    }
 
    private JLabel getLabel(BufferedImage[] images) {
        for(int j = 0; j < images.length; j++)
            imRay.add(new ImageIcon(images[j]));
        label = new JLabel(imRay.get(0));
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }
 
    private JPanel getComboPanel() {
        JComboBox combo = new JComboBox();
        for(int j = 0; j < imRay.size(); j++)
            combo.addItem(Integer.valueOf(j));
        combo.addActionListener(this);
        JPanel panel = new JPanel();
        panel.add(combo);
        return panel;
    }
 
    public static void main(String[] args) throws IOException {
        String[] ids = { "--g--", "---h-" };
        BufferedImage[] images = new BufferedImage[ids.length];
        for(int j = 0; j < images.length; j++) {
            String path = "images/" + ids[j] + ".jpg";
            images[j] = ImageIO.read(new File(path));
        }
        ImageSwap test = new ImageSwap();
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(test.getLabel(images));
        f.add(test.getComboPanel(), "North");
        f.setSize(400,400);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}