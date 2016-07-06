package labjava;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import labjava.TableGUI.MyTableModel;


public class EditGUI extends JFrame
{  // Instantiate textfields for input and a textarea for output.
	public JLabel idLabel = new JLabel("ID number");
	public JLabel nameLabel = new JLabel("Name");
	public JLabel surnameLabel = new JLabel("Surname");
	public JButton addDataButton = new JButton("Add entry to the database");
	public JTextArea output = new JTextArea(3,20);
	private JTextField inputID = new JTextField(8);
	private JTextField inputName = new JTextField(20);
	private JTextField inputSurname = new JTextField(20);

   public EditGUI()
   {  // Register a listener with the button
		  class MyListener implements ActionListener{
	
				public void actionPerformed(ActionEvent e){
					String newID = inputID.getText();
					String newName = inputName.getText();
					String newSurname = inputSurname.getText();

					//try connecting through rmi to update the table
					try{
					   String[] arguments=new String[]{newID,newName,newSurname};
					   RemoteAddingUser.main(arguments);
					   output.setText("This person has been added!");
					   inputID.setText("");
					   inputName.setText("");
					   inputSurname.setText("");
				 
					}catch(Exception ex){
					   ex.printStackTrace();
					   output.setText("A problem happened during adding entry...");
					   }
			       }
				}  
		  
  	  addDataButton.addActionListener(new MyListener());
 
      // Don't let the user change the output.
      output.setEditable(false);

      // Add all the components to the frame
      this.getContentPane().add(idLabel);
	  this.getContentPane().add(inputID);
	  this.getContentPane().add(nameLabel);
	  this.getContentPane().add(inputName);
	  this.getContentPane().add(surnameLabel);
	  this.getContentPane().add(inputSurname);
      this.getContentPane().add(output);
	  this.getContentPane().add(addDataButton);
	  this.getContentPane().add(output);
      inputID.requestFocus();        // start with focus on this field
   }

        /**
      * Create the GUI and show it. For thread safety, this method should be
      * invoked from the event-dispatching thread.
      */
     private static void createAndShowGUI() {
          // Create and set up the window.
          EditGUI frame = new EditGUI();
		  frame.setTitle("Add new entries");
		  frame.setLocation(20,100);
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setLayout(new GridLayout(4,2));
		  frame.setPreferredSize(new Dimension(420, 300)); 
          frame.pack();//sets the minimum size needed to display GUI
          frame.setVisible(true);          // Display the window.
     }

     public static void main(String[] args) {
          // Schedule a job for the event-dispatching thread: creating and showing this application's GUI.
          javax.swing.SwingUtilities.invokeLater(new Runnable() {
               public void run() {
                    createAndShowGUI();
               }
          });
     }
 }


