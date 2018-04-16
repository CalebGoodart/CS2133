import java.io.*;
import java.net.Socket;

public class Connection implements Runnable{

    private Socket socket;
    public Connection(Socket socket){
        this.socket = socket;
    }

    private File loadedFile = null;
    private String output = "";

    public void run(){
        PrintStream out = null;
        BufferedReader in = null;
        String input = "";

        try {

            out = new PrintStream(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Reciving");

            try {
                input = in.readLine();
                System.out.println(input);

            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("Prossessing");

            if (input.contains("GET")) {

                String dir = input.substring(5, input.length() - 9);

                if (dir.equalsIgnoreCase("")) {

                    loadedFile = new File("index.html");

                }else {

                    System.out.println(dir);
                    loadedFile = new File(dir);
                }
                System.out.println("sending");

                if (!(loadedFile.exists())){
                    out.println("HTTP/1.1 404 Not Found\\r\\n\\r\\n");
                    out.flush();

                }else {

                    out.println("HTTP/1.1 200 OK\\r\\n");
                    out.println("Content-type: text/html\\r\\n\\r\\n");


                    BufferedReader bufferedReader = new BufferedReader(new FileReader(loadedFile));

                    String line;

                    while ((line = bufferedReader.readLine()) != null){

                        output += line + "\n";
                    }
                    out.print(output);
                }


                out.flush();
                System.out.println("done");
            }

        }catch (Exception e) {

            out.println("HTTP/1.1 500 Internal Server Error\\r\\n\\r\\n");
            out.flush();
            e.printStackTrace();
        }finally {

            try {
                in.close();
                out.close();
                socket.close();
            } catch (Exception e){

                System.out.println("Could not close everything!");
            }
        }
    }
}
