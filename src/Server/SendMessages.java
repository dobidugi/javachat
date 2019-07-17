package Server;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;
import javax.swing.JTextArea;

public class SendMessages extends Thread {
	private JTextField input;
	private JTextArea screen;
	@Override
	public void run() {
		super.run();
		// start logic
		input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String msg;
					msg = input.getText();
					if (msg.equals("exit")) {
						System.out.println("disconnect chat");
					}
					allUserMsg(msg);
					input.setText("");
					screen.append("[Server] "+msg+'\n');
				}
			}
		});
	}

	private void allUserMsg(String msg) {
		for(int i=0;i<ServerController.List.size();i++) {
			ServerController.List.get(i).println("[Server] "+msg);
			ServerController.List.get(i).flush();
		}
	}
	
	public void setInputText(JTextField input) {
		this.input = input;
	}
	
	public void setScreen(JTextArea screen) {
		this.screen = screen;;
	}
}
