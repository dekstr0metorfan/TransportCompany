import java.util.ArrayList;
import java.util.List;

public class Train
{
    int capacity;
    int speed;
    double cost; //cost per km
    double revenue; //revenue per passenger per km
    Station start_station;
    Station finish_station;
    double route_distance;
    int number_of_transits;
    
    public Train(Station start_station, Station finish_station)
    {
        this.capacity = 100;
        this.speed = 100;
        this.cost = 10;
        this.revenue = 10;
        this.start_station = start_station;
        this.finish_station = finish_station;
        this.route_distance = Math.sqrt((finish_station.location[0] - start_station.location[0]) * (finish_station.location[0] - start_station.location[0]) + (finish_station.location[1] - start_station.location[1]) * (finish_station.location[1] - start_station.location[1]));
        this.number_of_transits = (int)(this.route_distance / this.speed);
    }
    
    public double transit()
    {
        int transit_passengers = 0;
        
        for (Passenger passenger : new ArrayList<Passenger>(start_station.passengers))
        {
            if (passenger.destination == this.finish_station)
            {
                transit_passengers++;
                start_station.passengers.remove(passenger);
                
                if (transit_passengers == this.capacity)
                    break;
            }
        }
        
        if (this.number_of_transits % 2 != 0)
        {
            Station temp = this.start_station;
            this.start_station = this.finish_station;
            this.finish_station = temp;
        }
        
        return ((this.revenue * transit_passengers - this.cost) * this.route_distance) * this.number_of_transits;
    }
}
