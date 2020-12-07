<<<<<<< Updated upstream:finalproject/src/finalproject/Pawn.java
package chessgui.pieces;
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pieces;
>>>>>>> Stashed changes:finalproject/src/pieces/Pawn.java

import chessgui.Board;

public class Pawn extends Piece {

    private boolean has_moved;
    
    public Pawn(int x, int y, boolean is_white, String file_path, Board board)
    {
        super(x,y,is_white,file_path, board);
        has_moved = false;
    }
    
    public void setHasMoved(boolean has_moved)
    {
        this.has_moved = has_moved;
    }
    
    public boolean getHasMoved()
    {
        return has_moved;
    }
    
    @Override
    public boolean canMove(int destination_x, int destination_y)
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
    }
}