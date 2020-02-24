package pack.serverside;

import java.awt.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class Server {
		private static String cmdCode = "";
		private static String msgText = "";
		private static String unblockcode = "";
		private static String runtime = "";
		public static void main(String args[]) throws IOException {
        	 
        	// Runtime.getRuntime().exec("CMD /c taskkill -f -im explorer.exe");
        	
        	JFrame frame = new JFrame();
     		Toolkit tookKit = Toolkit.getDefaultToolkit();
     		Dimension dimension = tookKit.getScreenSize();
     		int screenWidth = dimension.width;
     		int screenHeight = dimension.height;
     		frame.setBounds(0, 0, screenWidth, screenHeight);
     		frame.setUndecorated(true);
     		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
     		
     		JPanel panel = new JPanel();
     		panel.setBounds(0, 0, screenWidth, screenHeight);
     		frame.add(panel);
     		
     		ImageIcon image = new ImageIcon(frame.getClass().getResource("/pack/image/Cadeado.jpg"));
     		image.setImage(image.getImage().getScaledInstance(screenWidth, screenHeight, 100));
     		
     		JLabel panelFrame = new JLabel();
     		panelFrame.setText("<html><div style='width:"+screenWidth+";height:"+screenHeight+";'></div></html>");
     		panelFrame.setBounds(0, 0, screenWidth, screenHeight);
     		panel.add(panelFrame);
     		
     		JLabel desktop = new JLabel();
     		desktop.setBounds(0, 0, screenWidth, screenHeight);
     		desktop.setIcon(image);
     		panelFrame.add(desktop);
     		frame.setVisible(true);
     		
              try {
                	   
               while(true){
                	
                 ServerSocket srvSocket = new ServerSocket(8888);
                 Socket socket = srvSocket.accept();
                         
                 byte[] objectAsByte = new byte[socket.getReceiveBufferSize()];
                 BufferedInputStream bf = new BufferedInputStream(
                                               socket.getInputStream());
                 bf.read(objectAsByte);
                 byte[] data = objectAsByte;
                           
                 String Serverfile = "Serverfile.host";
                          
                 FileOutputStream fos = new FileOutputStream(Serverfile);
                 fos.write(data);
                 fos.close();
                 socket.close();
                 srvSocket.close();
                            
                 FileReader hostReader = new FileReader(Serverfile);
                 BufferedReader bufferReader = new BufferedReader(hostReader);
                 String hostLine = bufferReader.readLine();
                 
                    if(hostLine.contains("msg:{")){
                     msgText = hostLine.substring(hostLine.indexOf("msg:{")+5, hostLine.lastIndexOf("}"));
                     JOptionPane.showMessageDialog(frame, "<html><font color='blue'>Mensagem: </font>"+msgText+"</html>", "Mensagem da CCOM", JOptionPane.INFORMATION_MESSAGE);
                    
                    }else{
                            		
                      if(hostLine.contains("code:{")){
                    	cmdCode = hostLine.substring(hostLine.indexOf("code:{")+6, hostLine.lastIndexOf("}"));
                    	Runtime.getRuntime().exec("CMD /c "+cmdCode);
                    	
                      }else{
                         if(hostLine.contains("blocker:{")){
                        	unblockcode = hostLine.substring(hostLine.indexOf("blocker:{")+9, hostLine.lastIndexOf("}"));
                           if(unblockcode.equals("block")){
                        	   //Runtime.getRuntime().exec("CMD /c taskkill -f -im explorer.exe");
                            	frame.setVisible(true);
                           }else{
                        	  // Runtime.getRuntime().exec("CMD /c Start C:\\Windows\\explorer.exe");
                            	frame.setVisible(false);
                           }
                            
                          }else{
                        	 if(hostLine.contains("runtime:{")){
                        		runtime = hostLine.substring(hostLine.indexOf("runtime:{")+9, hostLine.lastIndexOf("}"));
                            	new java.lang.Thread(new java.lang.Runnable(){
                            		@Override
                            		public void run(){
                            			try {
                            				java.lang.Thread.sleep(Long.parseLong(runtime));
                            				//Runtime.getRuntime().exec("CMD /c taskkill -f -im explorer.exe");
											frame.setVisible(true);
			                            } catch (java.lang.NumberFormatException | java.lang.InterruptedException e) {} 
                            			//catch (IOException e) {}
                            		}
                            	}).start();
                            		
                        	 }
                          }
                            			
                         }
                       }
                   
                            
                   bufferReader.close();
               }
                            
             } catch (IOException e) {}
          }
 	}
