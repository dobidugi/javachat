package Server;

import Server.ServerController;
import Server.Design;
public class Main {
	public static void main(String[] args) {
		Design design = new Design();
		design.makeFrame();
		ServerController Server = new ServerController();
		Server.setPort(8888);
		Server.setInputText(design.getInputText());
		Server.setScreen(design.getScreen());
		Server.setFrame(design.getFrame());
		Server.start();
	}
}
