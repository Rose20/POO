package view;

import java.awt.BorderLayout;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class PhotoView extends JFrame {

    private static final long serialVersionUID = 1L;

    private JButton[] tab = new JButton[15];
    private JPanel panelPhotosCard;
    private JPanel panelSelectedPhoto;
    private JPanel panelScroll;
    private JLabel lblClickOnThe;
    private JPanel panelWithPhotosButtons;
    private JScrollPane scrollPanePhotos;
    private JButton btnPhotoIsHere;
    private JButton btnAddToContact;
    protected ImageIcon image;
   // protected static ContactPhoto ContactPhoto;

    /**
     * Frame builder
     *
     * @see class SmartphoneFrame
     */
    public PhotoView() {
        super();

        panelPhotosCard = new JPanel();
        getContentPane().add(panelPhotosCard, BorderLayout.CENTER);
        panelPhotosCard.setLayout(new CardLayout(0, 0));

        panelScroll = new JPanel();
        panelScroll.setBackground(Color.GRAY);
        panelPhotosCard.add(panelScroll, "name_44554684112709");
        panelScroll.setLayout(null);

        lblClickOnThe = new JLabel("Click on the photo to open");
        lblClickOnThe.setFont(new Font("Dialog", Font.BOLD, 13));
        lblClickOnThe.setForeground(Color.WHITE);
        lblClickOnThe.setBounds(12, 12, 212, 14);
        panelScroll.add(lblClickOnThe);

        scrollPanePhotos = new JScrollPane(
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPanePhotos.setBounds(12, 37, 450, 599);
        panelScroll.add(scrollPanePhotos);

        panelWithPhotosButtons = new JPanel();
        scrollPanePhotos.setViewportView(panelWithPhotosButtons);
        panelWithPhotosButtons.setLayout(new GridLayout(5, 3, 20, 20));

        for (int i = 0; i < 15; i++) {
            tab[i] = new JButton(String.valueOf(i));
            tab[i] = new JButton(new ImageIcon(
                    ((new ImageIcon(
                            PhotoView.class.getResource("/Images/p" + i
                                    + ".jpg")).getImage().getScaledInstance(-1,
                            150, Image.SCALE_FAST))))); // icon on every button is scaled to JButtons size

            tab[i].setPreferredSize(new Dimension(200, 150));
            panelWithPhotosButtons.add(tab[i]);

            tab[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent a) {

                    for (int i = 0; i < 15; i++) { // an ActionListener is added to every JButton with an icon

                        if (a.getSource() == tab[i]) {
                            System.out.println("Image: " + i);

                            panelPhotosCard.removeAll();
                            panelPhotosCard.add(panelSelectedPhoto); //new panel of CardLayout is open 
                            panelPhotosCard.repaint();
                            panelPhotosCard.revalidate();

                            System.out.println("The button was clicked!");
                            System.out.println("/Images/p" + i + ".jpg");  // clicked JButton transfered an icon to other JButton
                            btnPhotoIsHere.setIcon(new ImageIcon(
                                    ((new ImageIcon(PhotoView.class
                                            .getResource("/Images/p" + i
                                                    + ".jpg")).getImage()
                                    .getScaledInstance(-1, 330,
                                            Image.SCALE_FAST)))));

                            image = new ImageIcon(
                                    PhotoView.class
                                    .getResource("/Images/p" + i
                                            + ".jpg"));

                            Path path = FileSystems.getDefault().getPath(
                                    "/Images/p" + i + ".jpg");

                            System.out.println("path: " + path);

                        }

                    }
                }
            });
            panelSelectedPhoto = new JPanel();
            panelSelectedPhoto.setBackground(Color.GRAY);
            panelPhotosCard.add(panelSelectedPhoto, "name_43166851735807");
            panelSelectedPhoto.setLayout(null);

            btnPhotoIsHere = new JButton();
            btnPhotoIsHere.setBounds(59, 70, 360, 330);
            panelSelectedPhoto.add(btnPhotoIsHere);

            btnAddToContact = new JButton("galerie");
            btnAddToContact.setFont(new Font("Dialog", Font.BOLD, 13));
            btnAddToContact.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                	PhotoView f = new PhotoView() ;
                	f.setVisible(true);
                	f.setBounds(100, 100, 450, 599);
                	dispose();
                    /*ContactPhoto.getButton();
		            ContactPhoto.givePhoto(image);*/
                }
            });
            btnAddToContact.setBounds(168, 448, 137, 40);
            panelSelectedPhoto.add(btnAddToContact);

           // super.giveTitle("PHOTOS");
        }
    }
}
