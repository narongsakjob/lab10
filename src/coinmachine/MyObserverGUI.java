package coinmachine;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

public class MyObserverGUI extends JFrame implements Observer{

	private JPanel contentPane;
	private JTextField textField;
	CoinMachine coinMachine;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * @param coinMachine Inherited CoinMachine  from demo
	 * @param textField show your count capacity
	 */
	public MyObserverGUI(CoinMachine c) {
		coinMachine =c;
		setBounds(100, 100, 281, 160);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("#Coins:");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblNewLabel.setBounds(6, 17, 91, 40);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Accepting Coins");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		lblNewLabel_1.setForeground(new Color(102, 255, 0));
		lblNewLabel_1.setBounds(6, 69, 259, 53);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		textField.setBounds(99, 6, 154, 68);
		panel.add(textField);
		textField.setColumns(10);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * textField update your textField
	 */
	@Override
	public void update(Observable o, Object arg) {
		textField.setText(Integer.toString(coinMachine.getCount()));
		
	}
}
