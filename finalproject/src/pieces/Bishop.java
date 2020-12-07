/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pieces;

/**
 *
 * @author user
 */
public class Bishop extends Piece{
<<<<<<< Updated upstream:finalproject/src/finalproject/Bishop.java
    
    @Override
    public boolean canMove (Board board, Spot initialSpot, Spot finalSpot){
        //checks if the same color piece is on the final spot
        Piece testPiece = finalSpot.getPiece();
        if(testPiece!=null){ //checks if theres a piece on the final spot
            if(testPiece.isWhite && this.isWhite){
                return false;
            }else if(!testPiece.isWhite && !this.isWhite){
                return false;
            }
        }
        //checks if the piece is moving properly
        if(initialSpot.getX()==finalSpot.getX() || initialSpot.getY()==finalSpot.getY()){
            return false;
        }
        if(Math.abs(finalSpot.getX()-initialSpot.getX()) != Math.abs(finalSpot.getY()-initialSpot.getY())){
            return false;
        }
        //checks if there are no pieces on the way
        int i;
        int spaces = Math.abs(finalSpot.getX()-initialSpot.getX());
        Spot testSpot;
        //directions are in white perspective (not sure with this hehehe)
        if(finalSpot.getX()>initialSpot.getX() && finalSpot.getY()>initialSpot.getY()){ //northwest
            for(i=1;i<spaces;i++){
                testPiece = testSpot.getPiece(initialSpot.getX()+i, initialSpot.getY()+i);
                if(testPiece!=null){
                    return false;
                }
            }
        }else if(finalSpot.getX()>initialSpot.getX() && finalSpot.getY()<initialSpot.getY()){ //northeast
            for(i=1;i<spaces;i++){
                testPiece = testSpot.getPiece(initialSpot.getX()+i, initialSpot.getY()-i);
                if(testPiece!=null){
                    return false;
                }
            }
        }else if(finalSpot.getX()<initialSpot.getX() && finalSpot.getY()<initialSpot.getY()) { //southeast
            for (i = 1; i < spaces; i++) {
                testPiece = testSpot.getPiece(initialSpot.getX() - i, initialSpot.getY() - i);
                if (testPiece != null) {
                    return false;
                }
            }
        }else if(finalSpot.getX()<initialSpot.getX() && finalSpot.getY()>initialSpot.getY()){ //southwest
            for (i = 1; i < spaces; i++) {
                testPiece = testSpot.getPiece(initialSpot.getX() - i, initialSpot.getY() + i);
                if (testPiece != null) {
                    return false;
                }
            }
        }
        return true;
    }
=======

>>>>>>> Stashed changes:finalproject/src/pieces/Bishop.java
}
