import java.io.IOException;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
	{
        Company company = new Company();
        
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the max simulation time [days]: ");
        int max_day = scanner.nextInt();
        
        System.out.print("Enter the revenue modifier: ");
        double revenue_mod = scanner.nextDouble();

        System.out.print("Enter the cost modifier: ");
        double cost_mod = scanner.nextDouble();
        

        company.simulation(max_day, revenue_mod, cost_mod);
    }
}