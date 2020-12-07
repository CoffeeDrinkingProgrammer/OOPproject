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
public abstract class Player {
    public boolean isWhiteSide;
    public boolean isHumanPlayer;

    public boolean isWhiteSide() {
        return isWhiteSide;
    }

    public void setWhiteSide(boolean whiteSide) {
        isWhiteSide = whiteSide;
    }

    public boolean isHumanPlayer() {
        return isHumanPlayer;
    }

    public void setHumanPlayer(boolean humanPlayer) {
        isHumanPlayer = humanPlayer;
    }
}
