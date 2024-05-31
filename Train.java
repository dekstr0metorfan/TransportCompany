public class Train
{
    static int amount = 0; //total amount of trains
    
    String ID; //name of train
    double cost; //cost per km
    double revenue; //revenue per passenger per km
    int capacity; //train capacity
    Station start_station, finish_station; //route stations
    double route_distance; //distance from start station to finish station in km
    
    public Train(Station start_station, Station finish_station)
    {
        amount++;
        this.ID = String.valueOf(amount);
        this.cost = 2;
        this.revenue = 2;
        this.capacity = 100;
        this.start_station = start_station;
        this.finish_station = finish_station;
        this.route_distance = Math.sqrt((finish_station.location[0] - start_station.location[0]) * (finish_station.location[0] - start_station.location[0]) + (finish_station.location[1] - start_station.location[1]) * (finish_station.location[1] - start_station.location[1]));
    }

    public double transit()
    {
        int transit_passengers = Math.min(this.start_station.passengers, this.capacity);
		
		this.start_station.passengers -= transit_passengers;
        
        return (this.revenue * transit_passengers - this.cost) * this.route_distance;
    }
}
