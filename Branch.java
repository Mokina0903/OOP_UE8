import java.util.LinkedList;

public class Branch {

    private final int x;
    private final int y;
    private final Tree tree;

    private Element elem; //Nuts and Squirrels
    private LinkedList<Branch> neighbors = null;
    private char branchChar = 'x';

    private boolean free = true;
    private boolean containsNut = false; //is here a nut?

    private Thread t;

    public Branch(int x, int y, Tree tree){
        this.x = x;
        this.y = y;
        this.tree = tree;
    }

    public void startThread() {
        t = new Thread(elem);
        t.start();
    }

    public void interruptThread() {
        if (t != null && t.isAlive())
            t.interrupt();
    }



    //set new element in branch and change the char
    public void changeElem(Element elem) {
        elem.setBranchChar();
    }

    public void setElem(Element elem) {
        this.elem = elem;
        this.free = false;
    }

    //if taken by a squirrel
    public void setBranchChar(char c) {
        this.branchChar = c;
        this.free = false;
    }

    public void clear() {
        this.branchChar = 'x';
        this.free = true;
        this.elem = null;
    }

    public char getBranchChar() {
        return branchChar;
    }

    public Element getElem() {
        return elem;
    }

    public boolean getFree() {
        return free;
    }

    public void setNeighbors(LinkedList<Branch> neighbors) {
        this.neighbors = neighbors;
    }

    public LinkedList<Branch> getNeighbors() {
        return neighbors;
    }

    public void setContainsNut(boolean b) {
        containsNut = b;
    }

    public boolean getContainsNut () {
        return containsNut;
    }

    public void setEndProgram() {
        tree.setEnd();
    }

    @Override
    public String toString() {
        return x + "," + y;
    }
}
