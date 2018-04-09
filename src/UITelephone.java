import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class UITelephone extends JFrame implements CommunicationDevice {

	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	public JTextArea message;
	private JButton inputHashValue;
	private JButton inputHangUp;
	private JButton inputQuit; 
	private JButton input1;
	private JButton input2;
	private JButton input3;
	private JButton input4;
	private JButton input5;
	private JButton input6;
	private JButton input7;
	private JButton input8;
	private JButton input9;
	private JButton input0;
	private JButton inputA;
	private JButton inputB;
	private JButton inputC;
	private JButton inputD;
	private JButton inputE;
	private JButton inputF;
	private JButton inputG;
	private JButton inputH;
	private JButton inputI;
	private JButton inputJ;
	private JButton inputK;
	private JButton inputL;
	private JButton inputM;
	private JButton inputN;
	private JButton inputO;
	private JButton inputP;
	private JButton inputQ;
	private JButton inputR;
	private JButton inputS;
	private JButton inputT;
	private JButton inputU;
	private JButton inputV;
	private JButton inputW;
	private JButton inputX;
	private JButton inputY;
	private JButton inputZ;
	private JButton inputa;
	private JButton inputb;
	private JButton inputc;
	private JButton inputd;
	private JButton inpute;
	private JButton inputf;
	private JButton inputg;
	private JButton inputh;
	private JButton inputi;
	private JButton inputj;
	private JButton inputk;
	private JButton inputl;
	private JButton inputm;
	private JButton inputn;
	private JButton inputo;
	private JButton inputp;
	private JButton inputq;
	private JButton inputr;
	private JButton inputs;
	private JButton inputt;
	private JButton inputu;
	private JButton inputv;
	private JButton inputw;
	private JButton inputx;
	private JButton inputy;
	private JButton inputz;
	private JButton inputShift;
	private JButton inputEnter;
	private boolean caseLetter = false;
	
	public UITelephone(Connection connection) {
		initialize(connection);
		this.setVisible(true);
	}
	
	private void initialize(Connection c) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 570, 500);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		input1 = new JButton("1");
		input1.setFont(new Font("Dialog", Font.BOLD, 20));
		input1.setBounds(50, 150, 45, 45);
		contentPanel.add(input1);
		input2 = new JButton("2");
		input2.setFont(new Font("Dialog", Font.BOLD, 20));
		input2.setBounds(95, 150, 45, 45);
		contentPanel.add(input2);
		input3 = new JButton("3");
		input3.setFont(new Font("Dialog", Font.BOLD, 20));
		input3.setBounds(140, 150, 45, 45);
		contentPanel.add(input3);
		input4 = new JButton("4");
		input4.setFont(new Font("Dialog", Font.BOLD, 20));
		input4.setBounds(185, 150, 45, 45);
		contentPanel.add(input4);
		input5 = new JButton("5");
		input5.setFont(new Font("Dialog", Font.BOLD, 20));
		input5.setBounds(230, 150, 45, 45);
		contentPanel.add(input5);
		input6 = new JButton("6");
		input6.setFont(new Font("Dialog", Font.BOLD, 20));
		input6.setBounds(275, 150, 45, 45);
		contentPanel.add(input6);
		input7 = new JButton("7");
		input7.setFont(new Font("Dialog", Font.BOLD, 20));
		input7.setBounds(320, 150, 45, 45);
		contentPanel.add(input7);
		input8 = new JButton("8");
		input8.setFont(new Font("Dialog", Font.BOLD, 20));
		input8.setBounds(365, 150, 45, 45);
		contentPanel.add(input8);
		input9 = new JButton("9");
		input9.setFont(new Font("Dialog", Font.BOLD, 20));
		input9.setBounds(410, 150, 45, 45);
		contentPanel.add(input9);
		input0 = new JButton("0");
		input0.setFont(new Font("Dialog", Font.BOLD, 20));
		input0.setBounds(455, 150, 45, 45);
		contentPanel.add(input0);
		
		inputa = new JButton("a");
		inputa.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputa.setBounds(50, 195, 45, 45);
		contentPanel.add(inputa);
		inputb = new JButton("b");
		inputb.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputb.setBounds(95, 195, 45, 45);
		contentPanel.add(inputb);
		inputc = new JButton("c");
		inputc.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputc.setBounds(140, 195, 45, 45);
		contentPanel.add(inputc);
		inputd = new JButton("d");
		inputd.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputd.setBounds(185, 195, 45, 45);
		contentPanel.add(inputd);
		inpute = new JButton("e");
		inpute.setFont(new Font("Dialog", Font.PLAIN, 15));
		inpute.setBounds(230, 195, 45, 45);
		contentPanel.add(inpute);
		inputf = new JButton("f");
		inputf.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputf.setBounds(275, 195, 45, 45);
		contentPanel.add(inputf);
		inputg = new JButton("g");
		inputg.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputg.setBounds(320, 195, 45, 45);
		contentPanel.add(inputg);
		inputh = new JButton("h");
		inputh.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputh.setBounds(365, 195, 45, 45);
		contentPanel.add(inputh);
		inputi = new JButton("i");
		inputi.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputi.setBounds(410, 195, 45, 45);
		contentPanel.add(inputi);
		inputj = new JButton("j");
		inputj.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputj.setBounds(455, 195, 45, 45);
		contentPanel.add(inputj);
		inputk = new JButton("k");
		inputk.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputk.setBounds(50, 240, 45, 45);
		contentPanel.add(inputk);
		inputl = new JButton("l");
		inputl.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputl.setBounds(95, 240, 45, 45);
		contentPanel.add(inputl);
		inputm = new JButton("m");
		inputm.setFont(new Font("Dialog", Font.PLAIN, 12));
		inputm.setBounds(140, 240, 45, 45);
		contentPanel.add(inputm);
		inputn = new JButton("n");
		inputn.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputn.setBounds(185, 240, 45, 45);
		contentPanel.add(inputn);
		inputo = new JButton("o");
		inputo.setFont(new Font("Dialog", Font.PLAIN, 14));
		inputo.setBounds(230, 240, 45, 45);
		contentPanel.add(inputo);
		inputp = new JButton("p");
		inputp.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputp.setBounds(275, 240, 45, 45);
		contentPanel.add(inputp);
		inputq = new JButton("q");
		inputq.setFont(new Font("Dialog", Font.PLAIN, 14));
		inputq.setBounds(320, 240, 45, 45);
		contentPanel.add(inputq);
		inputr = new JButton("r");
		inputr.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputr.setBounds(365, 240, 45, 45);
		contentPanel.add(inputr);
		inputs = new JButton("s");
		inputs.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputs.setBounds(410, 240, 45, 45);
		contentPanel.add(inputs);
		inputt = new JButton("t");
		inputt.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputt.setBounds(455, 240, 45, 45);
		contentPanel.add(inputt);
		inputu = new JButton("u");
		inputu.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputu.setBounds(50, 285, 45, 45);
		contentPanel.add(inputu);
		inputv = new JButton("v");
		inputv.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputv.setBounds(95, 285, 45, 45);
		contentPanel.add(inputv);
		inputw = new JButton("w");
		inputw.setFont(new Font("Dialog", Font.PLAIN, 12));
		inputw.setBounds(140, 285, 45, 45);
		contentPanel.add(inputw);
		inputx = new JButton("x");
		inputx.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputx.setBounds(185, 285, 45, 45);
		contentPanel.add(inputx);
		inputy = new JButton("y");
		inputy.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputy.setBounds(230, 285, 45, 45);
		contentPanel.add(inputy);
		inputz = new JButton("z");
		inputz.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputz.setBounds(275, 285, 45, 45);
		contentPanel.add(inputz);
		
		inputA = new JButton("A");
		inputA.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputA.setBounds(50, 195, 45, 45);
		contentPanel.add(inputA);
		inputB = new JButton("B");
		inputB.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputB.setBounds(95, 195, 45, 45);
		contentPanel.add(inputB);
		inputC = new JButton("C");
		inputC.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputC.setBounds(140, 195, 45, 45);
		contentPanel.add(inputC);
		inputD = new JButton("D");
		inputD.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputD.setBounds(185, 195, 45, 45);
		contentPanel.add(inputD);
		inputE = new JButton("E");
		inputE.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputE.setBounds(230, 195, 45, 45);
		contentPanel.add(inputE);
		inputF = new JButton("F");
		inputF.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputF.setBounds(275, 195, 45, 45);
		contentPanel.add(inputF);
		inputG = new JButton("G");
		inputG.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputG.setBounds(320, 195, 45, 45);
		contentPanel.add(inputG);
		inputH = new JButton("H");
		inputH.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputH.setBounds(365, 195, 45, 45);
		contentPanel.add(inputH);
		inputI = new JButton("I");
		inputI.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputI.setBounds(410, 195, 45, 45);
		contentPanel.add(inputI);
		inputJ = new JButton("J");
		inputJ.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputJ.setBounds(455, 195, 45, 45);
		contentPanel.add(inputJ);
		inputK = new JButton("K");
		inputK.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputK.setBounds(50, 240, 45, 45);
		contentPanel.add(inputK);
		inputL = new JButton("L");
		inputL.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputL.setBounds(95, 240, 45, 45);
		contentPanel.add(inputL);
		inputM = new JButton("M");
		inputM.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputM.setBounds(140, 240, 45, 45);
		contentPanel.add(inputM);
		inputN = new JButton("N");
		inputN.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputN.setBounds(185, 240, 45, 45);
		contentPanel.add(inputN);
		inputO = new JButton("O");
		inputO.setFont(new Font("Dialog", Font.PLAIN, 14));
		inputO.setBounds(230, 240, 45, 45);
		contentPanel.add(inputO);
		inputP = new JButton("P");
		inputP.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputP.setBounds(275, 240, 45, 45);
		contentPanel.add(inputP);
		inputQ = new JButton("Q");
		inputQ.setFont(new Font("Dialog", Font.PLAIN, 14));
		inputQ.setBounds(320, 240, 45, 45);
		contentPanel.add(inputQ);
		inputR = new JButton("R");
		inputR.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputR.setBounds(365, 240, 45, 45);
		contentPanel.add(inputR);
		inputS = new JButton("S");
		inputS.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputS.setBounds(410, 240, 45, 45);
		contentPanel.add(inputS);
		inputT = new JButton("T");
		inputT.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputT.setBounds(455, 240, 45, 45);
		contentPanel.add(inputT);
		inputU = new JButton("U");
		inputU.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputU.setBounds(50, 285, 45, 45);
		contentPanel.add(inputU);
		inputV = new JButton("V");
		inputV.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputV.setBounds(95, 285, 45, 45);
		contentPanel.add(inputV);
		inputW = new JButton("W");
		inputW.setFont(new Font("Dialog", Font.PLAIN, 12));
		inputW.setBounds(140, 285, 45, 45);
		contentPanel.add(inputW);
		inputX = new JButton("X");
		inputX.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputX.setBounds(185, 285, 45, 45);
		contentPanel.add(inputX);
		inputY = new JButton("Y");
		inputY.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputY.setBounds(230, 285, 45, 45);
		contentPanel.add(inputY);
		inputZ = new JButton("Z");
		inputZ.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputZ.setBounds(275, 285, 45, 45);
		contentPanel.add(inputZ);
		
		changeCharactersToMay();
		
		inputShift = new JButton("A - a");
		inputShift.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputShift.setBounds(320, 285, 90, 45);
		contentPanel.add(inputShift);
		inputHashValue = new JButton("#");
		inputHashValue.setActionCommand("#");
		inputHashValue.setFont(new Font("Dialog", Font.PLAIN, 20));
		inputHashValue.setBackground(Color.GREEN);
		inputHashValue.setBounds(410, 285, 45, 45);
		contentPanel.add(inputHashValue);
		inputEnter = new JButton("Enter");
		inputEnter.setFont(new Font("Dialog", Font.PLAIN, 15));
		inputEnter.setBounds(455, 285, 45, 45);
		contentPanel.add(inputEnter);
		
		inputHangUp = new JButton("Colgar");
		inputHangUp.setActionCommand("H");
		inputHangUp.setFont(new Font("Dialog", Font.PLAIN, 20));
		inputHangUp.setBackground(Color.RED); 
		inputHangUp.setBounds(50, 350, 135, 50);
		contentPanel.add(inputHangUp);
		
		inputQuit = new JButton("Salir");
		inputQuit.setActionCommand("Q");
		inputQuit.setFont(new Font("Dialog", Font.PLAIN, 20));
		inputQuit.setBackground(Color.GRAY);
		inputQuit.setBounds(365, 350, 135, 50);
		contentPanel.add(inputQuit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 24, 450, 114);
		contentPanel.add(scrollPane);
		
		message = new JTextArea(20,20);
		message.setEditable(false);
		scrollPane.setViewportView(message);
		message.setFont(new Font("Tahoma", Font.PLAIN, 20));
		message.setBackground(Color.WHITE);
		message.setForeground(Color.BLUE);
		 
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
		input0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"0");
				
			}
		});
		inputA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"A");
				
			}
		});
		inputB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"B");
				
			}
		});
		inputC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"C");
				
			}
		});
		inputD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"D");
				
			}
		});
		inputE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"E");
				
			}
		});
		inputF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"F");
				
			}
		});
		inputG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"G");
				
			}
		});
		inputH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"H");
				
			}
		});
		inputI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"I");
				
			}
		});
		inputJ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"J");
				
			}
		});
		inputK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"K");
				
			}
		});
		inputL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"L");
				
			}
		});
		inputM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"M");
				
			}
		});
		inputN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"N");
				
			}
		});
		inputO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"O");
				
			}
		});
		inputP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"P");
				
			}
		});
		inputQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"Q");
				
			}
		});
		inputR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"R");
				
			}
		});
		inputS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"S");
				
			}
		});
		inputT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"T");
				
			}
		});
		inputU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"U");
				
			}
		});
		inputV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"V");
				
			}
		});
		inputW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"W");
				
			}
		});
		inputX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"X");
				
			}
		});
		inputY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"Y");
				
			}
		});
		inputZ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"Z");
				
			}
		});
		
		inputa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"a");
				
			}
		});
		inputb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"b");
				
			}
		});
		inputc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"c");
				
			}
		});
		inputd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"d");
				
			}
		});
		inpute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"e");
				
			}
		});
		inputf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"f");
				
			}
		});
		inputg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"g");
				
			}
		});
		inputh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"h");
				
			}
		});
		inputi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"i");
				
			}
		});
		inputj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"j");
				
			}
		});
		inputk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"k");
				
			}
		});
		inputl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"l");
				
			}
		});
		inputm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"m");
				
			}
		});
		inputn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"n");
				
			}
		});
		inputo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"o");
				
			}
		});
		inputp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"p");
				
			}
		});
		inputq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"q");
				
			}
		});
		inputr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"r");
				
			}
		});
		inputs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"s");
				
			}
		});
		inputt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"t");
				
			}
		});
		inputu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"u");
				
			}
		});
		inputv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"v");
				
			}
		});
		inputw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"w");
				
			}
		});
		inputx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"x");
				
			}
		});
		inputy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"y");
				
			}
		});
		inputz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"z");
				
			}
		});
		
		inputEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"\n");
				
			}
		});
		
		inputHangUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"H");
			}
		}); 
		inputHashValue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processInput(c,"#");
			}
		}); 
		 
		inputQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);  
		    	dispose();
		    	System.exit(0);
			}
		});
		inputShift.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (caseLetter) {
					changeCharactersToMay();
					caseLetter = false;
				} else {
					changeCharactersToMin();
					caseLetter = true;
				}
			}
		});
	}
	
	public void changeCharactersToMin() {
		inputA.setVisible(false);
		inputB.setVisible(false);
		inputC.setVisible(false);
		inputD.setVisible(false);
		inputE.setVisible(false);
		inputF.setVisible(false);
		inputG.setVisible(false);
		inputH.setVisible(false);
		inputI.setVisible(false);
		inputJ.setVisible(false);
		inputK.setVisible(false);
		inputL.setVisible(false);
		inputM.setVisible(false);
		inputN.setVisible(false);
		inputO.setVisible(false);
		inputP.setVisible(false);
		inputQ.setVisible(false);
		inputR.setVisible(false);
		inputS.setVisible(false);
		inputT.setVisible(false);
		inputU.setVisible(false);
		inputV.setVisible(false);
		inputW.setVisible(false);
		inputX.setVisible(false);
		inputY.setVisible(false);
		inputZ.setVisible(false);
		inputa.setVisible(true);
		inputb.setVisible(true);
		inputc.setVisible(true);
		inputd.setVisible(true);
		inpute.setVisible(true);
		inputf.setVisible(true);
		inputg.setVisible(true);
		inputh.setVisible(true);
		inputi.setVisible(true);
		inputj.setVisible(true);
		inputk.setVisible(true);
		inputl.setVisible(true);
		inputm.setVisible(true);
		inputn.setVisible(true);
		inputo.setVisible(true);
		inputp.setVisible(true);
		inputq.setVisible(true);
		inputr.setVisible(true);
		inputs.setVisible(true);
		inputt.setVisible(true);
		inputu.setVisible(true);
		inputv.setVisible(true);
		inputw.setVisible(true);
		inputz.setVisible(true);
		inputy.setVisible(true);
		inputz.setVisible(true);
	}
	
	public void changeCharactersToMay() {
		inputA.setVisible(true);
		inputB.setVisible(true);
		inputC.setVisible(true);
		inputD.setVisible(true);
		inputE.setVisible(true);
		inputF.setVisible(true);
		inputG.setVisible(true);
		inputH.setVisible(true);
		inputI.setVisible(true);
		inputJ.setVisible(true);
		inputK.setVisible(true);
		inputL.setVisible(true);
		inputM.setVisible(true);
		inputN.setVisible(true);
		inputO.setVisible(true);
		inputP.setVisible(true);
		inputQ.setVisible(true);
		inputR.setVisible(true);
		inputS.setVisible(true);
		inputT.setVisible(true);
		inputU.setVisible(true);
		inputV.setVisible(true);
		inputW.setVisible(true);
		inputX.setVisible(true);
		inputY.setVisible(true);
		inputZ.setVisible(true);
		inputa.setVisible(false);
		inputb.setVisible(false);
		inputc.setVisible(false);
		inputd.setVisible(false);
		inpute.setVisible(false);
		inputf.setVisible(false);
		inputg.setVisible(false);
		inputh.setVisible(false);
		inputi.setVisible(false);
		inputj.setVisible(false);
		inputk.setVisible(false);
		inputl.setVisible(false);
		inputm.setVisible(false);
		inputn.setVisible(false);
		inputo.setVisible(false);
		inputp.setVisible(false);
		inputq.setVisible(false);
		inputr.setVisible(false);
		inputs.setVisible(false);
		inputt.setVisible(false);
		inputu.setVisible(false);
		inputv.setVisible(false);
		inputw.setVisible(false);
		inputz.setVisible(false);
		inputy.setVisible(false);
		inputz.setVisible(false);
	}
	
	@Override
	public void updateDevice(String message) {
		this.message.setText(message+'\n'); 
	}

	@Override
	public void runConnection(Connection connection) {
		// TODO Auto-generated method stub
		
	}
	
	public void processInput(Connection c,String input){  
		this.message.setText(this.message.getText()+input);
		if (input.isEmpty()) {
       	 return;
        }
	         if (input.equalsIgnoreCase("H"))
	             c.hangUp();
	         else if (input.equalsIgnoreCase("Q")){ 
			     this.setVisible(false);  
			     this.dispose();
	         }else if (input.length() == 1
	            && "1234567890#".indexOf(input) >= 0)
	        	 c.dial(input);
	         else
	        	 c.recordMessage(input);
	} 

}
