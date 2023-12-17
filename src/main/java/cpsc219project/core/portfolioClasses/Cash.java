package cpsc219project.core.portfolioClasses;

import cpsc219project.core.portfolioClasses.Asset;

public class Cash extends Asset {

    /**
     * cpsc219project.core.portfolioClasses.Cash is used in transactions. For buying stocks and storing value
     * of sold stocks.
     */

    public Cash(String name, double value) {
        super(name, value);
    }
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void addCash(double money) {
        setValue(getValue() + money);
    }

    public void removeCash(double money) {
        setValue(getValue() - money);
    }

}
