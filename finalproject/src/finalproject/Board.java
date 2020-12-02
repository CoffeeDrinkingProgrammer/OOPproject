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
public class Board {
    private Spot[][] boxes;
    
    //constructors
    public Board(){
        
    }
    
    //setters and getters
    public Spot[][] getBoxes(){
        return boxes;
    }
    
    public void setBoxes(Spot[][] boxes){
        this.boxes = boxes.clone();
    }
    
    
    //methods
    public void Board(){
        
    }
    
    public Spot getBox(int x, int y){ //DOES THIS NEED ANOTHER PARAMERTER "PIECE" TO COMPLETE SPOT???
        
    }
    
    public void resetBoard(){
        
    }
}
