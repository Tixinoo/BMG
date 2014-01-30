
import java.util.ArrayList;
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

        System.out.println("\n-------> A calculation with selected operators <-------");
        sc = new Scanner(System.in);
        char op = '+';
        ArrayList<Character> operators = new ArrayList<Character>();
        while (op != '0') {
            System.out.print("Operator? ");
            op = sc.next().charAt(0);
            if (op != '0') operators.add(op);
        }
        QuestionCalculation qc3 = new QuestionCalculation();
        qc3.generate(operators);
        System.out.println(qc3);
        double res3 = qc3.solve();
        System.out.println("Result3: " + res3);
        System.out.println("---------------------------------------------------------------------\n");

        System.out.println("\n-------> A calculation with selected operators and given length <-------");
        sc = new Scanner(System.in);
        System.out.print("Length? ");
        int l2 = sc.nextInt();
        char op2 = '+';
        ArrayList<Character> operators2 = new ArrayList<Character>();
        while (op2 != '0') {
            System.out.print("Operator? ");
            op2 = sc.next().charAt(0);
            if (op2 != '0') operators2.add(op2);
        }
        QuestionCalculation qc4 = new QuestionCalculation();
        qc4.generate(operators2,l2);
        System.out.println(qc4);
        double res4 = qc4.solve();
        System.out.println("Result4: " + res4);
        System.out.println("---------------------------------------------------------------------\n");

        System.out.println("\n-------> An exercise with these questions <-------");
        Exercise ex1 = new Exercise("calculation");
        ex1.setStatement(new Wording());
        ex1.addQuestion(qc1);
        ex1.addQuestion(qc2);
        ex1.addQuestion(qc3);
        ex1.addQuestion(qc4);
        System.out.println(ex1);
        System.out.println("---------------------------------------------------------------------\n");

        System.out.println("\n-------> An exercise with a given type <-------");
        System.out.println("Type? ");
        String t = sc.next();
        System.out.println("");
        Exercise ex2 = new Exercise(t);
        ex2.generate();
        System.out.println(ex2);
        System.out.println("---------------------------------------------------------------------\n");
        
        
        // TODO
        
        System.out.println("\n-------> TODO <-------");
        
        // Encoding and saving
        ex2.setTitle("Ex-1-calculation");
        ex2.save(); // Encode the file in a string and save it in a file "<exercise.title>.txt" (here, "Ex-1-calculation.txt")
        
        // Decoding and loading
        Exercise ex2load = new Exercise();
        ex2load.load("Ex-1-calculation"); // Load the exercise from the file "Ex-1-calculation.txt" in the object "ex2load"
        
    }

}
