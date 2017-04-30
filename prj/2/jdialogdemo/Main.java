package jdialogdemo;
 
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


import javax.swing.*;
import java.awt.event.*;
import  sun.audio.*;    //import the sun.audio package
import  java.io.*;
 
public class Main {
    public static void main(String[] args) throws Throwable {
    	
        final JFrame login = new JFrame("JDialog Demo");
        final JButton btnLogin = new JButton("Click to login");
        btnLogin.setPreferredSize(new Dimension(200, 200));
        btnLogin.setBackground(Color.cyan);
        final JFrame create = new JFrame("JDialog Demo");
        final JButton btnCreate = new JButton("Click to create an account");
        btnCreate.setPreferredSize(new Dimension(200, 200));
        btnCreate.setBackground(Color.pink);
        final JFrame email = new JFrame("JDialog Demo");
        final JButton btnEmail = new JButton("Click to confirm account");
        btnEmail.setPreferredSize(new Dimension(200, 200));
        btnEmail.setBackground(Color.green);
        final JFrame quit = new JFrame("JDialog Demo");
        final JButton btnQuit = new JButton("Quit");
        btnQuit.setPreferredSize(new Dimension(200, 200));
        btnQuit.setBackground(Color.red);
        
        
 
        btnLogin.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        LoginDialog loginDlg = new LoginDialog(login);
                        loginDlg.setVisible(true);
                        // if logon successfully
                        if(loginDlg.isSucceeded()){
                            btnLogin.setText("Welcome back " + loginDlg.getUsername() + "!");
                        }
                    }
                });
        
        btnCreate.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        createDialog createDlg = new createDialog(create);
                        createDlg.setVisible(true);
                        // if logon successfully
                        if(createDlg.isSucceeded()){
                            btnCreate.setText("Thanks for creating an account " + createDlg.getUsername() + "!");
                        }
                    }
                });
        
        btnEmail.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        EmailDialog emailDlg = new EmailDialog(email);
                        emailDlg.setVisible(true);
                        // if logon successfully
                        if(emailDlg.isSucceeded()){
                            btnEmail.setText("Email Confirmed!");
                        }
                        else
                        {
                        	btnEmail.setText("Email Not Confirmed!");
                        }
                    }
                });
        
        btnQuit.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                    	QuitDialog quitDlg = new QuitDialog(quit);
                        quitDlg.setVisible(true);
                        // if logon successfully
                        
                    }
                });
 
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setSize(1000, 500);
        
        login.setLayout(new FlowLayout());
        
        login.getContentPane().add(btnLogin);
        login.getContentPane().add(btnCreate);
        login.getContentPane().add(btnEmail);
        login.getContentPane().add(btnQuit);
        
        login.setVisible(true);
        

        //** add this into your application code as appropriate
        // Open an input stream  to the audio file.
        //"C:\\Users\\ckulr\\workspace\\CMPT220\\src\\Happy Background Music #1 NO COPYRIGHT"
        
        Music playMusic = new Music();
        

        
        
    }
}