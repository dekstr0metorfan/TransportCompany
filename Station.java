import java.util.*;
public class Station
{
    Random random = new Random();
    String name; //name of station
    int passengers; //station capacity
    int distance; //distance from starting point
    public Station(String name, int distance)
    {
        this.name = name;
        this.distance = distance;
    }
    public int calculate_passengers(int min, int max)
    {
        return random.nextInt((max-min)+1) + min;
    }
}
