package com.jpiva.controller;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import com.jpiva.model.Contrato;

public class ImprimeContrato {
	
	private String conteudoPdf;
	private String nome;
	private Contrato contrato;
	

	MontarContrato mc = new MontarContrato();

	public void setConteudoPdf(String conteudoPdf) {
		this.conteudoPdf = conteudoPdf;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

		
	public void imprimirContratoPdf(){
	
		// Create a document and add a page to it
		PDDocument document;
		try {
			document = new PDDocument();
		
			PDPage page = new PDPage(PDPage.PAGE_SIZE_A4);
			document.addPage(page);
				
		
			// Start a new content stream which will "hold" the to be created content
			PDPageContentStream cs = new PDPageContentStream(document, page);
				
			//PDFont fontTitulo = PDType1Font.HELVETICA_BOLD;
			// Define a text content stream using the selected font, moving the cursor and drawing the text "Hello World"
			
			cs =  mc.getPDPageContentStream(cs, contrato);
			/*
			cs.beginText();
			cs.setFont( fontTitulo, 12 );
			cs.moveTextPositionByAmount( 10, 70 );
			cs.drawString("Associação Lucca's de Arte marcial");
			cs.endText();
			*/
		
			// Make sure that the content stream is closed:
			cs.close();
		
			// Save the results and ensure that the document is properly closed:
			document.save( this.nome + ".pdf");
			
			File pdfFile = new File(this.nome + ".pdf");
			Desktop.getDesktop().open(pdfFile);
			
			
			document.close();
		}  catch (COSVisitorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
	}

}
