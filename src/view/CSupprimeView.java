package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.chrono.JapaneseDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CSupprimeView extends JFrame {
	private JPanel contentPaneSupp;
	private JPanel panelCentre;
	private JOptionPane panelOption;
	private JButton btnSupprime;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;

	public CSupprimeView() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPaneSupp = new JPanel();
		panelCentre = new JPanel();
		panelOption = new JOptionPane();
		btnSupprime = new JButton("showOptionDialog");
		btn2 = new JButton("showConfirmDialog");
		btn3 = new JButton("showInputDialog");
		btn4 = new JButton("showMessageDialog");
		btn5 = new JButton("showInternalMessageDialog");
		
		btnSupprime.addActionListener(new ActionListener() {
			Object[] options = { "OK", "CANCEL" };

			public void actionPerformed(ActionEvent e) {
				JOptionPane.showOptionDialog(contentPaneSupp,
						"Click OK to continue", "showOptionDialog",
						JOptionPane.DEFAULT_OPTION,
						JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			}
		});

		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelOption.showConfirmDialog(contentPaneSupp,
						"please choose one", "showConfirmDialog",
						JOptionPane.OK_CANCEL_OPTION);

			}
		});
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] possibleValues = { "First", "Second", "Third" };
				Object selectedValue = JOptionPane.showInputDialog(contentPaneSupp,
				"Choose one", "showInputDialog",
				JOptionPane.INFORMATION_MESSAGE, null,
				possibleValues, possibleValues[0]);
			}
		});
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPaneSupp, "alert", "showMessageDialog1", JOptionPane.ERROR_MESSAGE);

			}
		});
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPaneSupp, "information",
						"showMessageDialog2", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		

		panelCentre.add(btnSupprime);
		panelCentre.add(btn2);
		panelCentre.add(btn3);
		panelCentre.add(btn4);
		panelCentre.add(btn5);
		
		contentPaneSupp.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPaneSupp.setLayout(new BorderLayout(0, 0));

		// contentPaneSupp.add(panelCentre,BorderLayout.CENTER);
		contentPaneSupp.add(panelCentre, BorderLayout.CENTER);
		add(contentPaneSupp);
		setResizable(false);
		setTitle("Supprimer Contact");
		pack();
	}

}
