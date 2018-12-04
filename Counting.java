
/**
 * A class containing methods for various counting functions such as permutations, combinations, etc.
 *
 * @author Ravi Ghaghada ravighaghada28@gmail.com
 * @author Ramit110
 * @version 4/12/2018
 */
public class Counting
{
    /* 
        A method that detects whether a given number is negative or not.
        Returns false if the number is null.
    */
    private static boolean isNegative(int x)
    {
        if(x == null)
        {
            return false;
        }
        return (x < 0);
    }

    /*
        A method that returns the factorial of a number x.
        Will crash if x is greater than the stack size limit of Java.
    */
    public static int factorial(int x)
    {
        if (isNegative(x))
            return -1;
        else if (x==1 || x==0)
            return x;
        else
            return x*factorial(x-1);
    }
    
    /*
        A method that obtains the number of r-permutations of a set with n elements 
        based on whether repititions are allowed or not.
    */
    public static int permute(int n, int r, boolean repititionsAllowed)
    {
        if (!isNegative(n) && !isNegative(r))
            if (n>r && !repititionsAllowed)
                return factorial(n)/factorial(n-r);
            else if (n>r && repititionsAllowed)
                return (int)Math.pow(n,r);
        else 
            {
                System.out.println("Error: n is not greater than r");        
                return -2;
            }
    
        else
            return -1;
    }
}
