package task6;

public abstract class Worker {
    public Shop workingShop = Shop.getInstance();

    public abstract double getMoneyAvailable();
}
