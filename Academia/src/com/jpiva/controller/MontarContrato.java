package com.jpiva.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import com.jpiva.model.Contrato;

public class MontarContrato {
	
		
	
	public PDPageContentStream getPDPageContentStream(PDPageContentStream c, Contrato cto){
		
		PDFont fontTitulo = PDType1Font.HELVETICA_BOLD;
		try {
			
			c.beginText();
			c.setFont(fontTitulo,24);
			c.moveTextPositionByAmount(70,750);
			c.drawString("Associação Lucca's de Arte marcial");
			c.endText();
			c.beginText();
			c.setFont(fontTitulo,8);
			c.moveTextPositionByAmount(74,740);
			c.drawString("Rua Graciosa, 95 - Pq. Sete de Setembro - Diadema Fone:4044-4232");
			c.endText();
			c.beginText();			
			c.setFont(fontTitulo,16);
			c.moveTextPositionByAmount(72,700);
			c.drawString("Contrato de locação de serviço nº");
			c.endText();
			
			c.beginText();			
			c.setFont(fontTitulo,10);
			c.moveTextPositionByAmount(15,670);
			c.drawString("Pelo presente instrumento particular de contrato de locação de serviço a Associação Lucca's de Arte Marcial,");
			c.endText();
			
			c.beginText();			
			c.setFont(fontTitulo,10);
			c.moveTextPositionByAmount(15,650);
			c.drawString("em sede Rua: Graciosa, 95 - Diadema - SP. Doravante denomidado locador CNPJ: 06.176.996/0001-77, de outro");
			c.endText();
			
			c.beginText();			
			c.setFont(fontTitulo,10);
			c.moveTextPositionByAmount(15,630);
			c.drawString("pelo " + cto.getCliente().getAluno() + " doravante locatário neste ato representado pelo SR(a) " + cto.getCliente().getRepresentante());
			c.endText();
			
			c.beginText();			
			c.setFont(fontTitulo,10);
			c.moveTextPositionByAmount(15,610);
			c.drawString("tem entre si justo o contrato abaixo:");
			c.endText();
			
			String complemento = cto.getCliente().getComplemento().equals("")?"":", Compl: " +cto.getCliente().getComplemento();
			
			c.beginText();			
			c.setFont(fontTitulo,10);
			c.moveTextPositionByAmount(15,590);
			c.drawString("End: " + cto.getCliente().getEndereco() + ", " + cto.getCliente().getNumero() + complemento  + "  Bairro: " + cto.getCliente().getBairro() + "  Cidade: " + cto.getCliente().getCidade() + " - SP - " + cto.getCliente().getCep());
			c.endText();
			
			c.beginText();			
			c.setFont(fontTitulo,10);
			c.moveTextPositionByAmount(15,570);
			c.drawString("Fone: " + cto.getCliente().getFone1()  + "   Fone: " + cto.getCliente().getFone2() + "  Email: " + cto.getCliente().getLocalNascimento());
			c.endText();
						
			c.beginText();			
			c.setFont(fontTitulo,10);
			c.moveTextPositionByAmount(15,550);
			c.drawString("Data Nasc: " + definirData(cto.getCliente().getDtNascimento()) + "  Local Nasc: " + cto.getCliente().getLocalNascimento() + "   Treinou Antes: " + cto.getCliente().getTreinouAntes()  + "   Onde?: " + cto.getCliente().getOndeTreinou());
			c.endText();
			
			
			c.beginText();			
			c.setFont(fontTitulo,10);
			c.moveTextPositionByAmount(15,530);
			c.drawString("Idade:" + cto.getCliente().getIdade()  + "   Peso:" + cto.getCliente().getPeso() + "   Altura:" + cto.getCliente().getAltura());
			c.endText();
			
			c.beginText();			
			c.setFont(fontTitulo,10);
			c.moveTextPositionByAmount(15,510);
			c.drawString("Escolaridade:" + cto.getCliente().getEscolaridade() + "   Local de Trabalho: " + cto.getCliente().getLocalTrabalho());
			c.endText();
			
			c.beginText();			
			c.setFont(fontTitulo,10);
			c.moveTextPositionByAmount(15,490);
			c.drawString("End:" + cto.getCliente().getEnderecoTrabalho() + ", " + cto.getCliente().getNumeroTrabalho() + "  Bairro:" + cto.getCliente().getBairroTrabalho() + "  Cidade: " + cto.getCliente().getCidadeTrabalho() + " - SP");
			c.endText();
			
			c.beginText();			
			c.setFont(fontTitulo,10);
			c.moveTextPositionByAmount(15,470);
			c.drawString("Fone°:" + cto.getCliente().getFoneTrabalho() + "   e-mail: " + cto.getCliente().getFoneTrabalho());
			c.endText();
			
			c.beginText();			
			c.setFont(fontTitulo,10);
			c.moveTextPositionByAmount(15,450);
			c.drawString("Est.Civil:   RG:" + cto.getCliente().getRg() + "   CPF:" + cto.getCliente().getCpf());
			c.endText();
			
			c.beginText();			
			c.setFont(fontTitulo,10);
			c.moveTextPositionByAmount(15,430);
			c.drawString("Filiação Pai:" + cto.getCliente().getNomePai() + "   Mãe:" + cto.getCliente().getNomeMae());
			c.endText();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}
	
	private String definirData(Date dt){
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return df.format(dt);
	}

}
