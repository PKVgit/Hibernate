package items;

public class Humans {

    private int id;
    private String name;
    private int age;
    private int groupId;

    public Humans() {}
    public Humans(int id, String name, int age, int clipId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.groupId = clipId;
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
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getGroupId() {
        return groupId;
    }
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public boolean equals(Humans humans) {
        boolean bool;
        if(humans.getId() == this.getId() && humans.getName().equals(this.getName()) && humans.getAge() == this.getAge()
                && humans.getGroupId() == this.getGroupId()) {
            bool = true;
        }
        else {
            bool = false;
        }
        return bool;
    }

    @Override
    public String toString() {
        return String.format("|Id: %d|Name: %d|Age: %s|GroupId: %d|", id, name, age, groupId);
    }
}
