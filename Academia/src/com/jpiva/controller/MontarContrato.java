package com.jpiva.controller;

import java.io.IOException;

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
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}

}
