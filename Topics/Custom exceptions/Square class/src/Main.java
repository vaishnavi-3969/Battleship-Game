import java.util.Scanner;

class Square {
    int a;

    public Square(int a) throws SquareSizeException {
        if (a > 0) this.a = a;
        else
            throw new SquareSizeException("zero or negative size"); //put you code here
    }
}

class Main {
    public static void main(String[] args) throws SquareSizeException {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        //put your code here
        try{
            Square square = new Square(a);
        }catch (SquareSizeException e){
            throw new SquareSizeException("zero or negative size");
        }
    }
}

class SquareSizeException extends Exception {
    public SquareSizeException(String message) {
        super(message);
    }
}