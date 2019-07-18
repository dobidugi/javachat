package Client;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Setting {
	
	private JFrame frame;
	private JLabel iplabel;
	private JTextField ipfield;
	private JLabel portlabel;
	private JTextField portfield;
	private JLabel idlabel;
	private JTextField idfield;
	private JButton connect;
	
	private String ip = null;
	private int port = 0;
	private String id = null;
	
	public void makeFrame() {
		drawFrame();
		drawIpSection();
		drawPortSection();
		drawIDSection();
		drawConnectButton();
		frame.setLayout(null);
		frame.setSize(200, 150);
		frame.setVisible(true);
	}
	
	private void drawIpSection() {
		drawIpLabel();
		drawIpTextField();
	}
	
	private void drawIpLabel() {
		iplabel = new JLabel("IP ");
		iplabel.setBounds(1,1,50,20);
		frame.add(iplabel);
	}
	
	private void drawIpTextField() {
		ipfield = new JTextField();
		ipfield.setBounds(51,1,100,20);
		ipfield.setHorizontalAlignment(JTextField.CENTER);
		frame.add(ipfield);
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				System.exit(0);
		    }
		});
	}
	
	
	private void drawPortSection() {
		drawPortLabel();
		drawPortTextField();
	}
	
	private void drawPortLabel() {
		portlabel = new JLabel("PORT ");
		portlabel.setBounds(1,20,50,20);
		frame.add(portlabel);
	}
	
	private void drawPortTextField() {
		portfield = new JTextField();
		portfield.setBounds(51,20,100,20);
		portfield.setHorizontalAlignment(JTextField.CENTER);
		frame.add(portfield);
	}
	
	private void drawIDSection() {
		drawIDlabel();
		drawIDTextField();
	}
	
	private void drawIDlabel() {
		idlabel = new JLabel("ID ");
		idlabel.setBounds(1,40,50,20);
		frame.add(idlabel);
	}
	
	private void drawIDTextField() {
		idfield = new JTextField();
		idfield.setBounds(51,40,100,20);
		idfield.setHorizontalAlignment(JTextField.CENTER);
		frame.add(idfield);
	}
	
	private void drawConnectButton() {
		connect = new JButton("CONNECT");
		connect.setBounds(1,60,200,50);
		connect.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
			            ip = ipfield.getText();
			            port = Integer.valueOf(portfield.getText());
			            id = idfield.getText();
			            frame.dispose();
			        }  
			    });  
		frame.add(connect);
	}
	
	private void drawFrame(){
		frame = new JFrame();
	}
	
	public String getID() {
		return this.id;
	}
	
	public String getIP() {
		return this.ip;
	}
	
	public int getPORT() {
		return this.port;
	}
}
