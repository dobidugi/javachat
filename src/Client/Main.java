package Client;

import Client.ChatController;
import Client.Design;
import Client.Setting;

import java.net.Socket;

public class Main {
	public static void main(String[] arags) {
		String ip;
		int port;
		String id;
		
		Setting setting = new Setting();
		setting.makeFrame();
		do {
			ip = setting.getIP();
			port = setting.getPORT();
			id = setting.getID();
			if(ip!=null || port!=0 || id!=null) {
				break;
			}
			else { System.out.print("while settings"); }
		} while(true);
		
		Design design = new Design();
		design.makeFrame();
		Socket Client = null;
		ChatController Chat = new ChatController();
		Chat.setInputText(design.getInputText());
		Chat.setScreen(design.getScreen());
		Chat.setFrame(design.getFrame());
		Chat.setID(id);
		System.out.println("I`m Client");
		System.out.println("waiting for connect...");
		try {
			Client = new Socket(ip, port);
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