/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pieces;
import java.util.*;
import chess.Board;
import chess.Spot;

/**
 *
 * @author user
 */
public abstract class Piece {
    private boolean isKilled = false;
    private boolean isWhite = false;
    private boolean hasMoved = false;

    /* Constructor */

    public Piece(boolean white){
        this.isWhite = white;
    }

    /* Getters and Setters */

    public boolean isKilled() {
        return isKilled;
    }

    public void setKilled(boolean killed) {
        isKilled = killed;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public void setWhite(boolean white) {
        isWhite = white;
    }

    public boolean hasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

    /* methods */

    public ArrayList<Spot> canMove(Board board, Spot initialSpot){
        ArrayList<Spot> allowedMoves = new ArrayList<>();
        return allowedMoves;
    }
}
