import java.util.ArrayList;

public abstract class Train
{
    protected int capacity;
    protected int speed;
    protected double cost; //cost per km
    protected double revenue; //revenue per passenger per km
    protected Station start_station;
    protected Station finish_station;
    protected final double ROUTE_DISTANCE;
    protected final int NUMBER_OF_TRANSITS;
    
    public Train(Station start_station, Station finish_station)
    {
        this.start_station = start_station;
        this.finish_station = finish_station;
        this.ROUTE_DISTANCE = Math.sqrt((finish_station.location[0] - start_station.location[0]) * (finish_station.location[0] - start_station.location[0]) + (finish_station.location[1] - start_station.location[1]) * (finish_station.location[1] - start_station.location[1]));
        this.NUMBER_OF_TRANSITS = (int)(this.ROUTE_DISTANCE / this.speed);
    }
    
    public double transit(double cost_mod, double revenue_mod)
    {
        int transit_passengers = 0;
        
        for (Passenger passenger : new ArrayList<>(start_station.passengers))
        {
            if (passenger.get_destination() == this.finish_station)
            {
                transit_passengers++;
                start_station.passengers.remove(passenger);
                
                if (transit_passengers == this.capacity)
                    break;
            }
        }
        
        if (this.NUMBER_OF_TRANSITS % 2 != 0)
        {
            Station temp = this.start_station;
            this.start_station = this.finish_station;
            this.finish_station = temp;
        }
        
        return ((transit_passengers * this.revenue * revenue_mod - this.cost * cost_mod) * this.ROUTE_DISTANCE) * this.NUMBER_OF_TRANSITS;
    }
}
