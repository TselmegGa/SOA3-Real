import Domain.Backlog;
import Domain.Branch;
import Domain.Item;
import Domain.VersionControl;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

class VersionControlTest {
    @Test
    void versionControlTest(){
        Branch branch = new Branch("Home page");

        ArrayList<Branch> list = new ArrayList<>();
        VersionControl versionControl = new VersionControl();
        list.add(branch);

        versionControl.setBranches(list);


        assertTrue(versionControl.getBranches().get(0) == branch);
    }
}
