package application;

import java.io.Serializable;

public abstract class Activity implements Serializable {
	private static final long serialVersionUID = 6969694201337L;
	private static String name;
    int startWeek, endWeek;

    public Activity(String name){
        this.name = name;
    }

    public Activity(String name, int startWeek){
        this.name = name;
        this.startWeek = startWeek;
    }

    public Activity(String name, int startWeek, int endWeek){
        this.name = name;
        this.startWeek = startWeek;
        this.endWeek = endWeek;
    }

    public Object getName() {
        return name;
    }


}

