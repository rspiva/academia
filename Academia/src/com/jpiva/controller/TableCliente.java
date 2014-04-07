package com.jpiva.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.jpiva.model.Cliente;

public class TableCliente extends AbstractTableModel{
	
	private List<Cliente> linhas;
	private String[] colunas = new String[] { "Nome", "Cpf" };
	// Constantes representando o índice das colunas
	private static final int NOME = 0;
	private static final int CPF = 1;
	
	public TableCliente(){
		linhas = new ArrayList<Cliente>();
	}
	
	public TableCliente(List<Cliente> listDeClientes){
		linhas = new ArrayList<Cliente>(listDeClientes);
	}
	

	public List<Cliente> getLinhas() {
		return linhas;
	}

	public void setLinhas(List<Cliente> linhas) {
		this.linhas = linhas;
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
	    return colunas[columnIndex];
	};
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
	    switch (columnIndex) {
	    case NOME:
	        return String.class;
	    case CPF:
	        return String.class;
	    default:
	        // Não deve ocorrer, pois só existem 2 colunas
	        throw new IndexOutOfBoundsException("columnIndex out of bounds");
	    }
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
	    return false;
	}

	@Override
	public int getRowCount() {
	    return linhas.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
	    // Pega o sócio referente a linha especificada.
	    Cliente cliente = linhas.get(rowIndex);
	 
	    switch (columnIndex) {
	    case NOME:
	        return cliente.getAluno();
	    case CPF:
	        return cliente.getCpf();
	    default:
	        // Não deve ocorrer, pois só existem 2 colunas
	        throw new IndexOutOfBoundsException("columnIndex out of bounds");
	    }
	}
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	    // Pega o sócio referente a linha especificada.
		Cliente cliente = linhas.get(rowIndex);
	 
		switch (columnIndex) {
	    case NOME:
	        cliente.setAluno((String) aValue);
	        break;
	    case CPF:
	        cliente.setCpf((String) aValue);
	        break;
	    default:
	        // Não deve ocorrer, pois só existem 2 colunas
	        throw new IndexOutOfBoundsException("columnIndex out of bounds");
	    }
	     
	     
	    fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualização da célula
	}
	
	// Retorna o sócio referente a linha especificada
	public Cliente getCliente(int indiceLinha) {
	    return linhas.get(indiceLinha);
	}
	 
	// Adiciona o sócio especificado ao modelo
	public void addCliente(Cliente cliente) {
	    // Adiciona o registro.
	    linhas.add(cliente);
	 
	    // Pega a quantidade de registros e subtrai 1 para
	    // achar o último índice. A subtração é necessária
	    // porque os índices começam em zero.
	    int ultimoIndice = getRowCount() - 1;
	 
	    // Notifica a mudança.
	    fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}
	 
	// Remove o sócio da linha especificada.
	public void removeCliente(int indiceLinha) {
	    // Remove o registro.
	    linhas.remove(indiceLinha);
	 
	    // Notifica a mudança.
	    fireTableRowsDeleted(indiceLinha, indiceLinha);
	}
	 
	// Adiciona uma lista de sócios no final da lista.
	public void addListaDeClientes(List<Cliente> clientes) {
	    // Pega o tamanho antigo da tabela, que servirá
	    // como índice para o primeiro dos novos registros
	    int indice = getRowCount();
	 
	    // Adiciona os registros.
	    linhas.addAll(clientes);
	 
	    // Notifica a mudança.
	    fireTableRowsInserted(indice, indice + clientes.size());
	}
	 
	// Remove todos os registros.
	public void limpar() {
	    // Remove todos os elementos da lista de sócios.
	    linhas.clear();
	 
	    // Notifica a mudança.
	    fireTableDataChanged();
	}
	
	//referencia: http://devsv.wordpress.com/2012/07/08/como-implementar-um-tablemodel/

}
