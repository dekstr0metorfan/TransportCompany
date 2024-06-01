import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        double budget = 0;
        Scanner scanner = new Scanner(System.in);

        ArrayList<Train> trains = new ArrayList<>();
        ArrayList<Station> stations = new ArrayList<>();

        CityStation A = new CityStation("A",0, 0);
        VillageStation B = new VillageStation("B", 200, 200);

        stations.add(A);
        stations.add(B);

        System.out.print("Enter the max. simulation time [days]: ");
        int max_day = scanner.nextInt();

        System.out.print("Enter the ticket price: ");
        double revenue = scanner.nextInt();

        System.out.print("Enter the cost of one transit: ");
        double cost = scanner.nextInt();

        Train train1 = new Train(A, B, cost, revenue);
        trains.add(train1);

        for(int day = 1; day <= max_day; day++)
        {
            System.out.println("Simulation day: " + day);

            for(Station station : stations){
                station.generate_passengers();
                System.out.println("Passengers on station " + station.name + ": " + station.passengers);
            }

            for(Train train : trains){
                budget += train.run_balance();
            }
            System.out.println("Budget at the end of day: " + budget + "\n");
        }

        System.out.println("Total company profit: " + budget);
    }
}