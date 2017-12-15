package items;

public class Cities {

    public int id;
    private String name;
    private int years;
    private int countryId;

    public Cities() { }
    public Cities(int id, String name, int years, int countryId) {
        this.id = id;
        this.name = name;
        this.years = years;
        this.countryId=countryId;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getYears() {
        return years;
    }
    public void setYears(int years) {
        this.years = years;
    }
    public int getcountryId() {
        return countryId;
    }
    public void setcountryId(int id) {
        this.countryId = countryId;
    }

    public boolean equals(Cities city) {
        boolean bool;
        if(city.getId() == this.getId() && city.getName().equals(this.getName()) && city.getYears()==this.getYears() && city.countryId == this.countryId) {
            bool = true;
        }
        else {
            bool = false;
        }
        return bool;
    }

    @Override
    public String toString() {
        return String.format("|Id: %d|Name: %s|Years %s", id, name,years);
    }
}
