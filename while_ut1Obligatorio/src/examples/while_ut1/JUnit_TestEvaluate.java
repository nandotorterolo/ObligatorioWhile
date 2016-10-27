package examples.while_ut1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import junit.framework.TestCase;
import org.junit.*;

import examples.while_ut1.ast.AssignmentStmtWithType;
import examples.while_ut1.ast.State;
import examples.while_ut1.ast.Stmt;

public class JUnit_TestEvaluate extends TestCase {

	
//
//
//	// Positivo
	public void test1() {
		String inputTest="{num y=2.0;y=2342*2;}";

		Map<String,Object> hashValores = new HashMap<String,Object>();
		Map<String,String> hashTipos = new HashMap<String,String>();
		agregarAMapas(hashValores,hashTipos,"y",2342*2.0,"Double");
		// assert statements
		assertTrue(hashValores.equals(Main.evaluateInput(inputTest).mapaValores) && 
				hashTipos.equals(Main.evaluateInput(inputTest).mapaTipo));
	}
//	
//	
//	
	public void test101() {
		String inputTest="{num y=2.0;y=2342*2.0;}";

		Map<String,Object> hashValores = new HashMap<String,Object>();
		Map<String,String> hashTipos = new HashMap<String,String>();
		agregarAMapas(hashValores,hashTipos,"y",2342*2.0,"Double");
		// assert statements
		assertTrue(hashValores.equals(Main.evaluateInput(inputTest).mapaValores) && 
				hashTipos.equals(Main.evaluateInput(inputTest).mapaTipo));
	}


	
	public void test2() {
		String inputTest="int y=0-2;";

		Map<String,Object> hashValores = new HashMap<String,Object>();
		hashValores.put("y", -2);
		Map<String,String> hashTipos = new HashMap<String,String>();
		hashTipos.put("y", "Integer");
		// assert statements
		assertTrue(hashValores.equals(Main.evaluateInput(inputTest).mapaValores) && 
				hashTipos.equals(Main.evaluateInput(inputTest).mapaTipo));
	}
//
//
	public void test3() {
		String inputTest="if !(1==1) then int x=1; else str x=\"2\";";

		Map<String,Object> hashValores = new HashMap<String,Object>();
		Map<String,String> hashTipos = new HashMap<String,String>();
		
		// assert statements
		assertTrue(hashValores.equals(Main.evaluateInput(inputTest).mapaValores) && 
				hashTipos.equals(Main.evaluateInput(inputTest).mapaTipo));
	}
//	
	public void test103() {
		String inputTest="{int i=1;i=i+1;if (i==2) then {int x=1;print(x);i=32;} else str x=\"2\";}";
		
		Map<String,Object> hashValores = new HashMap<String,Object>();
		Map<String,String> hashTipos = new HashMap<String,String>();
		agregarAMapas(hashValores,hashTipos,"i",32,"Integer");
		// assert statements
		assertTrue(hashValores.equals(Main.evaluateInput(inputTest).mapaValores) && 
				hashTipos.equals(Main.evaluateInput(inputTest).mapaTipo));
	}
//
//
	public void test4() {
		String inputTest="{int x;if (1==1) then x=1;}";

		Map<String,Object> hashValores = new HashMap<String,Object>();
		Map<String,String> hashTipos = new HashMap<String,String>();
		agregarAMapas(hashValores,hashTipos,"x",1,"Integer");
		// assert statements
		assertTrue(hashValores.equals(Main.evaluateInput(inputTest).mapaValores) && 
				hashTipos.equals(Main.evaluateInput(inputTest).mapaTipo));
	}
//
	public void test5() {
		String inputTest="{int x;if (true) then x=1;}";

		Map<String,Object> hashValores = new HashMap<String,Object>();
		Map<String,String> hashTipos = new HashMap<String,String>();
		agregarAMapas(hashValores,hashTipos,"x",1,"Integer");
		// assert statements
		assertTrue(hashValores.equals(Main.evaluateInput(inputTest).mapaValores) && 
				hashTipos.equals(Main.evaluateInput(inputTest).mapaTipo));
	}
//
//
	public void test6() {
		String inputTest="{int x;if (true==false) then x=1;}";

		Map<String,Object> hashValores = new HashMap<String,Object>();
		Map<String,String> hashTipos = new HashMap<String,String>();
		agregarAMapas(hashValores,hashTipos,"x",null,"Integer");
		// assert statements
		assertTrue(hashValores.equals(Main.evaluateInput(inputTest).mapaValores) && 
				hashTipos.equals(Main.evaluateInput(inputTest).mapaTipo));
	}
//
	public void test7() {
		String inputTest="str hello = \"hello worl\";";

		Map<String,Object> hashValores = new HashMap<String,Object>();
		Map<String,String> hashTipos = new HashMap<String,String>();
		agregarAMapas(hashValores,hashTipos,"hello","hello worl","String");
		// assert statements
		assertTrue(hashValores.equals(Main.evaluateInput(inputTest).mapaValores) && 
				hashTipos.equals(Main.evaluateInput(inputTest).mapaTipo));
	}
//
	public void test8() {
		String inputTest="{int i;int x=i=1;}";

		Map<String,Object> hashValores = new HashMap<String,Object>();
		Map<String,String> hashTipos = new HashMap<String,String>();
		agregarAMapas(hashValores,hashTipos,"i",1,"Integer");
		agregarAMapas(hashValores,hashTipos,"x",1,"Integer");
		// assert statements
		assertTrue(hashValores.equals(Main.evaluateInput(inputTest).mapaValores) && 
				hashTipos.equals(Main.evaluateInput(inputTest).mapaTipo));	}
//
	public void test9() {
		String inputTest="{int x;if (true) then {x=1;int y=1;}}";

		Map<String,Object> hashValores = new HashMap<String,Object>();
		Map<String,String> hashTipos = new HashMap<String,String>();
		agregarAMapas(hashValores,hashTipos,"x",1,"Integer");
		// assert statements
		assertTrue(hashValores.equals(Main.evaluateInput(inputTest).mapaValores) && 
				hashTipos.equals(Main.evaluateInput(inputTest).mapaTipo));	}
//
	public void test10() {
		String inputTest="print(1+2);";

		Map<String,Object> hashValores = new HashMap<String,Object>();
		Map<String,String> hashTipos = new HashMap<String,String>();
		// assert statements
		assertTrue(hashValores.equals(Main.evaluateInput(inputTest).mapaValores) && 
				hashTipos.equals(Main.evaluateInput(inputTest).mapaTipo));
	}
//
	public void test110() {
		String inputTest="print(\"1+2\");";

		Map<String,Object> hashValores = new HashMap<String,Object>();
		Map<String,String> hashTipos = new HashMap<String,String>();
		
		// assert statements
		assertTrue(hashValores.equals(Main.evaluateInput(inputTest).mapaValores) && 
				hashTipos.equals(Main.evaluateInput(inputTest).mapaTipo));
	}
//	
	public void test11() {
		String inputTest="{num y=1; print(y);}";

		Map<String,Object> hashValores = new HashMap<String,Object>();
		Map<String,String> hashTipos = new HashMap<String,String>();
		agregarAMapas(hashValores,hashTipos,"y",1.0,"Double");
		// assert statements
		assertTrue(hashValores.equals(Main.evaluateInput(inputTest).mapaValores) && 
				hashTipos.equals(Main.evaluateInput(inputTest).mapaTipo));
	}
//
	public void test12() {
		String inputTest="{str y=\"sadfsa\"; print(length(y));}";

		Map<String,Object> hashValores = new HashMap<String,Object>();
		Map<String,String> hashTipos = new HashMap<String,String>();
		agregarAMapas(hashValores,hashTipos,"y","sadfsa","String");
		// assert statements
		assertTrue(hashValores.equals(Main.evaluateInput(inputTest).mapaValores) && 
				hashTipos.equals(Main.evaluateInput(inputTest).mapaTipo));
	}
//
//
	public void test13() {
		String inputTest="{str y=\"6\"; print(length(y));}";

		Map<String,Object> hashValores = new HashMap<String,Object>();
		Map<String,String> hashTipos = new HashMap<String,String>();
		agregarAMapas(hashValores,hashTipos,"y","6","String");
		// assert statements
		assertTrue(hashValores.equals(Main.evaluateInput(inputTest).mapaValores) && 
				hashTipos.equals(Main.evaluateInput(inputTest).mapaTipo));
	}
//
	public void test113() {
		String inputTest="{str y=\"6\"; print(length(y)); int x=length(y);}";

		Map<String,Object> hashValores = new HashMap<String,Object>();
		Map<String,String> hashTipos = new HashMap<String,String>();
		agregarAMapas(hashValores,hashTipos,"y","6","String");
		agregarAMapas(hashValores,hashTipos,"x",1,"Integer");
		// assert statements
		assertTrue(hashValores.equals(Main.evaluateInput(inputTest).mapaValores) && 
				hashTipos.equals(Main.evaluateInput(inputTest).mapaTipo));
	}
//	
	public void test14() {
		String inputTest="{int y=6; print(defined(y));}";

		Map<String,Object> hashValores = new HashMap<String,Object>();
		Map<String,String> hashTipos = new HashMap<String,String>();
		agregarAMapas(hashValores,hashTipos,"y",6,"Integer");
		// assert statements
		assertTrue(hashValores.equals(Main.evaluateInput(inputTest).mapaValores) && 
				hashTipos.equals(Main.evaluateInput(inputTest).mapaTipo));
	}
//
	public void test15() {
		String inputTest="{bool y=defined(y); print(y); print(defined(y));}";

		Map<String,Object> hashValores = new HashMap<String,Object>();
		Map<String,String> hashTipos = new HashMap<String,String>();
		agregarAMapas(hashValores,hashTipos,"y",false,"Boolean");
		// assert statements
		assertTrue(hashValores.equals(Main.evaluateInput(inputTest).mapaValores) && 
				hashTipos.equals(Main.evaluateInput(inputTest).mapaTipo));
	}
//
	public void test16() {
		String inputTest="{int i=0; while (i <= 3) do i=i+1;}";

		Map<String,Object> hashValores = new HashMap<String,Object>();
		Map<String,String> hashTipos = new HashMap<String,String>();
		agregarAMapas(hashValores,hashTipos,"i",4,"Integer");
		// assert statements
		assertTrue(hashValores.equals(Main.evaluateInput(inputTest).mapaValores) && 
				hashTipos.equals(Main.evaluateInput(inputTest).mapaTipo));

	}


