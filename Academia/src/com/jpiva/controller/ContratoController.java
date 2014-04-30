package com.jpiva.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.jpiva.model.Cliente;
import com.jpiva.model.Contrato;

public class ContratoController {
	
	Contrato cto;
	Path caminho;
	Charset charset;
	Gson gs = new Gson();
	
	public ContratoController(){
		charset = Charset.forName("ISO-8859-1");
	}
	
	public void salvarContrato(Contrato cto, String strcaminho){
		
		if(strcaminho.equals("")){
			strcaminho = "C:/Users/Rodrigo/Documents/Contrato/" + cto.getCliente().getCpf() + ".json";
		}
		
		caminho = Paths.get(strcaminho);
		BufferedWriter bw;
		
		
		
		try{			
			boolean arquivoExite = Files.exists(caminho);
			if(!arquivoExite){
				Files.createFile(caminho);
			}
			
			bw = Files.newBufferedWriter(caminho, charset);
			bw.write(gs.toJson(cto));
			bw.flush();
			bw.close();
			JOptionPane.showMessageDialog(null, "Registro salvo com sucesso");
		
		}catch(FileNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"Não foi possivel salvar arquivo",
					                           "Registro não foi Salvo", JOptionPane.ERROR_MESSAGE, null);	
			e.printStackTrace();
		}catch (IOException e){
			JOptionPane.showMessageDialog(null,"Não foi possivel salvar arquivo",
                    "Registro não foi Salvo", JOptionPane.ERROR_MESSAGE, null);	
			
		}catch (Exception e){
			JOptionPane.showMessageDialog(null,"Erro desconhecido",
                    "Registro não foi Salvo", JOptionPane.ERROR_MESSAGE, null);		
		}
	}
	
	public Contrato getContrato(String strcaminho){
		Contrato cto = null;
		caminho = Paths.get(strcaminho);
		BufferedReader buffR;
		try{
			buffR = Files.newBufferedReader(caminho, charset);
			String texto;
			while ((texto = buffR.readLine ()) != null ) {
				cto = gs.fromJson(texto, Contrato.class);
        		//System.out.println(cliente.getAluno());  
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cto;
	}

}
