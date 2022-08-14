package battleship;

public class Field {
    public final String[] vertAxis = {" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    public final String[] horzAxis = {" ", " ", "1"," ","2"," ","3"," ","4"," ",
            "5"," ","6"," ","7"," ","8"," ","9"," ","10"};
    public String[][] battleField = new String[11][21];

    public String[][] getBattleField() {
        return battleField;
    }

}