import java.util.ArrayList;

import model.QuestionCalculation;
import model.QuestionEquation;
import model.QuestionFraction;


public class TestKernel57 {

	public static void main(String[] args) {
		QuestionCalculation qcal = new QuestionCalculation();
		ArrayList<Integer> opd = new ArrayList<Integer>();
		opd.add(12);
		opd.add(84);
		opd.add(45);
		opd.add(90);
		ArrayList<Character> opt = new ArrayList<Character>();
		opt.add('+');
		opt.add('/');
		opt.add('-');
		qcal.setOperands(opd);
		qcal.setOperators(opt);
		qcal.setLength(4);
		
		String str = qcal.encode();
		System.out.println(str);
		QuestionCalculation qcal2 = QuestionCalculation.decode(str);
		System.out.println(qcal2);
		str = qcal2.encode();
		System.out.println(str+ "\n");
		
		QuestionFraction qfra = new QuestionFraction();
		ArrayList<Integer> num = new ArrayList<Integer>();
		num.add(12);
		num.add(84);
		num.add(45);
		num.add(90);
		ArrayList<Integer> dnm = new ArrayList<Integer>();
		dnm.add(5);
		dnm.add(3);
		dnm.add(2);
		dnm.add(45);
		opt = new ArrayList<Character>();
		opt.add('+');
		opt.add('/');
		opt.add('-');
		qfra.setNumerators(num);
		qfra.setDenominators(dnm);
		qfra.setOperators(opt);
		qfra.setLength(4);
		System.out.println(qfra.encode()+ "\n");
		
		QuestionEquation qequ = new QuestionEquation();
		opd = new ArrayList<Integer>();
		opd.add(12);
		opd.add(84);
		opd.add(45);
		opd.add(90);
		ArrayList<Boolean> ukn = new ArrayList<Boolean>();
		ukn.add(false);
		ukn.add(false);
		ukn.add(true);
		ukn.add(false);
		opt = new ArrayList<Character>();
		opt.add('+');
		opt.add('/');
		opt.add('=');
		qequ.setOperands(opd);
		qequ.setOperators(opt);
		qequ.setUnknowns(ukn);
		qequ.setLength(4);
		System.out.println(qequ.encode());
	}

}
