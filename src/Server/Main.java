package Server;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.util.ArrayList;
import java.io.PrintWriter;
import Server.ServerThread;
import Server.SendMessages;

public class Main {
	public static ArrayList<PrintWriter> List;
	public static void main(String[] args) {
		List = new ArrayList<PrintWriter>();
		try {
			ServerSocket Server = new ServerSocket(8888);
			Socket Client = new Socket();
			SendMessages th2 = new SendMessages();
			th2.start();
			System.out.println("Server Start");
			while (true) {
				Client = Server.accept();
				System.out.println("Connet");
				ServerThread th = new ServerThread();
				th.setSocket(Client);
				List.add(new PrintWriter(Client.getOutputStream()));
				th.start();
			}
		} catch (IOException e) {
			System.out.println("Exception");
		}

	}

}
