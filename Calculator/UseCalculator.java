package Calculator;

import java.util.Scanner;
class UseCalculator {
    public static void main(String[] args)
{
Scanner sa=new Scanner(System.in);
// Gets User Input
System.out.println("Select the Calculator: Basic - B or Scientific - S.");
System.out.flush();
String option=sa.nextLine();
if(option.length()==1)
{
if (option.equals("B") || option.equals("b"))
{
// Calls the Basic Calculator Application
Calculator c=new Calculator();
c.Calc();
}
else if(option.equals("S") || option.equals("s"))
{
// Calls the Scientific Calculator Application
ScientificCalculator sc=new ScientificCalculator();
sc.Calc();
}
else
{
System.out.println("***Please enter option 'B' or 'S'.***");
}
}
else
{
System.out.println("***Please enter option 'B' or 'S'.***");
}
sa.close();
}

}


    

