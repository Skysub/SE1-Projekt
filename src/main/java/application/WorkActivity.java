package application;

import java.util.ArrayList;

public class WorkActivity extends Activity{


    //Constructors ---------------------------------------------------------
    public WorkActivity(String name) {
        super(name);
    }

    public WorkActivity(String name, int startWeek){
        super(name,startWeek);
    }

    public WorkActivity(String name, Integer startWeek, Integer endWeek) {
        super(name, startWeek,  endWeek);
    }
    // ---------------------------------------------------------------------    
}
