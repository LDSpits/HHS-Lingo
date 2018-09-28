package Swing.HHS.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class DesignFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DesignFrame frame = new DesignFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DesignFrame() {
		getContentPane().setForeground(Color.BLACK);
		getContentPane().setBackground(ProgramStyle.BACKGROUND_COLOR);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 928, 558);
		
		setContentPane(contentPane);
		
		JLabel lblTeamIndelen = new JLabel("Team Indelen");
		lblTeamIndelen.setForeground(Color.WHITE);
		lblTeamIndelen.setFont(new Font("Tahoma", Font.PLAIN, 48));
		lblTeamIndelen.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblTeamIndelen, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(ProgramStyle.BACKGROUND_COLOR);
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0};
		gbl_panel.rowHeights = new int[]{0};
		gbl_panel.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
	}

}
