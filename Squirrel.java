import java.util.Random;

public class Squirrel extends Element{

    //2 cells needed - random neighbor?
    private Branch[] position = new Branch[2];

    public Squirrel(Branch branch) {
        super(branch);
        position[0] = branch;
        position[1] = getRandomNeighbor();
    }

    //adds random neighbor that is free for 2nd branch
    private Branch getRandomNeighbor() {
        Random r = new Random();
        int i = r.nextInt(position[0].getNeighbors().size());
        if (!position[0].getNeighbors().get(i).getFree()) {
            getRandomNeighbor();
        }
        return position[0].getNeighbors().get(i);
    }

    public void setBranchChar() {
        setBranch('e', position[0]);
        setBranch('h', position[1]);
    }

    public void setBranch(char c, Branch branch) {
        branch.setElem(this);
        branch.setBranchChar(c);
    }

    //todo: implementation
    @Override
    public void run() {

    }


}