	public void test17() {
		String inputTest="{bool i=true; while i do {print(i); i=false;} print(i);}";

		Map<String,Object> hashValores = new HashMap<String,Object>();
		Map<String,String> hashTipos = new HashMap<String,String>();
		agregarAMapas(hashValores,hashTipos,"i",false,"Boolean");
		// assert statements
		assertTrue(hashValores.equals(Main.evaluateInput(inputTest).mapaValores) && 
				hashTipos.equals(Main.evaluateInput(inputTest).mapaTipo));

	}


	public void test18() {
		String inputTest="{int i=2+2;}";

		Map<String,Object> hashValores = new HashMap<String,Object>();
		Map<String,String> hashTipos = new HashMap<String,String>();
		agregarAMapas(hashValores,hashTipos,"i",4,"Integer");
		// assert statements
		assertTrue(hashValores.equals(Main.evaluateInput(inputTest).mapaValores) && 
				hashTipos.equals(Main.evaluateInput(inputTest).mapaTipo));
	}

	
	public void test118() {
		String inputTest="{num i=2+2.5;}";

		Map<String,Object> hashValores = new HashMap<String,Object>();
		Map<String,String> hashTipos = new HashMap<String,String>();
		agregarAMapas(hashValores,hashTipos,"i",4.5,"Double");
		// assert statements
		assertTrue(hashValores.equals(Main.evaluateInput(inputTest).mapaValores) && 
				hashTipos.equals(Main.evaluateInput(inputTest).mapaTipo));

	}

	
	public void test19() {
		String inputTest="{int i=2-2;}";

		Map<String,Object> hashValores = new HashMap<String,Object>();
		Map<String,String> hashTipos = new HashMap<String,String>();
		agregarAMapas(hashValores,hashTipos,"i",0,"Integer");
		// assert statements
		assertTrue(hashValores.equals(Main.evaluateInput(inputTest).mapaValores) && 
				hashTipos.equals(Main.evaluateInput(inputTest).mapaTipo));

	}

