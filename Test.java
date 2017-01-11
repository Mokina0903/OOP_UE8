/*

Arbeitsaufteilung:
Monika:


 */
public class Test {

    public static void main(String[] args) {

        //Test1
        Tree t1 = new Tree(5, 2, 2);
        System.out.println("Start -------\n" + t1);
        System.out.println();

        t1.startThreads();
        while (!t1.getEnded())
            ;

/*      //Test2
        Tree t2 = new Tree(7, 4, 7);
        System.out.println(t2);
        System.out.println();

        t2.startThreads();
        while (!t2.getEnded())
            ;*/

/*        //Test3
        Tree t3 = new Tree(5, 2, 4);
        System.out.println("Start -------\n" + t3);
        System.out.println();

        t3.startThreads();
        while (!t3.getEnded())
            ;*/
    }
}
