import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Robot {

    public static String movement(String d){

        if (d.equalsIgnoreCase("w")){
            //forward movement
        }

        if (d.equalsIgnoreCase("s")){
            //backward movement
        }

        if (d.equalsIgnoreCase("a")){
            //left movement
        }

        if (d.equalsIgnoreCase("d")){
            //right movement
        }


        return "this isnt here yet";
    }

    public static void main(String[] args){

        final String takeoff_msg = "{\"op\":\"publish\",\"topic\":\"/ardrone/takeoff\",\"msg\":{}}";
        final String landing_msg = "{\"op\":\"publish\",\"topic\":\"/ardrone/land\",\"msg\":{}}";
        String movment = "{\"op\":\"publish\",\"topic\":\"/cmd_vel\",\"msg\":{\"linear\":{\"x\":0,\"y\":0,\"z\":0},\"angular\":{\"x\":0,\"y\":0,\"z\":0}}}";
        String userinput;
        Scanner scanner = new Scanner(System.in);

        try {
            Socket socket = new Socket("lear.cs.okstate.edu", 9095);
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            out.print("GET /robot_sim.html HTTP/1.1\r\n");
            out.print("host: lear.cs.okstate.edu\r\n\r\n");
            out.flush();

            while (true){
                userinput = scanner.next();

                if (userinput.equals("exit")){
                    break;
                }else if (userinput.equals("land")){
                    System.out.println(userinput);
                    out.print(landing_msg);
                    out.flush();
                }else if (userinput.equals("takeoff")){
                    out.print(takeoff_msg);
                    out.flush();
                }else{
                    movement(userinput);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
