import java.net.ServerSocket;

public class Webserver{

    public static void main(String[] args){

            try {
                ServerSocket serverSocket = new ServerSocket(2000);
                while (true) {

                    Thread thread = new Thread(new Connection(serverSocket.accept()));
                    thread.start();
                    System.out.println("tread started");
                }
            } catch (Exception e) {

                e.printStackTrace();
            }
    }
}
