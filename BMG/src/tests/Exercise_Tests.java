package tests;

import database.BaseSetting;
import java.util.ArrayList;
import java.util.Iterator;
import model.Exercise;
import model.Question;
import model.QuestionCalculation;
import model.Wording;

public class Exercise_Tests 
{
    
    public static void main(String[] args)
    {
        BaseSetting bs = new BaseSetting();
        
        Wording w = new Wording("Je suis un énoncé", new Object[10]);
        
        if (w != null) {System.out.println("WORDING NOT NULL");}
        
        // INSERTION WORDING
        w.insert(bs);
        
        if (w != null) {System.out.println("WORDING NOT NULL");}
        
        w = null;
        
        if (w == null) {System.out.println("WORDING NULL");}
        
        w = Wording.findById(1, bs);
        
        if (w != null) {System.out.println("WORDING NULL");}
        
        if (bs != null) {System.out.println("BS OK");}
        
        ArrayList<Question> alq = new ArrayList<>();
        
        QuestionCalculation qc1 = new QuestionCalculation("Qui suis-je ?",1);
        QuestionCalculation qc2 = new QuestionCalculation("Où est Brian ?",1);
        
        // INSERTION QUESTIONS
        qc1.insert(bs);
        qc2.insert(bs);
        
        System.out.println("INSERT QC OK");
        
        alq.add(qc1);
        alq.add(qc2);
        
        Exercise e = new Exercise("Titre", w, alq, "Exercice de calculs", 1, true);
        
        // INSERTION EXERCISE
        e.insert(bs);
        
        System.out.println("INSERT E OK");
        
        ArrayList<Question> newalq = Exercise.findById_AllQuestions(e.getId(), bs);
        
        Iterator it = newalq.iterator();
        
        while (it.hasNext())
        {
            System.out.println("test");
            System.out.println("test"+it.next().equals(qc1));
        }
        
        // INSERTION CONTAINS
        //(e.getId(),qc1.getID());
        //(e.getId(),qc2.getID());
    }
    
}
