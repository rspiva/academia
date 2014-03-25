package com.jpiva.controller;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class ImprimeContrato {
	
	private String conteudoPdf;
	private String nome;
	

	public void setConteudoPdf(String conteudoPdf) {
		this.conteudoPdf = conteudoPdf;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public void imprimirContratoPdf(){
	
		// Create a document and add a page to it
		PDDocument document;
		try {
			document = new PDDocument();
		
			PDPage page = new PDPage();
			document.addPage(page);
		
			// Create a new font object selecting one of the PDF base fonts
			PDFont font = PDType1Font.HELVETICA_BOLD;
		
			// Start a new content stream which will "hold" the to be created content
			PDPageContentStream contentStream = new PDPageContentStream(document, page);
		
			// Define a text content stream using the selected font, moving the cursor and drawing the text "Hello World"
			contentStream.beginText();
			contentStream.setFont( font, 12 );
			contentStream.moveTextPositionByAmount( 100, 700 );
			contentStream.drawString(conteudoPdf);
			contentStream.endText();
		
			// Make sure that the content stream is closed:
			contentStream.close();
		
			// Save the results and ensure that the document is properly closed:
			document.save( this.nome + ".pdf");
			
			File pdfFile = new File(this.nome + ".pdf");
			try {
				Desktop.getDesktop().open(pdfFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			document.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		} catch (COSVisitorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
