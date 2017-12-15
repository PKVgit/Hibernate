package items;

public class Groups {

    private int id;
    private String name;
    private int cityId;

    public Groups() { }
    public Groups(int id, String name, int cityId) {
        this.id = id;
        this.name = name;
        this.cityId = cityId;
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
    public int getCityId() {
        return cityId;
    }
    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public boolean equals(Groups gr) {
        boolean bool;
        if(gr.getId() == this.getId() && gr.getName().equals(this.getName()) &&
                 gr.getCityId() == this.getCityId() ) {
            bool = true;
        }
        else {
            bool = false;
        }
        return bool;
    }

    @Override
    public String toString() {
        return String.format("|Id: %d|Name: %s|", id, name);
    }
}
