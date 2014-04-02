package com.jpiva.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.jpiva.model.Cliente;

public class ClienteController {
	
	private Cliente cliente;
	private List<Cliente> clientes;
	Gson gs = new Gson();
	File arquivo = new File("cliente.json");
	
	//leitura de dados com o FileReader e BufferedReader, estudar forma de ler dados com o
	// FileInputStream			
	public ClienteController(){
		
		clientes = new ArrayList<Cliente>();
		FileReader fileR;
		BufferedReader buffR;  
		try {
			fileR = new FileReader (arquivo);
			buffR = new BufferedReader (fileR);
			String texto;  
        	while ((texto = buffR.readLine ()) != null ) {
        		Cliente cliente = gs.fromJson(texto, Cliente.class);
        		clientes.add(cliente);
			    System.out.println(cliente.getAluno());  
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
		
		this.clientes.add(cliente);
		
		try {
			FileOutputStream fos = new FileOutputStream(arquivo);
			
			//Inserir o tratamento de quando houver o cliente atualiza
			
			for(Cliente c : this.clientes){
				//adiciona na linha cada json
				fos.write(gs.toJson(c).getBytes());
				fos.write("\n".getBytes());
			}
			
			fos.close();
			
			
		
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
