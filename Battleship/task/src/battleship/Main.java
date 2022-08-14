////package battleship;
////
////import java.util.Objects;
////import java.util.Scanner;
////
////public class Main {
////    static char[] alphabet = {'A','B','C','D','E','F','G','H','I','J'};
////    //alphabet => 0-A,1-B,2-C,3-D,4-E,5-F,6-G,7-H,8-I,9-J
////    static Scanner scanner = new Scanner(System.in);
////    //Main method
////    public static void main(String[] args) {
////        int n = 10;
////        char[][] gameField;
////        gameField = createGameField(n);
////        printGameField(gameField,n);
////        System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells):");
////        aircraftCarrier(gameField, n);
////        printGameField(gameField, n);
////        System.out.println("Enter the coordinates of the Battleship (4 cells):");
////        step1(gameField, n);
////        System.out.println("Enter the coordinates of the Submarine (3 cells):");
////        step2(gameField, n);
////        System.out.println("Enter the coordinates of the Destroyer (2 cells):");
////        step3(gameField, n);
////
////    }
////    public static void step1(char[][] gameField,int n){
////        boolean stop = false;
////        do{
////            try{
////                aircraftCarrier(gameField, n);
////                printGameField(gameField,n);
////                stop = true;
////            }
////            catch (Exception e){
////                System.out.println("Error! Wrong ship location! Try again:");
////            }
////        }while(!stop);
////    }
////    public static void step3(char[][] gameField,int n){
////        boolean stop = false;
////        do{
////            try{
////                aircraftCarrier(gameField, n);
////                printGameField(gameField,n);
////                stop = true;
////            }
////            catch (Exception e){
////                System.out.println("You placed it too close to another one. Try again:");
////            }
////        }while(!stop);
////    }
////    public static void step2(char[][] gameField,int n){
////        boolean stop = false;
////        do{
////            try{
////                aircraftCarrier(gameField, n);
////                printGameField(gameField,n);
////                stop = true;
////            }
////            catch (Exception e){
////                System.out.println("Error! Wrong length of the Submarine! Try again:");
////            }
////        }while(!stop);
////    }
////    //creating game field
////    public static char[][] createGameField(int n){
////        char[][] gameField = new char[n][n];
////        for(int i=0; i<n; i++){
////            for(int j=0; j<n;j++){
////                gameField[i][j]='~';
////            }
////        }
////        return gameField;
////    }
////    public static void printGameField(char[][] gameField, int n){
////        System.out.println("  1 2 3 4 5 6 7 8 9 10");
////        for(int i=0; i<n; i++){
////            System.out.print(alphabet[i]+" ");
////            for(int j=0; j<n; j++){
////                System.out.print(gameField[i][j]+" ");
////            }
////            System.out.println();
////        }
////    }
////    public static char[][] aircraftCarrier(char[][] gameField,int n){
////        String cell1 = scanner.next();//F3
////        String cell2 = scanner.next();//F7
////        int index1 = 0, index2=0;
////        char[] c1 = cell1.toCharArray();//F
////        char[] c2 = cell2.toCharArray();//F
////        for(int i=0;i<alphabet.length;i++){
////            if(alphabet[i]==c1[0]){
////                index1 = i;
////            }
////            if(alphabet[i]==c2[0]){
////                index2 = i;
////            }
////        }
//////        System.out.println(index1+" "+index2);
////        int n1 = Integer.parseInt(String.valueOf(c1[1]));
////        int n2 = Integer.parseInt(String.valueOf(c2[1]));
//////        System.out.println(c1[0]+" "+c2[0]);
//////        System.out.println(n1+" "+n2);
////        if(Objects.equals(index1,index2)){
////            for(int i = n1-1; i <= n2-1; i++){
////                gameField[index1][i]='O';
////            }
////        }else if(Objects.equals(n1, n2)){
////            for(int i = index1; i <= index2; i++){
////                gameField[i][n1-1]='O';
////            }
////        }
////        return gameField;
////    }
////}
//
////-----------------
//package battleship;
//
//import java.util.Scanner;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class Main {
//    static Scanner scanner = new Scanner(System.in);
//    static String coordinatesInput;
//    static final int aircraftCarrierLength = 5;
//    static final int battleshipLength = 4;
//    static final int submarineLength = 3;
//    static final int cruiserLength = 3;
//    static final int destroyerLength = 2;
//
//    static boolean isVertical;
//    static Pattern coordinatesPattern = Pattern.compile("^([A-J]+\\d{1,2}+ +[A-J]+\\d{1,2})");
//
//    public static void main(String[] args) {
//        Field field1 = new Field();
//        makeClearField(field1);
//        printField(field1);
//        fillFieldWithShips(field1);
//
//    }
//
//    private static void fillFieldWithShips(Field field) {
//        System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells):");
//        placeShip(aircraftCarrierLength, field);
//
//        System.out.println("Enter the coordinates of the Battleship (4 cells):");
//        placeShip(battleshipLength, field);
//
//        System.out.println("Enter the coordinates of the Submarine (3 cells):");
//        placeShip(submarineLength, field);
//
//        System.out.println("Enter the coordinates of the Cruiser (3 cells):");
//        placeShip(cruiserLength, field);
//
//        System.out.println("Enter the coordinates of the Destroyer (2 cells):");
//        placeShip(destroyerLength, field);
//
//    }
//
//    private static void placeShip(int requiredShipLength, Field field) {
//        coordinatesInput = scanner.nextLine();
//        Matcher matcher = coordinatesPattern.matcher(coordinatesInput);
//        if (matcher.matches()) { //coordinates correctness verification
//
//            String[] fullCoordinates = coordinatesInput.split(" ");
//            String[] firstCoordinate = fullCoordinates[0].split("", 2);
//            String[] secondCoordinate = fullCoordinates[1].split("", 2);
//
//            if (Integer.parseInt(firstCoordinate[1]) > 10 || Integer.parseInt(secondCoordinate[1]) > 10) { //in case of e.g. J11
//                System.out.println("Error! Incorrect coordinates! try again:");
//                placeShip(requiredShipLength, field);
//
//            } else { //if coordinates given are correct
//
//                if (isCorrectShip(firstCoordinate, secondCoordinate, requiredShipLength)) { //if ship is a straight line and has correct length
//                    int[][] shipCoordinates = generateShipCoordinates(firstCoordinate, secondCoordinate, requiredShipLength);
//
//                    if (isNotTooClose(shipCoordinates, field, requiredShipLength)) {
//                        for (int i = 0; i < requiredShipLength; i++) {
//                            field.battleField[shipCoordinates[0][i]][shipCoordinates[1][i]] = "O";
//
//                        }
//                        printField(field);
//                    } else {
//                        System.out.println("Error! Ship placed too close to another, try again: ");
//                        placeShip(requiredShipLength, field);
//                    }
//
//                } else {
//                    System.out.println("Error! This is not a correct ship, try again:");
//                    placeShip(requiredShipLength, field);
//                }
//            }
//        } else {
//            System.out.println("Error! Incorrect pattern! try again:");
//            placeShip(requiredShipLength, field);
//        }
//    }
//
//    private static int[][] generateShipCoordinates(String[] firstCoordinate, String[] secondCoordinate, int requiredShipLength) {
//        int[][] shipCoordinates = new int[2][requiredShipLength];
//        ;
//
//        if (firstCoordinate[0].equals(secondCoordinate[0])) { //same letter coordinate == horizontal ship character values stored as charset number
//            isVertical = false;
//
//            for (int i = 0; i < requiredShipLength; i++) {
//                shipCoordinates[0][i] = firstCoordinate[0].charAt(0) - 64;
//                shipCoordinates[1][i] = 2 * (Math.min(Integer.parseInt(firstCoordinate[1]), Integer.parseInt(secondCoordinate[1])) + i);
//            }
//        } else { // same number coordinate == vertical ship , character values stored as charset number
//            isVertical = true;
//            int[][] shipCoordinates1 = new int[requiredShipLength][2];
//            for (int i = 0; i < requiredShipLength; i++) {
//                shipCoordinates1[i][0] = Math.min(firstCoordinate[0].charAt(0), secondCoordinate[0].charAt(0)) + -64 + i;
//                shipCoordinates1[i][1] = 2 * Integer.parseInt(firstCoordinate[1]);
//            }
//            for (int i = 0; i < requiredShipLength; i++) {
//                for (int j = 0; j < 2; j++) {
//                    shipCoordinates[j][i] = shipCoordinates1[i][j];
//                }
//
//            }
//        }
//        return shipCoordinates;
//    }
//
//    private static boolean isNotTooClose(int[][] shipCoordinates, Field field, int requiredShipLength) {
//        for (int i = 0; i < requiredShipLength; i++) {
//            //N
//            if (shipCoordinates[0][i] - 1 > 1) {
//                if (!(field.battleField[shipCoordinates[0][i] - 1][shipCoordinates[1][i]].equals("~"))) {
//                    return false;
//                }
//            }
//            //S
//            if (shipCoordinates[0][i] + 1 < field.vertAxis.length - 1) {
//                if (!(field.battleField[shipCoordinates[0][i] + 1][shipCoordinates[1][i]].equals("~"))) {
//                    return false;
//                }
//            }
//            //E
//            if (shipCoordinates[1][i] < field.horzAxis.length - 2) {
//                if (!(field.battleField[shipCoordinates[0][i]][shipCoordinates[1][i] + 2].equals("~"))) {
//                    return false;
//                }
//            }
//            //W
//            if (shipCoordinates[1][i] > 2) {
//                if (!(field.battleField[shipCoordinates[0][i]][shipCoordinates[1][i] - 2].equals("~"))) {
//                    return false;
//                }
//            }
//
//        }
//        return true;
//    }
//
//    public static boolean isCorrectShip(String[] firstCoordinate, String[] secondCoordinate, int requiredShipLength) {
//        return ((Math.abs(firstCoordinate[0].charAt(0) - secondCoordinate[0].charAt(0)) == requiredShipLength - 1
//                && firstCoordinate[1].equals(secondCoordinate[1]))
//                || (Math.abs(Integer.parseInt(firstCoordinate[1]) - Integer.parseInt(secondCoordinate[1])) == requiredShipLength - 1
//                && firstCoordinate[0].equals(secondCoordinate[0])));
//    }
//
//    public static void makeClearField(Field field) {
//        //fill the field with spaces
//        for (int i = 0; i < field.vertAxis.length; i++) {
//            for (int j = 0; j < field.horzAxis.length; j++) {
//                field.battleField[i][j] = " ";
//            }
//        }
//
//        //add horizontal and vertical axes
//        for (int i = 0; i < field.vertAxis.length; i++) {
//            field.battleField[i][0] = field.vertAxis[i];
//        }
//        for (int i = 0; i < field.horzAxis.length; i++) {
//            field.battleField[0][i] = field.horzAxis[i];
//        }
//
//        //add "~" representing the fog of war
//        for (int i = 1; i < field.vertAxis.length; i++) {
//            for (int j = 2; j < field.horzAxis.length; j += 2) {
//                field.battleField[i][j] = "~";
//            }
//        }
//    }
//
//    public static void printField(Field field) {
//        for (int i = 0; i < field.vertAxis.length; i++) {
//            for (int j = 0; j < field.horzAxis.length; j++) {
//                System.out.print(field.battleField[i][j]);
//            }
//            System.out.println();
//        }
//    }
//}


package battleship;

public class Main {

    public static void main(String[] args)
        BattleshipGame.playGame();
    }
}