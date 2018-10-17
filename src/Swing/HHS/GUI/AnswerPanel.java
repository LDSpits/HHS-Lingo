package Swing.HHS.GUI;

import java.util.ArrayList;

import javax.swing.JPanel;

public class AnswerPanel extends JPanel {
	
	public AnswerPanel(String answer, String attempt) {
		if(answer.length() != attempt.length()) {
			// this is an invalid answer, length does not match the answer length
			IsInvalid(answer.length());
			return;
		}
		
		CharacterPanel[] panels = new CharacterPanel[answer.length()];
		char[] answerArray = answer.toCharArray();
		
		for (int i = 0; i < panels.length; i++) {
			panels[i] = new CharacterPanel(attempt.toCharArray()[i]);
			add(panels[i]);
		}
		
		ArrayList<CharacterPanel> yellowPanels = new ArrayList<CharacterPanel>();
		
		// Orange panels check
		for (int i = 0; i < panels.length; i++) {
			CharacterPanel panel = panels[i];
			
			if (panel.getCharacter() == answerArray[i]) {
				panel.IsCorrectPosition();
				answerArray[i] = '*';
			} else {
				yellowPanels.add(panel);
			}
		}
		
		// yellow panels
		for (int i = 0; i < yellowPanels.size(); i++) {
			CharacterPanel panel = yellowPanels.get(i);
			
			if(String.valueOf(answerArray).contains(Character.toString(panel.getCharacter()))) {
				panel.IsInvalidLocation();
				
				int position = String.valueOf(answerArray)
	                    .lastIndexOf(Character.toString(panel.getCharacter()));

	            answerArray[position] = '*';
			}
			
		}
	}
	
	private void IsInvalid(int length) {
		// Create an invalid answer with the same amount of panels as the amount of characters
		for(int i = 0; i < length; i++) {
			
			// add the characters to the current panel
			add(new CharacterPanel('-'));
		}
	}
	
}
