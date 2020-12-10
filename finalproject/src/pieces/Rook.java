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
public class Rook extends Piece{
    private boolean has_moved;
    
    //constructor
    public Rook(boolean is_white)
    {
        super(is_white);
        has_moved = false;
    }
    @Override
    public ArrayList<Spot> canMove(Board board, Spot initialSpot)
    {

        ArrayList<Spot> allowedMoves = new ArrayList<>();
        
        allowedMoves.clear();
        Spot newSpot;
        for(int i=initialSpot.getRow()+1;i<8;i++){
            
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
        for(int i=initialSpot.getRow()-1;i>=0;i--){
            
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
        for(int i=initialSpot.getCol()+1;i<8;i++){
            
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
        for(int i=initialSpot.getCol()-1;i>=0;i--){
            
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
        return allowedMoves; 
    }
}
    
