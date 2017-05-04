package ProjectTwo;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.*;
import javax.swing.border.*;
public class QuitDialog extends JDialog {
	
    private JLabel lbQuit;
    private boolean succeeded;
    private JButton btnQuitYes;
    private JButton btnQuitNo;
    
	
   public QuitDialog(Frame parent) {
	 super(parent, "Quit", true);
     //
     JPanel panel = new JPanel(new GridBagLayout());
     GridBagConstraints cs = new GridBagConstraints();

     cs.fill = GridBagConstraints.HORIZONTAL;

     lbQuit = new JLabel("Are you sure you want to quit?");
     cs.gridx = 0;
     cs.gridy = 0;
     cs.gridwidth = 1;
     panel.add(lbQuit, cs);
     panel.setBorder(new LineBorder(Color.GREEN));
     panel.setBackground(Color.CYAN);

     

     

     btnQuitYes = new JButton("Yes");
     btnQuitNo = new JButton("No");
     btnQuitYes.setBackground(Color.GREEN);
     btnQuitNo.setBackground(Color.RED);

     btnQuitYes.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {
         	
         	
         		
             	Project_Two.quitProgram();
         	
         
     }});
         	
 		
        
     btnQuitNo.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {
         	
         	
         		
             	dispose();
         	
         
     }});
     JPanel bp = new JPanel();
     bp.add(btnQuitYes);
     bp.add(btnQuitNo);
     

     getContentPane().add(panel, BorderLayout.CENTER);
     getContentPane().add(bp, BorderLayout.PAGE_END);

     pack();
     setResizable(false);
     setLocationRelativeTo(parent);
 
     


}
     
   }

