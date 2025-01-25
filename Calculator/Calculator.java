package Calculator;
import java.io.*;
import java.util.Scanner;

class Calculator {
    public void Calc() {
        boolean next;
        int iFirstNumber;
        int iSecondNumber;
        Scanner sc=new Scanner(System.in);
        do{ 
            System.out.println("Please Enter First Number: ");
            
                iFirstNumber=sc.nextInt();
            
           
            System.out.println("Please enter the Operation (Add : +, Minus : -, Product : *, Divide : /):");
            char option=sc.next().charAt(0);
            System.out.println("Please Enter Second Number: ");
            
                iSecondNumber=sc.nextInt();

            if (option == '+' || option == '-' || option == '*' || option == '/'){
                // Creates Calculate Class Instance
                Calculate c=new Calculate(iFirstNumber,iSecondNumber,option);
                // Calls the class methods
                c.doCalculation();
                c.getResult();
            }
            else{
                System.out.println("***Operation Not Available. Please select any of the available options.***");
            }
            // Checks if the user would like to compute again
            System.out.println("Would you like to calculate again (y/n)?");
            System.out.flush();
            char aa=sc.next().charAt(0);
            if ((aa=='y') || (aa=='Y')){
                next=true;}
            else{
                next=false;
            }   
        }while(next);
        sc.close();
    }
    

}
