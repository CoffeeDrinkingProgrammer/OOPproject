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
public class Knight extends Piece{
    
    @Override
    public boolean canMove(Board board, Spot initialSpot, Spot finalSpot){

        //checks if a same-color piece is on the destination
        Piece testPiece= finalSpot.getPiece();

        if(testPiece!=null){
            if(testPiece.isWhite() && this.isWhite()){
                return false;
            }else if(!testPiece.isWhite() && !this.isWhite()){
                return false;
            }
        }

        //checks if the piece is moving properly

        if(Math.abs(finalSpot.getX() - initialSpot.getX()) == 1){
            if(Math.abs(finalSpot.getY() - initialSpot.getY()) != 2){
                return false;
            }
        }else if(Math.abs(finalSpot.getX() - initialSpot.getX()) == 2){
            if(Math.abs(finalSpot.getY() - initialSpot.getY()) != 1){
                return false;
            }
        }

        return true;
    }
}
