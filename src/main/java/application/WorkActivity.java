package application;

public class WorkActivity extends Activity{

    public WorkActivity(String name) {
        super(name);
    }

    public WorkActivity(String name, int startWeek){
        super(name,startWeek);
    }

    public WorkActivity(String name, Integer startWeek, Integer endWeek) {
        super(name, startWeek,  endWeek);
    }

    public Object getStartWeek() {
        return this.startWeek;
    }

    public Object getEndWeek() {
        return this.endWeek;
    }
    
}
