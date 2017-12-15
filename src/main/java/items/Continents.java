package items;

public class Continents {

    private int id;
    private String name;
    private int teritory;


    public Continents() { }
    public Continents(int id, String name, int teritory) {
        this.id = id;
        this.name = name;
        this.teritory = teritory;
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
    public int getTeritory() {
        return teritory;
    }
    public void setTeritory(int teritory) {

        this.teritory = teritory;
    }


    public boolean equals(Continents continents) {
        boolean bool;
        if(continents.getId() == this.getId() && continents.getName().equals(this.getName()) && continents.getTeritory() == this.getTeritory()
                ) {
            bool = true;
        }
        else {
            bool = false;
        }
        return bool;
    }

    @Override
    public String toString() {
        return String.format("|id: %d|Name: %s|Teritory:  %s", id, name, teritory);
    }
}
