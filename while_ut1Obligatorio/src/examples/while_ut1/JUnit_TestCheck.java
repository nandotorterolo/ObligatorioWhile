package examples.while_ut1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;
import org.junit.*;

import examples.while_ut1.ast.CheckState;
import examples.while_ut1.ast.ObjectState;
import examples.while_ut1.ast.State;
import examples.while_ut1.ast.Stmt;

public class JUnit_TestCheck extends TestCase {

	// Positivo
	public void test1() {
		String inputTest="x=true*2;";
		CheckState checkState=Main.checkInput(inputTest);
	}

	
	public void test101() {
		String inputTest="int x=true*2;";
		CheckState checkState=Main.checkInput(inputTest);

	}

	public void test2() {
		String inputTest="num x=1+false;";
		CheckState checkState=Main.checkInput(inputTest);
	}
	
	
	public void test3() {
		String inputTest="int x=x+1;";
		CheckState checkState=Main.checkInput(inputTest);
	}

	public void test4() {
		String inputTest="int x=y*2;";
		CheckState checkState=Main.checkInput(inputTest);
	}

	public void test5() {
		String inputTest="while 1 do {}";
		CheckState checkState=Main.checkInput(inputTest);
	}
	
	public void test6() {
		String inputTest="if 2 then {} else {}";
		CheckState checkState=Main.checkInput(inputTest);
	}
	
	public void test7() {
		String inputTest="if \"x\" then {} else {}";
		CheckState checkState=Main.checkInput(inputTest);
	} 
	
	public void test8() {
		String inputTest="str x=\"x\"*2;";
		CheckState checkState=Main.checkInput(inputTest);
	}
	
	public void test9() {
		String inputTest="{int x=17; x=x+1;}";
		CheckState checkState=Main.checkInput(inputTest);
	}
	
	public void test10() {
		System.out.println("Test10");
		String inputTest="bool x=true<=\"false\";";
		CheckState checkState=Main.checkInput(inputTest);
	}
	
	public void test11(){
		System.out.println("Test11");
		String inputTest="{bool x=true; while x do  x=false;}";
		CheckState checkState=Main.checkInput(inputTest);
		
	}
	
	public void test12(){
		System.out.println("Test12");
		String inputTest="{if true then int x=1; else str x=\"1\"; int x=x*2; x=\"String\"; x=false;}";
		CheckState checkState=Main.checkInput(inputTest);
	}
	
	public void test1112(){
		System.out.println("Test12");
		String inputTest="if true then int x=1; else str x=\"1\";";
		CheckState checkState=Main.checkInput(inputTest);
	}
	
	public void test112(){
		System.out.println("Test12");
		String inputTest="{int x=x*2; x=\"String\";}";
		CheckState checkState=Main.checkInput(inputTest);
	}
	
	public void test13(){
		System.out.println("Test13");
		String inputTest="{int x=1;if true then int x=1; else int x=2; x=x*2;}";
		CheckState checkState=Main.checkInput(inputTest);
	}
	
	public void test14(){
		System.out.println("Test14");
		String inputTest="{if false then int x=1; else int y=2; x=\"sdfs\";}";
		CheckState checkState=Main.checkInput(inputTest);
	}
	
	public void test15(){
		System.out.println("Test15");
		String inputTest="{if true then int x=1; else str x=\"hola\"; int x=1;x=x*2;}";
		CheckState checkState=Main.checkInput(inputTest);
	}
	
	
	public void test16(){
		System.out.println("Test16");
		String inputTest="{if true then int x=1; int x=1;x=x*2;}";
		CheckState checkState=Main.checkInput(inputTest);
	}
	
	public void test17(){
		System.out.println("Test17");
		String inputTest="{while true do int x=1; int x=1;x=x*2;}";
		CheckState checkState=Main.checkInput(inputTest);
	}
}
