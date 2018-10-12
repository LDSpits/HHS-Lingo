package Swing.HHS.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class StartLayout implements ILayout {
	
	private MainWindow window;
	
	public StartLayout(MainWindow window) {
		this.window  = window;
	}

	@Override
	public JPanel render() {
		JPanel contentPane = new JPanel();
		contentPane.setBackground(ProgramStyle.BACKGROUND_COLOR);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Lingo");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(ProgramStyle.BACKGROUND_COLOR);
		contentPane.add(panel, BorderLayout.SOUTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{900, 0};
		gbl_panel.rowHeights = new int[]{50, 50, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnStart = new JButton("Start");
		btnStart.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnStart.setHorizontalTextPosition(SwingConstants.CENTER);
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.out.println("start button has been pressed");
				
				window.renderLayout(new LingoGameLayout(window));
			}
		});
		
		GridBagConstraints gbc_btnStart = new GridBagConstraints();
		gbc_btnStart.fill = GridBagConstraints.NONE;
		gbc_btnStart.insets = new Insets(0, 0, 5, 0);
		gbc_btnStart.gridx = 0;
		gbc_btnStart.gridy = 0;
		panel.add(btnStart, gbc_btnStart);
		
		JButton btnCredits = new JButton("Credits");
		btnCredits.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCredits.setAlignmentX(Component.CENTER_ALIGNMENT);
		GridBagConstraints gbc_btnCredits = new GridBagConstraints();
		gbc_btnCredits.fill = GridBagConstraints.NONE;
		gbc_btnCredits.gridx = 0;
		gbc_btnCredits.gridy = 1;
		panel.add(btnCredits, gbc_btnCredits);
		
		return contentPane;
		
	}
	
	
}
