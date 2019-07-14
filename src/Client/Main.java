package Client;

import Client.ChatController;
import java.net.Socket;

public class Main {
	public static void main(String[] arags) {
		Socket Client = null;
		ChatController Chat = new ChatController();
		System.out.println("I`m Client");
		System.out.println("waiting for connect...");
		try {
			Client = new Socket("127.0.0.1", 8888);
			System.out.println("succes connect");
		} catch (Exception e) {
			System.out.println("failed connet");
		}
		try {
			Chat.setSocket(Client);
			System.out.println("chat start");
			Chat.start();
		} catch (Exception e) {
			System.out.println("Thread error");
		}
	}
}