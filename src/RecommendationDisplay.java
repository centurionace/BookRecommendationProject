import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;

/**
 * This class takes in an arraylist of string containing recommended book titles 
 * and display them to the user in a JFrame
 * @author Ace
 *
 */
public class RecommendationDisplay extends JFrame {

	private JLabel book;
	private JButton closebutton;
	private ArrayList<JLabel> labels = new ArrayList<JLabel>();
	
	public RecommendationDisplay(ArrayList<String> booklist){
		
//first setting up the JFrame		
		
		this.setSize(400,400);
		setLayout(new FlowLayout());
		
//read in the list of book titles
//create a JLabel for each of them
		
		for (String bookname : booklist){
			book = new JLabel();
			book.setText(bookname);
			labels.add(book);
		}

//adding all the JLabels to the JFrame		
		
		for (JLabel book : labels){
			add(book);
		}

//also implements a close button for user to close the JFrame		
		
		closebutton = new JButton("Close window");
		add(closebutton);		
		event e = new event();
		closebutton.addActionListener(e);
		
	}
	
	public class event implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.println("event");
			setVisible(false);
		}
	}
	
	
}
