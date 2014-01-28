
import java.util.Scanner;
import model.*;

public class Main {

    private static Scanner sc;

    public static void main(String[] args) {

        System.out.println("\n-----------------------\n  Welcome in B.M.G. !\n-----------------------\n");

        System.out.println("-------> A random calculation <-------");
        QuestionCalculation qc1 = new QuestionCalculation();
        qc1.generate();
        System.out.println(qc1);
        double res1 = qc1.solve();
        System.out.println("Result1: " + res1);
        System.out.println("---------------------------------------------------------------------\n");

        System.out.println("\n-------> A calculation with a given length <-------");
        sc = new Scanner(System.in);
        System.out.print("Length? ");
        int l = sc.nextInt();
        QuestionCalculation qc2 = new QuestionCalculation();
        qc2.generate(l);
        System.out.println(qc2);
        double res2 = qc2.solve();
        System.out.println("Result2: " + res2);
        System.out.println("---------------------------------------------------------------------\n");

        System.out.println("\n-------> An exercise with a given type <-------");
        System.out.println("Type? ");
        String t = sc.next();
        System.out.println("");
        Exercise ex1 = new Exercise(t);
        ex1.setStatement(new Wording());
        ex1.addQuestion(qc1);
        ex1.addQuestion(qc2);
        System.out.println(ex1);

    }

}
