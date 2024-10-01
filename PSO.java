import java.util.*;

public class PSO {
    // Define the number of particles, iterations, and dimensions
    public static final int NUM_PARTICLES = 50;
    public static final int NUM_ITERATIONS = 100;
    public static final int NUM_DIMENSIONS = 10; // 10 tasks

    // Define the mobile devices and edge servers
    public static final int NUM_DEVICES = 5;
    public static final int NUM_SERVERS = 3;

    // Define the task requirements
    public static final double[][] TASK_REQUIREMENTS = {
        {100, 100}, // Task 1
        {200, 200}, // Task 2
        {300, 300}, // Task 3
        {400, 400}, // Task 4
        {500, 500}, // Task 5
        {600, 600}, // Task 6
        {700, 700}, // Task 7
        {800, 800}, // Task 8
        {900, 900}, // Task 9
        {1000, 1000} // Task 10
    };

    // Define the device and server capacities
    public static final double[][] DEVICE_CAPACITIES = {
        {1000, 1000}, // Device 1
        {800, 800}, // Device 2
        {1200, 1200}, // Device 3
        {900, 900}, // Device 4
        {1100, 1100} // Device 5
    };

    public static final double[][] SERVER_CAPACITIES = {
        {2000, 2000}, // Server 1
        {2500, 2500}, // Server 2
        {3000, 3000} // Server 3
    };

    public static void main(String[] args) {
        // Initialize the particles
        Particle[] particles = new Particle[NUM_PARTICLES];
        for (int i = 0; i < NUM_PARTICLES; i++) {
            particles[i] = new Particle(NUM_DIMENSIONS);
        }

        // Initialize the best particle
        Particle bestParticle = particles[0];

        // Run the PSO algorithm
        for (int iteration = 0; iteration < NUM_ITERATIONS; iteration++) {
            // Evaluate the particles
            for (int i = 0; i < NUM_PARTICLES; i++) {
                particles[i].evaluate();
            }

            // Update the best particle
            for (int i = 0; i < NUM_PARTICLES; i++) {
                if (particles[i].getFitness() < bestParticle.getFitness()) {
                    bestParticle = particles[i];
                }
            }

            // Update the particles
            for (int i = 0; i < NUM_PARTICLES; i++) {
                particles[i].updateVelocity(bestParticle);
                particles[i].updatePosition();
            }
        }

        // Print the best solution
        System.out.println("Best solution:");
        System.out.println("Task assignments:");
        HashMap<Double,Integer>map=new HashMap<>();
        ArrayList<Double>list=new  ArrayList<>();

        for (int i = 0; i < NUM_DIMENSIONS; i++) {
            map.put(bestParticle.getPosition()[i],i+1);
            list.add(bestParticle.getPosition()[i]);
        }
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            System.out.println("Task "+map.get(list.get(i))+ ": "+list.get(i));
        }
        System.out.println("Fitness: " + bestParticle.getFitness());
    }
}

class Particle {
    public double[] position;
    public double[] velocity;
    public double fitness;

    public Particle(int dimensions) {
        position = new double[dimensions];
        velocity = new double[dimensions];
        fitness = Double.MAX_VALUE;

        // Initialize the position and velocity randomly
        for (int i = 0; i < dimensions; i++) {
            position[i] = Math.random();
            velocity[i] = Math.random();
        }
    }

    public void evaluate() {
        // Calculate the fitness of the particle
        fitness = 0;
        for (int i = 0; i < PSO.NUM_DIMENSIONS; i++) {
            // Calculate the task assignment cost
            double taskAssignmentCost = 0;
            if (position[i] < 0.5) {
                // Assign the task to the device
                taskAssignmentCost = PSO.TASK_REQUIREMENTS[i][0] / PSO.DEVICE_CAPACITIES[(int) (Math.random() * PSO.NUM_DEVICES)][0];
            } else {
                // Assign the task to the server
                taskAssignmentCost = PSO.TASK_REQUIREMENTS[i][0] / PSO.SERVER_CAPACITIES[(int) (Math.random() * PSO.NUM_SERVERS)][0];
            }
            fitness += taskAssignmentCost;
        }
    }

    public void updateVelocity(Particle bestParticle) {
        // Update the velocity of the particle
        for (int i = 0; i < PSO.NUM_DIMENSIONS; i++) {
            velocity[i] = 0.5 * velocity[i] + 0.5 * (bestParticle.getPosition()[i] - position[i]);
        }
    }
    
    public void updatePosition() {
        // Update the position of the particle
        for (int i = 0; i < PSO.NUM_DIMENSIONS; i++) {
            position[i] += velocity[i];
        }
    }
    
    public double[] getPosition() {
        return position;
    }
    
    public double getFitness() {
        return fitness;
    }
    }