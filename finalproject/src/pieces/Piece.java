/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pieces;
import java.util.*;
import chess.*;

/**
 *
 * @author user
 */
public abstract class Piece {
    private boolean isKilled = false;
    private boolean isWhite = false;

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

    /* methods */

    public abstract ArrayList<Spot> canMove(Board board, Spot initialSpot);
}
