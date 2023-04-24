package application;

public abstract class Activity {
    private static String name;
    int startWeek, endWeek;

    public Activity(String name){
        this.name = name;
    }

    public Activity(String name, int startWeek){
        this.name = name;
        this.startWeek = startWeek;
    }

    public Object getName() {
        return name;
    }


}

