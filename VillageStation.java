import java.util.Random;

public class VillageStation extends Station
{
    Random random = new Random();

    public VillageStation(String name, int x, int y)
    {
        super(name, x, y);
    }

    @Override
    public void generate_passengers(StationGraph graph)
    {
        int number_of_passengers = random.nextInt((1000));
        
        for (int i = 0; i < number_of_passengers; i++)
        {
            this.passengers.add(new Passenger(graph.stations.get(this)));
        }
    }
}
