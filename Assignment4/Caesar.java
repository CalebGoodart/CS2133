import java.io.*;

public class Caesar {

    public static char Cipher(int charvalue, int key){

        if (charvalue < 32 || charvalue > 126){
            return (char) charvalue;
        }

        charvalue = charvalue + key;

        if (charvalue > 126 ){
            charvalue = charvalue - 95;
        }

        if (charvalue < 32){
            charvalue = charvalue + 95;
        }

        return (char) charvalue;
    }

    public static void main(String[] args){

        int letter;
        int key;
        File infile;
        File outfile;
        BufferedReader in;
        FileOutputStream writeout;

        try{
            outfile = new File(args[2]);
            key = Integer.parseInt(args[0]);
            infile = new File(args[1]);
            in= new BufferedReader(new FileReader(infile));
            writeout= new FileOutputStream(outfile);

            while ((letter = in.read()) != -1){

                writeout.write(Cipher(letter, key));
            }

            writeout.close();

        }catch (Exception e){

            try{

                key = Integer.parseInt(args[0]);
                infile = new File(args[1]);
                in = new BufferedReader(new FileReader(infile));

                while ((letter = in.read()) != -1){

                    System.out.print(Cipher(letter, key));
                }
                in.close();

            }catch (Exception a){

                System.out.println("Usage: Caesar <key(integer)> <infile> [outfile]");
            }
        }
    }
}
