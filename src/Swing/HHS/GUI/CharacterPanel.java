package Swing.HHS.GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class CharacterPanel extends JPanel{
	
	private JLabel character;
	
	public CharacterPanel(char Character) {
		// Default size of panel is 80 pixels width & height
		setPreferredSize(new Dimension(80, 80));
		
		// Use the BorderLayout to be able to center the text
		setLayout(new BorderLayout(0, 0));
		
		// Create JLabel with the letter as text
		character = new JLabel(String.valueOf(Character));
		character.setFont(new Font("Tahoma", Font.PLAIN, 40));
		character.setAlignmentX(Component.CENTER_ALIGNMENT);
		character.setHorizontalTextPosition(SwingConstants.CENTER);
		character.setHorizontalAlignment(SwingConstants.CENTER);
		
		// Add the label to the panel
		add(character);
	}
}
