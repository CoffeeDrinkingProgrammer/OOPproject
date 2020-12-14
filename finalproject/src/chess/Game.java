/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import pieces.*;
import java.util.ArrayList;

/**
 *
 * @author user
 */

/* there is still no code for checkmate
*  and undoMove(?)  */

public enum gameStatus{
    ACTIVE, BLACK_WINS, WHITE_WINS, FORFEIT, STALEMATE, RESIGNATION
}

public class Game {

    private Player[] players;
    private Board board;
    private Player currentTurn;
    private gameStatus status;
    private ArrayList<Move> movesPlayed;

    /* Getters and Setters */

    public gameStatus getStatus() {
        return status;
    }

    public void setStatus(gameStatus status) {
        this.status = status;
    }

    /* Methods */

    private void initGame(Player p1, Player p2){
        players[0] = p1;
        players[1] = p2;
        board.resetBoard();
        this.currentTurn = (p1.isWhiteSide())? p1 :  p2;
        movesPlayed.clear();
    }

    public boolean isEnd(){
        return this.getStatus() != gameStatus.ACTIVE;
   }

   public boolean playerMove(Player player, int initialSpotRow, int initialSpotCol, int finalSpotRow, int finalSpotCol){
        Spot initialBox = board.getBox(initialSpotRow, initialSpotCol);
        Spot finalBox = board.getBox(finalSpotRow, finalSpotCol);
        Move move = new Move(player, initialBox, finalBox);
        return this.makeMove(move, player);
   }

   private boolean makeMove(Move move, Player player){
        Piece sourcePiece = move.getInitialSpot().getPiece();
        /* if there is no piece to be moved */
        if (sourcePiece == null){
            return false;
        }
        /* if it is not the player's turn to make a move */
        if(player != currentTurn){
            return false;
        }
        /* if piece to be moved does not match player's side */
        if(sourcePiece.isWhite() != player.isWhiteSide()){
            return false;
        }
        /* if move is not valid
        if(!sourcePiece.){
            return false;
        }
         */

        /* if move is valid */
        Piece destPiece = move.getFinalSpot().getPiece();
        if(destPiece != null){
            destPiece.setKilled(true);
            move.setPieceKilled(destPiece);
        }

        /* store move */
        movesPlayed.add(move);

        /* move piece from source to destination */
       move.getFinalSpot().setPiece(move.getInitialSpot().getPiece());
       move.getInitialSpot().setPiece(null);

       if(destPiece != null && destPiece instanceof King){
           this.status((player.isWhiteSide()) ? (gameStatus.WHITE_WINS) : (gameStatus.BLACK_WINS);
       }

       /* set the current turn to the other player */
       this.currentTurn = (this.currentTurn == players[0]) ? players[1] : players[0];

       return  true;
   }

}

