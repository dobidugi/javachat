package Client;

import java.net.Socket;

import javax.swing.JTextField;
import javax.swing.JTextArea;

import Client.ReceiveMessages;
import Client.SendMessages;

public class ChatController {
	private Socket Client;
	private JTextField input;
	private JTextArea screen;
	
	public void setSocket(Socket Client) {
		this.Client = Client;
	}
	
	private void makeThread() {
		Runnable RecMsg = new ReceiveMessages(Client,screen);
		Runnable SendMsg = new SendMessages(Client,input);
		Thread th1 = new Thread(RecMsg);
		Thread th2 = new Thread(SendMsg);
		th1.start();
		th2.start();
		while(true) {
			if(th1.getState() == Thread.State.TERMINATED)
			{
				th2.stop();
				break;
			}
		}
	}
	
	public void setScreen(JTextArea screen) {
		this.screen = screen;
	}
	
	public void setInputText(JTextField input) {
		this.input = input;
	}
	
	public void start() {
		makeThread();
	}
}
