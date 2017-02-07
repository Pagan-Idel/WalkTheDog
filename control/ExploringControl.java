/*
 * Project author: Ideal Pagen and gab    James.
 * 
 */
package byui.cit260.walkTheDog.control;

import byui.cit260.walkTheDog.exceptions.ExploringControlException;
import byui.cit260.walkTheDog.model.EventsType;
import byui.cit260.walkTheDog.model.Player;
import byui.cit260.walkTheDog.view.ErrorView;
import byui.cit260.walkTheDog.view.GameMenuView;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Random;
import walkthedog.WalkTheDog;

/**
 *
 * @author gab & Idel
 *
 * Team Effort: eventOnExplore()
 *
 * individual: gab - eventOnNoExplore() gab - generateIdealLeashLength() gab -
 * randomNumberGenerator()
 *
 * Idel - generateFidoMood()
 *
 */
public class ExploringControl {

    protected final BufferedReader keyboard = WalkTheDog.getInFile();
    protected final PrintWriter console = WalkTheDog.getOutFile();

    // Generate event on an explore
    public int eventOnExplore(int leashLength, int idealLeashLength) throws ExploringControlException {

        if (leashLength < 0 || leashLength > 15) {      // test for good leashlenght
            throw new ExploringControlException("\nCan not set Leash Lenght to " + leashLength
                    + " becasue the length is outside of the bounds of the leash.");
        }

        if (idealLeashLength < 4 || idealLeashLength > 15) {      // test for good idealLeashLength
            throw new ExploringControlException("\nCan not set Ideal Leash Lenght to " + idealLeashLength
                    + " becasue the length is outside of the bounds of the leash.");
        }

        double upperBase = 10;          //define an upperBase integer
        double lowerBase = 0.1;          //define an lowerBase integer	
        double idealLeashLengthD = idealLeashLength;      //change int to double

        idealLeashLengthD = leashLength * lowerBase * idealLeashLengthD / leashLength * upperBase;

        if (leashLength >= idealLeashLengthD) {
            return 1;                                 // return 1 for yes overlap
        }

        return 0;                                    // return 0 for no overlap

    }

    // Generate event on No Explore
    public int eventOnNoExplore(int noExploreCounter, int idealLeashLength, int randomNumber) throws ExploringControlException {

        double noExploreCounterD = (double) noExploreCounter;
        double minLeashLenght = 4;

        if (noExploreCounter < 0 || noExploreCounter > 10) {      // test for good leashlenght
            throw new ExploringControlException("*** Our appologies, something went wrong. ***"
                    + "\n*** ERROR in GameMenuView.java ***"
                    + "\nin       public int eventOnNoExplore(int noExploreCounter, int idealLeashLength, int randomNumber)"
                    + "\n if (noExploreCounter < 0 || noExploreCounter > 10)");
        }

        if (idealLeashLength < 4 || idealLeashLength > 15) {
            throw new ExploringControlException("*** Our appologies, something went wrong. ***"
                    + "\n*** ERROR in GameMenuView.java ***"
                    + "\nin       public int eventOnNoExplore(int noExploreCounter, int idealLeashLength, int randomNumber)"
                    + "\n if (idealLeashLength < 4 || idealLeashLength > 15)");
        }

        if (randomNumber < 4 || randomNumber > 19) {
            throw new ExploringControlException("*** Our appologies, something went wrong. ***"
                    + "\n*** ERROR in GameMenuView.java ***"
                    + "\nin       public int eventOnNoExplore(int noExploreCounter, int idealLeashLength, int randomNumber)"
                    + "\n if (randomNumber < 4 || randomNumber > 19)");
        }

        if (noExploreCounter == 0) {                             // test noExploreCounter not zero if zero add 1
            noExploreCounterD = 1.0;
        }

        double randomNumberD = randomNumber;          // cast int to double

        double fidoLeashOverlap = minLeashLenght + .1 * noExploreCounterD * randomNumberD;

        if (fidoLeashOverlap < idealLeashLength) {      // test for overlap
            return 0;
        }

        return 1;                                    // return 1 for yes overlap

    }

