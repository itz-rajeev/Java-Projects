import java.util.Scanner;
import java.net.*;
class findhost{
    public static void main(String[] args) {
        char choice;
        String str="";
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("Select Your Choice");
            System.out.println("I -> Find IP Address of Given Host Name.");
            System.out.println("A -> Find All IP Address for a Given Host Name.");
            System.out.println("L -> Find the Local Host");
            System.out.println("E -> Exit");
            System.out.println("Your Choice: ");
            try{
                switch(choice=sc.next().charAt(0)){
                    case 'I':
                    case 'i': System.out.println("Enter Host Name :  ");
                    str=sc.next();
                    try{
                        InetAddress addr=InetAddress.getByName(str);
                        System.out.println("IP Address of the site is:"+addr);
                    }
                    catch(Exception e){
                        System.out.println("There is an expection : "+e.getMessage());
                    }
                    break;
                    case 'A':
                    case 'a': System.out.println("Enter host name :");
                    str=sc.next();
                    try{
                        InetAddress[] addrs=InetAddress.getAllByName(str);
                        System.out.println("IP Addresses of the site are:");
                        for(int i=0;i<addrs.length;i++){
                            System.out.println(addrs[i]);
                        }}
                        catch(Exception e){
                            System.out.println("There is an expection : "+e.getMessage());   
                    }
                    break;
                    case 'l':
                    case 'L':try{
                    InetAddress name=InetAddress.getLocalHost();
                    System.out.println("Local host:"+name.toString());}
                    catch(Exception e){
                        System.out.println("There is an expection : "+e.getMessage());   
                }
                break;
                case 'e':
                case 'E':System.exit(0);
                default:System.out.println("Invalid Choice.");
                }
            }
            catch(Exception e){
                System.out.println("I/O error");
            }
        }
    }
}