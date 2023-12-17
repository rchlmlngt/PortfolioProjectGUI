package cpsc219project.core.portfolioClasses;

public abstract class Asset {
    private String name;
    protected double value;

    public Asset(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return  name + "\t" + value;
    }
}
