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
public class Bishop extends Piece{
    
    public Bishop(boolean is_white)
    {
        super(is_white);
        
    }
    
    @Override
   public ArrayList<Spot> canMove(Board board, Spot initialSpot){
        
       ArrayList<Spot> allowedMoves = new ArrayList<>();
       allowedMoves.clear();
       Spot newSpot;
       
       for(int i=1;i<8;i++){
           if(initialSpot.getRow()+i<8&&initialSpot.getCol()+i<8){
               if(board.getBox(initialSpot.getRow()+i, initialSpot.getCol()+i).getPiece()==null){
                   newSpot = new Spot(initialSpot.getRow()+i,initialSpot.getCol()+i);
                   allowedMoves.add(newSpot);
               }else{
                   
                    if(board.getBox(initialSpot.getRow()+i, initialSpot.getCol()+i).getPiece().isWhite()!=this.isWhite()){
                        newSpot = new Spot(initialSpot.getRow()+i,initialSpot.getCol()+i);
                        allowedMoves.add(newSpot);
                    }
                    break;
                }
           }
           
       }
       for(int i=1;i<8;i++){
           if(initialSpot.getRow()-i>=0&&initialSpot.getCol()+i<8){
               if(board.getBox(initialSpot.getRow()-i, initialSpot.getCol()+i).getPiece()==null){
                   newSpot = new Spot(initialSpot.getRow()-i,initialSpot.getCol()+i);
                   allowedMoves.add(newSpot);
               }else{
                   
                    if(board.getBox(initialSpot.getRow()-i, initialSpot.getCol()+i).getPiece().isWhite()!=this.isWhite()){
                        newSpot = new Spot(initialSpot.getRow()-i,initialSpot.getCol()+i);
                        allowedMoves.add(newSpot);
                    }
                    break;
                }
           }
           
       }
       for(int i=1;i<8;i++){
           if(initialSpot.getRow()+i<8&&initialSpot.getCol()-i>=0){
               if(board.getBox(initialSpot.getRow()+i, initialSpot.getCol()-i).getPiece()==null){
                   newSpot = new Spot(initialSpot.getRow()+i,initialSpot.getCol()-i);
                   allowedMoves.add(newSpot);
               }else{
                   
                    if(board.getBox(initialSpot.getRow()+i, initialSpot.getCol()-i).getPiece().isWhite()!=this.isWhite()){
                        newSpot = new Spot(initialSpot.getRow()+i,initialSpot.getCol()-i);
                        allowedMoves.add(newSpot);
                    }
                    break;
                }
           }
           
       }
       for(int i=1;i<8;i++){
           if(initialSpot.getRow()-i>=0&&initialSpot.getCol()-i>=0){
               if(board.getBox(initialSpot.getRow()-i, initialSpot.getCol()-i).getPiece()==null){
                   newSpot = new Spot(initialSpot.getRow()-i,initialSpot.getCol()-i);
                   allowedMoves.add(newSpot);
               }else{
                   
                    if(board.getBox(initialSpot.getRow()-i, initialSpot.getCol()-i).getPiece().isWhite()!=this.isWhite()){
                        newSpot = new Spot(initialSpot.getRow()-i,initialSpot.getCol()-i);
                        allowedMoves.add(newSpot);
                    }
                    break;
                }
           }
       }
       return allowedMoves; 
   }
}
