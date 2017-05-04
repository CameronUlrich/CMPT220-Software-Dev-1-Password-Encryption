package ProjectTwo;
 
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.List;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.swing.*;
import javax.swing.border.*;
 
public class LoginDialog extends JDialog {
 
    public JTextField tfUsername;
    public JPasswordField pfPassword;
    private JLabel lbUsername;
    private JLabel lbPassword;
    private JButton btnLogin;
    private JButton btnCancel;
    private boolean succeeded;
    
 
    public LoginDialog(Frame parent) {
        super(parent, "Login", true);
        
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
 
        lbPassword = new JLabel("Password: ");
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
 
        btnLogin = new JButton("Login");
        btnLogin.setBackground(Color.GREEN);
 
        btnLogin.addActionListener(new ActionListener() {
        	 
            public void actionPerformed(ActionEvent e) {
            	
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
            		
                        /*
		            		String line;
		            		
		            		KeyGenerator keygenerator = KeyGenerator.getInstance("MD5");
		                    SecretKey myDesKey = keygenerator.generateKey();
		                    
		                    Cipher desCipher;
		                    Cipher inCipher;
		                    desCipher = Cipher.getInstance("MD5");
		                    inCipher = Cipher.getInstance("MD5");
		
		
		                    byte[] text = getPassword().getBytes("UTF-8");
		
		
		                    desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
		                    byte[] textEncrypted = desCipher.doFinal(text);
		
		                    String encryptPass = new String(textEncrypted);
		                    //System.out.println(s);
		
		                    inCipher.init(Cipher.DECRYPT_MODE, myDesKey);
		                    byte[] textDecrypted = inCipher.doFinal(textEncrypted);
		
		                    String decryptPass = new String(textDecrypted);
                    */
                    
                    
            		List lines =  (List) Files.readAllLines(Paths.get("C:\\Users\\ckulr\\workspace\\CMPT220\\src\\ProjectTwo.txt"), StandardCharsets.UTF_8);
                	if (lines.contains("U: " + getUsername()) && lines.contains("P: " + password)) {
    					JOptionPane.showMessageDialog(LoginDialog.this,
    					        "Hi  " + getUsername() + ", you have successfully logged in.",
    					        "Login",
    					        JOptionPane.INFORMATION_MESSAGE);
    					succeeded = true;
    					
    					dispose();
					} 
                	else {
					    JOptionPane.showMessageDialog(LoginDialog.this,
					            "You haven't created an account yet or that password or username is incorrect!",
					            "Login",
					            JOptionPane.ERROR_MESSAGE);
					    // reset username and password
					    tfUsername.setText("");
					    pfPassword.setText("");
					    
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
        bp.add(btnLogin);
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
 
    public String getPassword() {
    	
    	
        	return new String(pfPassword.getPassword());
    	
    	
    }
    
    
 
    public boolean isSucceeded() {
        return succeeded;
    }
    private void writeAll() {
		  
        BufferedWriter buf;
        try {
            buf = new BufferedWriter(new FileWriter("C:\\Users\\ckulr\\workspace\\CMPT220\\src\\ProjectTwo.txt", true));
            buf.write(getUsername() + "\r\n" + getPassword());
            buf.newLine();
            buf.close();
            JOptionPane.showMessageDialog(this, "You have successfully logged in.");
 
        } catch (Exception e) {
        }
    }
}