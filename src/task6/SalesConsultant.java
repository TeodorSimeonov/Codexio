package task6;

public class SalesConsultant extends Worker {
    private double earnedMoney;

    public SalesConsultant() {
        this.workingShop.addWorker(this);
    }

    //We can also make a class Product with price field
    public void sellProduct(double price) {
        if (price > 0) {
            this.earnedMoney += price;
        }
    }

    @Override
    public double getMoneyAvailable() {
        if (this.earnedMoney < 0) {
            return 0;
        }
        return this.earnedMoney;
    }
}
