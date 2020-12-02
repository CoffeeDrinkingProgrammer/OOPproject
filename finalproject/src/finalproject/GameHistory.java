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
public class GameHistory {
    private Game[] history;
    
    //constructors
    public GameHistory(){
        
    }
    
    
    //getters and setters
    public Game[] getGameHistory(){
        return history;
    }
    
    public void setGameHistory(Game[] history){
        this.history = history.clone();
    }
    
    
    //functions
    public boolean addGame(Game game){
        boolean ret = false;
        
        return ret;
    }
    
    public boolean removeGame(String id){
        boolean ret = false;
        
        return ret;
    }
    
    public void displayHistory(){
        
    }
    
}
