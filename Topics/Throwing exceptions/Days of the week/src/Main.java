import java.util.*;

public class Main {

    public static String getDayOfWeekName(int number) {
        // write your code here
        String n;
        switch (number){
            case 1:
                n = "Mon";
                break;
            case 2:
                n = "Tue";
                break;
            case 3:
                n =  "Wed";
                break;
            case 4:
                n = "Thu";
                break;
            case 5:
                n = "Fri";
                break;
            case 6:
                n = "Sat";
                break;
            case 7:
                n = "Sun";
                break;
            default:
                throw new IllegalArgumentException();
        }
        return n;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dayNumber = scanner.nextInt();
        try {
            System.out.println(getDayOfWeekName(dayNumber));
        } catch (Exception e) {
            System.out.println(e.getClass().getName());
        }
    }
}