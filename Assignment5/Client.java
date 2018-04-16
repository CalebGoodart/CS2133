import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client{

    public static void main(String[] args) {

            try {
                InetAddress local = InetAddress.getLocalHost();
                Socket socket = new Socket(local, 2000);
                PrintStream out = new PrintStream(socket.getOutputStream());
                Scanner scanner = new Scanner(System.in);
                Thread thread = new Thread(new ClientReciver(socket));
                thread.start();

                String output = "GET /MineSweeper2.0/MineButton.java HTTP/1.1";

                System.out.println("sending");
                out.println(output);
                out.flush();

            } catch (Exception e) {
                e.printStackTrace();
            }

    }
}