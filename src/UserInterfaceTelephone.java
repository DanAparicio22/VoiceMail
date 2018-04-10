import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.ScrollPane;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

 
public class UserInterfaceTelephone extends JFrame implements Telephone{

	private static final String KEY_CONFIRM = "#";
	private static final String KEY_HANG_UP = "h";
	private static final String KEY_NINE = "9";
	private static final String KEY_EIGHT = "8";
	private static final String KEY_SEVEN = "7";
	private static final String KEY_SIX = "6";
	private static final String KEY_FIVE = "5";
	private static final String KEY_FOUR = "4";
	private static final String KEY_THREE = "3";
	private static final String KEY_TWO = "2";
	private static final String KEY_ONE = "1";
	private static final String INPUT_EMPTY = "";
	private static final String HANG_UP = "H";
	private static final String QUIT_CONNECTION = "Q";
	private static final String KEYS_FOR_DIAL = "1234567890#";
	private static final int ZERO_COINCIDENCES = 0;
	private static final int LENGTH_ONE = 1;
	private JPanel contentPane;
	public JTextArea answerMessage; 
	private JButton inputConfirm;
	private JButton inputHangUp;
	private JButton inputQuitConnection; 
	private JButton inputKey1;
	private JButton inputKey2;
	private JButton inputKey3;
	private JButton inputKey4;
	private JButton inputKey5;
	private JButton inputKey6;
	private JButton inputKey7;
	private JButton inputKey8;
	private JButton inputKey9; 
	private JTextArea messageInput;
 
	public UserInterfaceTelephone(Connection connection) {
		initialize(connection);
		this.setVisible(true);
	}
 
	private void initialize(Connection connection) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 478, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		inputKey1 = new JButton(KEY_ONE);
		inputKey1.setFont(new Font("Dialog", Font.PLAIN, 20));
		inputKey1.setBounds(61, 317, 50, 50);
		contentPane.add(inputKey1);
		
		inputKey2 = new JButton(KEY_TWO);
		inputKey2.setFont(new Font("Dialog", Font.PLAIN, 20));
		inputKey2.setBounds(133, 317, 50, 50);
		contentPane.add(inputKey2);
		
		inputKey3 = new JButton(KEY_THREE);
		inputKey3.setFont(new Font("Dialog", Font.PLAIN, 20));
		inputKey3.setBounds(207, 317, 50, 50);
		contentPane.add(inputKey3);
		
		inputKey4 = new JButton(KEY_FOUR);
		inputKey4.setFont(new Font("Dialog", Font.PLAIN, 20));
		inputKey4.setBounds(61, 254, 50, 50);
		contentPane.add(inputKey4);
		
		inputKey5 = new JButton(KEY_FIVE);
		inputKey5.setFont(new Font("Dialog", Font.PLAIN, 20));
		inputKey5.setBounds(133, 254, 50, 50);
		contentPane.add(inputKey5);
		
		inputKey6 = new JButton(KEY_SIX);
		inputKey6.setFont(new Font("Dialog", Font.PLAIN, 20));
		inputKey6.setBounds(207, 254, 50, 50);
		contentPane.add(inputKey6);
		
		inputKey7 = new JButton(KEY_SEVEN);
		inputKey7.setFont(new Font("Dialog", Font.PLAIN, 20));
		inputKey7.setBounds(61, 188, 50, 50);
		contentPane.add(inputKey7);
		
		inputKey8 = new JButton(KEY_EIGHT);
		inputKey8.setFont(new Font("Dialog", Font.PLAIN, 20));
		inputKey8.setBounds(133, 188, 50, 50);
		contentPane.add(inputKey8);
		
		inputKey9 = new JButton(KEY_NINE);
		inputKey9.setFont(new Font("Dialog", Font.PLAIN, 20));
		inputKey9.setBounds(207, 188, 50, 50);
		contentPane.add(inputKey9);
		
		inputHangUp = new JButton("Hang up");
		inputHangUp.setActionCommand(HANG_UP);
		inputHangUp.setFont(new Font("Dialog", Font.BOLD, 15));
		inputHangUp.setBackground(Color.RED); 
		inputHangUp.setBounds(281, 254, 118, 50);
		contentPane.add(inputHangUp);
		
		inputConfirm = new JButton("Confirm #");
		inputConfirm.setActionCommand(KEY_CONFIRM);
		 
