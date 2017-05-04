package ProjectTwo;

import java.util.Hashtable;
import java.util.List;
import java.util.Enumeration;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import javax.swing.border.*;


import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
 
public class createDialog extends JDialog {
 
    public JTextField tfUsername;
    public JPasswordField pfPassword;
    private JLabel lbUsername;
    private JLabel lbPassword;
    private JLabel lbEmail;
    public JTextField tfEmail;
    private JButton btnLogin;
    private JButton btnCancel;
    private boolean succeeded;
    public static final int PASSWORD_REQUIRED_LENGTH = 7;
    
    
 
    public createDialog(Frame parent) {
        super(parent, "Login", true);
        //
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
 
        cs.fill = GridBagConstraints.HORIZONTAL;
        
        
 
        lbUsername = new JLabel("Create an Username: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(lbUsername, cs);
 
        tfUsername = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(tfUsername, cs);
 
        lbPassword = new JLabel("Create a Password: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(lbPassword, cs);
 
        pfPassword = new JPasswordField(20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(pfPassword, cs);
        panel.setBorder(new LineBorder(Color.GRAY));
        
        lbEmail = new JLabel("Store your Email: ");
        cs.gridx = 0;
        cs.gridy = 2;
        cs.gridwidth = 1;
        panel.add(lbEmail, cs);
 
        tfEmail = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 2;
        cs.gridwidth = 2;
        panel.add(tfEmail, cs);
        panel.setBorder(new LineBorder(Color.GREEN));
        panel.setBackground(Color.CYAN);
 
        btnLogin = new JButton("Create");
        btnLogin.setBackground(Color.GREEN);
 
        btnLogin.addActionListener(new ActionListener() {
 
            @SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
            	
            	
            		
            	
		            try {
		            	if(userField() == false){
		            		JOptionPane.showMessageDialog(createDialog.this,
						            "You haven't filled out a username!",
						            "Login",
						            JOptionPane.ERROR_MESSAGE);
						    // reset username and password
						    
						    succeeded = false;
		            	}
		            	else if(passField() == false){
		            		JOptionPane.showMessageDialog(createDialog.this,
						            "You haven't filled out a password!",
						            "Login",
						            JOptionPane.ERROR_MESSAGE);
						    // reset username and password
						    
						    succeeded = false;
		            	}
		            	else if(emailField() == false){
		            		JOptionPane.showMessageDialog(createDialog.this,
						            "You haven't filled out an email!",
						            "Login",
						            JOptionPane.ERROR_MESSAGE);
						    // reset username and password
						    
						    succeeded = false;
		            	}
		            	else{
		            		
		            	
			            	List lines =  (List) Files.readAllLines(Paths.get("C:\\Users\\ckulr\\workspace\\CMPT220\\src\\ProjectTwo.txt"), StandardCharsets.UTF_8);
			            	if (Project_Two.create(getUsername(), getPassword(), getEmail()) && getEmail().contains("@") && !lines.contains("U: " + getUsername()) && isValidPassword(getPassword())) {
								JOptionPane.showMessageDialog(createDialog.this,
								        "Hi " + getUsername() + "! You have successfully created an account and logged in.",
								        "Login",
								        JOptionPane.INFORMATION_MESSAGE);
								succeeded = true;
								
								writeAll();
								dispose();
							} 
			            	else if(!isValidPassword(getPassword())) {
								JOptionPane.showMessageDialog(createDialog.this,
							            "A password must have at least seven characters.\n" +
						                "A password consists of only letters and digits.\n" +
						                "A password must contain at least two digits \n" +
						                "Enter a password meeting the requirements above: ",
							            "Login",
							            JOptionPane.ERROR_MESSAGE);
							    // reset username and password
							    
							    pfPassword.setText("");
							    
							    succeeded = false;
								
							}else if(!getEmail().contains("@")) {
								JOptionPane.showMessageDialog(createDialog.this,
							            "Your email must have an @ symbol for it to be a valid email!",
							            "Email Error",
							            JOptionPane.ERROR_MESSAGE);
							    // reset username and password
							    
							    tfEmail.setText("");
							    
							    succeeded = false;
								
							}
			            	
			            	else {
							    JOptionPane.showMessageDialog(createDialog.this,
							            "This username is already taken!",
							            "Login",
							            JOptionPane.ERROR_MESSAGE);
							    // reset username and password
							    tfUsername.setText("");
							    pfPassword.setText("");
							    tfEmail.setText("");
							    succeeded = false;
							}
			            	
						} 
		            }
						
		            	
		            	catch (HeadlessException e1) {
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
    
    public static boolean isValidPassword(String password) {
    	

        if (password.length() < PASSWORD_REQUIRED_LENGTH) return false;

        int charCount = 0;
        int numCount = 0;
        for (int i = 0; i < password.length(); i++) {

            char ch = password.charAt(i);

            if (isNumeric(ch)) numCount++;
            else if (isLetter(ch)) charCount++;
            else return false;
        }


        return (charCount >= 2 && numCount >= 2);
    }

    public static boolean isLetter(char ch) {
        ch = Character.toUpperCase(ch);
        return (ch >= 'A' && ch <= 'Z');
    }


    public static boolean isNumeric(char ch) {

        return (ch >= '0' && ch <= '9');
    }
    
    
    public String getEmail() {
        return tfEmail.getText().trim();
    }
    
 
    public boolean isSucceeded() {
        return succeeded;
    }
    public boolean userField(){
    	if(tfUsername.getText().trim().isEmpty())
    	{
    		return false;
    	}
    	return true;
    }
    public boolean passField(){
    	if(pfPassword.getText().trim().isEmpty())
    	{
    		return false;
    	}
    	return true;
    }
    public boolean emailField(){
    	if(tfEmail.getText().trim().isEmpty())
    	{
    		return false;
    	}
    	return true;
    }
    
    
    
    
    private void writeAll() {
    	
    	      
 	   
        BufferedWriter buf;
        try {
        	try{
        		
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
                KeyGenerator keygenerator = KeyGenerator.getInstance("UTF-8");
                SecretKey myDesKey = keygenerator.generateKey();

                Cipher desCipher;
                Cipher inCipher;
                desCipher = Cipher.getInstance("UTF-8");
                inCipher = Cipher.getInstance("UTF-8");


                byte[] text = getPassword().getBytes("UTF-8");


                desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
                byte[] textEncrypted = desCipher.doFinal(text);

                String encryptPass = new String(textEncrypted);
                //System.out.println(s);

                inCipher.init(Cipher.DECRYPT_MODE, myDesKey);
                byte[] textDecrypted = inCipher.doFinal(textEncrypted);

                String decryptPass = new String(textDecrypted);
                //System.out.println(s);
                 * 
                 */
                buf = new BufferedWriter(new FileWriter("C:\\Users\\ckulr\\workspace\\CMPT220\\src\\ProjectTwo.txt", true));
                buf.write("U: " + getUsername() + "\r\nP: " + password + "\r\nEmail: " + getEmail());
                buf.newLine();
                buf.close();
                JOptionPane.showMessageDialog(this, "Account Saved.");
            }catch(NoSuchAlgorithmException e)
            {
            	e.printStackTrace();
            }
            
 
        } catch (Exception e) {
        }
    }
}