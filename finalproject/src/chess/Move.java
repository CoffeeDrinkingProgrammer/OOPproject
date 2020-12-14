/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import pieces.*;

/**
 *
 * @author user
 */
public class Move{
    private Player player;
    private Spot initialSpot;
    private Spot finalSpot;
    private Piece pieceMoved;
    private Piece pieceKilled;
    private boolean isCastlingMove = false;

    /* Constructor */

    public Move(Player player, Spot initialSpot, Spot finalSpot) {
        this.player = player;
        this.initialSpot = initialSpot;
        this.finalSpot = finalSpot;
        this.pieceMoved = initialSpot.getPiece();
    }

    /* Getters and Setters */

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Spot getInitialSpot() {
        return initialSpot;
    }

    public void setInitialSpot(Spot initialSpot) {
        this.initialSpot = initialSpot;
    }

    public Spot getFinalSpot() {
        return finalSpot;
    }

    public void setFinalSpot(Spot finalSpot) {
        this.finalSpot = finalSpot;
    }

    public Piece getPieceMoved() {
        return pieceMoved;
    }

    public void setPieceMoved(Piece pieceMoved) {
        this.pieceMoved = pieceMoved;
    }

    public Piece getPieceKilled() {
        return pieceKilled;
    }

    public void setPieceKilled(Piece pieceKilled) {
        this.pieceKilled = pieceKilled;
    }

    public boolean isCastlingMove() {
        return isCastlingMove;
    }

    public void setCastlingMove(boolean castlingMove) {
        isCastlingMove = castlingMove;
    }
}
