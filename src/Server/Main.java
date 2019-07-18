package Server;

import Server.ServerController;
import Server.Design;
import Server.Setting;

public class Main {
	public static void main(String[] args) {
		int port =0;
		Setting setting = new Setting();
		setting.makeFrame();
		do  {
			port = setting.getPORT();
			System.out.println("while loop");
		}while(port==0);
		Design design = new Design();
		design.makeFrame();
		ServerController Server = new ServerController();
		Server.setPort(port);
		Server.setInputText(design.getInputText());
		Server.setScreen(design.getScreen());
		Server.setFrame(design.getFrame());
		Server.start();
	}
}
