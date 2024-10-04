import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        char player1; //you don't need to initalize a variable unless you're doing operations with them (like comparisons or math)
        char player2;

        System.out.println("Welcome to Rock, Paper, Scissors!\nPlayer 1, please input your choice: Rock, Paper, or Scissors? [R, P,S]");
        char player1 = DetermineInput(); //sets player1 to determined output
        System.out.println("Player 2, please input your choice: Rock, Paper, or Scissors? [R, P,S]");
        char player2 = DetermineInput(); //runs determineoutput method and then sets player2 to the returned value

    }

    /*you use public static char here for the method (public static char means the method has to return a char)
    because you want to return the value and then used that returned value to initialize the player variables
    you can set the player values without, returning but its just flat-out easier to do it this way, since you only have to initialize the variables once*/
    public static char DetermineInput() {

        /*this is an array; you create an array by adding [] to the end of the datatype
        final means that the variable cannot be reinitialized, so it stays constant and cannot change after first initialization
        technically you don't need an array here. you can just do if(input =='R' || input =='P' || input == 'S') in the dowhile loop
        but this is shorter and more dynamic since you can edit the options variable to accept anything you want, if you ever want to change the accepted items the player can input
        the variable is rendered as OPTIONS in all capitals because it's a constant. the code will run irregardless of the variable name but it's convention to name constants in all capital*/
        final char[] OPTIONS = {'R','P','S'};
        Scanner scan = new Scanner(System.in);
        boolean validInput = false;
        char input;

        /*checking for if scan.hasNextLine is irrelevant; you only have to check if youre input is supposed to be an integer or double
        when you're asking the user to input integers you need to check if scan.hasNextInt is because ints cant handle string values (since they are only for numbers)
        but when you're working with string/char if you input just about anything into scan.nextline it wont give an error because you can put numbers in strings*/

        do {

            //set the input to upper case so that way the input works regardless if user types captial or lowercase chars
            input = (scan.next().toUpperCase()).charAt(0);

            /*lets break this down
            the OPTIONS is an array. .contains(); checks if the array contains the input value, and returns true if it doesn.
            you can't use [var].contains(); on arrays though, that's only for the arrayList datatype, which is completely different from regular arrays for some reason
            so you have to cast the array to the arrayList datatype using Arrays.asList
            basically, all this is checking is "does anything in the OPTIONS array match the user input*/
            if (Arrays.asList(OPTIONS).contains(input)) {
                validInput = true;
            } if(!validInput) { //when youre checking for false values, you can just put an ! in front of the statement instead of doing (statement) = false. it works both ways but this is shorter
                System.out.println("You've input an invalid response. Please try again.");
                scan.nextLine();
                }
            return(input); //returns the input value
        } while (!validInput);
    }

}
