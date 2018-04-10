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

public class UITelephone extends JFrame implements Observer{

	private JPanel contentPane;
	public JTextArea notification; 
	private JButton inputHashtag;
	private JButton inputH;
	private JButton inputQ; 
	private JButton input1;
	private JButton input2;
	private JButton input3;
	private JButton input4;
	private JButton input5;
	private JButton input6;
	private JButton input7;
	private JButton input8;
	private JButton input9; 
	private JTextArea inputTextArea;
 
	public UITelephone(Connection c) {
		initialize(c);
		this.setVisible(true);
	}
 
	private void initialize(Connection c) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 478, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		input1 = new JButton("1");
		input1.setFont(new Font("Dialog", Font.PLAIN, 20));
		input1.setBounds(61, 317, 50, 50);
		contentPane.add(input1);
		
		input2 = new JButton("2");
		input2.setFont(new Font("Dialog", Font.PLAIN, 20));
		input2.setBounds(133, 317, 50, 50);
		contentPane.add(input2);
		
		input3 = new JButton("3");
		input3.setFont(new Font("Dialog", Font.PLAIN, 20));
		input3.setBounds(207, 317, 50, 50);
		contentPane.add(input3);
		
		input4 = new JButton("4");
		input4.setFont(new Font("Dialog", Font.PLAIN, 20));
		input4.setBounds(61, 254, 50, 50);
		contentPane.add(input4);
		
		input5 = new JButton("5");
		input5.setFont(new Font("Dialog", Font.PLAIN, 20));
		input5.setBounds(133, 254, 50, 50);
		contentPane.add(input5);
		
		input6 = new JButton("6");
		input6.setFont(new Font("Dialog", Font.PLAIN, 20));
		input6.setBounds(207, 254, 50, 50);
		contentPane.add(input6);
		
		input7 = new JButton("7");
		input7.setFont(new Font("Dialog", Font.PLAIN, 20));
		input7.setBounds(61, 188, 50, 50);
		contentPane.add(input7);
		
		input8 = new JButton("8");
		input8.setFont(new Font("Dialog", Font.PLAIN, 20));
		input8.setBounds(133, 188, 50, 50);
		contentPane.add(input8);
		
		input9 = new JButton("9");
		input9.setFont(new Font("Dialog", Font.PLAIN, 20));
		input9.setBounds(207, 188, 50, 50);
		contentPane.add(input9);
		
		inputH = new JButton("Colgar");
		inputH.setActionCommand("H");
		inputH.setFont(new Font("Dialog", Font.BOLD, 15));
		inputH.setBackground(Color.RED); 
		inputH.setBounds(281, 254, 118, 50);
		contentPane.add(inputH);
		
		inputHashtag = new JButton("Confirmar #");
		inputHashtag.setActionCommand("#");
		 
		inputHashtag.setFont(new Font("Dialog", Font.BOLD, 15));
		inputHashtag.setBackground(Color.GREEN);
		inputHashtag.setBounds(281, 188, 118, 50);
		contentPane.add(inputHashtag);
		
		inputQ = new JButton("Salir");
		inputQ.setActionCommand("Q");
		inputQ.setFont(new Font("Dialog", Font.BOLD, 15));
		inputQ.setBackground(Color.GRAY);
		inputQ.setBounds(281, 317, 118, 50);
		contentPane.add(inputQ);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 45, 390, 128);
		contentPane.add(scrollPane);
		
		notification = new JTextArea(4,10);
		scrollPane.setViewportView(notification);
		notification.setEditable(false);
		notification.setFont(new Font("Tahoma", Font.PLAIN, 15));
		notification.setBackground(Color.WHITE);
		notification.setForeground(Color.BLUE);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(30, 403, 390, 97);
		contentPane.add(scrollPane_1);
		
		inputTextArea = new JTextArea(4, 10);
		scrollPane_1.setViewportView(inputTextArea);
		inputTextArea.setForeground(Color.BLUE);
		inputTextArea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		inputTextArea.setBackground(Color.WHITE);
		
		JLabel labelSend = new JLabel("Escribe aqui tu mensaje");
		labelSend.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelSend.setBounds(30, 378, 166, 21);
		contentPane.add(labelSend);
		
		JLabel labelAnswer = new JLabel("Respuesta");
		labelAnswer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelAnswer.setBounds(30, 21, 166, 21);
		contentPane.add(labelAnswer);
		 
		input1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				processInput(c,"1");
			}
		});  
		input2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"2");
			}
		});  
		input3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"3");
			}
		});  
		input4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"4");
			}
		});  
		input5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"5");
			}
		});  
		input6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"6");
			}
		});  
		input7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"7");
			}
		});  
		input8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"8");
			}
		});  
		input9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 processInput(c,"9");
				
			}
		});  
		inputH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				processInput(c,"h");
			}
		}); 
		inputHashtag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 processInput(c,"#");
			}
		}); 
		 
		inputQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);  
		    	dispose();
		    	System.exit(0);
			}
		});   
	} 
	
	@Override
	public void update(String message) { 
		this.notification.setText(message+'\n'); 
	}
	
	public void processInput(Connection c,String key){   
			if(!inputTextArea.getText().trim().isEmpty()){
				c.recordMessage(inputTextArea.getText());
			}  
			if(key.equalsIgnoreCase("H")){ 
				c.hangUp();
			} else if (key.equalsIgnoreCase("Q")){ 
			     this.setVisible(false);  
			     this.dispose();
			     System.exit(0);
	         }else if(key.length() == 1
	            && "1234567890#".indexOf(key) >= 0){
	        	 c.dial(key);
	         }
			inputTextArea.setText("");
	} 
}
