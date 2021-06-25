package Domain;

import java.util.ArrayList;

public class VersionControl {
    private ArrayList<Branch> branches;

    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public void setBranches(ArrayList<Branch> branches) {
        this.branches = branches;
    }
}
