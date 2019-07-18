package Server;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Setting {
	
	private JFrame frame;
	private JLabel portlabel;
	private JTextField portfield;
	private JButton start;
	private int port;
	
	public void makeFrame() {
		drawFrame();
		drawPortSection();
		drawStartButton();
		frame.setLayout(null);
		frame.setSize(200, 100);
		frame.setVisible(true);
	}
	
	private void drawFrame() {
		frame = new JFrame();
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				System.exit(0);
		    }
		});
	}
	
	private void drawPortSection() {
		drawPortlabel();
		drawPortTextField();
		
	}
	
	private void drawPortlabel() {
		portlabel = new JLabel("PORT ");
		portlabel.setBounds(1,1,50,20);
		frame.add(portlabel);
		
	}
	
	private void drawStartButton() {
		start = new JButton("SERVER START");
		start.setBounds(1,21,200,40);
		start.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
			            port = Integer.valueOf(portfield.getText());
			            frame.dispose();
			        }  
			    }); 
		frame.add(start);
	}
	
	private void drawPortTextField() {
		portfield =new JTextField();
		portfield.setBounds(51,1,100,20);
		portfield.setHorizontalAlignment(JTextField.CENTER);
		frame.add(portfield);
	}
	
	public int getPORT() {
		return this.port;
	}
	
}
