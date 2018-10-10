package Swing.HHS.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.JTextField;

public class DesignFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DesignFrame frame = new DesignFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DesignFrame() {
		getContentPane().setForeground(Color.BLACK);
		getContentPane().setBackground(ProgramStyle.BACKGROUND_COLOR);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel boxLayoutContainer = new JPanel();
		boxLayoutContainer.setBackground(Color.PINK);
		getContentPane().add(boxLayoutContainer, BorderLayout.CENTER);
		boxLayoutContainer.setLayout(new BoxLayout(boxLayoutContainer, BoxLayout.Y_AXIS));
		
		JPanel lingoCardPanel = new JPanel();
		lingoCardPanel.setMaximumSize(new Dimension(500, 320000));
		lingoCardPanel.setBackground(Color.WHITE);
		
		boxLayoutContainer.add(lingoCardPanel);
		
		JPanel lingoInputPanel = new JPanel();
		lingoCardPanel.add(lingoInputPanel);
		
		textField = new JTextField();
		lingoInputPanel.add(textField);
		textField.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Button has been clicked!");
			}
		});
		lingoInputPanel.add(btnOk);
		
		JPanel lingoEntryPanel = new JPanel();
		lingoCardPanel.add(lingoEntryPanel);
		
		// CharacterPanels are containers for individual characters 
		CharacterPanel characterPanel = new CharacterPanel('A');
		lingoEntryPanel.add(characterPanel);
		CharacterPanel characterPanel_1 = new CharacterPanel('P');
		lingoEntryPanel.add(characterPanel_1);
		CharacterPanel characterPanel_2 = new CharacterPanel('P');
		lingoEntryPanel.add(characterPanel_2);
		CharacterPanel characterPanel_3 = new CharacterPanel('E');
		lingoEntryPanel.add(characterPanel_3);
		CharacterPanel characterPanel_4 = new CharacterPanel('L');
		lingoEntryPanel.add(characterPanel_4);
		
		JLabel label = new JLabel("New label");
		getContentPane().add(label, BorderLayout.NORTH);
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 928, 558);
		
		setContentPane(contentPane);
		
		
	}
}
