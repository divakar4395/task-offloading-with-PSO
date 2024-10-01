Dataset:

Let's consider a simple scenario with 5 mobile devices, 3 edge servers, and 10 tasks. The dataset can be represented as follows:

Mobile devices:
Device 1: 10 tasks, 1000 MHz CPU, 1000 MB RAM
Device 2: 8 tasks, 800 MHz CPU, 800 MB RAM
Device 3: 12 tasks, 1200 MHz CPU, 1200 MB RAM
Device 4: 9 tasks, 900 MHz CPU, 900 MB RAM
Device 5: 11 tasks, 1100 MHz CPU, 1100 MB RAM
Edge servers:
Server 1: 2000 MHz CPU, 2000 MB RAM
Server 2: 2500 MHz CPU, 2500 MB RAM
Server 3: 3000 MHz CPU, 3000 MB RAM
Tasks:
Task 1: 100 MHz CPU, 100 MB RAM
Task 2: 200 MHz CPU, 200 MB RAM
Task 3: 300 MHz CPU, 300 MB RAM
Task 4: 400 MHz CPU, 400 MB RAM
Task 5: 500 MHz CPU, 500 MB RAM
Task 6: 600 MHz CPU, 600 MB RAM
Task 7: 700 MHz CPU, 700 MB RAM
Task 8: 800 MHz CPU, 800 MB RAM
Task 9: 900 MHz CPU, 900 MB RAM
Task 10: 1000 MHz CPU, 1000 MB RAM
This code defines the Particle class, which represents a particle in the PSO algorithm. Each particle has a position, velocity, and fitness value. The evaluate method calculates the fitness of the particle based on the task assignment cost. The updateVelocity method updates the velocity of the particle based on the best particle's position. The updatePosition method updates the position of the particle based on its velocity. The getPosition and getFitness methods return the position and fitness of the particle, respectively.

Note that this is a simplified implementation of the PSO algorithm, and you may need to modify it to suit your specific use case. Additionally, you may want to consider using a more robust optimization algorithm, such as the genetic algorithm or simulated annealing, depending on the complexity of your problem.
