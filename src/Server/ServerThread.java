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
				msg = userin.readLine();
				if(msg == null) {
					System.out.println(this.ID+" out chat.");
					Client.close();
					break;
				}
				else {
					totalmsg = this.ID +" : "+msg;
					System.out.println(totalmsg);
					for(int i=0;i<Main.List.size();i++) {
						Main.List.get(i).println(totalmsg);
						Main.List.get(i).flush();
					}
				}
			}
		} catch (IOException e) {

		}
	}

	private void setID() {
		try {
			this.ID = userin.readLine();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	private void makeUserInBuff() {
		try {
			this.userin = new BufferedReader(new InputStreamReader(Client.getInputStream()));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setSocket(Socket Client) {
		this.Client = Client;
	}

}
