package Swing.HHS.GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class CharacterPanel extends JPanel{
	
	private JLabel characterLabel;
	private char character;
	
	public CharacterPanel(char Character) {
		// Default size of panel is 80 pixels width & height
		setPreferredSize(new Dimension(80, 80));
		
		// Use the BorderLayout to be able to center the text
		setLayout(new BorderLayout(0, 0));
		
		character = Character;
		
		// Create JLabel with the letter as text
		characterLabel = new JLabel(String.valueOf(Character));
		characterLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		characterLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		characterLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		characterLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		// Add the label to the panel
		add(characterLabel);
	}
	
	public char getCharacter() {
		return character;
	}
	
	public void IsInvalidLocation() {
		this.setBackground(ProgramStyle.CHARACTER_INVALID_POSITION_COLOR);
	}
	
	public void IsCorrectPosition() {
		this.setBackground(ProgramStyle.CHARACTER_CORRECT_POSITION_COLOR);
	}
}
