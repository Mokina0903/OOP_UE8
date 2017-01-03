
public class Nut extends Element {

    private Branch branch = null;

    public Nut(Branch branch) {
        super(branch);
        this.branch = branch;
    }

    @Override
    public void setBranchChar() {
        branch.setBranchChar('o');
        branch.setElem(this);
    }


    //todo: implementation
    @Override
    public void run() {

    }
}
