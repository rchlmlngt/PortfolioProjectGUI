package cpsc219project.core.portfolioClasses;

import cpsc219project.core.portfolioClasses.Asset;

public class Stock extends Asset {

    /**
     *
     */
    private String symbol;
    private int shares;

    public Stock(String name, double value, String symbol, int shares ) {
        super(name, value);
        this.symbol = symbol;
        this.shares = shares;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getShares() {
        return shares;
    }
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    /**
     * Calculates the Book Value of a stock.
     * @return
     */
    public double stockBV(){
        return getValue() * shares;
    }

    /**
     * Calculates the market value of a stock
     * @param marketValue
     * @return
     */
    public double stockMV(double marketValue){
        return  marketValue * shares;
    }

    public double percentageChange(double marketPrice ){
        double gains = ((marketPrice - getValue())/getValue())*100;
        return gains;
    }


    @Override
    public String toString() {
        return super.toString() + "\t" + symbol + "\t" + shares;
    }

}
