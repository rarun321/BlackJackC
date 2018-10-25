/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjackc;

import java.awt.image.BufferedImage;

/**
 *
 * @author rithv
 */

public class Cards {
    private BufferedImage cardImage;
    private int vals;
        
     public Cards(int Value, BufferedImage card) {
      
        cardImage = card;
        vals= Value;
       
    }
     public BufferedImage getCardImage(){
        return cardImage;
    }
      public int getScore(){
        return vals;
    }
   
   
}

