
public abstract class Element implements Runnable {

    private Branch branch;

    public Element(Branch branch) {
        this.branch = branch;
    }

    public abstract void setBranchChar();

    public Branch getBranch() {
        return branch;
    }

}
