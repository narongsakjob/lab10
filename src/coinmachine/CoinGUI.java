package coinmachine;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JProgressBar;

public class CoinGUI extends JFrame implements Observer{

	private JPanel contentPane;
	
	CoinMachine coinMachine ;
	private JLabel lblNewLabel_1;
	private JProgressBar progressBar;
	private JButton btnNewButton;
	private JButton button;

	/**
	 * Create the frame.
	 * @param coinMachine Inherited CoinMachine  from demo
	 * @param lblNewLabel_1 show your balance
	 * @param btnNewButton show your button 5 bath
	 * @param button show your button 1 bath
	 * @param JButton show your button 10 bath
	 * @param progressBar show your capacity count 
	 * 
	 */
	public CoinGUI(CoinMachine c) {
		coinMachine = c;
		setBounds(100, 100, 464, 277);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Balance : 0");
		lblNewLabel_1.setForeground(new Color(46, 139, 87));
		lblNewLabel_1.setFont(new Font("KufiStandardGK", Font.BOLD, 18));
		lblNewLabel_1.setBounds(39, 32, 110, 45);
		panel.add(lblNewLabel_1);
		
		btnNewButton = new JButton();
		btnNewButton.setIcon(new ImageIcon(CoinGUI.class.getResource("/images/5baht.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Coin fiveBaht = new Coin(5, "Baht");
				System.out.println("Insert five baht");
				coinMachine.insert(fiveBaht);
				
			}
		});
		btnNewButton.setBounds(167, 143, 131, 102);
		panel.add(btnNewButton);
		
		button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Coin oneBaht = new Coin(1, "Baht");
				System.out.println("Insert one baht");
				coinMachine.insert(oneBaht);
			}
		});
		button.setIcon(new ImageIcon(CoinGUI.class.getResource("/images/1baht.png")));
		button.setBounds(24, 143, 131, 102);
		panel.add(button);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Coin tenBaht = new Coin(10, "Baht");
				System.out.println("Insert ten baht");
				coinMachine.insert(tenBaht);
			}
		});
		button_1.setIcon(new ImageIcon(CoinGUI.class.getResource("/images/10baht.png")));
		button_1.setBounds(310, 143, 131, 101);
		panel.add(button_1);
		
		JLabel lblNewLabel = new JLabel("Insert Money");
		lblNewLabel.setBounds(28, 104, 110, 34);
		panel.add(lblNewLabel);
		
		
		
		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setMinimum(0);
		progressBar.setMaximum(coinMachine.getCapacity());
		progressBar.setBounds(247, 32, 150, 47);
		panel.add(progressBar);
		
		JLabel lblStatus = new JLabel("Status :");
		lblStatus.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblStatus.setBounds(167, 29, 68, 45);
		panel.add(lblStatus);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * @param text set a text from balance update
	 * @param lblNewLabel_1 update show your balance
	 * @param progressBar update progressBar
	 */
	@Override
	public void update(Observable o, Object arg) {
		String text = String.format("Balance : %d", coinMachine.getBalance());
		lblNewLabel_1.setText(text);
		progressBar.setString(Integer.toString(coinMachine.getCount()));
		progressBar.setValue(coinMachine.getCount());
		
	}

}
