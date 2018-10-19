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
import javax.swing.ImageIcon;
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
	
	private int tryCount = 1;
	
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
		
		JLabel gameStatuslabel = new JLabel();
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.renderLayout(new LingoGameLayout(window));
			}
		});
		btnReset.setVisible(false);
		
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// validate the answer
				AnswerPanel panel = new AnswerPanel(answer, textField.getText().toUpperCase());
				
				if(panel.getIsAnswer()) {
					gameStatuslabel.setText("Gewonnen!!");
					btnOk.setEnabled(false);
					textField.setEnabled(false);
					btnReset.setVisible(true);
				}
				
				// Add the attempt to the screen 
				lingoCardPanel.add(panel);
				
				// Update the view
				window.redraw();
				
				tryCount++;
				
				if(tryCount > 5) {
					gameStatuslabel.setText("Verloren!!");
					btnOk.setEnabled(false);
					textField.setEnabled(false);
					btnReset.setVisible(true);
				}
			}
		});
		lingoInputPanel.add(btnOk);
		lingoInputPanel.add(gameStatuslabel);
		lingoInputPanel.add(btnReset);
		
		JPanel lingoEntryPanel = new JPanel();
		lingoCardPanel.add(lingoEntryPanel);
		
		JLabel show_image = new JLabel("");
		show_image.setHorizontalAlignment(SwingConstants.CENTER);
		show_image.setIcon(new ImageIcon(DesignFrame.class.getResource("/Lingook.png")));
		contentPane.add(show_image, BorderLayout.NORTH);	
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		
		return contentPane;
	}
}
