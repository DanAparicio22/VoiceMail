import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
 
public class UserInterfaceTelephone extends JFrame implements Telephone {

	private static final long serialVersionUID = 1L;
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
	private static final String EMPTY_INPUT = "";
	private static final String HANG_UP = "H";
	private static final String QUIT_CONNECTION = "Q";
	private JPanel contentPane;
	public JTextArea answerMessageTextArea; 
	private JButton buttonConfirm;
	private JButton buttonHangUp;
	private JButton buttonQuitConnection; 
	private JButton buttonOfNumber1;
	private JButton buttonOfNumber2;
	private JButton buttonOfNumber3;
	private JButton buttonOfNumber4;
	private JButton buttonOfNumber5;
	private JButton buttonOfNumber6;
	private JButton buttonOfNumber7;
	private JButton buttonOfNumber8;
	private JButton buttonOfNumber9;
	private JTextArea messageInputTextArea;
	private TelephoneService telephoneService;
 
	public UserInterfaceTelephone(TelephoneService telephoneService) {
		this.telephoneService = telephoneService;
		runConnection();
	}
 
	private void initialize() {
		generateContentPane();
		generateNumberButtonsForContentPane();
		generateHangUpButtonForContentPane();
		generateConfirmButtonForContentPane();
		generateQuitButtonForContentPane();		
		generateAnswerMessageTextAreaForContentPane();
		generateMessageTextAreaForContentPane();
		generateLabelMessageInputForContentPane();
		generateLabelAnswerForContentPane();
		giveActionToNumberButtons();
		giveActionToHangUpButton();
		giveActionToConfirmButton();
		giveActionToQuitButton();
	}
	
	@Override
	public void runConnection() {
		initialize();
		this.setVisible(true);
	}

	private void generateLabelMessageInputForContentPane() {
		JLabel labelMessageInput = new JLabel("Write here your message.");
		labelMessageInput.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelMessageInput.setBounds(30, 378, 166, 21);
		contentPane.add(labelMessageInput);
	}

	private void generateLabelAnswerForContentPane() {
		JLabel labelAnswer = new JLabel("Answer.");
		labelAnswer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelAnswer.setBounds(30, 21, 166, 21);
		contentPane.add(labelAnswer);
	}

	private void generateMessageTextAreaForContentPane() {
		JScrollPane scrollMessageInput = new JScrollPane();
		scrollMessageInput.setBounds(30, 403, 390, 97);
		contentPane.add(scrollMessageInput);
		messageInputTextArea = new JTextArea(4, 10);
		scrollMessageInput.setViewportView(messageInputTextArea);
		messageInputTextArea.setForeground(Color.BLUE);
		messageInputTextArea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		messageInputTextArea.setBackground(Color.WHITE);
	}

	private void generateAnswerMessageTextAreaForContentPane() {
		JScrollPane scrollAnswerMessage = new JScrollPane();
		scrollAnswerMessage.setBounds(30, 45, 390, 128);
		contentPane.add(scrollAnswerMessage);
		answerMessageTextArea = new JTextArea(4,10);
		scrollAnswerMessage.setViewportView(answerMessageTextArea);
		answerMessageTextArea.setEditable(false);
		answerMessageTextArea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		answerMessageTextArea.setBackground(Color.WHITE);
		answerMessageTextArea.setForeground(Color.BLUE);
	}

