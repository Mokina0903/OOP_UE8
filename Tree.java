
import java.util.LinkedList;
import java.util.Random;

public class Tree {

    private final int dimension; // between 1 and 80

    //2d Array built by constructor and never changed again.
    private Branch[][] branches = null;

    private boolean ended;

    public Tree(int dimension, int squirrel, int nut) {
        this.dimension = dimension;
        this.branches = new Branch[dimension][dimension];
        fillBranches();
        addNeighbors();
        setRandomElements(squirrel, ElementType.SQUIRREL);
        setRandomElements(nut, ElementType.NUT);
        startThreads();
    }

    private void fillBranches() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                branches[i][j] = new Branch(i,j, this);
            }
        }
    }

    private void addNeighbors() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                branches[i][j].setNeighbors(addNeighbors(i, j));
            }
        }
    }

    private LinkedList<Branch> addNeighbors(int x, int y) {
        LinkedList<Branch> list = new LinkedList<Branch>();

        if (x > 0) {
            list.add(getBranch(x - 1, y));
        }

        if (y > 0) {
            list.add(getBranch(x, y - 1));
        }
        if (x < dimension - 1) {
            list.add(getBranch(x + 1, y));
        }

        if (y < dimension - 1)
            list.add(getBranch(x, y + 1));

        return list;
    }

    //puts squirrels and nuts randomly on branches at start
    private void setRandomElements(int count, ElementType elem) {
        Random r = new Random();
        int x;
        int y;
        for (int i = 0; i < count; i++) {
            x = r.nextInt(dimension);
            y = r.nextInt(dimension);

            while (!getBranch(x, y).getFree()) {
                x = r.nextInt(dimension);
                y = r.nextInt(dimension);
            }
            Branch branch = branches[x][y];

            if (elem.equals(ElementType.SQUIRREL)) {
                branch.changeElem(new Squirrel(branch));
            } else {
                branch.changeElem(new Nut(branch));
            }
        }

    }

    //Starts threads in the tree, is called only once
    public synchronized void startThreads() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (getBranch(i, j).getElem() instanceof Squirrel) {
                    getBranch(i, j).startThread();
                }
            }
        }
    }

    public Branch getBranch(int i, int j) {
        return branches[i][j];
    }

    public synchronized void setEnd() {
        if (!ended) {
            System.out.println("Tree: \n" + this.toString());
            ended = true;
        }
        System.out.println("Tree: \n" + this.toString());
    }

    public boolean noNutsLeft() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (getBranch(i, j).getContainsNut()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean getEnded() {
        return ended;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                sb.append(branches[i][j].getBranchChar());
                sb.append(' ');
            }
            sb.append('\n');
        }

        return sb.toString();
    }

    //Methods just for testing
    public void printSquirrels() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (branches[i][j].getElem() instanceof Squirrel) {
                    System.out.print(i + "," + j + " ; ");
                    System.out.println(branches[i][j].getElem());
                }
            }
        }
        System.out.println();
    }

    public void printNuts() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (branches[i][j].getElem() instanceof Nut) {
                    System.out.print(i + "," + j + " ; ");
                }
            }
        }
        System.out.println();
    }

    public void printTakenBranches() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (!branches[i][j].getFree()) {
                    System.out.print(i + "," + j + " ; ");
                }
            }
        }
        System.out.println();
    }

}