    // Determin Fido Mood
    public int generateFidoMood(int numberOfTurns, int leashLength, int mood) throws ExploringControlException {

        if (leashLength < 0 || leashLength > 15) {
            throw new ExploringControlException("*** Our appologies, something went wrong. ***"
                    + "\n*** ERROR in GameMenuView.java ***"
                    + "\nin       public int generateFidoMood(int numberOfTurns, int leashLength, int mood)"
                    + "\n if (leashLength < 0 || leashLength > 15)");
        }

        if (mood < 0 || mood > 9) {   // checks if mood is valid
            throw new ExploringControlException("*** Our appologies, something went wrong. ***"
                    + "\n*** ERROR in GameMenuView.java ***"
                    + "\nin       public int generateFidoMood(int numberOfTurns, int leashLength, int mood)"
                    + "\n if (mood < 0 || mood > 9)");
        }

        if (numberOfTurns < 0) {
            throw new ExploringControlException("*** Our appologies, something went wrong. ***"
                    + "\n*** ERROR in GameMenuView.java ***"
                    + "\nin       public int generateFidoMood(int numberOfTurns, int leashLength, int mood)"
                    + "\n if (numberOfTurns < 0)");
        }
        double low = 0.0;
        double high = 1.0;
        double numberOfTurnTotal;

        numberOfTurnTotal = ((((double) mood / (double) leashLength)) * low) + high;

        numberOfTurns = (int) (numberOfTurns * numberOfTurnTotal);

        if (leashLength <= 4 && numberOfTurns == 0) {
            return mood;
        }

        if (leashLength <= 4 && numberOfTurns > 0) { //testing leash length is less than four and more than one turn
            if (mood <= 2) {
                mood = 0;
                return mood;
            }

            return mood -= 2; // fido is mad                 less freedom for fido (he gets mad)  
        }

        if (mood < 9) {
            return mood += 1;
        }

        return mood; //fido is happy

    }

    //create Ideal LeashLenght for actor
    public int generateIdealLeashLength(int randomNumber) throws ExploringControlException {     //create Ideal LeashLenght for actor

        if (randomNumber < 0 || randomNumber > 15) {
            throw new ExploringControlException("*** Our appologies, something went wrong. ***"
                    + "\n*** ERROR in GameMenuView.java ***"
                    + "\nin       public int generateIdealLeashLength(int randomNumber)"
                    + "\n if (leashLength < 0 || leashLength > 15)");
        }

        if (randomNumber == 0) {
            randomNumber = 1;
        }

        double minimumLength = 4.0;
        double randomNumberD = (double) randomNumber;

        if (randomNumberD < minimumLength) {
            return (int) randomNumberD + (int) minimumLength;
        }

        return (int) randomNumberD;

    }

    //create Ideal LeashLenght for actor
    public int idealLeashLength(int randomNumber) throws ExploringControlException {     //create userLeashLenght for actor

        if (randomNumber < 0 || randomNumber > 15) {
            throw new ExploringControlException("*** Our appologies, something went wrong. ***"
                    + "\n*** ERROR in GameMenuView.java ***"
                    + "\nin       visitSceanL() if (randomNumber < 0 || randomNumber > 15)");
        }

        if (randomNumber == 0) {
            randomNumber = 1;
        }

        double minimumLength = 4.0;
        double randomNumberD = (double) randomNumber;

        if (randomNumberD < minimumLength) {
            return (int) randomNumberD + (int) minimumLength;
        }

        return (int) randomNumberD;

    }

    //Generate a random number
    public int randomNumberGenerator16_0to15() {
        Random rand = new Random();
        return (int) rand.nextInt(16);
    }

    //Generate a random number
    public int randomNumberGenerator(int num) {
        Random rand = new Random();
        return (int) rand.nextInt(num);
    }

