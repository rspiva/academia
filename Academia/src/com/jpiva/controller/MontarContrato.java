package com.jpiva.controller;

import com.jpiva.model.Contrato;

public class MontarContrato {
	
	
	public String MontarConteudoContrato(Contrato cto){
		StringBuilder sc = new StringBuilder();
		
		sc.append("Associa��o Lucca�s de Arte Marcial\n");
		sc.append("Rua Graciosa, 95 - Pq. Sete de Setembro - Diadema Fone:4044-4232\n");
		sc.append("\n");
		sc.append("Contrato de loca��o de servi�o n�");
		
		sc.append("outro" + cto.getCliente().getAluno() + " doravante locatario nete ato represntado pelo SR(a)");
		sc.append(cto.getCliente().getRepresentante());
		
		return sc.toString();
		
	}

}
