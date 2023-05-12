import com.sci.dao.DBJobs;
import com.sci.models.Jobs;

import java.util.ArrayList;
import java.util.List;

public class TestJobs {
    public static void main(String[] args) {
        DBJobs j = new DBJobs();
        List <Jobs>l = j.get("President");

        for (Jobs k : l){
            System.out.println(k);

        }

        j.updateJobs("President" , 50000);
    }
}
