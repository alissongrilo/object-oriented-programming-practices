import java.util.Scanner;

public class Sqrt
{
    public static void main(String[] args)
    {
            Scanner input = new Scanner(System.in);
            double value = Double.parseDouble(input.nextLine());

            if (value >= 0)
            {
                System.out.println(Math.sqrt(value));
            }
            else
            {
                System.out.println("ERROR: There are no real roots for this number.");
            }
    }
}