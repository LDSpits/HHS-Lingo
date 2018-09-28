package Swing.HHS.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
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

public class TeamLayout implements ILayout {

	@Override
	public JPanel render() {
		JPanel contentPane = new JPanel();
		contentPane.setBackground(ProgramStyle.BACKGROUND_COLOR);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTeamIndelen = new JLabel("Team Indelen");
		lblTeamIndelen.setForeground(Color.WHITE);
		lblTeamIndelen.setFont(new Font("Tahoma", Font.PLAIN, 48));
		lblTeamIndelen.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTeamIndelen, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(ProgramStyle.BACKGROUND_COLOR);
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0};
		gbl_panel.rowHeights = new int[]{0};
		gbl_panel.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		return contentPane;
	}

}
