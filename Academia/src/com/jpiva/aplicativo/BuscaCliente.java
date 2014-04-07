package com.jpiva.aplicativo;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import com.jpiva.controller.ClienteController;
import com.jpiva.controller.TableCliente;

import javax.swing.JButton;
import javax.swing.JTable;

public class BuscaCliente extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTable tableCliente;
	private TableCliente tableModel;

	/**
	 * Create the panel.
	 */
	public BuscaCliente() {
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("171px:grow"),
				ColumnSpec.decode("17px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("86px:grow"),},
			new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JLabel lblCpf = new JLabel("Cpf");
		add(lblCpf, "1, 2, left, center");
		
		textField = new JTextField();
		add(textField, "4, 2, left, top");
		textField.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		add(lblNome, "1, 4");
		
		textField_1 = new JTextField();
		add(textField_1, "4, 4, fill, default");
		textField_1.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		add(btnBuscar, "4, 6");
		
		tableCliente = getTableCliente();
		add(tableCliente, "1, 8, 4, 1, fill, fill");
		
		//add(tableCliente, getTableCliente());
		

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
            tableModel = new TableCliente(cc.getClientes());
        }
        return tableModel;
    }
}