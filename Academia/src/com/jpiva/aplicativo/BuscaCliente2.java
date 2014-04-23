package com.jpiva.aplicativo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTable;

import com.jpiva.aplicativo.AcademiaLayout.BuscarCliente;
import com.jpiva.controller.ClienteController;
import com.jpiva.controller.TableCliente;
import com.jpiva.model.Cliente;

public class BuscaCliente2 extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTable tableCliente;
	private TableCliente tableModel;
	List<Cliente> lc;
	private Cliente cliente;
	private int index;

	/**
	 * Launch the application.
	 */
	public BuscaCliente2() {
		super("Buscar Aluno");
	}
	
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscaCliente2 frame = new BuscaCliente2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 */
	/**
	 * Create the frame.
	 */
	public void abrirBuscaCliente2() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNome = new JLabel("Nome:");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 0;
		contentPane.add(lblNome, gbc_lblNome);
		
		txtNome = new JTextField();
		txtNome.setText("");
		GridBagConstraints gbc_txtNome = new GridBagConstraints();
		gbc_txtNome.insets = new Insets(0, 0, 5, 0);
		gbc_txtNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNome.gridx = 1;
		gbc_txtNome.gridy = 0;
		contentPane.add(txtNome, gbc_txtNome);
		txtNome.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 0);
		gbc_btnBuscar.gridx = 1;
		gbc_btnBuscar.gridy = 2;
		contentPane.add(btnBuscar, gbc_btnBuscar);
		
		tableCliente = getTableCliente();
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 2;
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 3;
		contentPane.add(tableCliente, gbc_table);
		
		btnBuscar.addActionListener(new FiltrarCliente());
		tableCliente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tableCliente.getSelectionModel().addListSelectionListener(new ListSelectionListener() {  
	         
	        public void valueChanged(ListSelectionEvent e) {  
	             //System.out.println(tableCliente.getSelectedRow());
	        	 index = tableCliente.getSelectedRow();
	        	 cliente = (Cliente) lc.get(index);
	        	 dispose();
	        	 JOptionPane.showMessageDialog(null, "Aluno: " + cliente.getAluno()+ " carregado\nPressione o botão atualizar");
	        	   //feichar frame
	        }
			
	     });  
		
	}
	
	public Cliente getClienteSelecionado(){
		if(lc == null){
			return null;
		}
		cliente = (Cliente) lc.get(index);
		return this.cliente;
		
	}
	
	
	private JTable getTableCliente() {
        if (tableCliente == null) {
        	tableCliente = new JTable();
        	tableCliente.setModel(getTableModel());
        }
        return tableCliente;
	}
	
	 
    private TableCliente getTableModel() {
    	
    	ClienteController cc = new ClienteController();
        if (tableModel == null) {
            tableModel = new TableCliente();
        }
        return tableModel;
    }
    
    class FiltrarCliente implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			if(lc != null)
				lc.clear();
			
			lc = new ClienteController().getListFiltro(txtNome.getText());			
		    //System.out.println(lc);
		    tableModel.setLinhas(lc);
		    tableCliente.updateUI();
		    
		}
    }
    
    
    
    
    
}
