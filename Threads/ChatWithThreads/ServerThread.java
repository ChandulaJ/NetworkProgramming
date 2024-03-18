package Threads.ChatWithThreads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread extends Thread{
    private Socket client;
    private int client_id;
    private PrintWriter out;
    private BufferedReader in;
    private Scanner ScannerInput;

    public ServerThread(Socket client_socket, int c_id) throws IOException {
        this.client = client_socket;
        this.client_id = c_id;
        out = new PrintWriter(client.getOutputStream(),true);
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        ScannerInput = new Scanner(System.in);
    }

    @Override
    public void run() {

       try {

            out.println("Welcome to chat application");

            while(true) {

                String input = in.readLine();
                System.out.println("Client "+client_id+" says: "+input);
                System.out.println("Server: ");
                String output = ScannerInput.nextLine();
                out.println(output);

            }
        } catch (IOException e) {
           throw new RuntimeException(e);
       } finally {
           try {
               client.close();
               out.close();
               in.close();
           } catch (IOException e) {
               throw new RuntimeException(e);
           }

        }
    }
}
