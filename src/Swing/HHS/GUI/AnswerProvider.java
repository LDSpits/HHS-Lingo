package Swing.HHS.GUI;

import java.util.Random;

public class AnswerProvider {
	private String[] choices = {
			"appel",
			"groot",
			"klein",
			"zagen",
			"leven",
			"plein",
			"kwart",
			"slaap",
			"knaap",
			"staat"
	};
	
	public String GetRandomAnswer() {
		String answer = choices[new Random().nextInt(choices.length - 1)];
		System.out.println(answer);
		return answer;
	}
}