    //Generate a random number
    public int randomIdealLeashGenerator() {
        Random rand = new Random();
        return (int) 4 + rand.nextInt(12);
    }

    public int shortLeash(Player player) throws ExploringControlException {

        if (player.getPlayerLeashLenght() < 4) {
            int getFidoMood = this.generateFidoMood(player.getGameNumberOfTurns(), player.getPlayerLeashLenght(), player.getGameFidoMood());             // passes a random generated number to a variable
            if (getFidoMood == 0) {
                this.console.println("\nFido does not like a short leash"
                        + "\nand has been a bad dog, you loose 3 points");
                player.setPlayerCurrentScore(player.getPlayerCurrentScore() - 3);
                player.setGameNumberOfTurns(0);
                return 0;
            } else if (getFidoMood < player.getGameFidoMood()) {
                this.console.println("\nFido does not like a short leash"
                        + "\nand is starting to get unhappy");
                player.setGameFidoMood(getFidoMood);
                player.setGameNumberOfTurns(player.getGameNumberOfTurns() + 1);
            } else if (getFidoMood == player.getGameFidoMood()) {
                this.console.println("\nFido fido does not like a short leash "
                        + "\nluckily Fido is not that mad yet."
                        + "\nConsider keeping the leash longer than 3.");
                player.setGameNumberOfTurns(player.getGameNumberOfTurns() + 1);
            } else {
                throw new ExploringControlException("\n*** Our appologies, something went wrong. ***"
                        + "\n*** ERROR in GameMenuView.java ***"
                        + "\nin       visitSceanL() if(playerLeashLength<4)");
            }
        }
        return 1;
    }

