/**
 * RegionalTrain inherits from Train.
 * This class is responsible for managing RegionalTrain object.
 */
public class RegionalTrain extends Train
{
	/**
	 * Constructs RegionalTrain object
	 * @param start_station starting station
	 * @param end_station finish station
	 */
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
