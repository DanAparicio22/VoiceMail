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
	public JTextArea message;
	private String input;
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
	private Connection connection;
	/**
	 * Create the frame.
	 */
	public UITelephone() {
		initialize();
		this.setVisible(true);
	}
 
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 478, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		input1 = new JButton("1");
		input1.setFont(new Font("Dialog", Font.PLAIN, 20));
		input1.setBounds(62, 291, 50, 50);
		contentPane.add(input1);
		
		input2 = new JButton("2");
		input2.setFont(new Font("Dialog", Font.PLAIN, 20));
		input2.setBounds(134, 291, 50, 50);
		contentPane.add(input2);
		
		input3 = new JButton("3");
		input3.setFont(new Font("Dialog", Font.PLAIN, 20));
		input3.setBounds(208, 291, 50, 50);
		contentPane.add(input3);
		
		input4 = new JButton("4");
		input4.setFont(new Font("Dialog", Font.PLAIN, 20));
		input4.setBounds(62, 228, 50, 50);
		contentPane.add(input4);
		
		input5 = new JButton("5");
		input5.setFont(new Font("Dialog", Font.PLAIN, 20));
		input5.setBounds(134, 228, 50, 50);
		contentPane.add(input5);
		
		input6 = new JButton("6");
		input6.setFont(new Font("Dialog", Font.PLAIN, 20));
		input6.setBounds(208, 228, 50, 50);
		contentPane.add(input6);
		
		input7 = new JButton("7");
		input7.setFont(new Font("Dialog", Font.PLAIN, 20));
		input7.setBounds(62, 162, 50, 50);
		contentPane.add(input7);
		
		input8 = new JButton("8");
		input8.setFont(new Font("Dialog", Font.PLAIN, 20));
		input8.setBounds(134, 162, 50, 50);
		contentPane.add(input8);
		
		input9 = new JButton("9");
		input9.setFont(new Font("Dialog", Font.PLAIN, 20));
		input9.setBounds(208, 162, 50, 50);
		contentPane.add(input9);
		
		inputH = new JButton("Colgar");
		inputH.setActionCommand("H");
		inputH.setFont(new Font("Dialog", Font.PLAIN, 20));
		inputH.setBackground(Color.RED); 
		inputH.setBounds(302, 228, 118, 50);
		contentPane.add(inputH);
		
		inputHashtag = new JButton("Llamar #");
		inputHashtag.setActionCommand("#");
		 
		inputHashtag.setFont(new Font("Dialog", Font.PLAIN, 20));
		inputHashtag.setBackground(Color.GREEN);
		inputHashtag.setBounds(302, 162, 118, 50);
		contentPane.add(inputHashtag);
		
		inputQ = new JButton("Salir");
		inputQ.setActionCommand("Q");
		inputQ.setFont(new Font("Dialog", Font.PLAIN, 20));
		inputQ.setBackground(Color.GRAY);
		inputQ.setBounds(302, 291, 118, 50);
		contentPane.add(inputQ);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 24, 390, 114);
		contentPane.add(scrollPane);
		
		message = new JTextArea(4,10); 
		scrollPane.setViewportView(message);
		message.setFont(new Font("Tahoma", Font.PLAIN, 15));
		message.setBackground(Color.WHITE);
		message.setForeground(Color.BLUE);
		 
		input1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput("1");
			}
		});  
		input2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput("2");
			}
		});  
		input3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput("3");
			}
		});  
		input4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput("4");
			}
		});  
		input5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput("5");
			}
		});  
		input6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput("6");
			}
		});  
		input7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput("7");
			}
		});  
		input8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput("8");
			}
		});  
		input9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput("9");
				
			}
		});  
		inputH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput("h");
			}
		}); 
		inputHashtag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput("#");
			}
		}); 
		 
		inputQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);  
		    	dispose();
			}
		});   
	} 
	
	@Override
	public void Update(String message) { 
		this.message.setText(message); 
	}
	
	public void processInput(String input){  
		 
		//JOptionPane.showMessageDialog(null, "I am happy."); 
		boolean more = true;
	      while (more)
	      { 
	         if (input == null) return;
	         if (input.equalsIgnoreCase("H"))
	            this.connection.hangup();
	         else if (input.equalsIgnoreCase("Q")){
	            more = false; 
			     this.setVisible(false);  
			     this.dispose();
	         }else if (input.length() == 1
	            && "1234567890#".indexOf(input) >= 0)
	        	 this.connection.dial(input);
	         else
	        	 this.connection.record(input);
	      } 
	} 
	
	@Override
	public void run(Connection c) {
		this.connection=c;
		/*boolean more = true;
	      while (more)
	      {
	         String input = this.input;
	         if (input == null) return;
	         if (input.equalsIgnoreCase("H"))
	            c.hangup();
	         else if (input.equalsIgnoreCase("Q")){
	            more = false; 
			     this.setVisible(false);  
			     this.dispose();
	         }else if (input.length() == 1
	            && "1234567890#".indexOf(input) >= 0)
	            c.dial(input);
	         else
	            c.record(input);
	      }*/ 
	} 
}
