import domain.Branch;
import domain.VersionControl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VersionControlTest {
    @Test
    void versionControlTest(){
        Branch branch = new Branch("Home page");

        ArrayList<Branch> list = new ArrayList<>();
        VersionControl versionControl = new VersionControl();
        list.add(branch);

        versionControl.setBranches(list);


        assertSame(versionControl.getBranches().get(0), branch);
    }
}
