package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class HomeView extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane =new JPanel();;
	private JPanel panelTop  =new JPanel();
	private JPanel panelSud =new JPanel();;
	private JPanel panelCentre =new JPanel();;
	private JButton btnContact = new JButton("Contact");
	private JButton btnGalerie = new JButton("Galerie");
	private JButton btnQuitte = new JButton("Quitter");;
	protected JButton btnHome  = new JButton("Home");;
//	private CardLayout card;
	ImageIcon img;
	String fondEcran ;
	

	public HomeView() {
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	setLocationRelativeTo(null);
	setUndecorated(true);
		
	panelTop.setBackground(Color.BLACK);
	panelSud.setBackground(Color.GREEN);
	//card = new CardLayout();
	


	//btnHome.FlatStyle();
	

	btnContact.addActionListener(new ActionListener() {
	
		public void actionPerformed(ActionEvent arg0) {
			ContacView clikcontact = new ContacView();
			clikcontact.setBounds(100, 100, 370, 575);
			clikcontact.setVisible(true);
			dispose();
			
		}
	});
	btnGalerie.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent arg0) {
			PhotoView clikPhoto = new PhotoView();
			clikPhoto.setBounds(100, 100, 370, 575);
			clikPhoto.setVisible(true);
			dispose();
			
		}
	});
	btnQuitte.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e){
			 
			   if(e.getSource()==btnQuitte){
			      setVisible(false);
			     dispose();
			   }
			}
	});
	btnHome.addActionListener
	(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			setVisible(true);
		}
	});
	
	panelTop.add(btnContact);
	panelTop.add(btnGalerie);
	panelCentre.add(btnQuitte);
	panelSud.add(btnHome);
	
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPane.setLayout(new BorderLayout(0, 0));
	
	contentPane.add(panelTop, BorderLayout.NORTH);
	contentPane.add(panelCentre, BorderLayout.CENTER);
	contentPane.add(panelSud, BorderLayout.SOUTH);
	
	add(contentPane);
	
	setResizable(false);
	setTitle("IPHONE");
	pack();
	}
//	public void actionPerformed(ActionEvent ae) {
//
//		if (ae.getActionCommand() == "Contact") {
//			ContacView clikcontact = new ContacView();
//			clikcontact.setBounds(100, 100, 370, 575);
//			clikcontact.setVisible(true);
//		}else if (ae.getActionCommand()=="Galerie") {
//			
//		}
//			
//		}


	

	public static void main(String[] args) {
		HomeView frame=new HomeView();
		frame.setBounds(100, 100, 370, 575);
		//	frame.setSize(480, 800);
		frame.setVisible(true);
		
	}

}
