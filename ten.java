import java.util.Scanner;
public class ten
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows for Pascal's Triangle: ");
        int r = scanner.nextInt();
        PascalsTriangle(r);
    }
    private static void PascalsTriangle(int r)
     {
        for (int i = 0; i < r; i++) 
        {
            for (int j = 0; j < r - i - 1; j++) {
                System.out.print(" ");
            }
            int value = 1;
            for (int j = 0; j <= i; j++) 
            {
                System.out.print(value + " ");
                value = value * (i - j) / (j + 1);
            } 
            System.out.println();
        }
    }
}