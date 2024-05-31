import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        double budget = 0;
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Maximal simulation time [days]: ");
        
        int time_limit = scanner.nextInt();
        
        System.out.println("Ticket prices: ");
        
        int revenue_mod = scanner.nextInt();

        CityStation CityA = new CityStation(0, 0);
        CityStation CityB = new CityStation(200, 200);

        Train train1 = new Train();
        Train train2 = new Train();

        for(int day = 1; day <= time_limit; day++)
        {
            System.out.println("Simulation day: " + day);
            
            CityA.calculate_passengers(200, 600);
            budget += train1.transit(CityA, CityB);
            
            System.out.println("City A passengers: " + CityA.passengers);
            System.out.println("Budget at the end of day: " + budget);
        }

        System.out.println("Total company profit: " + budget);
    }
}