package Server;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ServerThread extends Thread {
	private Socket Client;
	public String msg;
	private String ID;
	private String totalmsg;
	private BufferedReader userin;

	@Override
	public void run() {
		super.run();
		makeUserInBuff();
		setID();
		try {
			while (true) {
				msg = (String) userin.readLine();
				if (msg == null) {
					outLog();
					break;
				} else {
					allUserSendMsg();
				}
			}
		} catch (IOException e) {

		}
	}

	private void setID() {
		try {
			this.ID = userin.readLine();
			msg = " join the chat";
			allUserSendMsg();
			inLog();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void makeUserInBuff() {
		try {
			this.userin = new BufferedReader(new InputStreamReader(Client.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void allUserSendMsg() {
		totalmsg = this.ID + " : " + msg;
		System.out.println(totalmsg);
		for (int i = 0; i < ServerController.List.size(); i++) {
			ServerController.List.get(i).println(totalmsg);
			ServerController.List.get(i).flush();
		}
	}

	private void outLog() {
		System.out.println(this.ID + " out the chat.");
		try {
			msg = " out the chat";
			allUserSendMsg();
			Client.close();
		} catch (Exception e) {
			System.out.println("Client close error");
		}
	}
	
	private void inLog() {
		System.out.println(this.ID+" join the chat.");
	}

	public void setSocket(Socket Client) {
		this.Client = Client;
	}
}
