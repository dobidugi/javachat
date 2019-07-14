package Client;

import java.lang.Runnable;
import java.lang.Override;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SendMessages implements Runnable {
	private Socket Client;
	private String ID;
	private PrintWriter sendWriter;

	@Override
	public void run() {
		// class logic start 
		setID();
		makeSendWriter();
		SendID();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String msg;
			while (true) {
				System.out.println("test");
				msg = in.readLine();
				if (msg.equals("exit")) {
					System.out.println("disconnect chat");
					Client.close();
					in.close();
					break;
				}
				this.sendWriter.println(msg);
				// System.out.println("나 : "+ msg);
				this.sendWriter.flush();
			}

		} catch (IOException e) {

		}
	}

	SendMessages(Socket Client) {
		this.Client = Client;
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
			System.out.print("사용하실 닉네임을 설정해주세요 : ");
			this.ID = in.readLine();
			//in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}