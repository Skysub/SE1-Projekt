package application;

public class WorkActivity extends Activity{

    public WorkActivity(String name) {
        super(name);
    }

    public WorkActivity(String name, int startWeek){
        super(name,startWeek);
    }

    public Object getStartWeek() {
        return this.startWeek;
    }
    
}
