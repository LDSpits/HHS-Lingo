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

public class TeamLayout implements ILayout {

	private MainWindow window;
	
	public TeamLayout(MainWindow window) {
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
				String input = textField.getText().toUpperCase();
				
				System.out.println("Ok pressed");
				
				if(input.length() != 5) {
					// TODO: Give an error message
					return;
				}
				
				JPanel entry = new JPanel();
				for (char character : input.toCharArray()) {
					entry.add(new CharacterPanel(character));
				}
				
				lingoCardPanel.add(entry);
				
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

}
