/*
 * Project author: gab James.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.walkTheDog.views;

import byui.cit260.walkTheDog.interfaces.DisplayInfo;
import byui.cit260.walkTheDog.model.Player;
import byui.cit260.walkTheDog.view.ErrorView;

/**
 *
 * @author gab
 */
public class ParkView  implements DisplayInfo {
    
    Player player;
   
    
//  ***THIS NEEDS TO BE FIXED*++**++**++**++**++**++**++**++**++**++**++**++**++**++**++**++**++**++**++**++***    
    @Override
    public Object display(Object object) {
        this.player = (Player) object;
//        this.printHeadRow();
//        this.printDividerRow();
//        for (int i = 0; i < this.player.getRowCount(); i++) {
//            Player[] rowOfLocations = this.board.getBoardLocations()[i];
//            this.printRow(i+1, rowOfLocations);
//            this.printDividerRow();
//        }
      //  ErrorView.display(this.getClass().getName());
         
        return null;
    }
    
    
}
