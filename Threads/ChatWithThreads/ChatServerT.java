package Threads.ChatWithThreads;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ChatServerT {
    static int PORT = 7744;
    public static void main(String[] args) throws IOException {
        System.out.println("\t\t Chat Server Chat");
        System.out.println("\t\t======================");

        ServerSocket serverSocket = new ServerSocket(PORT);

        int current_client = 1;
        try {
            while(true) {

                Socket client = serverSocket.accept();
                System.out.println("Client is connected...\n\n");
                ServerThread ct = new ServerThread(client,current_client);
                ct.start();


            }
        }
        finally {
            serverSocket.close();
        }

    }


}
