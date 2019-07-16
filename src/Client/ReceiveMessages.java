package Client;

import java.lang.Runnable;
import java.lang.Override;

import java.net.Socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import javax.swing.JTextArea;

public class ReceiveMessages implements Runnable {
	private Socket Client;
	private JTextArea screen;
	@Override
	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(Client.getInputStream()));
			String msg;

			while (true) {
				msg = in.readLine();
				if (msg == null) {
					System.out.println("disconnect chat");
					Client.close();
					break;
				}
				System.out.println(msg);
				screen.append(msg+"\n");
			}
		} catch (IOException e) {

		}
	}

	ReceiveMessages(Socket Client,JTextArea screen) {
		this.Client = Client;
		this.screen = screen;
	}
}
