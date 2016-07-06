
import java.awt.Dimension;
 
import javax.swing.*;
 
public class GUItable extends JFrame {
 
     public static void createGUI() {
          JFrame frame = new JFrame("Test frame");
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
          String[] columnNames = {
                    "Person ID"
          };
          
		  PersonTable table1=new PersonTable();
          String[][] data = table1.get();
           
          JTable table = new JTable(data, columnNames);
           
          JScrollPane scrollPane = new JScrollPane(table);
           
          frame.getContentPane().add(scrollPane);
          frame.setPreferredSize(new Dimension(450, 200));
          frame.pack();
          frame.setLocationRelativeTo(null);
          frame.setVisible(true);
     }
 
     public static void main(String[] args) {
          javax.swing.SwingUtilities.invokeLater(new Runnable() {
               public void run() {
                    JFrame.setDefaultLookAndFeelDecorated(true);
                    createGUI();
               }
          });
     }
}
