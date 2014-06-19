package com.unigranrio.tcc.teste;

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

	private static int i;
	private String resultado;

	public String executar(String codigo) {
		try {
			i++;
			ClassPool parent = new ClassPool(true);
			ClassPool child = new ClassPool(parent);
			child.insertClassPath(new ClassClassPath(this.getClass()));

			CtClass cc = child.makeClass("Exercicio" + Integer.toString(i));
			CtMethod m = CtNewMethod.make("public void execute() { " + codigo
					+ " }", cc);
			cc.addMethod(m);

			CtClass ci = child.get("com.unigranrio.tcc.teste.ProgramaIntf");
			cc.addInterface(ci);

			Class exIntf = cc.toClass();
			ProgramaIntf obj = (ProgramaIntf) exIntf.newInstance();

			PrintStream out = new PrintStream(new FileOutputStream(
					"console.txt", false));

			System.setOut(out);
			System.setErr(out);
			
			obj.execute();
			
			Scanner reader = new Scanner(new FileReader("console.txt"));
			
			resultado = reader.nextLine();
			while(reader.hasNext()){
				resultado += reader.nextLine();
			}
			
			reader.close();
			cc.detach();
			out.close();

		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CannotCompileException e) {
			resultado = e.getReason();
			// e.printStackTrace();
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

}
