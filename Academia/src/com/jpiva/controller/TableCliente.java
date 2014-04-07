package com.jpiva.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.jpiva.model.Cliente;

public class TableCliente extends AbstractTableModel{
	
	private List<Cliente> linhas;
	private String[] colunas = new String[] { "Nome", "Cpf" };
	// Constantes representando o �ndice das colunas
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
	        // N�o deve ocorrer, pois s� existem 2 colunas
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
	    // Pega o s�cio referente a linha especificada.
	    Cliente cliente = linhas.get(rowIndex);
	 
	    switch (columnIndex) {
	    case NOME:
	        return cliente.getAluno();
	    case CPF:
	        return cliente.getCpf();
	    default:
	        // N�o deve ocorrer, pois s� existem 2 colunas
	        throw new IndexOutOfBoundsException("columnIndex out of bounds");
	    }
	}
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	    // Pega o s�cio referente a linha especificada.
		Cliente cliente = linhas.get(rowIndex);
	 
		switch (columnIndex) {
	    case NOME:
	        cliente.setAluno((String) aValue);
	        break;
	    case CPF:
	        cliente.setCpf((String) aValue);
	        break;
	    default:
	        // N�o deve ocorrer, pois s� existem 2 colunas
	        throw new IndexOutOfBoundsException("columnIndex out of bounds");
	    }
	     
	     
	    fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualiza��o da c�lula
	}
	
	// Retorna o s�cio referente a linha especificada
	public Cliente getCliente(int indiceLinha) {
	    return linhas.get(indiceLinha);
	}
	 
	// Adiciona o s�cio especificado ao modelo
	public void addCliente(Cliente cliente) {
	    // Adiciona o registro.
	    linhas.add(cliente);
	 
	    // Pega a quantidade de registros e subtrai 1 para
	    // achar o �ltimo �ndice. A subtra��o � necess�ria
	    // porque os �ndices come�am em zero.
	    int ultimoIndice = getRowCount() - 1;
	 
	    // Notifica a mudan�a.
	    fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}
	 
	// Remove o s�cio da linha especificada.
	public void removeCliente(int indiceLinha) {
	    // Remove o registro.
	    linhas.remove(indiceLinha);
	 
	    // Notifica a mudan�a.
	    fireTableRowsDeleted(indiceLinha, indiceLinha);
	}
	 
	// Adiciona uma lista de s�cios no final da lista.
	public void addListaDeClientes(List<Cliente> clientes) {
	    // Pega o tamanho antigo da tabela, que servir�
	    // como �ndice para o primeiro dos novos registros
	    int indice = getRowCount();
	 
	    // Adiciona os registros.
	    linhas.addAll(clientes);
	 
	    // Notifica a mudan�a.
	    fireTableRowsInserted(indice, indice + clientes.size());
	}
	 
	// Remove todos os registros.
	public void limpar() {
	    // Remove todos os elementos da lista de s�cios.
	    linhas.clear();
	 
	    // Notifica a mudan�a.
	    fireTableDataChanged();
	}
	
	//referencia: http://devsv.wordpress.com/2012/07/08/como-implementar-um-tablemodel/

}
