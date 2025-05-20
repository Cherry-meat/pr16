import java.util.regex.*;
import java.io.*;
public class Main {
    public static void main(String[] args){
        String regx = "(/\\*[\\s\\S]*?\\*/)|((?<![(:\"\\w])(//.*))";
        Pattern pattern = Pattern.compile(regx);
        try (BufferedReader br = new BufferedReader(new FileReader("code.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("regex.txt"))){
            StringBuilder file = new StringBuilder();
            String s;
            while((s = br.readLine()) != null){
                file.append(s).append("\n");
            }
            Matcher matcher = pattern.matcher(file.toString());
            String result = matcher.replaceAll("");
            bw.write(result);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}