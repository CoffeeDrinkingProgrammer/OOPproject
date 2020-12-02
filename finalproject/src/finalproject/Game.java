/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

/**
 *
 * @author user
 */
enum gameStatus{
    blackWins, whiteWins, draw, checkmate, check;
}

public class Game {
    private String gameID;
    private Player[] players;
    private Board board;
    private Player currentTurn;
    //gameStatus moved above (before class)
    private Move[] movesPlayed;
    private Player winner;
    
    
    //constructors
    public Game(){
        
    }
    
    
    //getters and setters
    public String getGameID(){
        return gameID;
    }
    
    public void setGameID(String gameID){
        this.gameID = gameID;
    }
    
    public Player[] getPlayers(){
        return players;
    }
    
    public void setplayers(Player[] players){
        int x;
        for (x=0; players[x]!=NULL; x++){
            this.players[x] = players[x];
        }
    }
    
    public Board getBoard(){
        return board;
    }
    
    public void setBoard(Board board){
        this.board = board;
    }
    
    public Player getCurrentTurn(){
        return currentTurn;
    }
    
    public void setCurrentTurn(Player currentTurn){
        this.currentTurn = currentTurn;
    }
    
    public Move[] getMovesPlayed(){
        return movesPlayed;
    }
    
    public void setMovesPlayed(Move[] movesPlayed){
        this.movesPlayed = movesPlayed;
    }
    
    public Player getWinner(){
        return winner;
    }
    
    public void setWinner(Player winner){
        this.winner = winner;
    }
            
    
    //functions
    public void initialize(Player A, Player B){
    }
    
    public void isEnd(){
        
    }
    
    public boolean playerMove(Move move){
        boolean ret = false;
        
        return ret;
    }
    
    public boolean makeMove(Move move, Player currentPlayer){
        boolean ret = false;
        
        return ret;
    }
    
    public void showLastMove(){
        
    }
    
    
}
