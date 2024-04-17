import java.util.Scanner;

/**
 * RockPaperScissors
 */
public class RockPaperScissors {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        System.out.println("Let's play Rock Paper Scissors.\n");
        System.out.println("When I say 'shoot', Choose: rock, paper, or scissors.\n\n");
        System.out.println("Are you ready? Write 'yes' if you are\n");
        
        String userReady = scan.nextLine();

        if(userReady.equals("yes")){
            System.out.println("\nGreat!\n");
            System.out.println("rock - paper - scissors, shoot!\n");

            String userChoice = scan.nextLine();
            boolean isUserChoiceValid = userChoice.equals("rock") ||  userChoice.equals("paper") ||  userChoice.equals("scissors");

            if(!isUserChoiceValid){
                System.out.println("Error: your choice is not valid");
                System.exit(0);
            }

            String compChoice = computerChoice();

            String finalResult = result(userChoice, compChoice);

            printResult(userChoice, compChoice, finalResult);
            


        }else{
            System.out.println("Darn, some other time...!\n");

        }


        scan.close();
    }

    /**
     * Function name: computerChoice
     * @return (String)
     * 
     * Inside the function:
     * 1. Calculates a random number (int) between 0 and 2
     * 2. Returns a string representing the computer's choice based on the random number.
     */


    public static String computerChoice(){
        int randomNumber = (int)(Math.random()*3);
        switch(randomNumber){
            case 0: return "rock";
            case 1: return "paper";
            case 2: return "scissors";
            default: return "error";
        }
        }

    /**
     * Function name: result
     * 
     * @param userChoice (String)
     * @param compChoice (String)
     * @return (String)
     * 
     * Inside the function:
     * 1. Initializes three booleans: userWon, computerWon, and isTie based on the comparison of userChoice and compChoice.
     * 2. Returns a string indicating the result of the game based on the true boolean.
    */
    

    public static String result(String userChoice, String compChoice){
        
        boolean userWon = 
        userChoice.equals("rock") && compChoice.equals("scissors") ||
        userChoice.equals("paper") && compChoice.equals("rock") ||
        userChoice.equals("scissors") && compChoice.equals("paper");

        boolean computerWon = 
        compChoice.equals("rock") && userChoice.equals("scissors") ||
        compChoice.equals("paper") && userChoice.equals("rock") ||
        compChoice.equals("scissors") && userChoice.equals("paper");

        boolean isTie = userChoice.equals(compChoice);

        if(userWon){
            return "You win";
        }else if(computerWon){
            return "You lose";
        }else if(isTie){
            return "It's a tie";
        }else{
            return "INVALID CHOICE";
        }


    }

    public static void printResult(String userChoice, String compChoice, String finalResult){
        System.out.println("You chose: " + userChoice);
        System.out.println("The computer chose: " + compChoice);
        System.out.println(finalResult);
    }

        
    
    }

    


    
