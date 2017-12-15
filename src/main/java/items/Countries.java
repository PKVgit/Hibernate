package items;

public class Countries {

    private int id;
    private String name;
    private int continentId;

    public Countries() {}
    public Countries(int id, String name,  int continentId) {
        this.id = id;
        this.name = name;
        this.continentId = continentId;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getContinentId() {
        return continentId;
    }
    public void setContinentId(int continentId) {
        this.continentId = continentId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Countries country) {
        boolean bool;
        if(country.getId() == this.getId() && country.getName().equals(this.getName())
                 & country.getContinentId() == this.getContinentId()) {
            bool = true;
        }
        else {
            bool = false;
        }
        return bool;
    }

    @Override
    public String toString() {
        return String.format("|Id: %d|Name: %s", id, name);
    }
}
