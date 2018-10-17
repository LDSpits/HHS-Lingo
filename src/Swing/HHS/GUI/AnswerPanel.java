package Swing.HHS.GUI;

import javax.swing.JPanel;

public class AnswerPanel extends JPanel {
	
	public AnswerPanel(String answer, String attempt) {
		if(answer.length() != attempt.length()) {
			// this is an invalid answer, length does not match the answer length
			IsInvalid(answer.length());
		}
		
		char[] answerArray = answer.toCharArray();
		
		for (int i = 0; i < attempt.length(); i++) {
			char answerChar = answerArray[i];
			char attemptChar = attempt.toCharArray()[i];
			
			CharacterPanel panel = new CharacterPanel(attemptChar);
			
			if(attemptChar == answerChar) {
				panel.IsCorrectPosition();
				// "Consume" the character by replacing it with an invalid character
				answerArray[i] = '*';
			} else if(String.valueOf(answerArray).contains(Character.toString(attemptChar))) {
				panel.IsInvalidLocation();
				
				// Find the position of the correct character
				int position = String.valueOf(answerArray)
					.lastIndexOf(Character.toString(attemptChar));
				
				answerArray[position] = '*';
			}
			
			add(panel);
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
