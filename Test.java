/*

Arbeitsaufteilung:

Monika

Ausgabe gibt Eichhörnchen jeweils doppelt aus (da 2 Felder)
Funktioniert meistens! Manchmal tritt ein indexoutofboundsexception bei getRandomNeighbor() auf...


 */
public class Test {

    public static void main(String[] args) {

        //Test1
        Tree t1 = new Tree(5, 2, 2);
        System.out.println("--- Test1 ---\n");
        System.out.println("Start: \n" + t1);

        t1.startThreads();
        while (!t1.getEnded()) {
            System.out.print(""); //prgramm won't update and start next test empty method???
        }
        System.out.println(t1.getEnded());


       //Test2
        Tree t2 = new Tree(7, 4, 7);
        System.out.println("--- Test2 ---\n");
        System.out.println("Start: \n" + t2);

       t2.startThreads();
        while (!t2.getEnded()) {
            System.out.print("");
        }
        System.out.println(t2.getEnded());


        //Test3
        Tree t3 = new Tree(5, 3, 5);
        System.out.println("--- Test3 ---\n");
        System.out.println("Start: \n" + t3);

        t3.startThreads();
        while (!t3.getEnded()) {}

    }
}
