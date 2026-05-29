
import java.util.Scanner;

public class sixth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the month (1-12): ");
        int month = scanner.nextInt();

        System.out.print("Enter the year: ");
        int year = scanner.nextInt();
        if (month < 1 || month > 12 || year < 0) 
        {
            System.out.println("Invalid input. Please enter a valid month (1-12) and year.");
        } 
        else 
        {
            int days = getDaysInMonth(month, year);
            if (days == -1) 
            {
                System.out.println("Invalid month. Please enter a valid month (1-12).");
            } 
            else 
            {
                System.out.println(getMonthName(month) + " " + year + " had " + days + " days.");
            }
        }

    }

    private static int getDaysInMonth(int month, int year)
    {
        switch (month) 
        {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                return -1;
        }
    }

    private static boolean isLeapYear(int year) 
    {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    private static String getMonthName(int month) 
    {
        String[] monthNames = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        return monthNames[month - 1];
    }
}