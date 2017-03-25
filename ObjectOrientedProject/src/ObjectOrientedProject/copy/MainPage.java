package ObjectOrientedProject.copy;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MainPage extends JFrame implements ActionListener {

	JButton button1 = new JButton("Dublin");
	JButton button2 = new JButton("Navan");
	JButton button3 = new JButton("Drogheda");
	JButton button4 = new JButton("Tralee");
	MainPage() {

		super("Welcome to the main page"); // Name of frame

		Container contentPane = getContentPane(); // Create ContentPane

		JPanel panel = new JPanel(); // creates panel

		JLabel label1 = new JLabel("Welcome to Hoilday Planner please select a destination !");

		Font fancyFont2 = new Font("Serif", Font.ITALIC, 22);
	
		Font font1 = new Font("Serif", Font.ITALIC, 22);

		Border thickBorder = new LineBorder(Color.black, 2);

		label1.setIcon(new ImageIcon("ITB logo.png"));

		label1.setForeground(new Color(0, 128, 0));

		// Add to panel
		panel.add(label1);

		button1.setBorder(thickBorder);
		button2.setBorder(thickBorder);
		button3.setBorder(thickBorder);
		button4.setBorder(thickBorder);

		// add fonts to panels
		label1.setFont(font1);
		button1.setFont(fancyFont2);
		button2.setFont(fancyFont2);
		button3.setFont(fancyFont2);
		button4.setFont(fancyFont2);

		// add buttons to panel
		panel.add(button1);
		button1.addActionListener(this);

		panel.add(button2);
		button2.addActionListener(this);

		panel.add(button3);
		button3.addActionListener(this);

		panel.add(button4);
		button4.addActionListener(this);

		// add grid layout
		panel.setLayout(new GridLayout(2, 4, 50, 50));

		// change the color of the panel to white
		panel.setBackground(Color.MAGENTA);

		// Set text to red on all buttons
		button1.setForeground(Color.RED);
		button2.setForeground(Color.RED);
		button3.setForeground(Color.RED);
		button4.setForeground(Color.RED);

		// Set background color of buttons to white
		button1.setBackground(Color.WHITE);
		button2.setBackground(Color.WHITE);
		button3.setBackground(Color.WHITE);
		button4.setBackground(Color.WHITE);

		// Add to content pane
		contentPane.add(label1, BorderLayout.NORTH);
		contentPane.add(panel);
		contentPane.setBackground(Color.white);

		setSize(500, 400); // set size of frame
		setVisible(true);

	}

	public static void main(String[] args) {
		MainPage mainPage = new MainPage();

		mainPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mainPage.setExtendedState(mainPage.getExtendedState() | JFrame.MAXIMIZED_BOTH);

	}// end of main method

	public void actionPerformed(ActionEvent e) {

		/**
		 * Action event on all buttons that brings the user to their their
		 * respective pages
		 */

		 {
			if (e.getActionCommand().equals("Dublin")) {
				Dublin nextframe = new Dublin();
				Dublin.getWindows(); // load next page
				nextframe.setExtendedState(nextframe.getExtendedState() | JFrame.MAXIMIZED_BOTH);
				dispose();
			}

			if (e.getActionCommand().equals("Navan")) {
				Navan nextframe = new Navan();
				nextframe.setExtendedState(nextframe.getExtendedState() | JFrame.MAXIMIZED_BOTH);
				Navan.getWindows();
				dispose();// load next page

			}

			if (e.getActionCommand().equals("Drogheda")) {
				Drogheda nextframe = new Drogheda();
				Drogheda.getWindows(); // load next page
				nextframe.setExtendedState(nextframe.getExtendedState() | JFrame.MAXIMIZED_BOTH);
				dispose();
			}

			if (e.getActionCommand().equals("Tralee")) {
				Tralee nextframe = new Tralee();
				Tralee.getWindows();
				nextframe.setExtendedState(nextframe.getExtendedState() | JFrame.MAXIMIZED_BOTH);
				dispose();

			}

		}
	}

}// end of class
