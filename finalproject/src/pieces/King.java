/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pieces;

import chess.*;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class King extends Piece {
    private boolean isCastlingDone = false;
    private boolean hasMoved = false;

    public King(boolean white) {
        super(white);
    }

    /* Constructor */

    public boolean isCastlingDone() {
        return isCastlingDone;
    }

    /* Getters and Setters */

    public void setCastlingDone(boolean castlingDone) {
        isCastlingDone = castlingDone;
    }

    public boolean isHasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

    /* Methods */

    @Override
    public ArrayList<Spot> canMove(Board board, Spot initialSpot){
        ArrayList<Spot> allowedMoves = new ArrayList<Spot>();
        allowedMoves.clear();

        Spot newSpot;
        Piece finalSpotPiece;
        boolean initialSpotIsWhite = initialSpot.getPiece().isWhite();

        /* checks north direction */
        finalSpotPiece = board.getBox(initialSpot.getRow()+1, initialSpot.getCol()).getPiece();
        if (finalSpotPiece == null || finalSpotPiece.isWhite() != initialSpotIsWhite){
            newSpot = new Spot(initialSpot.getRow()+1, initialSpot.getCol());
            allowedMoves.add(newSpot);
        }

        /* checks northeast direction */
        finalSpotPiece = board.getBox(initialSpot.getRow()+1, initialSpot.getCol()+1).getPiece();
        if(finalSpotPiece == null || finalSpotPiece.isWhite() != initialSpotIsWhite){
            newSpot = new Spot(initialSpot.getRow()+1, initialSpot.getCol()+1);
            allowedMoves.add(newSpot);
        }

        /* checks east direction */
        finalSpotPiece = board.getBox(initialSpot.getRow(), initialSpot.getCol()+1).getPiece();
        if(finalSpotPiece == null || finalSpotPiece.isWhite() != initialSpotIsWhite){
            newSpot = new Spot(initialSpot.getRow(), initialSpot.getCol()+1);
            allowedMoves.add(newSpot);
        }

        /* checks southeast direction */
        finalSpotPiece = board.getBox(initialSpot.getRow()-1, initialSpot.getCol()+1).getPiece();
        if(finalSpotPiece == null || finalSpotPiece.isWhite() != initialSpotIsWhite){
            newSpot = new Spot(initialSpot.getRow()-1, initialSpot.getCol()+1);
            allowedMoves.add(newSpot);
        }

        /* checks south direction */
        finalSpotPiece = board.getBox(initialSpot.getRow()-1, initialSpot.getCol()).getPiece();
        if(finalSpotPiece == null || finalSpotPiece.isWhite() != initialSpotIsWhite){
            newSpot = new Spot(initialSpot.getRow()-1, initialSpot.getCol());
            allowedMoves.add(newSpot);
        }

        /* checks southwest direction */
        finalSpotPiece = board.getBox(initialSpot.getRow()-1, initialSpot.getCol()-1).getPiece();
        if(finalSpotPiece == null || finalSpotPiece.isWhite() != initialSpotIsWhite){
            newSpot = new Spot(initialSpot.getRow()-1, initialSpot.getCol()-1);
            allowedMoves.add(newSpot);
        }

        /* checks west direction */
        finalSpotPiece = board.getBox(initialSpot.getRow(), initialSpot.getCol()-1).getPiece();
        if (finalSpotPiece == null || finalSpotPiece.isWhite() != initialSpotIsWhite){
            newSpot = new Spot(initialSpot.getRow(), initialSpot.getCol()-1);
            allowedMoves.add(newSpot);
        }

        /* checks northwest direction */
        finalSpotPiece = board.getBox(initialSpot.getRow()+1, initialSpot.getCol()-1).getPiece();
        if(finalSpotPiece == null || finalSpotPiece.isWhite() != initialSpotIsWhite){
            newSpot = new Spot(initialSpot.getRow()+1, initialSpot.getCol()-1);
            allowedMoves.add(newSpot);
        }

        /* checks if castling is valid */
        /* note: if castlingMove, rook also needs to move, so there needs to be an identifier for castlingMove during traversal
        *  note: set hasMoved and set isCastlingDone
        * */
        if(this.hasMoved){
            Piece kingSideRook = board.getBox(initialSpot.getRow(), initialSpot.getCol()-3).getPiece();
            Piece queenSideRook = board.getBox(initialSpot.getRow(), initialSpot.getCol()+4).getPiece();
            int i;
            if(kingSideRook instanceof Rook && ((Rook) kingSideRook).hasMoved()){
                for(i = initialSpot.getCol()-1; i > 0 && board.getBox(initialSpot.getRow(), i).getPiece() == null; i--){}
                /* call isKingInDanger in for loop */
                if(i > 0){
                    newSpot = new Spot(initialSpot.getRow(), initialSpot.getCol()-2);
                    allowedMoves.add(newSpot);
                }
            }
            if(queenSideRook instanceof Rook && ((Rook) queenSideRook).hasMoved()){
                for(i = initialSpot.getCol()+1; i < 7 && board.getBox(initialSpot.getRow(), i).getPiece() == null; i++){}
                if(i < 7){
                    newSpot = new Spot(initialSpot.getRow(), initialSpot.getCol()+2);
                    allowedMoves.add(newSpot);
                }
            }
        }

    }



//    private boolean isValidCastling(Board board, Spot start, Spot end) {
//        if (this.isCastlingDone()) {
//            return false;
//        }
//        if (!this.hasMoved()) {
//            return false;
//        }
//
//        /* call isCheck here for start and end spot */
//
//        if (start.getCol() < end.getCol()) {
//            /* returns false if rook at Queen side has been moved */
//            if (!board.getBox(end.getRow(), 7).getPiece().hasMoved()) {
//                return false;
//            } else {
//                /* returns false if there are pieces in between King and rook */
//                for (int i = start.getCol(); i < 7; i++) {
//                    if (board.getBox(end.getRow(), i).getPiece() != null) {
//                        return false;
//                    }
//                }
//            }
//        } else if (start.getCol() > end.getCol()) {
//            /* returns false if rook at King side has been moved */
//            if (!board.getBox(end.getRow(), 0).getPiece().hasMoved()) {
//                return false;
//            } else {
//                /* returns false if there are pieces in between King and rook */
//                for (int i = start.getCol(); i > 0; i--) {
//                    if (board.getBox(end.getRow(), i).getPiece() != null) {
//                        return false;
//                    }
//                }
//            }
//        }
//        return true;
//    }


//    public boolean isCastlingMove(Spot start, Spot end){ not sure if this is still needed
//    }


