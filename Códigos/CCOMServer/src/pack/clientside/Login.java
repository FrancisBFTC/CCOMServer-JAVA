package pack.clientside;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.*;

public class Login extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel painel;
	private JLabel user;
	private JLabel pass;
	private JPasswordField userField;
	private JPasswordField passField;
	private JButton logButton;
	private String userText;
	private String passText;
	private JLabel incUser;
	private JLabel incPass;
	private String myUser = "bftcorporations";
	private String myPass = "wenderson";
	
	public Login(){
			
		ImageIcon image = new ImageIcon(this.getClass().getResource("/pack/image/Cadeado.jpg"));
  		image.setImage(image.getImage().getScaledInstance(130, 250, 100));
  		
  		ImageIcon img = new ImageIcon(this.getClass().getResource("/pack/image/Cadeado.jpg"));
  		img.setImage(img.getImage().getScaledInstance(100, 100, 100));
  		
    	 this.setBounds(400, 200, 400, 250);
    	 this.setResizable(false);
    	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	 this.setTitle("CCOM login");
    	 this.setIconImage(img.getImage());
    	 
    	 painel = new JLabel();
    	 painel.setBounds(0, 0, 400, 250);
    	 painel.setText("<html><div style='width:400;height:250;background:black;'></div></html>");
    	 this.add(painel);
    	 
    	 JLabel labelImage = new JLabel();
    	 labelImage.setText("<html><div style='width:130;height:250;background:green;'></div></html>");
    	 labelImage.setBounds(270, 0, 130, 250);
    	 labelImage.setIcon(image);
    	 painel.add(labelImage);
    	 
    	 user = new JLabel();
    	 user.setBounds(40, 40, 35, 20);
    	 user.setText("User:");
    	 user.setForeground(Color.green);
    	 painel.add(user);
    	 
    	 pass = new JLabel();
    	 pass.setBounds(40, 70, 35, 20);
    	 pass.setText("Pass:");
    	 pass.setForeground(Color.green);
    	 painel.add(pass);
    	 
    	 userField = new JPasswordField();
    	 userField.setBounds(80, 40, 170, 20);
    	 userField.setForeground(Color.green);
    	 userField.setBackground(Color.black);
    	 userField.setCaretColor(Color.green);
    	 painel.add(userField);
    	 
    	 passField = new JPasswordField();
    	 passField.setBounds(80, 70, 170, 20);
    	 passField.setForeground(Color.green);
    	 passField.setBackground(Color.black);
    	 passField.setCaretColor(Color.green);
    	 painel.add(passField);
    	 
    	 incUser = new JLabel();
    	 incUser.setBounds(0, 40, 150, 20);
    	 incUser.setForeground(Color.red);
    	 incUser.setVisible(false);
    	 incUser.setFont(new Font("Arial", 0, 12));
    	 incUser.setBackground(Color.green);
    	 labelImage.add(incUser);
    	 
    	 incPass = new JLabel();
    	 incPass.setBounds(0, 70, 150, 20);
    	 incPass.setForeground(Color.red);
    	 incPass.setVisible(false);
    	 incPass.setFont(new Font("Arial", 0, 12));
    	 incPass.setBackground(Color.green);
    	 labelImage.add(incPass);
    	 
    	 logButton = new JButton();
    	 logButton.setBounds(120, 100, 100, 30);
    	 logButton.setText("Sign in");
    	 logButton.setForeground(Color.green);
    	 logButton.setBackground(Color.black);
    	 logButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    	 painel.add(logButton);
    	 
    	 userField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {}
			
			@Override
			public void keyReleased(KeyEvent arg0) {}
			
			@SuppressWarnings("deprecation")
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER){
					userText = userField.getText();
					passText = passField.getText();
					
					if(userText.isEmpty()){
						incUser.setText("<html><div style='width:150;height:20;background:black;'>Preencha o usuário!</div></html>");
						incUser.setVisible(true);
						if(passText.isEmpty()){
							incPass.setText("<html><div style='width:150;height:20;background:black;'>Preencha a senha!</div></html>");
							incPass.setVisible(true);
						}else{
							if(!passText.equals(myPass)){
								incPass.setText("<html><div style='width:150;height:20;background:black;'>Senha Incorreta!</div></html>");
								incPass.setVisible(true);
							}
						}
					}else{
						incUser.setVisible(false);
						
						if(!userText.equals(myUser)){
							incUser.setText("<html><div style='width:150;height:20;background:black;'>Usuário Incorreto!</div></html>");
							incUser.setVisible(true);
						
						}
					
						if(passText.isEmpty()){
							incPass.setText("<html><div style='width:150;height:20;background:black;'>Preencha a senha!</div></html>");
							incPass.setVisible(true);
						}else{
							incPass.setVisible(false);
							
							if(!passText.equals(myPass)){
								incPass.setText("<html><div style='width:150;height:20;background:black;'>Senha Incorreta!</div></html>");
								incPass.setVisible(true);
							}
							
							if(!userText.equals(myUser)){
								incUser.setText("<html><div style='width:150;height:20;background:black;'>Usuário Incorreto!</div></html>");
								incUser.setVisible(true);
								
								if(!passText.equals(myPass)){
									incPass.setText("<html><div style='width:150;height:20;background:black;'>Senha Incorreta!</div></html>");
									incPass.setVisible(true);
								}
							}else{
								incUser.setVisible(false);
								
								if(!passText.equals(myPass)){
									incPass.setText("<html><div style='width:150;height:20;background:black;'>Senha Incorreta!</div></html>");
									incPass.setVisible(true);
								}else{
									incPass.setVisible(false);
									setVisible(false);
									Interface ccomserver;
									try {
										ccomserver = new Interface();
										ccomserver.setVisible(true);
									} catch (IOException e) {}
									
									
								}
								
							}
							
						}
					
					}
				}
			}
		});
    	 
    	 passField.addKeyListener(new KeyListener() {
 			
 			@Override
 			public void keyTyped(KeyEvent arg0) {}
 			
 			@Override
 			public void keyReleased(KeyEvent arg0) {}
 			
 			@SuppressWarnings("deprecation")
 			@Override
 			public void keyPressed(KeyEvent arg0) {
 				
 				if(arg0.getKeyCode() == KeyEvent.VK_ENTER){
 					userText = userField.getText();
 					passText = passField.getText();
 					
 					if(userText.isEmpty()){
 						incUser.setText("<html><div style='width:150;height:20;background:black;'>Preencha o usuário!</div></html>");
 						incUser.setVisible(true);
 						if(passText.isEmpty()){
 							incPass.setText("<html><div style='width:150;height:20;background:black;'>Preencha a senha!</div></html>");
 							incPass.setVisible(true);
 						}else{
 							if(!passText.equals(myPass)){
 								incPass.setText("<html><div style='width:150;height:20;background:black;'>Senha Incorreta!</div></html>");
 								incPass.setVisible(true);
 							}
 						}
 					}else{
 						incUser.setVisible(false);
 						
 						if(!userText.equals(myUser)){
 							incUser.setText("<html><div style='width:150;height:20;background:black;'>Usuário Incorreto!</div></html>");
 							incUser.setVisible(true);
 						
 						}
 					
 						if(passText.isEmpty()){
 							incPass.setText("<html><div style='width:150;height:20;background:black;'>Preencha a senha!</div></html>");
 							incPass.setVisible(true);
 						}else{
 							incPass.setVisible(false);
 							
 							if(!passText.equals(myPass)){
 								incPass.setText("<html><div style='width:150;height:20;background:black;'>Senha Incorreta!</div></html>");
 								incPass.setVisible(true);
 							}
 							
 							if(!userText.equals(myUser)){
 								incUser.setText("<html><div style='width:150;height:20;background:black;'>Usuário Incorreto!</div></html>");
 								incUser.setVisible(true);
 								
 								if(!passText.equals(myPass)){
 									incPass.setText("<html><div style='width:150;height:20;background:black;'>Senha Incorreta!</div></html>");
 									incPass.setVisible(true);
 								}
 							}else{
 								incUser.setVisible(false);
 								
 								if(!passText.equals(myPass)){
 									incPass.setText("<html><div style='width:150;height:20;background:black;'>Senha Incorreta!</div></html>");
 									incPass.setVisible(true);
 								}else{
 									incPass.setVisible(false);
 									
 									Interface ccomserver;
 									try {
 										ccomserver = new Interface();
 										ccomserver.setVisible(true);
 									} catch (IOException e) {}
 									
 									setVisible(false);
 								}
 								
 							}
 							
 						}
 					
 					}
 				}
 			}
 		});
    	 
    	 logButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent evt) {}
			
			@SuppressWarnings("deprecation")
			@Override
			public void mousePressed(MouseEvent evt) {
				userText = userField.getText();
				passText = passField.getText();
				
				if(userText.isEmpty()){
					incUser.setText("<html><div style='width:150;height:20;background:black;'>Preencha o usuário!</div></html>");
					incUser.setVisible(true);
					if(passText.isEmpty()){
						incPass.setText("<html><div style='width:150;height:20;background:black;'>Preencha a senha!</div></html>");
						incPass.setVisible(true);
					}else{
						if(!passText.equals(myPass)){
							incPass.setText("<html><div style='width:150;height:20;background:black;'>Senha Incorreta!</div></html>");
							incPass.setVisible(true);
						}
					}
				}else{
					incUser.setVisible(false);
					
					if(!userText.equals(myUser)){
						incUser.setText("<html><div style='width:150;height:20;background:black;'>Usuário Incorreto!</div></html>");
						incUser.setVisible(true);
					
					}
				
					if(passText.isEmpty()){
						incPass.setText("<html><div style='width:150;height:20;background:black;'>Preencha a senha!</div></html>");
						incPass.setVisible(true);
					}else{
						incPass.setVisible(false);
						
						if(!passText.equals(myPass)){
							incPass.setText("<html><div style='width:150;height:20;background:black;'>Senha Incorreta!</div></html>");
							incPass.setVisible(true);
						}
						
						if(!userText.equals(myUser)){
							incUser.setText("<html><div style='width:150;height:20;background:black;'>Usuário Incorreto!</div></html>");
							incUser.setVisible(true);
							
							if(!passText.equals(myPass)){
								incPass.setText("<html><div style='width:150;height:20;background:black;'>Senha Incorreta!</div></html>");
								incPass.setVisible(true);
							}
						}else{
							incUser.setVisible(false);
							
							if(!passText.equals(myPass)){
								incPass.setText("<html><div style='width:150;height:20;background:black;'>Senha Incorreta!</div></html>");
								incPass.setVisible(true);
							}else{
								incPass.setVisible(false);
								
								Interface ccomserver;
								try {
									ccomserver = new Interface();
									ccomserver.setVisible(true);
								} catch (IOException e) {}
								
								setVisible(false);
							}
							
						}
						
					}
				
				}
			}
			
			@Override
			public void mouseExited(MouseEvent evt) {
				logButton.setForeground(Color.green);
				logButton.setBackground(Color.black);
			}
			
			@Override
			public void mouseEntered(MouseEvent evt) {
				logButton.setForeground(Color.white);
				logButton.setBackground(Color.green);
			}
			
			@Override
			public void mouseClicked(MouseEvent evt) {}
		});
    	 
	}
	

	public static void main(String args[]) throws IOException {
		
		Login login = new Login();
		login.setVisible(true);
         
    }
}
