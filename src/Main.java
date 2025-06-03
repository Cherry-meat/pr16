import java.io.*;
public class Main {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new FileReader("reg.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("regno.txt"));
            String text;
            int index;
            while((text = br.readLine()) != (null)){
                index = text.indexOf("//");
                if((index == -1)){
                    index = text.indexOf("/*");
                    if (index  == -1){
                        bw.write(text + "\n");
                        bw.flush();
                    }
                    else{
                        if (index != 0){
                            bw.write(text.substring(0, index) + "\n");
                            bw.flush();
                        }
                        else{
                            while((index = text.indexOf("*/")) == -1){
                                text = br.readLine();
                            }
                            bw.write(text.substring(index + 2) + "\n");
                            bw.flush();
                        }
                    }
                }
                else if (index != 0){
                    bw.write(text.substring(0, index) + "\n");
                    bw.flush();
                }
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}