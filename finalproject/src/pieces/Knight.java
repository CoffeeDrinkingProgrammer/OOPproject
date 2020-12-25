/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pieces;
import java.util.ArrayList;
import chess.*;
/**
 *
 * @author user
 */
public class Knight extends Piece{
    
    /*constructor*/
    
     public Knight(boolean is_white)
    {
        super(is_white);
        
    }
    
    
    @Override
    
    public ArrayList<Spot> canMove(Board board, Spot initialSpot){
        
       ArrayList<Spot> allowedMoves = new ArrayList<>();
       allowedMoves.clear();
       Spot newSpot;
       
       
       
       for(int x=1;x<=2;x++){
           for(int y=1;y<=2;y++){
               newSpot = new Spot(initialSpot.getRow()+x,initialSpot.getCol()+y);
               if(Math.abs(newSpot.getRow() - initialSpot.getRow()) == 1){
                    if(Math.abs(newSpot.getCol() - initialSpot.getCol()) != 2){
                         if(board.getBox(initialSpot.getRow()+x,initialSpot.getCol()+y).getPiece()!=null){
                             if(board.getBox(initialSpot.getRow()+x,initialSpot.getCol()+y).getPiece().isWhite()!= this.isWhite()){
                                 allowedMoves.add(newSpot);
                             }
                         }else{
                              allowedMoves.add(newSpot);
                         }
                    }
                }else if(Math.abs(newSpot.getRow() - initialSpot.getRow()) == 2){
                    if(Math.abs(newSpot.getCol() - initialSpot.getCol()) != 1){
                         if(board.getBox(initialSpot.getRow()+x,initialSpot.getCol()+y).getPiece()!=null){
                             if(board.getBox(initialSpot.getRow()+x,initialSpot.getCol()+y).getPiece().isWhite()!= this.isWhite()){ 
                                 allowedMoves.add(newSpot);
                             }
                         }else{
                              allowedMoves.add(newSpot);
                         }
                    }
                }
            }
       }
       return allowedMoves;
    }
    /*public boolean canMove(Board board, Spot initialSpot, Spot finalSpot){

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
    }*/
}
