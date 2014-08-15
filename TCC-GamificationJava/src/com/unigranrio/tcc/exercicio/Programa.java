package com.unigranrio.tcc.exercicio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import javassist.CannotCompileException;
import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.NotFoundException;

public class Programa {

	private static int numero;
	private String resultado;
	private static Class<ProgramaIntf> exIntf;

	
	public String executar(String codigo) {
		try {
			numero++;
			ClassPool parent = new ClassPool(true);
			ClassPool child = new ClassPool(parent);
			child.insertClassPath(new ClassClassPath(this.getClass()));

			CtClass cc = child.makeClass("Exercicio" + Integer.toString(numero));
			CtMethod m = CtNewMethod.make("public void execute() { " + codigo
					+ " }", cc);
			cc.addMethod(m);

			CtClass ci = child.get("com.unigranrio.tcc.exercicio.ProgramaIntf");
			cc.addInterface(ci);

			exIntf = cc.toClass();
			ProgramaIntf obj = (ProgramaIntf) exIntf.newInstance();

			PrintStream out = new PrintStream(new FileOutputStream(
					"console.txt", false));
			System.setOut(out);
			System.setErr(out);
			
			obj.execute();
			cc.detach();
			
			resultado = resultadoDaExecucao();

			out.close();
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CannotCompileException e) {
			resultado = e.getReason();
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return resultado;
	}
	
	public String resultadoDaExecucao(){
		String resultado = null;
		try {
			Scanner reader = new Scanner(new FileReader("console.txt"));
			resultado = reader.nextLine();
			while (reader.hasNext()) {
				resultado += "\n";
				resultado += reader.nextLine();
			}

			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
		
	}

}
