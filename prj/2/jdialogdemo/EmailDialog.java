package jdialogdemo;
 
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;

import javax.swing.*;
import javax.swing.border.*;

import java.util.*;
import java.util.List;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
 
public class EmailDialog extends JDialog {
 
    public JTextField tfEmail;
    public JTextField tfUsername;
    public JPasswordField pfPassword;
    private JLabel lbUsername;
    
    private JLabel lbEmail;
    private JLabel lbPassword;
    private JButton btnSend;
    private JButton btnConfirm;
    private JButton btnCancel;
    private boolean succeeded;
    public int accounts;
 
    public EmailDialog(Frame parent) {
        super(parent, "Confirm", true);
        //
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
 
        cs.fill = GridBagConstraints.HORIZONTAL;
        
        lbUsername = new JLabel("Username: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(lbUsername, cs);
        
 
        tfUsername = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(tfUsername, cs);
        
        lbPassword = new JLabel("Enter your Password: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(lbPassword, cs);
 
        pfPassword = new JPasswordField(20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(pfPassword, cs);
        panel.setBorder(new LineBorder(Color.GREEN));
        panel.setBackground(Color.CYAN);
 
        lbEmail = new JLabel("Email: ");
        cs.gridx = 0;
        cs.gridy = 2;
        cs.gridwidth = 1;
        //panel.add(lbEmail, cs);
 
        tfEmail = new JTextField(20);
        cs.gridx = 2;
        cs.gridy = 2;
        cs.gridwidth = 2;
        //panel.add(tfEmail, cs);
        
        lbEmail = new JLabel("Email: ");
        cs.gridx = 0;
        cs.gridy = 2;
        cs.gridwidth = 1;
        panel.add(lbEmail, cs);
        
 
        tfEmail = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 2;
        cs.gridwidth = 2;
        panel.add(tfEmail, cs);
        
        
        btnConfirm = new JButton("Confirm that it is you!");
        btnSend = new JButton("Store");
        btnSend.setBackground(Color.GREEN);
 
        btnSend.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
            	
                panel.setBorder(new LineBorder(Color.GRAY));
            	try {
            		
            		String password = null;

            		MessageDigest md = MessageDigest.getInstance("MD5");
            		md.update(getPassword().getBytes());
            		byte[] bytes = md.digest();
            		
            		StringBuilder sb = new StringBuilder();
                    for(int i=0; i< bytes.length ;i++)
                    {
                        sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
                    }
                    //Get complete hashed password in hex format
                    password = sb.toString();
            		     
            		List lines =  (List) Files.readAllLines(Paths.get("C:\\Users\\ckulr\\workspace\\CMPT220\\src\\ProjectTwo.txt"), StandardCharsets.UTF_8);
            		
                	if ((Project_Two.userConf(getUsername(), password) == true)) {
                		boolean findUser = Files.readAllLines(Paths.get("C:\\Users\\ckulr\\workspace\\CMPT220\\src\\ProjectTwo.txt")).contains("U: " + getUsername());
                		boolean findPass = Files.readAllLines(Paths.get("C:\\Users\\ckulr\\workspace\\CMPT220\\src\\ProjectTwo.txt")).contains("P: " + password);
                		boolean findEmail = Files.readAllLines(Paths.get("C:\\Users\\ckulr\\workspace\\CMPT220\\src\\ProjectTwo.txt")).contains("Email: " + getEmail());
                		String inputSearch = "P: " + password;
                		
                		
                		BufferedReader br = new BufferedReader (new FileReader ("C:\\Users\\ckulr\\workspace\\CMPT220\\src\\ProjectTwo.txt"));
                		String line;
                		File f = new File("C:\\Users\\ckulr\\workspace\\CMPT220\\src\\ProjectTwo.txt");
                        Scanner fileScanner = new Scanner(f);
                		int lineNumber = 0;
                		int countLine = 0;
                        	if(findUser == true)
                    		{
                        		while( (line = br.readLine() ) != null) {
                        		    countLine++;
                        		    if(line.equals(inputSearch)){
                        		    	lineNumber += countLine;
                        		    }
                        		    //System.out.println(lineNumber + ",");
			                        		    if(line.equals("Email: " + getEmail())){
			                        		    	
			                        		    
			                        		    	
			                        		    	JOptionPane.showMessageDialog(EmailDialog.this,
			        								        "Yes " + getEmail() + " is your email that is stored!",
			        								        "Confirmed",
			        								        JOptionPane.INFORMATION_MESSAGE);
			        								succeeded = true;
			        								
			                        		    }
			                        		    
                        		    
                        		    	
                        		}
                        		if(findEmail == false){
	                        		JOptionPane.showMessageDialog(EmailDialog.this,
	        					            "That is not the email stored!",
	        					            "Confirm",
	        					            JOptionPane.ERROR_MESSAGE);
	        					    // reset username and password
	        					    tfEmail.setText("");
	        					    succeeded = false;
                        		}
	                        		
                        		
                    		}
                        	
                        	
                        	
                        
                        fileScanner.close();
                        //System.out.printf("%d lines\n", lineNumber);
                        	
                            
                		
                		
                		
                		
					} else {
					    JOptionPane.showMessageDialog(EmailDialog.this,
					            "That is not the email stored!",
					            "Confirm",
					            JOptionPane.ERROR_MESSAGE);
					    // reset username and password
					    tfEmail.setText("");
					    
					    succeeded = false;
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
 
                }
            }
           );
                	
					
        btnCancel = new JButton("Cancel");
        btnCancel.setBackground(Color.RED);
        btnCancel.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        JPanel bp = new JPanel();
        bp.add(btnSend);
        bp.add(btnCancel);
 
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);
 
        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }
    public String getUsername() {
        return tfUsername.getText().trim();
    }
 
    
    public String getEmail() {
        return tfEmail.getText().trim();
    }
 
    public String getPassword() {
        return new String(pfPassword.getPassword());
    }
 
    public boolean isSucceeded() {
        return succeeded;
    }
    private void writeAll() {
    	Scanner scanner = new Scanner("C:\\Users\\ckulr\\workspace\\CMPT220\\src\\ProjectTwo.txt");
        BufferedWriter buf;
        String line = null;
        try {
            buf = new BufferedWriter(new FileWriter("C:\\Users\\ckulr\\workspace\\CMPT220\\src\\ProjectTwo.txt", true));
            List<String> lines =  (List<String>) Files.readAllLines(Paths.get("C:\\Users\\ckulr\\workspace\\CMPT220\\src\\ProjectTwo.txt"), StandardCharsets.UTF_8);
            Path path = Paths.get("C:\\Users\\ckulr\\workspace\\CMPT220\\src\\ProjectTwo.txt");
            	while(scanner.hasNextLine()){
            	     if(("Email: " + getEmail()).contains(scanner.nextLine().trim())){
            	    	buf.close();
                     	JOptionPane.showMessageDialog(this, "You already have done this.");
            	        break;
            	      }else{
            	    	  int position = accounts * 3;
            	    	  String extraLine = "Email: " + getEmail();
            	    	  
            	    	  lines.set(position, extraLine);
            	    	  ((BufferedWriter) path).write("C:\\Users\\ckulr\\workspace\\CMPT220\\src\\ProjectTwo.txt");
            	    	  //buf.write("Email: " + getEmail());
            	            buf.newLine();
            	            buf.close();
            	            JOptionPane.showMessageDialog(this, "Data Saved");

            	      }

            	 }
            	
            
            
 
        } catch (Exception e) {
        }
        
    }
    
}