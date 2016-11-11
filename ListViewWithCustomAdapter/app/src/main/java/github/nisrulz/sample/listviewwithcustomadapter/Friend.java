package github.nisrulz.sample.listviewwithcustomadapter;

public class Friend {
    private String name;
    private int iconID;

    public Friend() {
    }

    public Friend(String name, int iconID) {
        this.name = name;
        this.iconID = iconID;
    }

    public String getName() {
        return name;
    }

    public int getIconID() {
        return iconID;
    }
}
