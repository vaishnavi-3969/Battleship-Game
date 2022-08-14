import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // start coding here
        String str1 = reader.readLine();
        String str = str1.trim();
        reader.close();
        if (str == null || str.isEmpty())
            System.out.println(0);
        else{
//            String w = str.trim();
            String[] words = str.split("\\s+");
            System.out.println(words.length);
        }

    }
}