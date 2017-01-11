import java.util.Random;

public class Squirrel extends Element {

    private Branch[] position = new Branch[2]; //2 cells needed - random neighbor
    private int steps = 0; //interrupts, when 32 is reached
    private int nutsEaten = 0; // counts the nuts that this squirrel has eaten

    static int idCount = 0;
    private final int ID;

    public Squirrel(Branch branch) {
        super(branch);
        position[0] = branch;
        position[1] = getRandomNeighbor();
        ID = ++idCount;
    }

    //adds random neighbor that is free for 2nd branch
   private Branch getRandomNeighbor() {
        if (!freeNeighbor()) {
            return null;
        }
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


    @Override
    public void run() {

        Branch b = position[0];
        while (steps < 32 && !b.noNutsLeft()  && !Thread.interrupted() && !b.noNutsLeft()) {

            //search for accessible nut and go there is available
            if (accessibleNut() != null) {
                Branch newBranch = accessibleNut();
                //the nut and/or branch could be already taken while waiting, so another check is made
                synchronized (newBranch) {
                    if (newBranch.getContainsNut()) {
                        moving(newBranch);
                        newBranch.setContainsNut(false);
                        nutsEaten++;
                        steps++;
                    }
                }
            }
            // go somewhere else
            else if (freeNeighbor()) {
                Branch newBranch = getRandomNeighbor();
                if (newBranch != null) {
                //the branch could be already taken while waiting, so another check is made
                synchronized (newBranch) {
                    if (newBranch.getFree()) {
                        moving(newBranch);
                        steps++;
                    }
                }
                }
            }
            //wait if can't move
            else {
                try {
                    Thread.sleep(15);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            //wait
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        }
        //end if 32 steps reached or no Nuts left
        if (!Thread.interrupted() && (steps >= 32 || b.noNutsLeft()) ) {
            b.setEndProgram();
        }

    }

    //clears old branches and moves to new position
    private void moving(Branch branch) {
        position[0].clear();
        position[1].clear();
        position[0] = branch;
        position[1] = getRandomNeighbor();
        setBranch('e', position[0]);
        setBranch('h', position[1]);
    }


    //does a neighbor contain a nut? (works only for 'e')
    private Branch accessibleNut() {

        for (Branch neighbor : position[0].getNeighbors()) {
            if (neighbor.getContainsNut()) {
                return neighbor;
            }
        }
        return null;
    }

    //only looks out for position[0] neighbors...
    private boolean freeNeighbor() {
        for (Branch neighbor : position[0].getNeighbors()) {
            if (neighbor.getFree()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return ID + " - Steps: " + this.steps + ", nuts eaten: " + nutsEaten;
    }
}