		inputConfirm.setFont(new Font("Dialog", Font.BOLD, 15));
		inputConfirm.setBackground(Color.GREEN);
		inputConfirm.setBounds(281, 188, 118, 50);
		contentPane.add(inputConfirm);
		
		inputQuitConnection = new JButton("Quit");
		inputQuitConnection.setActionCommand(QUIT_CONNECTION);
		inputQuitConnection.setFont(new Font("Dialog", Font.BOLD, 15));
		inputQuitConnection.setBackground(Color.GRAY);
		inputQuitConnection.setBounds(281, 317, 118, 50);
		contentPane.add(inputQuitConnection);
		
		JScrollPane scrollAnswerMessage = new JScrollPane();
		scrollAnswerMessage.setBounds(30, 45, 390, 128);
		contentPane.add(scrollAnswerMessage);
		
		answerMessage = new JTextArea(4,10);
		scrollAnswerMessage.setViewportView(answerMessage);
		answerMessage.setEditable(false);
		answerMessage.setFont(new Font("Tahoma", Font.PLAIN, 15));
		answerMessage.setBackground(Color.WHITE);
		answerMessage.setForeground(Color.BLUE);
		
		JScrollPane scrollMessageInput = new JScrollPane();
		scrollMessageInput.setBounds(30, 403, 390, 97);
		contentPane.add(scrollMessageInput);
		
		messageInput = new JTextArea(4, 10);
		scrollMessageInput.setViewportView(messageInput);
		messageInput.setForeground(Color.BLUE);
		messageInput.setFont(new Font("Tahoma", Font.PLAIN, 15));
		messageInput.setBackground(Color.WHITE);
		
		JLabel labelMessageInput = new JLabel("Write here your message.");
		labelMessageInput.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelMessageInput.setBounds(30, 378, 166, 21);
		contentPane.add(labelMessageInput);
		
		JLabel labelAnswer = new JLabel("Answer.");
		labelAnswer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelAnswer.setBounds(30, 21, 166, 21);
		contentPane.add(labelAnswer);
		 
		inputKey1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				processInput(connection,KEY_ONE);
			}
		});  
		inputKey2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(connection,KEY_TWO);
			}
		});  
		inputKey3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(connection,KEY_THREE);
			}
		});  
		inputKey4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(connection,KEY_FOUR);
			}
		});  
		inputKey5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(connection,KEY_FIVE);
			}
		});  
		inputKey6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(connection,KEY_SIX);
			}
		});  
		inputKey7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(connection,KEY_SEVEN);
			}
		});  
		inputKey8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(connection,KEY_EIGHT);
			}
		});  
		inputKey9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 processInput(connection,KEY_NINE);
				
			}
		});  
		inputHangUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				processInput(connection,KEY_HANG_UP);
			}
		}); 
		inputConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 processInput(connection,KEY_CONFIRM);
			}
		}); 
		 
		inputQuitConnection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quittingConnection();
			}
		});   
	} 
	
	@Override
	public void update(String message) { 
		setAnswerMessage(message); 
	}

	private void setAnswerMessage(String message) {
		this.answerMessage.setText(message);
	}
	
	public void processInput(Connection c,String input){  
		if(isNotEmptyMessageInput()){
				c.recordMessage(getMessageInput());
			}  
			if(isHangUp(input)){ 
				c.hangUp();
			} else if (isQuittingOfConnection(input)){ 
			     quittingConnection();
	         }else if(isDial(input)){
	        	 c.dial(input);
	         }
			  setMessageInput(INPUT_EMPTY);
	}
	
	private String getMessageInput() {
		return messageInput.getText();
	}
	
	private boolean isNotEmptyMessageInput() {
		return !getMessageInput().trim().isEmpty();
	} 

	public void setMessageInput(String newMessageInput) {
		messageInput.setText(newMessageInput);
	}


	private boolean isDial(String key) {
		return key.length() == LENGTH_ONE
		    && getCoincidencesInput(key) >= ZERO_COINCIDENCES;
	}

	private int getCoincidencesInput(String key) {
		return KEYS_FOR_DIAL.indexOf(key);
	}

	private void quittingConnection() {
		this.setVisible(false);  
		 this.dispose();
		 System.exit(0);
	}

	private boolean isQuittingOfConnection(String key) {
		return key.equalsIgnoreCase(QUIT_CONNECTION);
	}

	private boolean isHangUp(String key) {
		return key.equalsIgnoreCase(HANG_UP);
	}
}
