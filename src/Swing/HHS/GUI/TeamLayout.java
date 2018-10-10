package Swing.HHS.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class TeamLayout implements ILayout {

	@Override
	public JPanel render() {
		JPanel contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(ProgramStyle.BACKGROUND_COLOR);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel boxLayoutContainer = new JPanel();
		boxLayoutContainer.setBackground(Color.PINK);
		contentPane.add(boxLayoutContainer, BorderLayout.CENTER);
		boxLayoutContainer.setLayout(new BoxLayout(boxLayoutContainer, BoxLayout.Y_AXIS));
		
		JPanel lingoCardPanel = new JPanel();
		lingoCardPanel.setMaximumSize(new Dimension(500, 320000));
		lingoCardPanel.setBackground(Color.WHITE);
		
		boxLayoutContainer.add(lingoCardPanel);
		
		JPanel lingoInputPanel = new JPanel();
		lingoCardPanel.add(lingoInputPanel);
		
		JTextField textField = new JTextField();
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
		contentPane.add(label, BorderLayout.NORTH);
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		
		return contentPane;
	}

}
