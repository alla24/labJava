import java.awt.*;
import javax.swing.*;

public class swingTest1 {
	public static void main (String[] args){
		JFrame frame=new JFrame("Title can be here");
		frame.setSize(600,400);
		frame.setTitle("This is title form...");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//What to do when closed
		frame.setLocationRelativeTo(null); //To open form in the centre of the screen
		frame.setLayout(new GridBagLayout());
		JButton myButton = new JButton("Send data");
		myButton.setBackground(Color.YELLOW);
		JButton myButton2 = new JButton("Send data");
		JButton myButton3 = new JButton("Send data");
		JTextField textField = new JTextField(20);
		textField.setEditable(true);
		textField.getText();
		
		frame.add(myButton);//add component
		frame.add(myButton2);//add component
		frame.add(myButton3);//add component
		frame.add(textField);

		
		frame.setVisible(true);		
		//components
		//their positioning
		//listeners
	}
}