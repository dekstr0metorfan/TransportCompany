public class Train
{
    static int amount = 0; //total amount of trains
    
    String ID; //name of train
    double cost; //cost per km
    double revenue; //revenue per passenger per km
    int capacity; //train capacity
    
    public Train()
    {
        amount++;
        this.ID = String.valueOf(amount);
        this.cost = 2;
        this.revenue = 2;
        this.capacity = 100;
    }

    public double transit(Station start_station, Station finish_station)
    {
        int transit_passengers;
        
        if(start_station.passengers >= this.capacity)
        {
            transit_passengers = this.capacity;
        }
        
        else
        {
            transit_passengers = start_station.passengers;
        }
        
        start_station.passengers -= transit_passengers;
        
        double distance_travelled = Math.sqrt((finish_station.location[0] - start_station.location[0]) * (finish_station.location[0] - start_station.location[0]) + (finish_station.location[1] - start_station.location[1]) * (finish_station.location[1] - start_station.location[1]));
        
        return (this.revenue * transit_passengers - this.cost) * distance_travelled;
    }
}
