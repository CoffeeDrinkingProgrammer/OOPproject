/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pieces;

import chess.*;

/**
 *
 * @author user
 */
public class King extends Piece {
    private boolean isCastlingDone = false;

    public King(boolean white) {
        super(white);
    }

    /* Constructor */

    public boolean isCastlingDone() {
        return isCastlingDone;
    }

    public void setCastlingDone(boolean castlingDone) {
        isCastlingDone = castlingDone;
    }

    /* Methods */

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        /* piece can't move to a spot with a piece of the same color */
        if(end.getPiece().isWhite() == isWhite()){
            return false;
        }
        /* king can move one spot up, down, left, right or diagonal */
        int rowDiff = Math.abs(start.getRow() - end.getRow());
        int colDiff = Math.abs(start.getCol() - end.getCol());
        if(rowDiff + colDiff == 1){
           /* checks if move will not result into king being attacked on next turn */
            /* calls isAttacked for end spot */
           /* I need code of other pieces i think :c */
            return true;
        }
        if(rowDiff == 0 && colDiff == 2) {
            return this.isValidCastling(board, start, end);
        }else{
            return false;
        }
    }

    private boolean isValidCastling(Board board, Spot start, Spot end) {
        if (this.isCastlingDone()) {
            return false;
        }
        if (!this.hasMoved()) {
            return false;
        }

        /* call isCheck here for start and end spot */

        if (start.getCol() < end.getCol()) {
            /* returns false if rook at Queen side has been moved */
            if (!board.getBox(end.getRow(), 7).getPiece().hasMoved()) {
                return false;
            } else {
                /* returns false if there are pieces in between King and rook */
                for (int i = start.getCol(); i < 7; i++) {
                    if (board.getBox(end.getRow(), i).getPiece() != null) {
                        return false;
                    }
                }
            }
        } else if (start.getCol() > end.getCol()) {
            /* returns false if rook at King side has been moved */
            if (!board.getBox(end.getRow(), 0).getPiece().hasMoved()) {
                return false;
            } else {
                /* returns false if there are pieces in between King and rook */
                for (int i = start.getCol(); i > 0; i--) {
                    if (board.getBox(end.getRow(), i).getPiece() != null) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

//    public boolean isCastlingMove(Spot start, Spot end){ not sure if this is still needed
//    }


