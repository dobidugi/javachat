package Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SendMessages extends Thread {
	private BufferedReader in;
	private String msg;

	@Override
	public void run() {
		super.run();
		// start logic
		makeInBuffer();
		while (true) {
			try {
				msg = in.readLine();
				allUserMsg();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void allUserMsg() {
		for(int i=0;i<Main.List.size();i++) {
			Main.List.get(i).println("Server : "+msg);
			Main.List.get(i).flush();
		}
	}
	private void makeInBuffer() {
		in = new BufferedReader(new InputStreamReader(System.in));
	}
}
