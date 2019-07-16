package Client;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;

public class Design {
	
	private JFrame frame;
	private JTextField input;
	private JTextArea screen;
	
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
		screen.setBounds(1,1,400,300);
	}
	
	private void drawInputText() {
		input = new JTextField();
		input.setBounds(1,301,400,100);
		input.setBorder(new LineBorder(Color.black,1));
		/*input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					screen.append(input.getText()+"\n");
					input.setText("");
				}
			}
		});*/

	}
	
	private void addComponentFrame() {
		frame.add(screen);
		frame.add(input);
	}
	
	public JTextArea getScreen() {
		return screen;	
	}
	
	public JTextField getInputText() {
		return input;
	}
}
