package application;

public abstract class Activity {
    private static String name;
    int startWeek, endWeek;

    public Activity(String name){
        this.name = name;
    }

    public Object getName() {
        return name;
    }


}

