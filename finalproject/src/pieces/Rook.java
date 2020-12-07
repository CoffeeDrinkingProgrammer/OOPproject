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
public class Rook extends Piece{
    
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
        //checks if the piece is moving correctly
        if(initialSpot.getX()!=finalSpot.getX() && initialSpot.getY()!=finalSpot.getY()){
            return false;
        }
        //checks if there are no pieces on the way
        int Yspaces = Math.abs(finalSpot.getY() - initialSpot.getY());
        int Xspaces = Math.abs(finalSpot.getX() - initialSpot.getX());
        Spot testSpot;
        if(finalSpot.getY()>initialSpot.getY()){ //moving north (white perspective)
            for(int i=1;i<Yspaces;i++){
                testPiece = testSpot.getPiece(initialSpot.getX(), initialSpot.getX()+i);
                if(testPiece !=null){
                    return false;
                }
            }
        }else if(finalSpot.getY()<initialSpot.getY()){ //moving south (white perspective)
            for(int i=1;i<Yspaces;i++){
                testPiece = testSpot.getPiece(initialSpot.getX(), initialSpot.getY()-i);
                if(testPiece !=null){
                    return false;
                }
            }
        }else if(finalSpot.getX()>initialSpot.getX()){ //moving west (white perspective)
            for(int i=1;i<Xspaces;i++){
                testPiece = testSpot.getPiece(initialSpot.getX()+i, initialSpot.getY());
                if(testPiece !=null){
                    return false;
                }
            }
        }else if(finalSpot.getX()<initialSpot.getX()){ //moving east (white perspective)
            for(int i=1;i<Xspaces;i++){
                testPiece = testSpot.getPiece(initialSpot.getX()-i, initialSpot.getY());
                if(testPiece !=null){
                    return false;
                }
            }
        }
        return true;
    }
}