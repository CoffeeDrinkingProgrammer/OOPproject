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
public class Queen extends Piece{
    
    @Override
    public boolean canMove (Board board, Spot initialSpot, Spot finalSpot){
        
        //checks if the same color piece is on the final spot
        Piece testPiece = finalSpot.getPiece();
        if(testPiece!=null){ //checks if theres a piece on the final spot
            if(testPiece.isWhite != this.isWhite){
                return false;
            }
        }
        
        //checks if the piece is moving correctly
        int checker = 0;
        if(initialSpot.getX()!=finalSpot.getX() || initialSpot.getY()!=finalSpot.getY()){
            checker++;
        }
        if(Math.abs(finalSpot.getX()-initialSpot.getX()) == Math.abs(finalSpot.getY()-initialSpot.getY())){
            checker+=2;
        }
        if (checker == 0){
            return false;
        }
        
        //checks if there are no pieces on the way (white perspective == 1x1 lower leftmost spot)
        Spot testSpot;
        int i;
        if (checker == 1){ //moves in one of the cardinal directions
            int Yspaces = Math.abs(finalSpot.getY() - initialSpot.getY());
            int Xspaces = Math.abs(finalSpot.getX() - initialSpot.getX());
            if(finalSpot.getY()>initialSpot.getY()){ //moving north
                for(i=1;i<Yspaces;i++){
                    testPiece = testSpot.getPiece(initialSpot.getX(), initialSpot.getX()+i);
                    if(testPiece != null){
                        return false;
                    }
                }
            }else if(finalSpot.getY()<initialSpot.getY()){ //moving south
                for(i=1;i<Yspaces;i++){
                    testPiece = testSpot.getPiece(initialSpot.getX(), initialSpot.getY()-i);
                    if(testPiece != null){
                        return false;
                    }
                }
            }else if(finalSpot.getX()>initialSpot.getX()){ //moving east?
                for(i=1;i<Xspaces;i++){
                    testPiece = testSpot.getPiece(initialSpot.getX()+i, initialSpot.getY());
                    if(testPiece != null){
                        return false;
                    }
                }
            }else if(finalSpot.getX()<initialSpot.getX()){ //moving west?
                for(i=1;i<Xspaces;i++){
                    testPiece = testSpot.getPiece(initialSpot.getX()-i, initialSpot.getY());
                    if(testPiece != null){
                        return false;
                    }
                }
            }
        } else if (checker == 2){//moves diagonally
            int spaces = Math.abs(finalSpot.getX()-initialSpot.getX());
            if(finalSpot.getX()>initialSpot.getX() && finalSpot.getY()>initialSpot.getY()){ //northeast
                for(i=1;i<spaces;i++){
                    testPiece = testSpot.getPiece(initialSpot.getX()+i, initialSpot.getY()+i);
                    if(testPiece!=null){
                        return false;
                    }
                }
            }else if(finalSpot.getX()>initialSpot.getX() && finalSpot.getY()<initialSpot.getY()){ //northwest
                for(i=1;i<spaces;i++){
                    testPiece = testSpot.getPiece(initialSpot.getX()+i, initialSpot.getY()-i);
                    if(testPiece!=null){
                        return false;
                    }
                }
            }else if(finalSpot.getX()<initialSpot.getX() && finalSpot.getY()<initialSpot.getY()) { //southwest
                for (i = 1; i < spaces; i++) {
                    testPiece = testSpot.getPiece(initialSpot.getX() - i, initialSpot.getY() - i);
                    if (testPiece != null) {
                        return false;
                    }
                }
            }else if(finalSpot.getX()<initialSpot.getX() && finalSpot.getY()>initialSpot.getY()){ //southeast
                for (i = 1; i < spaces; i++) {
                    testPiece = testSpot.getPiece(initialSpot.getX() - i, initialSpot.getY() + i);
                    if (testPiece != null) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}
