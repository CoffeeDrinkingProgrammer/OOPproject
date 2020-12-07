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
public class Knight extends Piece{
    
    @Override
    public boolean canMove(int destination_x, int destination_y)
    {

        //checks if a same-color piece is on the destination
        Piece testPiece = board.getPiece(destination_x, destination_y);
        if(testPiece!=null){
            if(testPiece.isWhite()&&this.isWhite()){
                return false;
            }else if(testPiece.isBlack()&&this.isBlack()){
                return false;
            }
        }
        //checks if the piece is moving properly
        if(Math.abs(destination_x-this.getX())==1){
            if(Math.abs(destination_y-this.getY())!=2){
                return false;
            }
        }else if(Math.abs(destination_y-this.getY())==1){
            if(Math.abs(destination_x-this.getX())!=2){
                return false;
            }
        }

        return true;
    }
}
