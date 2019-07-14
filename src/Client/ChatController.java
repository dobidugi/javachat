package Client;

import java.net.Socket;
import Client.ReceiveMessages;
import Client.SendMessages;

public class ChatController {
	private Socket Client;
	
	public void setSocket(Socket Client) {
		this.Client = Client;
	}
	
	private void makeThread() {
		Runnable RecMsg = new ReceiveMessages(Client);
		Runnable SendMsg = new SendMessages(Client);
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
	
	public void start() {
		makeThread();
	}
}
