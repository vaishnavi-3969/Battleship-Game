import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // start coding here
        String str = reader.readLine();
        System.out.println(new StringBuilder(str).reverse());
        reader.close();
    }
}