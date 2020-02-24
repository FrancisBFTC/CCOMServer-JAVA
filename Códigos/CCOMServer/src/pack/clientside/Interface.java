package pack.clientside;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
  
  
public class Interface extends JFrame{
       
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private String computerName = "default";
		private String ipName = "0.0.0.0";
		private String portName = "null";
		private String computerMemorys = "";
		private JFrame[] frameTime = new JFrame[100];
		private JFrame[] comFrame = new JFrame[100];
		private JLabel[] labelComFrame = new JLabel[100];
		private JTextField[] ccomFieldArray = new JTextField[1000];
		private JEditorPane[] editorPane = new JEditorPane[100];
		private JScrollPane[] scrollPane = new JScrollPane[100];
		private JLabel[] setCcom = new JLabel[1000];
		private JButton[] ccomButton = new JButton[100];
		private JLabel[] divs = new JLabel[100];
		private JLabel[] nameComp = new JLabel[100];
		private JButton[] Send = new JButton[100];
		private JButton[] block = new JButton[100];
		private JButton[] runtime = new JButton[100];
		private JButton[] Comunication = new JButton[100];
		private JLabel[] labelTime = new JLabel[100];
		private JLabel[] Min = new JLabel[100];
		private JTextField[] minField = new JTextField[100];
		private JButton[] Program = new JButton[100];
		private int i = 0;
		private int i1 = 0;
		private boolean lastField = false;
		private int adds = 0;
		private int y = 0;
		private int a = 0;
		private String ipText = "";
		private String nameCompText = "";
		private String portText = "";
		private String Mensage = "";
		private String cmdIp = "";
		private String cmdPort = "";
		private JLabel panel5;
		private int Values = 170;
		public Interface() throws IOException {
        	 
        	
        	 
        	 this.setBounds(400, 200, 600, 500);
        	
        	 ImageIcon image = new ImageIcon(this.getClass().getResource("/pack/image/Cadeado.jpg"));
      		image.setImage(image.getImage().getScaledInstance(50, 50, 100));

        	 this.setIconImage(image.getImage());
        	 JLabel panel2 = new JLabel();
             panel2.setText("<html><div style='width:600;height:500;background:black;'></div></html>");
             panel2.setBounds(0, 0, 600, 500);
             this.add(panel2);
             this.setTitle("CCOM Server Interface");
             this.setResizable(true);
             
             this.addWindowListener(new WindowListener() {
				
				@Override
				public void windowOpened(WindowEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void windowIconified(WindowEvent arg0) {}
				
				@Override
				public void windowDeiconified(WindowEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void windowDeactivated(WindowEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void windowClosing(WindowEvent arg0) {
					
					if(JOptionPane.showConfirmDialog(null, "Deseja deslogar da CCOM Server?", "Deslogando", JOptionPane.WARNING_MESSAGE) == JOptionPane.OK_OPTION){
						int n = 1;
						while(n <= adds){
							if(comFrame[n] != null){
								comFrame[n].setVisible(false);
							}
							
							n = n + 1;
						}
						
						n = 0;
						while(n <= adds){
							if(frameTime[n] != null){
								frameTime[n].setVisible(false);
							}
							
							n = n + 1;
						}
						
						n = 0;
						
						setVisible(false);
						Login login = new Login();
						login.setVisible(true);
					}else{
						setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
					}
					
					
				}
				
				@Override
				public void windowClosed(WindowEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void windowActivated(WindowEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
             
             JLabel top = new JLabel();
             top.setText("<html><div style='width:600;height:50;background:green;'><font color='white' size='5'>CCOM Server</font></div></html>");
             top.setBounds(0, 0, 600, 50);
             panel2.add(top);
            
             
             
             JInternalFrame ComputersFrame = new JInternalFrame();
             ComputersFrame.setBounds(10, 70, 560, 200);
             ComputersFrame.setTitle("Computers Screen");
             ComputersFrame.setResizable(false);
             ComputersFrame.setClosable(true);
             ComputersFrame.setIconifiable(true);
             ComputersFrame.setBorder(BorderFactory.createLineBorder(Color.green, 1));
             ComputersFrame.show();
             panel2.add(ComputersFrame);
             
             JLabel panel4 = new JLabel();
             panel4.setText("<html><div style='width:560;height:200;background:black;'></div></html>");
             panel4.setBounds(0, 0, 560, 200);
             
             JScrollPane scroll;
             scroll = new JScrollPane(panel4, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
             ComputersFrame.getContentPane().add(scroll);
             
             JInternalFrame ccom = new JInternalFrame();
             ccom.setBounds(290, 280, 280, 170);
             ccom.setTitle("CCOM");
             ccom.setResizable(false);
             ccom.setClosable(true);
             ccom.setIconifiable(true);
             ccom.setBorder(BorderFactory.createLineBorder(Color.green, 1));
             ccom.show();
             panel2.add(ccom);
             
             String path = new File("").getAbsolutePath();
             String hostFile = path+"/dbcomp/.host";
             FileReader hostReader = new FileReader(hostFile);
             BufferedReader hostBuffer = new BufferedReader(hostReader);
             String lineHost = hostBuffer.readLine();
             
             while(lineHost != null){
            	
            	 
            	 int ad = adds;
            	 
            	 if(lineHost.contains("name:")){
            		 nameCompText = lineHost.substring(lineHost.indexOf("name:")+5, lineHost.lastIndexOf(";name")).trim();
            		 ipText = lineHost.substring(lineHost.indexOf("ip:")+3, lineHost.lastIndexOf(";ip")).trim();
            		 portText = lineHost.substring(lineHost.indexOf("port:")+5, lineHost.lastIndexOf(";port")).trim();
            		 
            		 
            		 
            		 divs[ad] = new JLabel();
            		 divs[ad].setBounds(10, y, 520, 50);
            		 divs[ad].setName(portText);
            		 divs[ad].setText("<html><div style='width:520;height:50;background:black;'></div></html>");
            		 divs[ad].setBorder(BorderFactory.createLineBorder(Color.green, 1));
            		 panel4.add(divs[ad]);
            		 
            		 nameComp[ad] = new JLabel();
            		 nameComp[ad].setText(nameCompText);
            		 nameComp[ad].setBounds(10, 10, 100, 20);
            		 nameComp[ad].setForeground(Color.green);
            		 nameComp[ad].setName(portText);
            		 divs[ad].add(nameComp[ad]);
            		 
            		 ccomButton[ad] = new JButton();
            		 ccomButton[ad].setText("Control");
            		 ccomButton[ad].setBounds(90, 10, 100, 20);
            		 ccomButton[ad].setName(ipText);
            		 ccomButton[ad].setForeground(Color.green);
            		 ccomButton[ad].setBackground(Color.black);
            		 ccomButton[ad].setCursor(new Cursor(Cursor.HAND_CURSOR));
            		 divs[ad].add(ccomButton[ad]);
                     
            		 
            		 ccomButton[ad].addMouseListener(new MouseListener() {
         				
         				@Override
         				public void mouseReleased(MouseEvent sd1) {
         					ccomButton[ad].setForeground(Color.green);
         					ccomButton[ad].setBackground(Color.black);
         				}
         				
         				@Override
         				public void mousePressed(MouseEvent sd2) {
         					
                   		 
         					ccomButton[ad].setForeground(Color.white);
         					ccomButton[ad].setBackground(Color.green);
         					ccom.setTitle("CCOM - "+nameComp[ad].getText());
         					
         					cmdIp = ccomButton[ad].getName();
         					cmdPort = nameComp[ad].getName();
         					ccom.show();
         				}
         				
         				@Override
         				public void mouseExited(MouseEvent sd3) {
         					ccomButton[ad].setForeground(Color.green);
         					ccomButton[ad].setBackground(Color.black);
         				}
         				
         				@Override
         				public void mouseEntered(MouseEvent sd4) {
         					ccomButton[ad].setForeground(Color.white);
         					ccomButton[ad].setBackground(Color.green);
         				}
         				
         				@Override
         				public void mouseClicked(MouseEvent sd5) {}
         			});
                      
            		 
            		 Comunication[ad] = new JButton();
            		 Comunication[ad].setText("Mensage");
            		 Comunication[ad].setBounds(200, 10, 100, 20);
            		 Comunication[ad].setName(ipText);
            		 Comunication[ad].setForeground(Color.green);
            		 Comunication[ad].setBackground(Color.black);
            		 Comunication[ad].setCursor(new Cursor(Cursor.HAND_CURSOR));
                     divs[ad].add(Comunication[ad]);
                     
                   
                     
                     

                     comFrame[ad] = new JFrame();
                     comFrame[ad].setBounds(290, 280, 315, 230);
                     comFrame[ad].setTitle("Mensage - "+nameCompText);
                     comFrame[ad].setIconImage(image.getImage());
                     comFrame[ad].setVisible(false);
                     comFrame[ad].setResizable(true);
                    
                     labelComFrame[ad] = new JLabel();
                     labelComFrame[ad].setText("<html><div style='width:315;height:230;background:black;'></div></html>");
                     labelComFrame[ad].setBounds(0, 0, 315, 230);
                     labelComFrame[ad].setForeground(Color.green);
            		 comFrame[ad].add(labelComFrame[ad]);
            		 
                     editorPane[ad] = new JEditorPane();
                     editorPane[ad].setBounds(2, 2, 300, 170);
                     editorPane[ad].setForeground(Color.green);
                     editorPane[ad].setBackground(Color.black);
                     labelComFrame[ad].add(editorPane[ad]);
                    		 
                     scrollPane[ad] = new JScrollPane(editorPane[ad]);
                     scrollPane[ad].setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                     scrollPane[ad].setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                     scrollPane[ad].setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
                     scrollPane[ad].setBounds(0, 0, 300, 170);
                     labelComFrame[ad].add(scrollPane[ad]);
                     
                     
                     
                     Comunication[ad].addMouseListener(new MouseListener() {
        				
        				@Override
        				public void mouseReleased(MouseEvent sd1) {
        					Comunication[ad].setForeground(Color.green);
        					Comunication[ad].setBackground(Color.black);
        				}
        				
        				@Override
        				public void mousePressed(MouseEvent sd2) {
        					Comunication[ad].setForeground(Color.white);
        					Comunication[ad].setBackground(Color.green);
        					
        					comFrame[ad].setVisible(true);
        				}
        				
        				@Override
        				public void mouseExited(MouseEvent sd3) {
        					Comunication[ad].setForeground(Color.green);
        					Comunication[ad].setBackground(Color.black);
        				}
        				
        				@Override
        				public void mouseEntered(MouseEvent sd4) {
        					Comunication[ad].setForeground(Color.white);
        					Comunication[ad].setBackground(Color.green);
        				}
        				
        				@Override
        				public void mouseClicked(MouseEvent sd5) {}
        			});
                     
                     Send[ad] = new JButton();
                     Send[ad].setText("Send Text to "+nameCompText);
                     Send[ad].setBounds(0, 170, 300, 20);
                     Send[ad].setName(portText);
                     Send[ad].setForeground(Color.green);
                     Send[ad].setBackground(Color.black);
                     Send[ad].setCursor(new Cursor(Cursor.HAND_CURSOR));
                     labelComFrame[ad].add(Send[ad]);
                     
                     Send[ad].addMouseListener(new MouseListener() {
						
						@Override
						public void mouseReleased(MouseEvent arg0) {}
						
						@Override
						public void mousePressed(MouseEvent arg0) {
							Mensage = "msg:{"+editorPane[ad].getText().replaceAll("\r\n", "<br>")+"}";
            				 try {
                                Socket socket = new Socket(Comunication[ad].getName(),
                                Integer.parseInt(Send[ad].getName()));
                                         
                               BufferedOutputStream bf = new BufferedOutputStream(socket.getOutputStream());
                               
                               String phrase = Mensage;
                               
                               byte[] bytephrase = phrase.getBytes();
                               bf.write(bytephrase);
                               bf.flush();
                               bf.close();
                               socket.close();
                               } catch (UnknownHostException e) {
                                  JOptionPane.showMessageDialog(null, "<html><font color='red'>computador não conectado a CCOM</font></html>", "Error Comunication", JOptionPane.ERROR_MESSAGE, image);
                               } catch (IOException e) {
                               	JOptionPane.showMessageDialog(null, "<html><font color='red'>computador não conectado a CCOM</font></html>", "Error Comunication", JOptionPane.ERROR_MESSAGE, image);
                               }
						}
						
						@Override
						public void mouseExited(MouseEvent arg0) {
							Send[ad].setForeground(Color.green);
							Send[ad].setBackground(Color.black);
						}
						
						@Override
						public void mouseEntered(MouseEvent arg0) {
							Send[ad].setForeground(Color.white);
							Send[ad].setBackground(Color.green);
						}
						
						@Override
						public void mouseClicked(MouseEvent arg0) {}
					});
                     
                     block[ad] = new JButton();
                     block[ad].setText("Unblock");
                     block[ad].setBounds(310, 10, 90, 20);
                     block[ad].setName(ipText);
                     block[ad].setForeground(Color.green);
                     block[ad].setBackground(Color.black);
                     block[ad].setCursor(new Cursor(Cursor.HAND_CURSOR));
                     divs[ad].add(block[ad]);
                     
                     block[ad].addMouseListener(new MouseListener() {
						
						@Override
						public void mouseReleased(MouseEvent e) {}
						
						@Override
						public void mousePressed(MouseEvent e) {
							try {
                                Socket socket = new Socket(block[ad].getName(),
                                Integer.parseInt(divs[ad].getName()));
                                         
                               BufferedOutputStream bf = new BufferedOutputStream(socket.getOutputStream());
                               
                               String phrase = "";
                               
                               if(block[ad].getText().equals("Block")){
                            	   block[ad].setText("Unblock");
                            	   block[ad].setForeground(Color.red);
                            	   
                            	   phrase = "blocker:{block}";
                               }else{
                            	   block[ad].setText("Block");
                            	   block[ad].setForeground(Color.green);
                            	   
                            	   phrase = "blocker:{unblock}";
                               }
                               
                               byte[] bytephrase = phrase.getBytes();
                               bf.write(bytephrase);
                               bf.flush();
                               bf.close();
                               socket.close();
                               } catch (UnknownHostException e2) {
                            	   JOptionPane.showMessageDialog(null, "<html><font color='red'>computador não conectado a CCOM</font></html>", "Error Blocker", JOptionPane.ERROR_MESSAGE, image);
                               } catch (IOException e2) {
                            	   JOptionPane.showMessageDialog(null, "<html><font color='red'>computador não conectado a CCOM</font></html>", "Error Blocker", JOptionPane.ERROR_MESSAGE, image);
                               }
						}
						
						@Override
						public void mouseExited(MouseEvent e) {
							block[ad].setForeground(Color.green);
							block[ad].setBackground(Color.black);
						}
						
						@Override
						public void mouseEntered(MouseEvent e) {
							block[ad].setForeground(Color.white);
							block[ad].setBackground(Color.green);
						}
						
						@Override
						public void mouseClicked(MouseEvent e) {}
					});
                     
                     runtime[ad] = new JButton();
                     runtime[ad].setText("Runtime");
                     runtime[ad].setBounds(410, 10, 90, 20);
                     runtime[ad].setName(ipText);
                     runtime[ad].setForeground(Color.green);
                     runtime[ad].setBackground(Color.black);
                     runtime[ad].setCursor(new Cursor(Cursor.HAND_CURSOR));
                     divs[ad].add(runtime[ad]);
                     
                     
						frameTime[ad] = new JFrame();
						frameTime[ad].setBounds(400, 200, 300, 150);
						frameTime[ad].setTitle("Time Programming - "+nameCompText);
						frameTime[ad].setIconImage(image.getImage());
						
						
						labelTime[ad] = new JLabel();
						labelTime[ad].setBounds(0, 0, 300, 150);
						labelTime[ad].setText("<html><div style='width:300;height:150;background:black;'></div></html>");
						frameTime[ad].add(labelTime[ad]);
						
						Min[ad] = new JLabel();
						Min[ad].setText("Tempo em Minutos: ");
						Min[ad].setBounds(20, 30, 115, 20);
						Min[ad].setForeground(Color.green);
						labelTime[ad].add(Min[ad]);
						
						minField[ad] = new JTextField();
						minField[ad].setBounds(140, 30, 100, 20);
						minField[ad].setForeground(Color.green);
						minField[ad].setBackground(Color.black);
						minField[ad].setCaretColor(Color.green);
						labelTime[ad].add(minField[ad]);
						
						Program[ad] = new JButton();
						Program[ad].setBounds(150, 60, 100, 20);
						Program[ad].setText("Program");
						Program[ad].setForeground(Color.green);
						Program[ad].setBackground(Color.black);
						Program[ad].setCursor(new Cursor(Cursor.HAND_CURSOR));
						labelTime[ad].add(Program[ad]);
						
						Program[ad].addMouseListener(new MouseListener() {
							
							@Override
							public void mouseReleased(MouseEvent arg0) {}
							
							@Override
							public void mousePressed(MouseEvent arg0) {
								
								try {
	                                Socket socket = new Socket(runtime[ad].getName(),
	                                Integer.parseInt(divs[ad].getName()));
	                                         
	                               BufferedOutputStream bf = new BufferedOutputStream(socket.getOutputStream());
	                               
	                               
	                               int myTime = Integer.parseInt(minField[ad].getText().trim());
	                               
	                               myTime = 1000 * myTime;
	                               

	                               String phrase = "runtime:{"+myTime+"}";
	                               
	                               byte[] bytephrase = phrase.getBytes();
	                               bf.write(bytephrase);
	                               bf.flush();
	                               bf.close();
	                               socket.close();
	                               } catch (UnknownHostException e2) {
	                            	   JOptionPane.showMessageDialog(null, "<html><font color='red'>computador não conectado a CCOM</font></html>", "Error Runtime", JOptionPane.ERROR_MESSAGE, image);
	                               } catch (IOException e2) {
	                            	   JOptionPane.showMessageDialog(null, "<html><font color='red'>computador não conectado a CCOM</font></html>", "Error Runtime", JOptionPane.ERROR_MESSAGE, image);
	                               }
								
								frameTime[ad].setVisible(false);
								
							}
							
							@Override
							public void mouseExited(MouseEvent arg0) {
								Program[ad].setForeground(Color.green);
								Program[ad].setBackground(Color.black);
							}
							
							@Override
							public void mouseEntered(MouseEvent arg0) {
								Program[ad].setForeground(Color.white);
								Program[ad].setBackground(Color.green);
							}
							
							@Override
							public void mouseClicked(MouseEvent arg0) {}
						});
                     
                     runtime[ad].addMouseListener(new MouseListener() {
						

						@Override
						public void mouseReleased(MouseEvent e) {}
						
						@Override
						public void mousePressed(MouseEvent e) {
							frameTime[ad].setVisible(true);
							
						}
						
						@Override
						public void mouseExited(MouseEvent e) {
							runtime[ad].setForeground(Color.green);
							runtime[ad].setBackground(Color.black);
						}
						
						@Override
						public void mouseEntered(MouseEvent e) {
							runtime[ad].setForeground(Color.white);
							runtime[ad].setBackground(Color.green);
						}
						
						@Override
						public void mouseClicked(MouseEvent e) {}
					});
            		 
            	 }
            	
            	 if(lineHost.contains("addictioned{")){
            		 adds = adds + 1;
            		 y = y + 50;
            		 if(adds >= 4){
            			 a = a + 50;
            			 int value = Integer.parseInt("200")+a;
            			 panel4.setText("<html><div style='width:560;height:"+value+";background:black;'></div></html>");
                         panel4.setBounds(0, 0, 560, 200);
            		 }
            	 }
            	 
            	 
            	 lineHost = hostBuffer.readLine();
             }
             
            hostBuffer.close();
            
            JButton refresh = new JButton();
            refresh.setBounds(190, 10, 150, 30);
            refresh.setText("Refresh");
            refresh.setForeground(Color.green);
            refresh.setBackground(Color.black);
            refresh.setCursor(new Cursor(Cursor.HAND_CURSOR));
            panel4.add(refresh);
            
            refresh.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent arg0) {
					adds = 0;
					y = 0;
					a = 0;
					
					String path = new File("").getAbsolutePath();
		             String hostFile = path+"/dbcomp/.host";
		             FileReader hostReader;
					try {
						hostReader = new FileReader(hostFile);
						BufferedReader hostBuffer = new BufferedReader(hostReader);
			            String lineHost = hostBuffer.readLine();
			            
			            while(lineHost != null){
			            	
			            	 
			            	 int ad = adds;
			            	 
			            	 if(lineHost.contains("name:")){
			            		 nameCompText = lineHost.substring(lineHost.indexOf("name:")+5, lineHost.lastIndexOf(";name")).trim();
			            		 ipText = lineHost.substring(lineHost.indexOf("ip:")+3, lineHost.lastIndexOf(";ip")).trim();
			            		 portText = lineHost.substring(lineHost.indexOf("port:")+5, lineHost.lastIndexOf(";port")).trim();
			            		 
			            		 
			            		 
			            		 divs[ad] = new JLabel();
			            		 divs[ad].setBounds(10, y, 520, 50);
			            		 divs[ad].setName(portText);
			            		 divs[ad].setText("<html><div style='width:520;height:50;background:black;'></div></html>");
			            		 divs[ad].setBorder(BorderFactory.createLineBorder(Color.green, 1));
			            		 panel4.add(divs[ad]);
			            		 
			            		 nameComp[ad] = new JLabel();
			            		 nameComp[ad].setText(nameCompText);
			            		 nameComp[ad].setBounds(10, 10, 100, 20);
			            		 nameComp[ad].setForeground(Color.green);
			            		 nameComp[ad].setName(portText);
			            		 divs[ad].add(nameComp[ad]);
			            		 
			            		 ccomButton[ad] = new JButton();
			            		 ccomButton[ad].setText("Control");
			            		 ccomButton[ad].setBounds(90, 10, 100, 20);
			            		 ccomButton[ad].setName(ipText);
			            		 ccomButton[ad].setForeground(Color.green);
			            		 ccomButton[ad].setBackground(Color.black);
			            		 ccomButton[ad].setCursor(new Cursor(Cursor.HAND_CURSOR));
			            		 divs[ad].add(ccomButton[ad]);
			                     
			            		 
			            		 ccomButton[ad].addMouseListener(new MouseListener() {
			         				
			         				@Override
			         				public void mouseReleased(MouseEvent sd1) {
			         					ccomButton[ad].setForeground(Color.green);
			         					ccomButton[ad].setBackground(Color.black);
			         				}
			         				
			         				@Override
			         				public void mousePressed(MouseEvent sd2) {
			         					
			                   		 
			         					ccomButton[ad].setForeground(Color.white);
			         					ccomButton[ad].setBackground(Color.green);
			         					ccom.setTitle("CCOM - "+nameComp[ad].getText());
			         					
			         					cmdIp = ccomButton[ad].getName();
			         					cmdPort = nameComp[ad].getName();
			         					ccom.show();
			         				}
			         				
			         				@Override
			         				public void mouseExited(MouseEvent sd3) {
			         					ccomButton[ad].setForeground(Color.green);
			         					ccomButton[ad].setBackground(Color.black);
			         				}
			         				
			         				@Override
			         				public void mouseEntered(MouseEvent sd4) {
			         					ccomButton[ad].setForeground(Color.white);
			         					ccomButton[ad].setBackground(Color.green);
			         				}
			         				
			         				@Override
			         				public void mouseClicked(MouseEvent sd5) {}
			         			});
			                      
			            		 
			            		 Comunication[ad] = new JButton();
			            		 Comunication[ad].setText("Mensage");
			            		 Comunication[ad].setBounds(200, 10, 100, 20);
			            		 Comunication[ad].setName(ipText);
			            		 Comunication[ad].setForeground(Color.green);
			            		 Comunication[ad].setBackground(Color.black);
			            		 Comunication[ad].setCursor(new Cursor(Cursor.HAND_CURSOR));
			                     divs[ad].add(Comunication[ad]);
			                     
			                   
			                     
			                     

			                     comFrame[ad] = new JFrame();
			                     comFrame[ad].setBounds(290, 280, 315, 230);
			                     comFrame[ad].setTitle("Mensage - "+nameCompText);
			                     comFrame[ad].setIconImage(image.getImage());
			                     comFrame[ad].setVisible(false);
			                     comFrame[ad].setResizable(true);
			                    
			                     labelComFrame[ad] = new JLabel();
			                     labelComFrame[ad].setText("<html><div style='width:315;height:230;background:black;'></div></html>");
			                     labelComFrame[ad].setBounds(0, 0, 315, 230);
			                     labelComFrame[ad].setForeground(Color.green);
			            		 comFrame[ad].add(labelComFrame[ad]);
			            		 
			                     editorPane[ad] = new JEditorPane();
			                     editorPane[ad].setBounds(2, 2, 300, 170);
			                     editorPane[ad].setForeground(Color.green);
			                     editorPane[ad].setBackground(Color.black);
			                     labelComFrame[ad].add(editorPane[ad]);
			                    		 
			                     scrollPane[ad] = new JScrollPane(editorPane[ad]);
			                     scrollPane[ad].setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			                     scrollPane[ad].setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			                     scrollPane[ad].setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
			                     scrollPane[ad].setBounds(0, 0, 300, 170);
			                     labelComFrame[ad].add(scrollPane[ad]);
			                     
			                     
			                     
			                     Comunication[ad].addMouseListener(new MouseListener() {
			        				
			        				@Override
			        				public void mouseReleased(MouseEvent sd1) {
			        					Comunication[ad].setForeground(Color.green);
			        					Comunication[ad].setBackground(Color.black);
			        				}
			        				
			        				@Override
			        				public void mousePressed(MouseEvent sd2) {
			        					Comunication[ad].setForeground(Color.white);
			        					Comunication[ad].setBackground(Color.green);
			        					
			        					comFrame[ad].setVisible(true);
			        				}
			        				
			        				@Override
			        				public void mouseExited(MouseEvent sd3) {
			        					Comunication[ad].setForeground(Color.green);
			        					Comunication[ad].setBackground(Color.black);
			        				}
			        				
			        				@Override
			        				public void mouseEntered(MouseEvent sd4) {
			        					Comunication[ad].setForeground(Color.white);
			        					Comunication[ad].setBackground(Color.green);
			        				}
			        				
			        				@Override
			        				public void mouseClicked(MouseEvent sd5) {}
			        			});
			                     
			                     Send[ad] = new JButton();
			                     Send[ad].setText("Send Text to "+nameCompText);
			                     Send[ad].setBounds(0, 170, 300, 20);
			                     Send[ad].setName(portText);
			                     Send[ad].setForeground(Color.green);
			                     Send[ad].setBackground(Color.black);
			                     Send[ad].setCursor(new Cursor(Cursor.HAND_CURSOR));
			                     labelComFrame[ad].add(Send[ad]);
			                     
			                     Send[ad].addMouseListener(new MouseListener() {
									
									@Override
									public void mouseReleased(MouseEvent arg0) {}
									
									@Override
									public void mousePressed(MouseEvent arg0) {
										Mensage = "msg:{"+editorPane[ad].getText().replaceAll("\r\n", "<br>")+"}";
			            				 try {
			                                Socket socket = new Socket(Comunication[ad].getName(),
			                                Integer.parseInt(Send[ad].getName()));
			                                         
			                               BufferedOutputStream bf = new BufferedOutputStream(socket.getOutputStream());
			                               
			                               String phrase = Mensage;
			                               
			                               byte[] bytephrase = phrase.getBytes();
			                               bf.write(bytephrase);
			                               bf.flush();
			                               bf.close();
			                               socket.close();
			                               } catch (UnknownHostException e) {
			                                  JOptionPane.showMessageDialog(null, "<html><font color='red'>computador não conectado a CCOM</font></html>", "Error Comunication", JOptionPane.ERROR_MESSAGE, image);
			                               } catch (IOException e) {
			                               	JOptionPane.showMessageDialog(null, "<html><font color='red'>computador não conectado a CCOM</font></html>", "Error Comunication", JOptionPane.ERROR_MESSAGE, image);
			                               }
									}
									
									@Override
									public void mouseExited(MouseEvent arg0) {
										Send[ad].setForeground(Color.green);
										Send[ad].setBackground(Color.black);
									}
									
									@Override
									public void mouseEntered(MouseEvent arg0) {
										Send[ad].setForeground(Color.white);
										Send[ad].setBackground(Color.green);
									}
									
									@Override
									public void mouseClicked(MouseEvent arg0) {}
								});
			                     
			                     block[ad] = new JButton();
			                     block[ad].setText("Unblock");
			                     block[ad].setBounds(310, 10, 90, 20);
			                     block[ad].setName(ipText);
			                     block[ad].setForeground(Color.green);
			                     block[ad].setBackground(Color.black);
			                     block[ad].setCursor(new Cursor(Cursor.HAND_CURSOR));
			                     divs[ad].add(block[ad]);
			                     
			                     block[ad].addMouseListener(new MouseListener() {
									
									@Override
									public void mouseReleased(MouseEvent e) {}
									
									@Override
									public void mousePressed(MouseEvent e) {
										try {
			                                Socket socket = new Socket(block[ad].getName(),
			                                Integer.parseInt(divs[ad].getName()));
			                                         
			                               BufferedOutputStream bf = new BufferedOutputStream(socket.getOutputStream());
			                               
			                               String phrase = "";
			                               
			                               if(block[ad].getText().equals("Block")){
			                            	   block[ad].setText("Unblock");
			                            	   block[ad].setForeground(Color.red);
			                            	   
			                            	   phrase = "blocker:{block}";
			                               }else{
			                            	   block[ad].setText("Block");
			                            	   block[ad].setForeground(Color.green);
			                            	   
			                            	   phrase = "blocker:{unblock}";
			                               }
			                               
			                               byte[] bytephrase = phrase.getBytes();
			                               bf.write(bytephrase);
			                               bf.flush();
			                               bf.close();
			                               socket.close();
			                               } catch (UnknownHostException e2) {
			                            	   JOptionPane.showMessageDialog(null, "<html><font color='red'>computador não conectado a CCOM</font></html>", "Error Blocker", JOptionPane.ERROR_MESSAGE, image);
			                               } catch (IOException e2) {
			                            	   JOptionPane.showMessageDialog(null, "<html><font color='red'>computador não conectado a CCOM</font></html>", "Error Blocker", JOptionPane.ERROR_MESSAGE, image);
			                               }
									}
									
									@Override
									public void mouseExited(MouseEvent e) {
										block[ad].setForeground(Color.green);
										block[ad].setBackground(Color.black);
									}
									
									@Override
									public void mouseEntered(MouseEvent e) {
										block[ad].setForeground(Color.white);
										block[ad].setBackground(Color.green);
									}
									
									@Override
									public void mouseClicked(MouseEvent e) {}
								});
			                     
			                     runtime[ad] = new JButton();
			                     runtime[ad].setText("Runtime");
			                     runtime[ad].setBounds(410, 10, 90, 20);
			                     runtime[ad].setName(ipText);
			                     runtime[ad].setForeground(Color.green);
			                     runtime[ad].setBackground(Color.black);
			                     runtime[ad].setCursor(new Cursor(Cursor.HAND_CURSOR));
			                     divs[ad].add(runtime[ad]);
			                     
			                     
									frameTime[ad] = new JFrame();
									frameTime[ad].setBounds(400, 200, 300, 150);
									frameTime[ad].setTitle("Time Programming -"+nameCompText);
									frameTime[ad].setIconImage(image.getImage());
									
									
									labelTime[ad] = new JLabel();
									labelTime[ad].setBounds(0, 0, 300, 150);
									labelTime[ad].setText("<html><div style='width:300;height:150;background:black;'></div></html>");
									frameTime[ad].add(labelTime[ad]);
									
									Min[ad] = new JLabel();
									Min[ad].setText("Tempo em Minutos: ");
									Min[ad].setBounds(20, 30, 115, 20);
									Min[ad].setForeground(Color.green);
									labelTime[ad].add(Min[ad]);
									
									minField[ad] = new JTextField();
									minField[ad].setBounds(140, 30, 100, 20);
									minField[ad].setForeground(Color.green);
									minField[ad].setBackground(Color.black);
									minField[ad].setCaretColor(Color.green);
									labelTime[ad].add(minField[ad]);
									
									Program[ad] = new JButton();
									Program[ad].setBounds(150, 60, 100, 20);
									Program[ad].setText("Program");
									Program[ad].setForeground(Color.green);
									Program[ad].setBackground(Color.black);
									Program[ad].setCursor(new Cursor(Cursor.HAND_CURSOR));
									labelTime[ad].add(Program[ad]);
									
									Program[ad].addMouseListener(new MouseListener() {
										
										@Override
										public void mouseReleased(MouseEvent arg0) {}
										
										@Override
										public void mousePressed(MouseEvent arg0) {
											
											try {
				                                Socket socket = new Socket(runtime[ad].getName(),
				                                Integer.parseInt(divs[ad].getName()));
				                                         
				                               BufferedOutputStream bf = new BufferedOutputStream(socket.getOutputStream());
				                               
				                               
				                               int myTime = Integer.parseInt(minField[ad].getText().trim());
				                               
				                               myTime = 1000 * myTime;
				                               

				                               String phrase = "runtime:{"+myTime+"}";
				                               
				                               byte[] bytephrase = phrase.getBytes();
				                               bf.write(bytephrase);
				                               bf.flush();
				                               bf.close();
				                               socket.close();
				                               } catch (UnknownHostException e2) {
				                            	   JOptionPane.showMessageDialog(null, "<html><font color='red'>computador não conectado a CCOM</font></html>", "Error Runtime", JOptionPane.ERROR_MESSAGE, image);
				                               } catch (IOException e2) {
				                            	   JOptionPane.showMessageDialog(null, "<html><font color='red'>computador não conectado a CCOM</font></html>", "Error Runtime", JOptionPane.ERROR_MESSAGE, image);
				                               }
											
											frameTime[ad].setVisible(false);
											
										}
										
										@Override
										public void mouseExited(MouseEvent arg0) {
											Program[ad].setForeground(Color.green);
											Program[ad].setBackground(Color.black);
										}
										
										@Override
										public void mouseEntered(MouseEvent arg0) {
											Program[ad].setForeground(Color.white);
											Program[ad].setBackground(Color.green);
										}
										
										@Override
										public void mouseClicked(MouseEvent arg0) {}
									});
			                     
			                     runtime[ad].addMouseListener(new MouseListener() {
									

									@Override
									public void mouseReleased(MouseEvent e) {}
									
									@Override
									public void mousePressed(MouseEvent e) {
										frameTime[ad].setVisible(true);
										
									}
									
									@Override
									public void mouseExited(MouseEvent e) {
										runtime[ad].setForeground(Color.green);
										runtime[ad].setBackground(Color.black);
									}
									
									@Override
									public void mouseEntered(MouseEvent e) {
										runtime[ad].setForeground(Color.white);
										runtime[ad].setBackground(Color.green);
									}
									
									@Override
									public void mouseClicked(MouseEvent e) {}
								});
			            		 
			            	 }
			            	
			            	 if(lineHost.contains("addictioned{")){
			            		 adds = adds + 1;
			            		 y = y + 50;
			            		 if(adds >= 4){
			            			 a = a + 50;
			            			 int value = Integer.parseInt("200")+a;
			            			 panel4.setText("<html><div style='width:560;height:"+value+";background:black;'></div></html>");
			                         panel4.setBounds(0, 0, 560, 200);
			            		 }
			            	 }
			            	 
			            	 
			            	 lineHost = hostBuffer.readLine();
			             }
			             
			            hostBuffer.close();
			            
					} catch (FileNotFoundException e1) {} 
					catch (IOException e) {}
					
				}
				
				@Override
				public void mouseExited(MouseEvent arg0) {
					refresh.setForeground(Color.green);
		            refresh.setBackground(Color.black);
					
				}
				
				@Override
				public void mouseEntered(MouseEvent arg0) {
					refresh.setForeground(Color.white);
		            refresh.setBackground(Color.green);
					
				}
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
             
           
            
             panel5 = new JLabel();
             panel5.setText("<html><div style='width:280;height:170;background:black;'></div></html>");
             panel5.setBounds(0, 0, 280, 170);
             
             JScrollPane scroll2;
             scroll2 = new JScrollPane(panel5);
             ccom.getContentPane().add(scroll2);
            
             
             new Thread(new Runnable(){
            	 @Override
            	 public void run(){
            		 while(true){
            			 int num = i;
            			 int num1 = i1;
            			 
            			 setCcom[num] = new JLabel();
                         setCcom[num].setText(">");
                         setCcom[num].setForeground(Color.white);
                         setCcom[num].setFont(new Font("Arial", 1, 17));
                         setCcom[num].setBounds(1, num, 15, 15);
                         panel5.add(setCcom[num]);
                         
                         ccomFieldArray[num] = new JTextField();
                         ccomFieldArray[num].setBounds(12, num1, 245, 20);
                         ccomFieldArray[num].setText("");
                         ccomFieldArray[num].setForeground(Color.red);
                         ccomFieldArray[num].setBackground(Color.black);
                         ccomFieldArray[num].setCaretColor(Color.red);
                         ccomFieldArray[num].setBorder(null);
                         panel5.add(ccomFieldArray[num]);
                         
                         ccomFieldArray[num].addKeyListener(new KeyListener() {
							
							@Override
							public void keyTyped(KeyEvent key) {
								
							}
							
							@Override
							public void keyReleased(KeyEvent key) {
								
							}
							
							@Override
							public void keyPressed(KeyEvent key) {
								int getKey = key.getKeyCode();
								if(getKey == KeyEvent.VK_ENTER){
									String ipCmd = cmdIp;
									String ipPort = cmdPort;
									try {
		                                 Socket socket = new Socket(ipCmd,
		                                 Integer.parseInt(ipPort));
		                                          
		                                BufferedOutputStream bf = new BufferedOutputStream(socket.getOutputStream());
		                                
		                                String phrase = "code:{"+ccomFieldArray[num].getText()+"}";
		                                
		                                byte[] bytephrase = phrase.getBytes();
		                                bf.write(bytephrase);
		                                bf.flush();
		                                bf.close();
		                                socket.close();
		                                } catch (UnknownHostException e) {
		                                	JOptionPane.showMessageDialog(null, "<html><font color='red'>computador não conectado a CCOM</font></html>", "Error Commands", JOptionPane.ERROR_MESSAGE, image);
		                                } catch (IOException e) {
		                                	JOptionPane.showMessageDialog(null, "<html><font color='red'>computador não conectado a CCOM</font></html>", "Error Commands", JOptionPane.ERROR_MESSAGE, image);
		                                }
									lastField = true;
									try {
										Robot robot = new Robot();
										robot.keyPress(KeyEvent.VK_TAB);
										robot.keyRelease(KeyEvent.VK_TAB);
									} catch (AWTException e) {}
									
									i = i + 1;
									if(i >= 8){
										Values += 20;
										panel5.setText("<html><div style='width:280;height:"+Values+";background:black;'></div></html>");
							            panel5.setBounds(0, 0, 280, Values);
										
									}
									
								}
							}
							
						});
                         
                         while(!lastField){}
                         i1 = i1 + 20;
                         lastField = false;
            		 }
            	 }
             }).start();
             
             
             
             
             
             JInternalFrame InternalFrame = new JInternalFrame();
             InternalFrame.setBounds(10, 280, 270, 170);
             InternalFrame.setTitle("Add Computers");
             InternalFrame.setResizable(false);
             InternalFrame.setClosable(true);
             InternalFrame.setBorder(BorderFactory.createLineBorder(Color.green, 1));
             InternalFrame.show();
             panel2.add(InternalFrame);
             
             JLabel panel3 = new JLabel();
             panel3.setText("<html><div style='width:300;height:200;background:black;'></div></html>");
             panel3.setBounds(0, 0, 300, 200);
             InternalFrame.add(panel3);
             
             JLabel labelIp = new JLabel();
             labelIp.setText("IP:");
             labelIp.setForeground(Color.green);
             labelIp.setBounds(0, 10, 40, 20);
             panel3.add(labelIp);
             
             JTextField IP = new JTextField();
             IP.setBounds(40, 10, 200, 20);
             IP.setBackground(Color.black);
             IP.setForeground(Color.green);
             IP.setCaretColor(Color.green);
             panel3.add(IP);
            
             
             JLabel labelPort = new JLabel();
             labelPort.setText("Port:");
             labelPort.setForeground(Color.green);
             labelPort.setBounds(0, 40, 40, 20);
             panel3.add(labelPort);
     		
             JTextField Port = new JTextField();
             Port.setBounds(40, 40, 200, 20);
             Port.setBackground(Color.black);
             Port.setText("8888");
             Port.setEnabled(false);
             Port.setForeground(Color.green);
             Port.setCaretColor(Color.green);
             panel3.add(Port);
             
             JLabel labelName = new JLabel();
             labelName.setText("Name:");
             labelName.setForeground(Color.green);
             labelName.setBounds(0, 70, 40, 20);
             panel3.add(labelName);
     		
             JTextField nameField = new JTextField();
             nameField.setBounds(40, 70, 200, 20);
             nameField.setBackground(Color.black);
             nameField.setForeground(Color.green);
             nameField.setCaretColor(Color.green);
             panel3.add(nameField);
             
             JButton add = new JButton();
             add.setText("Add");
             add.setBounds(160, 100, 60, 20);
             add.setForeground(Color.green);
             add.setBackground(Color.black);
             add.setCursor(new Cursor(Cursor.HAND_CURSOR));
             panel3.add(add);
             
             
             add.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {}
				
				@Override
				public void mousePressed(MouseEvent e) {
					computerName = nameField.getText();
					ipName = IP.getText();
					portName = Port.getText();
					
					if(ipName.isEmpty() || portName.isEmpty()){
						JOptionPane.showMessageDialog(null, "<html><font color='red'>Não foi possível adicionar algum computador!<br>Os campos estão vazios!</font></html>");
					}else{
						File computers = new File("dbcomp/.host");
						
						try {
							FileReader fileReader = new FileReader(computers);
							BufferedReader bufferReader = new BufferedReader(fileReader);
							String compLines = bufferReader.readLine();
							
							while(compLines != null){
								
								computerMemorys += compLines + "\n";
								compLines = bufferReader.readLine();
							}
							
							PrintWriter printWriter = new PrintWriter(computers);
							printWriter.println(computerMemorys+"addictioned{");
							printWriter.println("name: "+computerName+";name | ip: "+ipName+";ip | port: "+portName+";port |");
							printWriter.println("}");
							printWriter.println("");
							printWriter.close();
							bufferReader.close();
							computerMemorys = "";
							
						} catch (FileNotFoundException e1) {} catch (IOException e1) {}
				
						
					try {
						Runtime.getRuntime().exec("CMD /c copy /b System\\Server.exe computers\\"+computerName+".exe");
					} catch (IOException e1) {}
						
						
					}
					
					
					
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					add.setForeground(Color.green);
					add.setBackground(Color.black);
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					add.setForeground(Color.white);
					add.setBackground(Color.green);
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {}
			});
             
           
             
             JTextField Msg = new JTextField();
             Msg.setBounds(40, 70, 250, 20);
             Msg.setBackground(Color.black);
             Msg.setForeground(Color.green);
            
             
         }
         
         
  
   
     }