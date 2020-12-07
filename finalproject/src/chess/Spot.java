/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import pieces.Piece;

/**
 *
 * @author user
 */
public class Spot {
    private Piece piece;
    private int row;
    private int col;

    /* Constructors */

    public Spot(int row, int col, Piece piece) {
        this.piece = piece;
        this.row = row;
        this.col = col;
    }

    /* Getters and Setters */

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
