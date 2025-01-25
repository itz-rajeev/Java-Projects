package Calculator;

import java.util.Scanner;
class ScientificCalculator  {
    String Operator;
    Double dblNumber;
    public void Calc() {
        boolean next;
        Scanner sa=new Scanner(System.in);
        do{
    
   System.out.println("Please enterthe Operation (Sine-s, Cosine-c, Tangent-t, Log-l):");
System.out.flush();
Operator=sa.next();
System.out.println("Please enter a Value: ");
System.out.flush();

    dblNumber=sa.nextDouble();



if(Operator.length()==1){
    // Creates calculate Class Instance
    Calculate sc=new Calculate(dblNumber,Operator.charAt(0));
    sc.doCalculation();
    sc.getResult();
}
else
{
System.out.println("***Operation Not Available. Please select any of the available options.***");
}
// Checks if the user would like to compute again
System.out.println("Would you like to calculate again (y/n)?");
System.out.flush();
char aa=sa.next().charAt(0) ;
if ((aa=='y') || (aa=='Y'))
{
next=true;
}
else
{
next=false;
}

}
while(next);

sa.close();
}


}

    

