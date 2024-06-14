public class RegionalTrain extends Train
{
	public RegionalTrain(Station start_station, Station end_station)
	{
		super(start_station, end_station);
		this.capacity = 300;
		this.speed = 80;
		this.cost = 47;
		this.revenue = 0.095;
		this.number_of_transits = (int) (24 / (this.ROUTE_DISTANCE / this.speed));
	}
}
