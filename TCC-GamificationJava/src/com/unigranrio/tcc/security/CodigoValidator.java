package com.unigranrio.tcc.security;

import java.util.LinkedList;
import java.util.List;

public class CodigoValidator {

	List<String> listaDeCodigos;
	
	public CodigoValidator(){
		listaDeCodigos = new LinkedList<String>();
		listaDeCodigos.add("for(;;)");
		listaDeCodigos.add("while(true)");
	}
	
	public boolean validarCodigo(String codigo){
		for(String codigoMalicioso : listaDeCodigos){
			if(codigo.contains(codigoMalicioso)){
				return false;
			}
		}
		return true;
	}
}
