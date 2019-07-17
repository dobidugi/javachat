package Client;

import java.lang.Runnable;
import java.lang.Override;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;

import java.net.Socket;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class SendMessages implements Runnable {
	private Socket Client;
	private String ID;
	private PrintWriter sendWriter;
	private JTextField input;

	@Override
	public void run() {
		// start logic
		setID();
		makeSendWriter();
		SendID();
		input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String msg;
					msg = input.getText();
					if (msg.equals("exit")) {
						System.out.println("disconnect chat");
						try {
							Client.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					sendWriter.println(msg);
					input.setText("");
					sendWriter.flush();
				}
			}
		});
	}

	SendMessages(Socket Client, JTextField input) {
		this.Client = Client;
		this.input = input;
	}

	private void SendID() {
		this.sendWriter.println(ID);
		this.sendWriter.flush();
	}

	private void makeSendWriter() {
		try {
			this.sendWriter = new PrintWriter(this.Client.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void setID() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Set your use id : ");
			this.ID = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}