

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pieces;
import java.util.ArrayList;
import chess.*;



public class Pawn extends Piece {

    private boolean hasMoved = false;
    
    /* Constructor */
    public Pawn(boolean is_white)
    {
        super(is_white);
    }
    
    /* Getters and Setters */

    public boolean hasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }
    
    @Override
    public ArrayList<Spot> canMove(Board board, Spot initialSpot)
    {
        ArrayList<Spot> allowedMoves = new ArrayList<>();
        allowedMoves.clear();
        Spot newSpot;
        
        if(this.isWhite()){
            if(!this.hasMoved()){ 
                for(int i=1;i<=2;i++){ //white's first possible moves
                    if(board.getBox(initialSpot.getRow()+i, initialSpot.getCol()).getPiece()==null){
                        newSpot = new Spot(initialSpot.getRow()+i, initialSpot.getCol());
                        allowedMoves.add(newSpot);
                    }else{
                        break;
                    }
                        newSpot = new Spot(initialSpot.getRow()+i, initialSpot.getCol());
                        allowedMoves.add(newSpot);
                }
                
            }else{ 
                if(board.getBox(initialSpot.getRow()+1, initialSpot.getCol()).getPiece()==null){
                    newSpot = new Spot(initialSpot.getRow()+1, initialSpot.getCol());
                    allowedMoves.add(newSpot);
                }
            }
            if(board.getBox(initialSpot.getRow()+1, initialSpot.getCol()+1).getPiece()!=null){ //an attacking white pawn
                if(!board.getBox(initialSpot.getRow()+1, initialSpot.getCol()+1).getPiece().isWhite()){
                    newSpot = new Spot(initialSpot.getRow()+1, initialSpot.getCol()+1);
                    allowedMoves.add(newSpot);
                }
            }else if(board.getBox(initialSpot.getRow()+1, initialSpot.getCol()-1).getPiece()!=null){
                if(!board.getBox(initialSpot.getRow()+1, initialSpot.getCol()-1).getPiece().isWhite()){
                    newSpot = new Spot(initialSpot.getRow()+1, initialSpot.getCol()-1);
                    allowedMoves.add(newSpot);
                }
            }
        }
        
        if(!this.isWhite()){
            if(!this.hasMoved()){ //black's first possible moves
                for(int i=1;i<2;i++){
                    if(board.getBox(initialSpot.getRow()-i, initialSpot.getCol()).getPiece() ==null){
                        newSpot = new Spot(initialSpot.getRow()-i, initialSpot.getCol());
                        allowedMoves.add(newSpot);
                    }else{
                        break;
                    }
                        newSpot = new Spot(initialSpot.getRow()-i, initialSpot.getCol());
                        allowedMoves.add(newSpot);
                }
            }
            if(board.getBox(initialSpot.getRow()-1, initialSpot.getCol()+1).getPiece() !=null){ //an attacking black pawn
                if(board.getBox(initialSpot.getRow()-1, initialSpot.getCol()+1).getPiece().isWhite()){
                    newSpot = new Spot(initialSpot.getRow()-1, initialSpot.getCol()+1);
                    allowedMoves.add(newSpot);
                }
            }else if(board.getBox(initialSpot.getRow()-1, initialSpot.getCol()-1).getPiece() !=null){
                if(board.getBox(initialSpot.getRow()-1, initialSpot.getCol()-1).getPiece().isWhite()){
                    newSpot = new Spot(initialSpot.getRow()-1, initialSpot.getCol()-1);
                    allowedMoves.add(newSpot);
                }
            }
        }
        
        return allowedMoves;
    }
    
    /*public boolean canMove(int destination_x, int destination_y)
    {
        // Remember: A pawn may only move towards the oponent's side of the board.
        // If the pawn has not moved yet in the game, for its first move it can 
        // move two spaces forward. Otherwise, it may only move one space. 
        // When not attacking it may only move straight ahead.
        // When attacking it may only move space diagonally forward
        
        Piece possiblepiece = board.getPiece(destination_x,destination_y);
        
        //Check if the move is backwards where it won't let it move.
        if(this.isWhite()){
            if(this.getY()>destination_y){
                return false;
            }
        } else if (this.isBlack()){
            if(this.getY()<destination_y){
                return false;
            }
        }
        
        //checks if there is a piece infront.
        if(this.getX()==destination_x){
            if(this.isWhite()){
                Piece frontwhite = board.getPiece(this.getX(), this.getY()+1);
                if(frontwhite!=null){
                    return false;
                }
            } else if(this.isBlack()){
                Piece frontblack = board.getPiece(this.getX(), this.getY()-1);
                if(frontblack!=null){
                    return false;
                }
            }
            //Pawn movement where it only allows the two square movement at the start and also checks if there is a piece two squares infront.
            if(Math.abs(destination_y-this.getY())>2){
                return false;
            } else if(Math.abs(destination_y-this.getY())==2){
                if(this.has_moved){
                    return false;
                }
                if(this.isWhite()){
                    Piece frontwhite1 = board.getPiece(this.getX(), this.getY()+2);
                    if(frontwhite1!=null){
                        return false;
                    }
                } else if (this.isBlack()){
                    Piece frontblack1= board.getPiece(this.getX(), this.getY()+2);
                    if(frontblack1!=null){
                        return false;
                    }
                }
            }
        }else{
            //Taking A piece.
            if(Math.abs(destination_x - this.getX())!= 1 || Math.abs(destination_y-this.getY())!=1){
               return false;
            }
            if(this.isWhite()){
                if(possiblepiece == null || possiblepiece.isWhite()){
                 return false;
                }
            }
            if(this.isBlack()){
                if(possiblepiece == null || possiblepiece.isBlack()){
                 return false;
                }
            }
        }
        
        
        
    
        return true;
    }*/
}
