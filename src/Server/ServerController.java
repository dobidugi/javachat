package Server;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.util.ArrayList;
import java.io.PrintWriter;
import Server.ServerThread;
import Server.SendMessages;

public class ServerController {
	private ServerSocket Server;
	private Socket Client;
	private int port;
	public static ArrayList<PrintWriter> List;

	public void start() {
		List = new ArrayList<PrintWriter>();
		makeServerSocket();
		System.out.println("server start");
		makeClientSocket();
		System.out.println("waiting for user");
		makeMsgThread();
		acceptClient();
	}

	private void acceptClient() {
		while (true) {
			try {
				Client = Server.accept();
				ServerThread th = new ServerThread();
				th.setSocket(Client);
				List.add(new PrintWriter(Client.getOutputStream()));
				th.start();
			} catch (IOException e) {
				System.out.println("accept error");
			}
		}
	}

	private void makeMsgThread() {
		SendMessages th2 = new SendMessages();
		th2.start();
	}
	
	private void makeClientSocket() {
		Client = new Socket();
	}

	private void makeServerSocket() {
		try {
			Server = new ServerSocket(port);
		} catch (IOException e) {
			System.out.println("serverSocket error");
		}
	}

	public void setPort(int port) {
		this.port = port;
	}
}
