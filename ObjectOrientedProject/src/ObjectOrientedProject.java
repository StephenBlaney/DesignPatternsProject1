import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

public class ObjectOrientedProject {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ObjectOrientedProject window = new ObjectOrientedProject();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ObjectOrientedProject() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblHelloworld = new JLabel("Welcome to hoilday planner home page ");
		lblHelloworld.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHelloworld.setForeground(Color.BLUE);
		lblHelloworld.setBackground(Color.WHITE);
		lblHelloworld.setBounds(78, 11, 272, 37);
		frame.getContentPane().add(lblHelloworld);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(121, 103, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(241, 103, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(121, 173, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(241, 173, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
	}
}
