/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

/**
 *
 * @author user
 */
<<<<<<< Updated upstream:finalproject/src/finalproject/Piece.java
public abstract class Piece {
    private boolean pieceState;
    private boolean isWhite;


    public boolean canMove(Board board, Spot initialSpot, Spot finalSpot){
        boolean ret = false;
        
        return ret;
=======
public class HumanPlayer extends Player {
    public HumanPlayer(boolean whiteSide){
        this.isWhiteSide = whiteSide;
        this.isHumanPlayer = true;
>>>>>>> Stashed changes:finalproject/src/chess/HumanPlayer.java
    }
}
