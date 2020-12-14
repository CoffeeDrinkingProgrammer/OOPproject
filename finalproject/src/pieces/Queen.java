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
public class Queen extends Piece{
    
    public Queen(boolean is_white)
    {
        super(is_white);
        
    }
    
    @Override
    public ArrayList<Spot> canMove(Board board, Spot initialSpot){
        
        ArrayList<Spot> allowedMoves = new ArrayList<>();
       
       Spot newSpot;
        
       for(int i=initialSpot.getRow()+1;i<8;i++){ //moves going towards black side
            if(board.getBox(i, initialSpot.getCol()).getPiece()==null){
                newSpot = new Spot(i, initialSpot.getCol());
                allowedMoves.add(newSpot);
            }else{
                if(board.getBox(i, initialSpot.getCol()).getPiece().isWhite() != this.isWhite()){
                    newSpot = new Spot(i, initialSpot.getCol());
                    allowedMoves.add(newSpot);
                }
                break;
            }          
        }
       
        for(int i=initialSpot.getRow()-1;i>=0;i--){ //moves going towards white side
            if(board.getBox(i, initialSpot.getCol()).getPiece()==null){
                newSpot = new Spot(i, initialSpot.getCol());
                allowedMoves.add(newSpot);
            }else{
                if(board.getBox(i, initialSpot.getCol()).getPiece().isWhite() != this.isWhite()){
                    newSpot = new Spot(i, initialSpot.getCol());
                    allowedMoves.add(newSpot);
                }
                break;
            }          
        }
        
        for(int i=initialSpot.getCol()+1;i<8;i++){ //moves to the right (white perspective)
            if(board.getBox(initialSpot.getRow(),i ).getPiece()==null){
                newSpot = new Spot(initialSpot.getRow(),i);
                allowedMoves.add(newSpot);
            }else{
                if(board.getBox(initialSpot.getRow(),i).getPiece().isWhite() != this.isWhite()){
                    newSpot = new Spot(initialSpot.getRow(),i);
                    allowedMoves.add(newSpot);
                }
                break;
            }           
        }
        
        for(int i=initialSpot.getCol()-1;i>=0;i--){ //moves to the left (white perspective)
            if(board.getBox(initialSpot.getRow(),i ).getPiece()==null){
                newSpot = new Spot(initialSpot.getRow(),i);
                allowedMoves.add(newSpot);
            }else{
                if(board.getBox(initialSpot.getRow(),i).getPiece().isWhite() != this.isWhite()){
                    newSpot = new Spot(initialSpot.getRow(),i);
                    allowedMoves.add(newSpot);
                }
                break;
            }
        }
        
        for(int i=1;i<8;i++){ //northeast (white perspective)
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
        
        for(int i=1;i<8;i++){ //southeast (white perspective)
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
       
        for(int i=1;i<8;i++){ //northwest (white perspective)
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
        
        for(int i=1;i<8;i++){//southwest (white perspective)
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
