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
import java.nio.charset.CharacterCodingException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class LingoGameLayout implements ILayout {

	private MainWindow window;
	
	private String answer = new AnswerProvider()
			.GetRandomAnswer()
			.toUpperCase();
	
	public LingoGameLayout(MainWindow window) {
		this.window = window;
	}
	
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
				System.out.println("Ok pressed");
				
				// Add the attempt to the screen 
				lingoCardPanel.add(new AnswerPanel(answer, textField.getText().toUpperCase()));
				
				System.out.println("Repainting");
				
				// Update the view
				window.redraw();
				
			}
		});
		lingoInputPanel.add(btnOk);
		
		JPanel lingoEntryPanel = new JPanel();
		lingoCardPanel.add(lingoEntryPanel);
		
		JLabel label = new JLabel("New label");
		contentPane.add(label, BorderLayout.NORTH);
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		
		return contentPane;
	}
	
	private JPanel ValidateAnswer(String attempt) {
		
		// Create a panel that will hold the attempt
		JPanel entry = new JPanel();
		
		// Check if the answer length equals the length of the attempt
		if(answer.length() == attempt.length()) {
			// Valid attempt
			
			for (int i = 0; i < attempt.length(); i++) {
				char answerChar = answer.toCharArray()[i];
				char attemptChar = attempt.toCharArray()[i];
				
				CharacterPanel panel = new CharacterPanel(attemptChar);
				
				if(attemptChar == answerChar)
					panel.IsCorrectPosition();
				
				entry.add(panel);
			}
		} else {
			// Create an invalid answer with the same amount of panels as the amount of characters
			for(int i = 0; i < answer.length(); i++) {
				entry.add(new CharacterPanel('-'));
			}
		}
		
		return entry;
		
	}

}
