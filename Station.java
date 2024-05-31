import java.util.*;

public abstract class Station
{
    int[] location = new int[2]; //location of the station on a grid in km
    int passengers; //number of passengers on the station
    
    public Station(int x, int y)
    {
        this.location[0] = x;
        this.location[1] = y;
        this.passengers = 0;
    }
    
    public abstract void calculate_passengers(int min, int max);
}