	public void test20() {
		String inputTest="{num i=2*2;}";

		Map<String,Object> hashValores = new HashMap<String,Object>();
		Map<String,String> hashTipos = new HashMap<String,String>();
		agregarAMapas(hashValores,hashTipos,"i",4.0,"Double");
		// assert statements
		assertTrue(hashValores.equals(Main.evaluateInput(inputTest).mapaValores) && 
				hashTipos.equals(Main.evaluateInput(inputTest).mapaTipo));

	}

	public void test21() {
		String inputTest="{num i=2/2;}";

		Map<String,Object> hashValores = new HashMap<String,Object>();
		Map<String,String> hashTipos = new HashMap<String,String>();
		agregarAMapas(hashValores,hashTipos,"i",2/2.0,"Double");
		// assert statements
		assertTrue(hashValores.equals(Main.evaluateInput(inputTest).mapaValores) && 
				hashTipos.equals(Main.evaluateInput(inputTest).mapaTipo));

	}

	public void test22() {
		String inputTest="{int i=1+2/99;}";
		
		Map<String,Object> hashValores = new HashMap<String,Object>();
		Map<String,String> hashTipos = new HashMap<String,String>();
		agregarAMapas(hashValores,hashTipos,"i",1+2/99,"Integer");
		// assert statements
		assertTrue(hashValores.equals(Main.evaluateInput(inputTest).mapaValores) && 
				hashTipos.equals(Main.evaluateInput(inputTest).mapaTipo));
	}


	public void test23() {
		String inputTest="{bool i=defined(i); int y=3; if (!(i) && y==3) then i=true;}";

		Map<String,Object> hashValores = new HashMap<String,Object>();
		Map<String,String> hashTipos = new HashMap<String,String>();
		agregarAMapas(hashValores,hashTipos,"i",true,"Boolean");
		agregarAMapas(hashValores,hashTipos,"y",3,"Integer");
		// assert statements
		assertTrue(hashValores.equals(Main.evaluateInput(inputTest).mapaValores) && 
				hashTipos.equals(Main.evaluateInput(inputTest).mapaTipo));
	}

	
	public void agregarAMapas(Map<String,Object> mapaValores,Map<String,String> mapaTipos,String id,Object obj,String str){
		mapaValores.put(id, obj);
		mapaTipos.put(id, str);
	}

}
