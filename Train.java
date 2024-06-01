public class Train
{
    private static int amount = 0; //total amount of trains
    int capacity = 100; // zakladajac ze jest stale

    Station start_station;
    Station finish_station;
    String ID; //id of train
    double cost; //cost per km
    double revenue; //revenue per passenger per km
    private final double speed = 5; // predkosc, jeszcze nie wiem co z tym, ile razy w ciagu dnia jedzie czy cos

    public Train(Station start_station, Station finish_station, double cost, double revenue)
    {
        amount++;
        this.start_station = start_station;
        this.finish_station = finish_station;
        this.ID = String.valueOf(amount);
        this.cost = cost;
        this.revenue = revenue;
    }

    public double run_balance()
    {
        int transit_passengers;

        if(start_station.passengers >= capacity)
        {
            transit_passengers = capacity;
        } else {
            transit_passengers = start_station.passengers;
        }

        start_station.passengers -= transit_passengers;

        double distance_travelled = Math.sqrt((finish_station.location[0] - start_station.location[0]) * (finish_station.location[0] - start_station.location[0]) + (finish_station.location[1] - start_station.location[1]) * (finish_station.location[1] - start_station.location[1]));
        return ((revenue * transit_passengers - cost) * distance_travelled) * speed;
    }
}
