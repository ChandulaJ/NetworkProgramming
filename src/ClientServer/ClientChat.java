package ClientServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientChat {
static int port = 7777;
	
	public static void main(String[] args) throws IOException {
		System.out.println("\t\t Simple client");
		System.out.println("\t\t================\n\n");
		
		Scanner ScannerInput = new Scanner(System.in);
		String input,output;
		
		InetAddress ipAddress = InetAddress.getLocalHost(); // if it was between two computers, the ip address comes here
		
		Socket socket = new Socket(ipAddress,port);
		System.out.println("Server is connected ...\n\n");
		
		PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		try {


			while(true) {
				input = in.readLine();
				System.out.println("Server says: "+input);
				System.out.println("Me: ");
				output = ScannerInput.nextLine();
				out.println(output);
			}
			}
			finally {
				socket.close();
				out.close();
				in.close();
			}
		
		
		
	}
}
