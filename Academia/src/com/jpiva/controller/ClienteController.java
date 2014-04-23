package com.jpiva.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.jpiva.model.Cliente;

public class ClienteController {
	
	private Cliente cliente;
	private List<Cliente> clientes;
	
	Gson gs = new Gson();
	Path caminho;
	Charset charset;
	public List<Cliente> filterList;
	
	//leitura de dados com o FileReader e BufferedReader, estudar forma de ler dados com o
	// FileInputStream			
	public ClienteController(){
		
		clientes = new ArrayList<Cliente>();
		caminho = Paths.get("C:/academia/cliente.json");
		charset = Charset.forName("ISO-8859-1");
		
		BufferedReader buffR;  
		try {
			buffR = Files.newBufferedReader(caminho, charset);
			String texto;  
        	while ((texto = buffR.readLine ()) != null ) {
        		Cliente cliente = gs.fromJson(texto, Cliente.class);
        		clientes.add(cliente);
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
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List getClientes() {
		return clientes;
	}
	public void setClientes(List clientes) {
		this.clientes = clientes;
	}
	
	public void salvaCliente(Cliente cliente){
		BufferedWriter bw;
		//Inserir o tratamento de quando houver o cliente atualiza
		for( int i = 0; i < this.clientes.size(); i++){
			if(cliente.equals(this.clientes.get(i))){
				this.clientes.remove(i);
			}
		}
		this.clientes.add(cliente);
		
		try {
			bw = Files.newBufferedWriter(caminho, charset);
			
			for(Cliente c : this.clientes){
				//adiciona na linha cada json
				bw.write(gs.toJson(c));
				bw.write("\n");
			}
			bw.flush();
			bw.close();
			JOptionPane.showMessageDialog(null, "Registro salvo com sucesso");			
		
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"Não foi encontrado o arquivo,\npara salvar o registro",
					                           "Registro não foi Salvo", JOptionPane.ERROR_MESSAGE, null);	
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<Cliente> getListFiltro(String filter){
		
		filterList = new ArrayList<Cliente>();
		
		for(Cliente c : this.clientes){
			if(c.getAluno().matches("(?i).*"+ filter + ".*")){
				filterList.add(c);
			}
				
		}
		
		Collections.sort(filterList);
		
		return this.filterList;
			
	}
	
}
