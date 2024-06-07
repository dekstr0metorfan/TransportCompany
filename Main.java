import java.util.*;
//klasa firmy???
public class Main
{
    public static void main(String[] args)
    {
        double budget = 0;
        
        
        StationGraph station_graph = new StationGraph();
        
        CityStation A = new CityStation("A",0, 0);
        VillageStation B = new VillageStation("B", 200, 200);
        
        station_graph.add_station(A);
        station_graph.add_station(B);
        station_graph.add_route(A, B);
        

        ArrayList<Train> trains = new ArrayList<>();
        trains.add(new Train(A, B));
        
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the max simulation time [days]: ");
        int max_day = scanner.nextInt();
        
        System.out.print("Enter the revenue modifier: ");
        double revenue_mod = scanner.nextDouble();

        System.out.print("Enter the cost modifier: ");
        double cost_mod = scanner.nextDouble();

        for (int day = 1; day <= max_day; day++)
        {
            System.out.println("Simulation day: " + day);

            for (Station station : station_graph.stations.keySet())
            {
                station.generate_passengers(station_graph); //caly graf czy lista???
            }

            for (Train train : trains)
            {
                budget += train.transit(cost_mod, revenue_mod);
            }
            
            System.out.println(A.passengers.size());
            System.out.println("Budget at the end of day: " + budget + "\n");
        }

        System.out.println("Total company profit: " + budget);
    }
}