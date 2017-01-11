/*

Arbeitsaufteilung:
Monika:

Leider ist das Programm nicht funktionsfähig.
Die Threads der Eichhörnchen scheinen einander zu blockieren. Es kommt zu einer Endlosschleife.
Der schachbrettartige Aufbau und das zufällige belegen der Felder mit Eichhörnchen und Nüssen
sammt Ausgabe ist in Ordnung

 */
public class Test {

    public static void main(String[] args) {

        //Test1
        Tree t1 = new Tree(5, 2, 2);
        System.out.println("Start -------\n" + t1);
        System.out.println();

      /*  t1.startThreads();
        while (!t1.getEnded())
            ;*/

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
