public class Topic {
    int id;
    String name;

    public Topic(String name) {
        this.setName(name);
    }

    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public boolean isExist(String name) {
        return false;
    }
}
