public class Train
{
    String ID; //name of train
    int cost; //cost per km
    int capacity; //train capacity
    public Train(String ID, int cost, int capacity)
    {
        this.ID = ID;
        this.cost = cost;
        this.capacity = capacity;
    }

    public static double transit(Train train, Station start_station, Station finish_station, int revenue)
    {
        if(train.capacity > start_station.passengers)
        {
            train.capacity = start_station.passengers;
        }
        int distance_travelled = Math.abs(finish_station.distance - start_station.distance);
        return revenue * distance_travelled - train.cost * distance_travelled;
    }
}
