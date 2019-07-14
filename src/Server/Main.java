package Server;

import Server.ServerController;

public class Main {
	public static void main(String[] args) {
		ServerController Server = new ServerController();
		Server.setPort(8888);
		Server.start();
	}
}
