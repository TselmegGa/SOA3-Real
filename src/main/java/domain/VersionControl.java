package domain;

import java.util.ArrayList;
import java.util.List;

public class VersionControl {
    private List<Branch> branches;

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(ArrayList<Branch> branches) {
        this.branches = branches;
    }
}
