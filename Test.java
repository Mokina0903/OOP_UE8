
public class Test {

    public static void main(String[] args) {

        //Test1
        Tree t1 = new Tree(5, 2, 1);
        System.out.println(t1);
        System.out.println();

        //Test2
        Tree t2 = new Tree(10, 5, 7);
        System.out.println(t2);
        System.out.println();


        //just for testing
        System.out.println("SQUIRRELS: ");
        t2.printSquirrels();
        System.out.println("NUTS: ");
        t2.printNuts();
        System.out.println("NOT FREE: ");
        t2.printTakenBranches();

        //Test3
    }
}
