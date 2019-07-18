package Client;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Design {
	
	private JFrame frame;
	private JTextField input;
	private JTextArea screen;
	private JScrollPane scroll;
	
	public void makeFrame() {
		drawFrame();
		drawChatScreen();
		drawInputText();
		addComponentFrame();
		frame.setLayout(null);
		frame.setSize(400, 400);
		frame.setVisible(true);
	}
	
	private void drawFrame() {
		frame = new JFrame();
	}
		
	
	private void drawChatScreen() {
		screen = new JTextArea();
		scroll = new JScrollPane(screen);
		scroll.setBounds(1,1,400,300);
		screen.setEditable(false);
		screen.setCaretPosition(screen.getDocument().getLength());
	}
	
	private void drawInputText() {
		input = new JTextField();
		input.setBounds(1,301,400,100);
		input.setBorder(new LineBorder(Color.black,1));

	}
	
	private void addComponentFrame() {
		frame.add(scroll);
		frame.add(input);
	}
	
	public JTextArea getScreen() {
		return screen;	
	}
	
	public JTextField getInputText() {
		return input;
	}
	
	public JFrame getFrame() {
		return frame;
	}
}
