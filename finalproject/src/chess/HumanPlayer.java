package chess;

public class HumanPlayer extends Player{

    public HumanPlayer(boolean whiteSide){
        this.isWhiteSide = whiteSide;
        this.isHumanPlayer = true;
    }
}
