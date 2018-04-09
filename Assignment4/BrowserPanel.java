import javax.swing.*;
import java.awt.*;
import java.awt.TextArea;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class BrowserPanel extends JPanel implements KeyListener{

    private JTextField urlArea;
    private TextArea displayArea;
    private String html = "";

    public BrowserPanel(){

        setLayout(new BorderLayout());

        urlArea = new JTextField();
        urlArea.addKeyListener(this);
        add(urlArea, BorderLayout.NORTH);

        displayArea = new TextArea();
        displayArea.setEditable(false);
        add(displayArea);

    }

    public String getHTML(String url){

        String output = "";
        String line;
        String dir = "/";
        String[] list = url.split("/");
        url = list[0];

        if (list.length > 1){

            for (int i = 1; i < list.length; i++){

                dir += list[i];
            }
        }


        try {
            InetAddress site = InetAddress.getByName(url);

            Socket socket = new Socket(site, 80);
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out.print("GET " + dir + " HTTP/1.1\r\n");
            out.print("host: " + url + "\r\n\r\n");
            out.flush();
            while ((line = in.readLine()) != null){
                output += line + "\n";
            }

        }catch (Exception e){

            return "Error";
        }
        return output;
    }

    public String htmlFilter(String html){

        String output = "";

        output += htmlTitle(html) + "\n";
        output += htmlbody(html) + "\n";
        return output;
    }

    private String htmlTitle(String html){
        String output = "";

        if (html.contains("<title>")){
            int indexStart = html.indexOf("<title>") + 7;
            int indextEnd = html.indexOf("</title>");

            for (int i = indexStart; i < indextEnd; i++){

                output += html.charAt(i);
            }
        }
        return output;
    }

    private String htmlbody(String html){
        String output = "";

        if (html.contains("<body")){
            int indexStart = html.indexOf("<body");
            int indextEnd = html.indexOf("</body>");

            for (int i = indexStart; i < indextEnd; i++){

                if (html.charAt(i) == '>'){

                    for (int j = i + 1; (html.charAt(j) != '<') && (j < indextEnd); j++){
                        output += html.charAt(j);
                    }

                }
            }
        }
        return output;
    }



    @Override
    public void keyReleased(KeyEvent e) { }

    @Override
    public void keyTyped(KeyEvent e) {

        if (e.getKeyChar() == KeyEvent.VK_ENTER){

            displayArea.setText("");

            html = getHTML(urlArea.getText());

            if (html.equals("Error")){
                displayArea.append("An Error has occurred \n   usage example: cs.okstate.edu/student.html");

            }else{
                displayArea.append(htmlFilter(html));
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) { }
}
