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
public class Board {
    private Spot[][] boxes;

    /* constructor  */

    public Board(){
        this.resetBoard();
    }

    /* method that checks if spot is within 8x8 board */

    public Spot getBox(int row, int col){
        if( row < 0 || row > 7 || col < 0 || col > 7){
            throw new Exception("Index out of bound");
        }
        return boxes[row][col];
    }

    /* method that initializes board */

    public void resetBoard(){
        /* initializes white pieces */
        boxes[0][0] = new Spot(0, 0, new Rook(true));
        boxes[0][1] = new Spot(0, 1, new Knight(true));
        boxes[0][2] = new Spot(0, 2, new Bishop(true));
        boxes[0][3] = new Spot(0, 3, new King(true));
        boxes[0][4] = new Spot(0, 4, new Queen(true));
        boxes[0][5] = new Spot(0, 5, new Bishop(true));
        boxes[0][6] = new Spot(0, 6, new Knight(true));
        boxes[0][7] = new Spot(0, 7, new Rook(true));

        /*initializes black pieces */
        boxes[7][0] = new Spot(7, 0, new Rook(false));
        boxes[7][1] = new Spot(7, 1, new Knight(false));
        boxes[7][2] = new Spot(7, 2, new Bishop(false));
        boxes[7][3] = new Spot(7, 3, new King(false));
        boxes[7][4] = new Spot(7, 4, new Queen(false));
        boxes[7][5] = new Spot(7, 5, new Bishop(false));
        boxes[7][6] = new Spot(7, 6, new Knight(false));
        boxes[7][7] = new Spot(7, 7, new Rook(false));

        /* initializes white and black pawn pieces */
        for(int col = 0; col < 8 ; col++){
            boxes[1][col] = new Spot(1, col, new Pawn(true));
            boxes[6][col] = new Spot(6, col, new Pawn(false));
        }

        /* initializes boxes without pieces */
        for(int row = 2; row < 6; row++){
            for(int col = 0; col < 8; col++){
                boxes[row][col] = new Spot(row, col, null);
            }
        }
    }
}
