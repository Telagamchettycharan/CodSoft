import java.util.Scanner;

public class Number_Game {
	
	static int getRandomNumber(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
		}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int max_chances=10;
		int total_score=0;
		System.out.println("Welcome to Number Game");
		System.out.println("You have "+max_chances+" chances to guess the Number between 1 to 100");
		
		boolean play_again=true;
		
		while(play_again) {
			int chances=max_chances;
			int rand=getRandomNumber(1,100);
			boolean correct=false;
			
			System.out.print("Guess the Number: ");
			
			for(int i=0;i<max_chances;i++) {
				int guess=sc.nextInt();
				if(guess==rand) {
					System.out.println("Hurray..! You Won the Game");
					correct=true;
					total_score++;
					break;
				}
				else if(guess>rand) {
					System.out.println("Too High - Try a Smaller Number");
				}
				else {
					System.out.println("Too Low - Try a larger Number");
				}
				chances--;
				System.out.println(chances+" attempts left");
			}
			
			if(!correct) 
				System.out.println("You Lost!..The number is: "+rand);
			
			System.out.println("Do you want to play again(y/n)");
			String ch=sc.next();
			play_again=ch.equalsIgnoreCase("y");
		}
		
		System.out.println("Your Total Score is: "+total_score);
		sc.close();
	}
}

/*  TASK 1

1. Generate a random number within a specified range, such as 1 to 100.

2. Prompt the user to enter their guess for the generated number.

3. Compare the user's guess with the generated number and provide feedback on whether the guess
is correct, too high, or too low.

4. Repeat steps 2 and 3 until the user guesses the correct number.

You can incorporate additional details as follows:

5. Limit the number of attempts the user has to guess the number.
6. Add the option for multiple rounds, allowing the user to play again.
7. Display the user's score, which can be based on the number of attempts taken or rounds won. */