    public int didUserExplore(Player player) throws ExploringControlException {

        if (player.getGameDidUserExplore() == 'n') {
            int eONE = this.eventOnNoExplore(player.getGameUserExploreCounter(), player.getGameIdealLeashLength(), this.randomIdealLeashGenerator());
            if (eONE < 0) {
                throw new ExploringControlException("\n*** Our appologies, something went wrong. ***"
                        + "\n*** ERROR in GameMenuView.java in ***"
                        + "\n   visitSceanL() if(gameUserExplore<0)***");
            } else if (eONE > 0) {
                player.setGameDidUserExplore('r');                                       // change char gameDidUserExplore to random event posible
                player.setGameUserExploreCounter(0);                                     // Set gameUserExploreCounter to ZERO after ramdom event is generated 
                this.console.println("/nA random event occured when you did not Explore the area./n");
                player.setPlayerLeashLenght(this.idealLeashLength(this.randomNumberGenerator16_0to15())); // passes a random generated playerLeashLenght to a variable
                GameMenuView checkExplore = new GameMenuView(player);
                checkExplore.userExplore();                                             // sends player to explore
            }
        }
        return 0;
    }

    
    
    
        public int displayLeashLengthInput() {

        this.console.println("Please enter a leash lenght for Fido"
                + "\nbefore moving forward.");

        char selection = ' ';
        int userLL = -2; //-2 so that it enters the do while statement

        do {
            String input = this.getLLInput(); // get first charecter of string
//            selection = input.charAt(0);
            userLL = Integer.parseInt(input);

            if (userLL < 0 || userLL > 15) {
                ErrorView.display(this.getClass().getName(), "Invalid Leash Length! Try again!");
            }
        } while (userLL < 0 || userLL > 15); // a selection is not "valid"
        return userLL;
    }

    
        public String getLLInput() {
        boolean valid = false;
        String playersInput = null;
//       Scanner keyboard = new Scanner(System.in);

        try {
            while (!valid) {

                this.console.println("\nPlease enter a leash length between 0 and 15: ");

                playersInput = this.keyboard.readLine();
                playersInput = playersInput.trim();

                if (playersInput.length() < 1) {
                    ErrorView.display(this.getClass().getName(), "Invalid entry - space is not an option");
                    continue;
                }
                break;
            }
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "Error reading inputL " + e.getMessage());
        }
        return playersInput;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    public void userExploreControl(Player player) throws ExploringControlException {

//        LeashLengthControl leash = new LeashLengthControl();

        ExploringControl explore = new ExploringControl();                         // calls random number generator
        EventsType[][] eventTypes = WalkTheDog.getCurrentGame().getEvent().getEventTypes();
        Player variable = new Player();

        variable.setGameIdealLeashLength(explore.idealLeashLength(explore.randomIdealLeashGenerator())); // passes a random generated idealLeashLength to a variable

        if (explore.shortLeash(player) > 0 && player.getGameDidUserExplore() == 'n') {

            player.setPlayerLeashLenght(this.displayLeashLengthInput());

// check if user had leash too short for too long and Fido was bad - no points for bad fido
            if (explore.eventOnExplore(variable.getPlayerLeashLenght(), variable.getGameIdealLeashLength()) > 0 && variable.getGameDidUserExplore() == 'r') {
                this.badFido(variable, eventTypes, explore);
            } else if (explore.eventOnExplore(player.getPlayerLeashLenght(), player.getGameIdealLeashLength()) > 0) {
                player.setGameDidUserExplore('y');
                this.console.println("\n*** Fido found a friend in this area");
                this.console.println("\n*** " + eventTypes[explore.randomNumberGenerator(8)][0].getEventScene().getEventsSymbol());
                player.setPlayerCurrentScore(player.getPlayerCurrentScore() + 1);
                if (player.getGameFidoMood() < 9) {
                    player.setGameFidoMood(player.getGameFidoMood() + 1);
                }
                this.console.println("\nFido Leash Length: " + player.getPlayerLeashLenght()
                        + "\nClosest object: " + player.getGameIdealLeashLength()
                        + "\n*** Players Current Score increases by 1 to " + player.getPlayerCurrentScore()
                        + "\nFido's Mood is now: " + player.getGameFidoMood());
            } else {
                player.setPlayerCurrentScore(player.getPlayerCurrentScore() + 1);
                player.setGameDidUserExplore('y');
                if (player.getGameFidoMood() < 9) {
                    player.setGameFidoMood(player.getGameFidoMood() + 1);
                }
                this.console.println("\nFido Leash Length: " + player.getPlayerLeashLenght()
                        + "\nClosest object: " + player.getGameIdealLeashLength()
                        + "\n*** Players Current Score increases by 1 to " + player.getPlayerCurrentScore()
                        + "\nFido's Mood is now: " + player.getGameFidoMood()
                        + "\n*** Fido was not interested in "
                        + "anything in the area it could reach ");
            }
        } // END          if (badDog > 0){
        else {
            this.console.println("\n\n************************************\n"
                    + "You have already explored this Area.\nPlease try another Area."
                    + "\n************************************\n");
        }

    }

    public void badFido(Player variable, EventsType[][] eventTypes, ExploringControl explore) { // check if user had leash too short for too long and Fido was bad - no points for bad fido

        variable.setGameDidUserExplore('y');
        this.console.println("\n*** Fido found something in this area");
        this.console.println("*** " + eventTypes[explore.randomNumberGenerator(8)][1].getEventScene().getEventsSymbol());
        variable.setPlayerCurrentScore(variable.getPlayerCurrentScore() - 1);

        if (variable.getGameFidoMood() < 9 && variable.getGameFidoMood() > 1) {
            variable.setGameFidoMood(variable.getGameFidoMood() - 1);
        }
        this.console.println("\nFido Leash Length: " + variable.getPlayerLeashLenght()
                + "\nClosest object: " + variable.getGameIdealLeashLength()
                + "\n*** Players Current Score decreases by 1 to " + variable.getPlayerCurrentScore()
                + "\nFido's Mood is now: " + variable.getGameFidoMood());
    }

}
