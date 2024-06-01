public abstract class Station
{
    String name;
    int[] location = new int[2]; //location of the station on a grid in km
    int passengers; //number of passengers on the station

    public void resetPassengers(){
        passengers = 0;
    }

    public Station(String name, int x, int y)
    {
        this.name = name;
        this.location[0] = x;
        this.location[1] = y;
        this.passengers = 0;
    }

    public abstract void generate_passengers();
}