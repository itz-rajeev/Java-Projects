import java.util.Scanner;
public class TwentyOneSticks {
    public static void main(String[] args) {
        int no_of_sticks=21;
        System.out.print("Do You Want TO Play First ? (Y/y):");//User can either choose to play first or second.
        Scanner sc=new Scanner(System.in);
        String first_attempt=sc.nextLine();
        int input_no=0;
        while(no_of_sticks>0){
            if(first_attempt=="y"|| first_attempt=="Y"){
                System.out.println("Currently "+no_of_sticks+" Sticks are available");
                System.out.println("Pick your Stick.(1 or 2)");
                input_no=sc.nextInt();
                if(input_no >= 2){
                    input_no=2;
                }
                else if(input_no<=1){
                    input_no=1;
                }
                no_of_sticks=no_of_sticks-input_no;
                if(no_of_sticks<=0){
                    System.out.println("You have lost the Game!!!");
                }
                else{
                    if((no_of_sticks-2)%3==0 || (no_of_sticks-2)==0){
                        input_no=1;
                    }
                    else{
                        input_no=2;
                    }
                    System.out.println("You Opponent picks "+input_no+" sticks");
                    no_of_sticks=no_of_sticks-input_no;
                    if(no_of_sticks<=0){
                        System.out.println("You have won the game!!!!");
                    }
                }
                
                
            }
            else{
                if((no_of_sticks-2)%3==0 || (no_of_sticks-2)==0){
                    input_no=1;
                }
                else{
                    input_no=2;
                }
                System.out.println("You Opponent picks "+input_no+" sticks");
                no_of_sticks=no_of_sticks-input_no;
                if(no_of_sticks<=0){
                    System.out.println("You have won the game!!!!");
                }
                else{
                System.out.println("Currently "+no_of_sticks+" are available");
                System.out.println("Pick your Stick.(1 or 2)");
                input_no=sc.nextInt();
                if(input_no>=2){
                    input_no=2;
                }
                else if(input_no<=1){
                    input_no=1;
                }
                no_of_sticks=no_of_sticks-input_no;
                if(no_of_sticks<=0){
                    System.out.println("You hav lost the game!!!");
                }
            }
        }
        }

    }
}
