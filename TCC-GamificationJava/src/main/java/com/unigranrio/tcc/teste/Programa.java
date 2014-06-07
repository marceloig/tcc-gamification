package com.unigranrio.tcc.teste;

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
	String resultado;

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
			System.out.println("Resposta:");
			obj.execute();
			cc.detach();

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
		}
		
		return resultado;
	}

}
