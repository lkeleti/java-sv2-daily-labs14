package week14.day05.city;

public class Office extends Building {

    private String company;
    private int numberOfTablesPerLevel;

    public Office(int area, int levels, Address address, String company, int numberOfTablesPerLevel) {
        super(area, levels, address);
        if (area / numberOfTablesPerLevel > 5) {
            throw new IllegalArgumentException("Too few tables !");
        }

        if (area / numberOfTablesPerLevel < 2) {
            throw new IllegalArgumentException("Too much tables !");
        }

        this.company = company;
        this.numberOfTablesPerLevel = numberOfTablesPerLevel;
    }

    public String getCompany() {
        return company;
    }

    public int getNumberOfTablesPerLevel() {
        return numberOfTablesPerLevel;
    }

    @Override
    public int calculateNumberOfPeopleCanFit() {
        return numberOfTablesPerLevel * (getLevels() - 1);
    }
}
