import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientReciver implements Runnable{

    Socket socket;
    public ClientReciver(Socket socket){
        this.socket = socket;
    }

    public void run() {

            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String test;
                System.out.println("Reciving");

                    try {

                        while ((test = in.readLine()) != null){

                            System.out.println(test);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
