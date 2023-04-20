package task6;

public class MarketingSpecialist extends Worker {
    private double budget;

    public MarketingSpecialist(double budget) {
        this.budget = budget;
        this.workingShop.addWorker(this);
    }

    // Campaign can also be a new class with cost field
    public void spendMoney(double marketingCampaignCost) {
        if (marketingCampaignCost > 0) {
            this.budget -= marketingCampaignCost;
        }
    }

    @Override
    public double getMoneyAvailable() {
        if (budget < 0) {
            return 0;
        }
        return this.budget;
    }
}
