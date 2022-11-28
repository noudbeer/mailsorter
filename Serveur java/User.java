public class User {
    int id;
    String name;

    public User(String name) {
        this.setName(name);
    }

    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}