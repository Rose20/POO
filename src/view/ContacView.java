package view;

	import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

public class ContacView extends JFrame  {
	private static final long serialVersionUID = 1L;
	private JPanel contentPaneContact = new JPanel();
	private JPanel panelCentreContact= new JPanel();
	private JPanel panelSudContact = new JPanel();
	private JPanel panelTopContact = new JPanel();
	
	private CardLayout cardContact;
	
	private JOptionPane panelOption;
	
	private JButton btnAjouter = new JButton("Ajouter");
	private JButton btnModifier = new JButton("Modifier");
	private JButton btnSupprimer = new JButton("Supprimer");
	private JButton	btnHome = new JButton("Home");
	
	protected DefaultListModel listModel = new DefaultListModel();
	protected JList list = new JList(listModel);
	protected ListSelectionModel listSelectionModel;
	
	
	private JScrollPane scrollPane  = new JScrollPane(list);

	
	public ContacView(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 575);
		setLocationRelativeTo(null);
		setUndecorated(true);
				
		panelCentreContact.setBackground(Color.yellow);
		panelTopContact.setBackground(Color.BLACK);
		panelSudContact.setBackground(Color.green);
		
		
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSelectionModel = list.getSelectionModel();
		//listSelectionModel.addListSelectionListener(this);


		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AjoutView clikHome= new AjoutView();
				clikHome.setBounds(100, 100, 370, 575);
				clikHome.setVisible(true);
				dispose();
		}
	});
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane panelOption =new JOptionPane();
				JOptionPane.showConfirmDialog(panelCentreContact,
						 "Être vous sûr de vouloir supprimer ce contact ?",
						 "Supprimer les Contacts",
						JOptionPane.OK_CANCEL_OPTION);
				
			//	dispose();
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
		
		
		panelCentreContact.add(scrollPane);
		panelTopContact.add(btnAjouter);
		panelTopContact.add(btnModifier);
		panelTopContact.add(btnSupprimer);
		panelSudContact.add(btnHome);
	
		
		contentPaneContact.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPaneContact.setLayout(new BorderLayout(0, 0));
	//	panelCentreContact.add(JList);
		
		contentPaneContact.add(panelTopContact, BorderLayout.NORTH);	
		contentPaneContact.add(panelCentreContact, BorderLayout.CENTER);	
		contentPaneContact.add(panelSudContact, BorderLayout.SOUTH);	

		
		add(contentPaneContact);
		setResizable(false);
		setTitle("Contact");
		pack();
		
		
	}
}
