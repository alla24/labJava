package labjava;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class TableGUI extends JPanel {

     public TableGUI() {
          super();
          setLayout(new BorderLayout());
          ArrayList<Person> list = new ArrayList<Person>();
		  PersonTable tableSource;
		  //read table object to update from file
		  try{
 
			   FileInputStream fin = new FileInputStream("PersonTable.ser");
			   ObjectInputStream ois = new ObjectInputStream(fin);
			   tableSource = new PersonTable((ArrayList)ois.readObject());
			   ois.close();
 
		  }catch(Exception ex){
			   ex.printStackTrace();
			   tableSource = new PersonTable();
		  } 

		list=tableSource.get();
		final MyTableModel model = new MyTableModel(list);
        JTable tableG = new JTable(model);
        tableG.setPreferredScrollableViewportSize(new Dimension(500, 200));
        tableG.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(tableG);// Create the scroll pane and add the table to it.
        add(scrollPane,BorderLayout.CENTER); // Add the scroll pane to this panel.
        final PersonTable temp=tableSource;
		class MyListener implements ActionListener{
			int action;
			MyListener(int action){
			this.action=action;
			}
			public void actionPerformed(ActionEvent e){
				switch(action){
			    	case 1:
			    	{
						String newID = JOptionPane.showInputDialog("Enter ID number");
						String newName = JOptionPane.showInputDialog("Enter First Name");
						String newSurname = JOptionPane.showInputDialog("Enter Surname");
						Person person=new Person(newID, newName, newSurname);
						((MyTableModel)model).add(person);};
			       case 2:
			       		{ temp.saveData();}  ;
					}
				}  
		  
		}
		JPanel inner = new JPanel();
		inner.setLayout(new GridLayout(1, 2, 10, 0));
		add(inner,BorderLayout.SOUTH);
		JButton addDataButton = new JButton("Add data");
		inner.add(addDataButton);
		addDataButton.addActionListener(new MyListener(1));
		JButton saveDataButton = new JButton("Save data");
		inner.add(saveDataButton);
		saveDataButton.addActionListener(new MyListener(2));
	}
class MyTableModel extends AbstractTableModel {
		private String[] columnNames = { "ID number", "Name", "Surname" };
        ArrayList<Person> list = null;
        MyTableModel(ArrayList<Person> list) {
        	this.list = list;
          }
        public int getColumnCount() {
        	return columnNames.length;
          }

        public int getRowCount() {
        	return list.size();
          }

        public String getColumnName(int col) {
        	return columnNames[col];
          }

        public Object getValueAt(int row, int col) {
        	Person object = list.get(row);
        	switch (col) {
               case 0:
                    return object.getID();
               case 1:
                    return object.getName();
               case 2:
                    return object.getSurname();
               default:
                    return "unknown";
               }
          }

       public Class getColumnClass(int c) {
    	   return getValueAt(0, c).getClass();
          }
       public void add(Person person) {
    	   int size = list.size();
    	   list.add(person);
    	   fireTableRowsInserted(size, size);
          }
}

     //Create the GUI and show it, should be invoked from the event-dispatching thread.
     private static void createAndShowGUI() {
          // Create and set up the window.
          JFrame frame = new JFrame("TableGUI");
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          TableGUI newContentPane = new TableGUI();// Create and set up the content pane.
          newContentPane.setOpaque(true); // content panes must be opaque
          frame.setContentPane(newContentPane);
          frame.pack();// Display the window.
          frame.setVisible(true);
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



