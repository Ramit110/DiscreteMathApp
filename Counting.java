
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

    /**
     *
     * Generate the next largest permutation in lexographic order
     */
    public static int[] generateNextPerm(int perm[]){
        int length = perm.length;

        // Get the largest segment with perm[j] < perm[j+1]
        int j = length-2;
        while (perm[j] > perm[j+1] && j>=0)
            j--;

        // Find the smallest integer greater than perm[j] to the right of perm[j]
        int k = length-1;
        while (perm[j] > perm[k])
            k--;

        // Swap perm[j] and perm[k]
        int temp = perm[j];
        perm[j] = perm[k];
        perm[k] = temp;

        // Arrange the terms after position j in increasing order using bubble sort
        for (int n=j+1; n<length; n++)
            for (int m=j+1; m<length-n+j; m++)
                if (perm[m] > perm[m+1]){
                    temp = perm[m];
                    perm[m] = perm[m+1];
                    perm[m+1] = temp;
                }    
        return perm;
    }    
    
    /**
    * A method that obtains the number of r-combinations of a set with n elements 
    * based on whether repititions are allowed or not
    **/
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
