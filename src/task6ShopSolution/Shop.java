package task6ShopSolution;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private static Shop instance;
    // Workers can also be put in set, if we don't want same worker to be added.
    // Equals method must be overridden, because we are using our classes.
    private List<Worker> workers;

    private Shop() {
        this.workers = new ArrayList<>();
    }

    public static Shop getInstance() {
        if (instance == null) {
            instance = new Shop();
        }
        return instance;
    }

    public void addWorker(Worker worker) {
        this.workers.add(worker);
    }

    public double getTurnover() {
        double turnOver = 0.0;
        for (Worker worker : this.workers) {
            turnOver += worker.getMoneyAvailable();
        }
        return turnOver;
    }
}
