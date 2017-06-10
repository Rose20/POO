package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AjoutView extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPaneAjout;
	private JPanel panelTopAjout;
	private JPanel panelCentreAjout;
	private JPanel panelSudAjout;
	private JButton btnEnregistrer;
	private JButton btnAnnule;
	private JButton btnHome;
	private JButton btnPhoto;
	private JLabel lblNom;
	private JLabel lblPrenom;
	private JLabel lblPhoneNo1;
	private JLabel lblEMail;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtPhoneNo1;
	private JTextField txtPhoneNo2;
	private JTextField txtEMail;
	
	ContactData contact = new ContactData();
	
	public AjoutView(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 575);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPaneAjout = new JPanel();
		panelTopAjout=new JPanel();
//		panelCentreAjout = new JPanel((new GridLayout(6,8,20,50)));
		panelCentreAjout = new JPanel(); // sans GridLayout
		panelSudAjout = new JPanel();
		
		
		panelTopAjout.setBackground(Color.BLACK);
		panelSudAjout.setBackground(Color.GREEN);
		
		JLabel lblNom = new JLabel("Nom:");
		JLabel lblPrenom = new JLabel("Prenom:");
		JLabel lblPhoneNo1 = new JLabel("Phone N°1:");
		JLabel lblPhoneNo2 = new JLabel("Phone N°2:");
		JLabel lblEMail = new JLabel("EMail:");
		
		txtNom = new JTextField(30);
		txtPrenom = new JTextField(30);
		txtPhoneNo1 = new JTextField(30);
		txtPhoneNo2 = new JTextField(30);
		txtEMail = new JTextField(30);
	//	JButton btnPhoto = new JButton("Photo");

		panelCentreAjout.setBackground(Color.green);
		panelTopAjout.setBackground(Color.BLACK);
		panelSudAjout.setBackground(Color.green);
		
		btnPhoto = new JButton("Photo");
		btnPhoto.setPreferredSize(new Dimension(330,100));
		btnPhoto.setBorderPainted(false); // retire l'effet btn
		btnPhoto.setForeground(Color.red);

		btnEnregistrer = new JButton("Enregistrer");
		btnAnnule = new JButton("Annuler");
		btnHome = new JButton("Home");
	//	btnHome.setBorderPainted(false);
		
		Vector v = new Vector(6, 3);
		int i = 0, k = 0;
		
		
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
									
			ConctactController clikHome = new ConctactController();;
		
			
//				clikHome.setBounds(100, 100, 370, 575);
//				clikHome.setVisible(true);
				
				if (txtNom.getText().equals("") && txtPrenom.getText().equals("")
						&& txtPhoneNo1.getText().equals("")
						&& txtPhoneNo2.getText().equals("")
						&& txtEMail.getText().equals("")
						) 
				{

					JOptionPane.showMessageDialog(panelCentreAjout, "Veuillez remplir !",
							"Entrées vides", JOptionPane.INFORMATION_MESSAGE);

				} else {
					ContactData contact = new ContactData();
					contact.setDetails(txtNom.getText(), txtPrenom.getText(),
							txtPhoneNo1.getText(), txtPhoneNo2.getText(),
							txtEMail.getText());
					v.addElement(contact);
					clikHome.SauveVector();
					txtNom.setText("");
					txtPrenom.setText("");
					txtPhoneNo1.setText("");
					txtPhoneNo2.setText("");
					txtEMail.setText("");
					

				}
				ContacView ah= new ContacView();
				ah.setBounds(100, 100, 370, 575);
				ah.setVisible(true);
				dispose();
		}
	});
		btnAnnule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContacView clikHome= new ContacView();
				clikHome.setBounds(100, 100, 370, 575);
				clikHome.setVisible(true);
				dispose();
		}
	});
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeView clikHome= new HomeView();
				clikHome.setBounds(100, 100, 370, 575);
				clikHome.setVisible(true);
				dispose();
		}
	});
		
		panelTopAjout.add(btnEnregistrer);
		panelTopAjout.add(btnAnnule);
		panelSudAjout.add(btnHome);
		
		panelCentreAjout.add(btnPhoto);
		panelCentreAjout.add(lblNom);
		panelCentreAjout.add(txtNom);
		panelCentreAjout.add(lblPrenom);
		panelCentreAjout.add(txtPrenom);
		panelCentreAjout.add(lblPhoneNo1);
		panelCentreAjout.add(txtPhoneNo1);
		panelCentreAjout.add(lblPhoneNo2);
		panelCentreAjout.add(txtPhoneNo2);
		panelCentreAjout.add(lblEMail);
		panelCentreAjout.add(txtEMail);
		
		contentPaneAjout.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPaneAjout.setLayout(new GridLayout(0, 1));

		contentPaneAjout.setLayout(new BorderLayout(0, 0));
		
		contentPaneAjout.add(panelTopAjout, BorderLayout.NORTH);
		contentPaneAjout.add(panelCentreAjout, BorderLayout.CENTER);
		contentPaneAjout.add(panelSudAjout, BorderLayout.SOUTH);
		
		add(contentPaneAjout);
		
		setResizable(false);
		setTitle("Enregistrer contact");
		pack();
	}

	public static void main(String[] args) {
		AjoutView frame=new AjoutView();
		frame.setBounds(100, 100, 370, 575);
		//	frame.setSize(480, 800);
		frame.setVisible(true);
		
	}
	
}
