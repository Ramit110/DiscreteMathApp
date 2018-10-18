
/**
 * A class containing methods for various counting functions such as permutations, combinations, etc.
 *
 * @author Ravi Ghaghada ravighaghada28@gmail.com
 * 14/10/2018
 */
public class Counting
{
    /* 
    A method that detects whether a given number is negative or not
     */
    private static boolean isNegative(int x, String methodname)
    {
        try{
            if (x<0)
            {
                throw new IllegalArgumentException("Error: Non-negative integer used in method " + methodname);
            }
            return false;
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e);
            return true;
        }

    }

    /*
    A method that returns the factorial of a number x
     */
    public static int factorial(int x)
    {
        if (isNegative(x, "factorial"))
        {
            System.exit(-1);
            return -1;
        }
        else if (x==1 || x==0)
            return x;

        else
            return x*factorial(x-1);
    }

    /*
    A method that obtains the number of r-permutations of a set with n elements 
    based on whether repititions are allowed or not
     */
    public static int permute(int n, int r, boolean repititionsAllowed)
    {
        if (!isNegative(n, "permute") && !isNegative(r, "permute"))
            if (n>=r && !repititionsAllowed)
                return factorial(n)/factorial(n-r);
            else if (n>r && repititionsAllowed)
                return (int)Math.pow(n,r);
            else 
            {
                System.out.println("Error: n must not be than r");        
                return -2;
            }

        else
            return -1;
    }
    
    /*
    A method that obtains the number of r-combinations of a set with n elements 
    based on whether repititions are allowed or not
     */
    public static int combination(int n, int r, boolean repititionsAllowed)
    {
        if (!isNegative(n, "combination") && !isNegative(r, "combination"))
            if (n>=r && !repititionsAllowed)
                return factorial(n)/(factorial(r)*factorial(n-r));
            else if (n>r && repititionsAllowed)
                return factorial(n+r-1)/(factorial(r)*factorial(n-1));
            else
            {
                System.out.println("Error: n must not be less than r");
                return -2;
            }
        else
            return -1;
    }
    
}
