### Overview

**TransportCompany** is a Java-based agent simulation designed to simulate the behavior of a train
network. The program uses various randomising mechanisms to set the number of passengers on
each station. Stations were placed in a coordinate system, while the relationships between them
were defined by a graph structure.

There are two types of stations - **CityStation** and **VillageStation** (highlighted in blue and red
respectively in the picture below). The main difference between CityStations and VillageStations
is that CityStations have a higher minimum of passengers and generate more passengers.

Additionally, there are two types of trains - **ExpressTrain** and **RegionalTrain**. ExpressTrains travel
only between CityStations, while RegionalTrains can move between all stations.

The simulation iterates day by day and calculates the transportation company's budget at the end
of each day. The result of the simulation is a .csv file summarizing the final budget of each day for
which the simulation was performed.

![image](https://github.com/user-attachments/assets/a74d7e18-297c-4f19-b65f-a3bd0fe656c6)

### Objectives
The main objectives of this project are:
- Calculating the budget of the transport company with the given parameters.
- Accurately simulating a fragment of reality.
- Generating .csv files with the results of the simulation.

### User guide
After starting the program, the following window is shown:

![image](https://github.com/user-attachments/assets/734d26dc-2795-4575-a0bd-67d5863f12e0)

Enter the following values:
- Max simulation time [days] – maximum number of days for which the simulation will be
performed
- Revenue modifier – revenue multiplier (per passenger per kilometer of travel)
- Cost modifier – cost per kilometer of travel

Click „Run Simulation”. After that, the following window will appear:

![image](https://github.com/user-attachments/assets/16542371-4641-4d81-b645-44759ef7f746)

In order to stop the program, close the window. The simulation results will be available in a .csv
file in the folder where the program is located.

### Project documentation

Full project documentation is available [here](https://github.com/dekstr0metorfan/TransportCompany/blob/main/Project_documentation/project_documentation.pdf).
