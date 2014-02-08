package tests;

import model.Wording;

public class Others_Tests 
{
    @SuppressWarnings("empty-statement")
    public static void main(String[] args)
    {	    
	double de = 3.50;
	int it = 666;
	String sg = "hello";
	char cr = '!';

	char res = ' ';

//	res = Wording.getType(de);	System.out.println(res);
//	res = Wording.getType(it);	System.out.println(res);
//	res = Wording.getType(sg);	System.out.println(res);
//	res = Wording.getType(cr);	System.out.println(res);
	
	System.out.println();
	
	System.out.println("DEBUT TEST ENCODE_VALUES");
	
	String big_s_encode = "";
	Object[] t_obj_encode = {de,it,sg,cr};
	
	Wording w_encode = new Wording("texte...",new Object[4]);
	
	w_encode.setValues(t_obj_encode);
	
	big_s_encode = w_encode.encodeValues();
	
	System.out.println("Obtenu :  "+big_s_encode);
	System.out.println("Attendu : "+"d(3.50):i(666):s(hello):c(!)");
	
	System.out.println("FIN TEST ENCODE_VALUES");
	
	System.out.println();
	
	System.out.println("DEBUT TEST DECODE_VALUES");
	
	Wording w_decode = new Wording("texte...",new Object[4]);
	
	String big_s_decode = "d(3.50):i(666):s(hello):c(!)";
	Object[] t_obj_decode = null;
	
	t_obj_decode = w_decode.decodeValues(big_s_decode);
	w_decode.setValues(t_obj_decode);
	
	System.out.println("Obtenu :  "+w_decode.encode());
	System.out.println("Attendu : "+"#Wording<-1><$<texte...>$><3.50:666:hello:!>");
	
	System.out.println("FIN TEST DECODE_VALUES");

    }
}
