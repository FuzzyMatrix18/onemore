import java.util.Date;

public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time() 
    {
        this(System.currentTimeMillis());
    }

    public Time(long elapsedTime) 
    {
        setTime(elapsedTime);
    }

    public Time(int hour, int minute, int second) 
    {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() 
    {
        return hour;
    }

    public int getMinute() 
    {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public void setTime(long elapsedTime) {
        // Convert elapsed time to seconds
        long totalSeconds = elapsedTime / 1000;

        // Compute the current second
        this.second = (int) (totalSeconds % 60);

        // Obtain the total minutes
        long totalMinutes = totalSeconds / 60;

        // Compute the current minute
        this.minute = (int) (totalMinutes % 60);

        // Obtain the total hours
        long totalHours = totalMinutes / 60;

        // Compute the current hour
        this.hour = (int) (totalHours % 24);
    }

    public static void main(String[] args) {
        // Create two Time objects
        Time currentTime = new Time();
        Time specificTime = new Time(555550000);

        // Display the current time
        System.out.println("Current Time:");
        System.out.printf("%02d:%02d:%02d%n", currentTime.getHour(), currentTime.getMinute(), currentTime.getSecond());

        // Display the specific time
        System.out.println("\nSpecific Time (555550000 milliseconds since Jan 1, 1970):");
        System.out.printf("%02d:%02d:%02d%n", specificTime.getHour(), specificTime.getMinute(), specificTime.getSecond());
    }
}