	private void giveActionToQuitButton() {
		buttonQuitConnection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quittingConnection();
			}
		});
	}

	private void giveActionToConfirmButton() {
		buttonConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 processInputOfButton(KEY_CONFIRM);
			}
		});
	}

	private void giveActionToHangUpButton() {
		buttonHangUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				processInputOfButton(KEY_HANG_UP);
			}
		});
	}

	private void giveActionToNumberButtons() {
		buttonOfNumber1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				processInputOfButton(KEY_ONE);
			}
		});  
		buttonOfNumber2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInputOfButton(KEY_TWO);
			}
		});  
		buttonOfNumber3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInputOfButton(KEY_THREE);
			}
		});  
		buttonOfNumber4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInputOfButton(KEY_FOUR);
			}
		});  
		buttonOfNumber5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInputOfButton(KEY_FIVE);
			}
		});  
		buttonOfNumber6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInputOfButton(KEY_SIX);
			}
		});  
		buttonOfNumber7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInputOfButton(KEY_SEVEN);
			}
		});  
		buttonOfNumber8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInputOfButton(KEY_EIGHT);
			}
		});  
		buttonOfNumber9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 processInputOfButton(KEY_NINE);
				
			}
		});
	}

	private void generateQuitButtonForContentPane() {
		buttonQuitConnection = new JButton("Quit");
		buttonQuitConnection.setActionCommand(QUIT_CONNECTION);
		buttonQuitConnection.setFont(new Font("Dialog", Font.BOLD, 15));
		buttonQuitConnection.setBackground(Color.GRAY);
		buttonQuitConnection.setBounds(281, 317, 118, 50);
		contentPane.add(buttonQuitConnection);
	}

	private void generateConfirmButtonForContentPane() {
		buttonConfirm = new JButton("Confirm #");
		buttonConfirm.setActionCommand(KEY_CONFIRM);
		buttonConfirm.setFont(new Font("Dialog", Font.BOLD, 15));
		buttonConfirm.setBackground(Color.GREEN);
		buttonConfirm.setBounds(281, 188, 118, 50);
		contentPane.add(buttonConfirm);
	}

	private void generateHangUpButtonForContentPane() {
		buttonHangUp = new JButton("Hang up");
		buttonHangUp.setActionCommand(HANG_UP);
		buttonHangUp.setFont(new Font("Dialog", Font.BOLD, 15));
		buttonHangUp.setBackground(Color.RED); 
		buttonHangUp.setBounds(281, 254, 118, 50);
		contentPane.add(buttonHangUp);
	}

	private void generateNumberButtonsForContentPane() {
		buttonOfNumber1 = new JButton(KEY_ONE);
		buttonOfNumber1.setFont(new Font("Dialog", Font.PLAIN, 20));
		buttonOfNumber1.setBounds(61, 317, 50, 50);
		contentPane.add(buttonOfNumber1);
		buttonOfNumber2 = new JButton(KEY_TWO);
		buttonOfNumber2.setFont(new Font("Dialog", Font.PLAIN, 20));
		buttonOfNumber2.setBounds(133, 317, 50, 50);
		contentPane.add(buttonOfNumber2);
		buttonOfNumber3 = new JButton(KEY_THREE);
		buttonOfNumber3.setFont(new Font("Dialog", Font.PLAIN, 20));
		buttonOfNumber3.setBounds(207, 317, 50, 50);
		contentPane.add(buttonOfNumber3);
		buttonOfNumber4 = new JButton(KEY_FOUR);
		buttonOfNumber4.setFont(new Font("Dialog", Font.PLAIN, 20));
		buttonOfNumber4.setBounds(61, 254, 50, 50);
		contentPane.add(buttonOfNumber4);
		buttonOfNumber5 = new JButton(KEY_FIVE);
		buttonOfNumber5.setFont(new Font("Dialog", Font.PLAIN, 20));
		buttonOfNumber5.setBounds(133, 254, 50, 50);
		contentPane.add(buttonOfNumber5);
		buttonOfNumber6 = new JButton(KEY_SIX);
		buttonOfNumber6.setFont(new Font("Dialog", Font.PLAIN, 20));
		buttonOfNumber6.setBounds(207, 254, 50, 50);
		contentPane.add(buttonOfNumber6);
		buttonOfNumber7 = new JButton(KEY_SEVEN);
		buttonOfNumber7.setFont(new Font("Dialog", Font.PLAIN, 20));
		buttonOfNumber7.setBounds(61, 188, 50, 50);
		contentPane.add(buttonOfNumber7);
		buttonOfNumber8 = new JButton(KEY_EIGHT);
		buttonOfNumber8.setFont(new Font("Dialog", Font.PLAIN, 20));
		buttonOfNumber8.setBounds(133, 188, 50, 50);
		contentPane.add(buttonOfNumber8);
		buttonOfNumber9 = new JButton(KEY_NINE);
		buttonOfNumber9.setFont(new Font("Dialog", Font.PLAIN, 20));
		buttonOfNumber9.setBounds(207, 188, 50, 50);
		contentPane.add(buttonOfNumber9);
	}

	private void generateContentPane() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 478, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	} 
	
	@Override
	public void updateMessage(String message) {
		setAnswerMessage(message);
	}

	private void setAnswerMessage(String message) {
		this.answerMessageTextArea.setText(message);
	}
	
	public void processInputOfButton(String input) {
		if(isNotEmptyMessageInput()) {
			telephoneService.processInput(getMessageInput());
		}
		telephoneService.processInput(input);
		setMessageInput(EMPTY_INPUT);
	}
	
	private String getMessageInput() {
		return messageInputTextArea.getText();
	}
	
	private boolean isNotEmptyMessageInput() {
		return !getMessageInput().trim().isEmpty();
	} 

	public void setMessageInput(String newMessageInput) {
		messageInputTextArea.setText(newMessageInput);
	}

	private void quittingConnection() {
		this.setVisible(false);  
		this.dispose();
		System.exit(0);
	}

}
