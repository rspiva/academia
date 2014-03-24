package com.jpiva.aplicativo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeListener;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import com.jpiva.model.Cliente;
import com.jpiva.model.Contrato;


public class AcademiaLayout extends JFrame{
	
	private JFrame frame = this;
	JPanel painelCliente = new JPanel();
	JPanel painelControle = new JPanel();
	JPanel painelContrato = new JPanel();
	
	
	JButton btnSalvar = new JButton("Salvar");
	
	// campos clientes
	JLabel lAluno = new JLabel("Aluno:");
	JTextField txtAluno = new JTextField("",25);

	JLabel lRepresentante = new JLabel("Representante:");
	JTextField txtRepresentante = new JTextField("",20);
	
	JLabel lEndereco = new JLabel("Endereço:");
	JTextField txtEndereco = new JTextField("",20);
	
	JLabel lNumero = new JLabel("Nº:");
	JTextField txtNumero = new JTextField("",4);
	
	JLabel lComplemento = new JLabel("Complemento:");
	JTextField txtComplemento = new JTextField("",20);
	
	JLabel lBairro = new JLabel("Bairro:");
	JTextField txtBairro = new JTextField("",12);
	
	JLabel lCidade = new JLabel("Cidade:");
	JTextField txtCidade = new JTextField("",12);
	
	JLabel lCep = new JLabel("CEP:");
	JTextField txtCep = new JTextField("",7);
	
	JLabel lFone1 = new JLabel("Fone:");
	JTextField txtFone1 = new JTextField("",8);
	
	JLabel lFone2 = new JLabel("Fone2:");
	JTextField txtFone2 = new JTextField("",8);
	
	JLabel lIdade = new JLabel("Idade:");
	JTextField txtIdade = new JTextField("",8);
	
	JLabel lLocalNascimento = new JLabel("Local Nascimento:");
	JTextField txtLocalNascimento = new JTextField("",20);
	
	JLabel lDtNascimento = new JLabel("Dt Nascimento:");
	JFormattedTextField txtDtNascimento = new JFormattedTextField(Mascara("##/##/####")); 
	
	JLabel lPeso = new JLabel("Peso:");
	JFormattedTextField txtPeso = new JFormattedTextField(Mascara("###.#")); 
	
	JLabel lAltura = new JLabel("Altura:");
	JFormattedTextField txtAltura = new JFormattedTextField(Mascara("#.##")); 
	
	JLabel lEscolaridade = new JLabel("Escolaridade:");
	JTextField txtEscolaridade = new JTextField("",20);
	
	JLabel lProfissao = new JLabel("Profissão:");
	JTextField txtProfissao = new JTextField("",12);
			
	JLabel lLocalTrabalho = new JLabel("Local Trab:");
	JTextField txtLocalTrabalho = new JTextField("",12);
	
	JLabel lEnderecoTrab = new JLabel("Endereço:");
	JTextField txtEnderecoTrab = new JTextField("",20);
	
	JLabel lNumeroTrab = new JLabel("Nº:");
	JTextField txtNumeroTrab = new JTextField("",4);
	
	JLabel lRg = new JLabel("RG:");
	JTextField txtRg = new JTextField("",12);
	
	JLabel lCpf = new JLabel("CPF:");
	JFormattedTextField txtCpf = new JFormattedTextField(Mascara("###.###.###-##")); 
	
	JLabel lPai = new JLabel("Pai");
	JTextField txtPai = new JTextField("",20);
	
	JLabel lMae = new JLabel("Mãe");
	JTextField txtMae = new JTextField("",20);
	
	
	//campos do contrato
	JLabel lLimiteAulas = new JLabel("Limite Aulas Mensais:");
	JTextField txtLimiteAulas = new JTextField("",3);
	
	JLabel lLimiteAulasSemanais = new JLabel("Limite Aulas Semanais:");
	JTextField txtLimiteSemanais = new JTextField("",3);
	
	JLabel lDiaDePagto = new JLabel("Dia de Pagamento:");
	JTextField txtDiaDePagto = new JTextField("",4);
	
	JLabel lQtdMesesPlano = new JLabel("Quantidade de Meses:");
	JTextField txtQtdMesesPlano = new JTextField("",4);
	
	JLabel lQtdParcela = new JLabel("Quantidade de Parcela:");
	JTextField txtQtdParcela = new JTextField("",4);
	
	JLabel lValorParcela = new JLabel("Valor:");
	JFormattedTextField txtValorParcela = new JFormattedTextField();
            
	
	FocusListener painter = new FocusListener() {  
	    @Override  
	    public void focusGained(FocusEvent e) { 
	        if (!(e.getSource() instanceof JComponent))
	             return;
	        JComponent field = (JComponent) e.getSource();
	        field.setBackground(Color.yellow);
	    }  

	    @Override   
	    public void focusLost(FocusEvent e) {  
	        if (!(e.getSource() instanceof JComponent))
	             return;
	        JComponent field = (JComponent) e.getSource();

	        field.setBackground(Color.WHITE);
	    }
	};

	
	public AcademiaLayout(){
		
		super("Luccas Team - Controle de Contratos");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		//cliente
		
		//painelCliente.setLayout(new FlowLayout(FlowLayout.LEFT));
		painelCliente.setLayout(new GridLayout(24,2,2,2));
		//painelContrato.setLayout(new GridLayout(6,2,2,2));
		painelContrato.setLayout(new FlowLayout(FlowLayout.LEFT));
		painelControle.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		lAluno.setLabelFor(txtAluno);
		txtAluno.addFocusListener(painter);
		painelCliente.add(lAluno);
		painelCliente.add(txtAluno);
				
		lRepresentante.setLabelFor(txtRepresentante);
		txtRepresentante.addFocusListener(painter);
		painelCliente.add(lRepresentante);
		painelCliente.add(txtRepresentante);
		
		lEndereco.setLabelFor(txtEndereco);
		txtEndereco.addFocusListener(painter);
		painelCliente.add(lEndereco);
		painelCliente.add(txtEndereco);
		
		lNumero.setLabelFor(txtNumero);
		txtNumero.addFocusListener(painter);
		painelCliente.add(lNumero);
		painelCliente.add(txtNumero);
		
		txtComplemento.addFocusListener(painter);
		painelCliente.add(lComplemento);
		painelCliente.add(txtComplemento);
		
		txtBairro.addFocusListener(painter);
		painelCliente.add(lBairro);
		painelCliente.add(txtBairro);
		
		txtCidade.addFocusListener(painter);
		painelCliente.add(lCidade);
		painelCliente.add(txtCidade);
		
		txtCep.addFocusListener(painter);
		painelCliente.add(lCep);
		painelCliente.add(txtCep);
		
		txtFone1.addFocusListener(painter);
		painelCliente.add(lFone1);
		painelCliente.add(txtFone1);
		
		txtFone2.addFocusListener(painter);
		painelCliente.add(lFone2);
		painelCliente.add(txtFone2);
		
		txtIdade.addFocusListener(painter);
		painelCliente.add(lIdade);
		painelCliente.add(txtIdade);
		
		txtLocalNascimento.addFocusListener(painter);
		painelCliente.add(lLocalNascimento);
		painelCliente.add(txtLocalNascimento);
		
		txtDtNascimento.addFocusListener(painter);
		painelCliente.add(lDtNascimento);
		painelCliente.add(txtDtNascimento);
		
		txtPeso.addFocusListener(painter);
		painelCliente.add(lPeso);
		painelCliente.add(txtPeso);
		
		txtAltura.addFocusListener(painter);
		painelCliente.add(lAltura);
		painelCliente.add(txtAltura);
		
		txtEscolaridade.addFocusListener(painter);
		painelCliente.add(lEscolaridade);
		painelCliente.add(txtEscolaridade);
		
		txtProfissao.addFocusListener(painter);
		painelCliente.add(lProfissao);
		painelCliente.add(txtProfissao);
		
		txtLocalTrabalho.addFocusListener(painter);
		painelCliente.add(lLocalTrabalho);
		painelCliente.add(txtLocalTrabalho);
		
		txtEnderecoTrab.addFocusListener(painter);
		painelCliente.add(lEnderecoTrab);
		painelCliente.add(txtEnderecoTrab);
		
		txtNumeroTrab.addFocusListener(painter);
		painelCliente.add(lNumeroTrab);
		painelCliente.add(txtNumeroTrab);
		
		txtRg.addFocusListener(painter);
		painelCliente.add(lRg);
		painelCliente.add(txtRg);
		
		txtCpf.addFocusListener(painter);
		painelCliente.add(lCpf);
		painelCliente.add(txtCpf);
		
		txtPai.addFocusListener(painter);
		painelCliente.add(lPai);
		painelCliente.add(txtPai);
		
		txtMae.addFocusListener(painter);
		painelCliente.add(lMae);
		painelCliente.add(txtMae);
		
		//contrato
		txtLimiteAulas.addFocusListener(painter);
		painelContrato.add(lLimiteAulas);
		painelContrato.add(txtLimiteAulas);
		
		txtLimiteSemanais.addFocusListener(painter);
		painelContrato.add(lLimiteAulasSemanais);
		painelContrato.add(txtLimiteSemanais);
		
		txtDiaDePagto.addFocusListener(painter);
		painelContrato.add(lDiaDePagto);
		painelContrato.add(txtDiaDePagto);
		
		txtQtdMesesPlano.addFocusListener(painter);
		painelContrato.add(lQtdMesesPlano);
		painelContrato.add(txtQtdMesesPlano);
		
		txtQtdParcela.addFocusListener(painter);
		painelContrato.add(lQtdParcela);
		painelContrato.add(txtQtdParcela);
		
		txtValorParcela.addFocusListener(painter);
		txtValorParcela.setColumns(10);
		txtValorParcela.setFormatterFactory(MascaraMonetario("#,###,###.00")); 
		txtValorParcela.setHorizontalAlignment(JTextField.TRAILING);
		
		painelContrato.add(lValorParcela);
		painelContrato.add(txtValorParcela);
		
		
		
		painelControle.add(btnSalvar);
		btnSalvar.addActionListener(new SalvarContrato());
		
				
		c.add(painelCliente, BorderLayout.NORTH);
		c.add(painelContrato, BorderLayout.CENTER);
		c.add(painelControle, BorderLayout.SOUTH);
		setSize(800,800);
		setVisible(true);
	
		
	}
	
		
	
    class SalvarContrato implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			Cliente c = new Cliente();
			Contrato cto = new Contrato();
			c.setAluno(txtAluno.getText());
			c.setRepresentante(txtRepresentante.getText());
			c.setEndereco(txtEndereco.getText());
			c.setNumero(txtNumero.getText());
			c.setComplemento(txtComplemento.getText());
			c.setBairro(txtBairro.getText());
			c.setCidade(txtCidade.getText());
			c.setCep(txtCep.getText());
			c.setFone1(txtFone1.getText());
			c.setFone2(txtFone2.getText());
			c.setIdade(Integer.parseInt(txtIdade.getText()));
			c.setLocalNascimento(txtLocalNascimento.getText());
						
			SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy");
			try {
				c.setDtNascimento(sdf1.parse(txtDtNascimento.getText()));
			} catch (ParseException e1) {
				JOptionPane.showMessageDialog(null, "Data esta incorreta");
				e1.printStackTrace();
			}
			c.setPeso(Double.parseDouble(txtPeso.getText()));
			c.setAltura(Double.parseDouble(txtAltura.getText()));
			c.setEscolaridade(txtEscolaridade.getText());
			c.setProfissao(txtProfissao.getText());
			c.setLocalTrabalho(txtLocalTrabalho.getText());
			c.setEnderecoTrabalho(txtEnderecoTrab.getText());
			c.setNumeroTrabalho(txtNumeroTrab.getText());
			c.setRg(txtRg.getText());
			c.setCpf(txtCpf.getText());
			c.setNomePai(txtPai.getText());
			c.setNomeMae(txtMae.getText());
			
			//campos do contrato
			cto.setCliente(c);
			cto.setLimiteDeAulas(Integer.parseInt(txtLimiteAulas.getText()));
			cto.setLimiteDeAulasSemanais(Integer.parseInt(txtLimiteSemanais.getText()));
			cto.setDiaDePagto(Integer.parseInt(txtDiaDePagto.getText()));
			cto.setQtdMesesPlano(Integer.parseInt(txtQtdMesesPlano.getText()));
			cto.setQtdParcela(Integer.parseInt(txtQtdParcela.getText()));
			cto.setValorParcela(new BigDecimal(0.0));
						
			JOptionPane.showMessageDialog(null, "Seu nome não é " + c.getAluno());
			JOptionPane.showMessageDialog(null, "contrato " + cto.getQtdMesesPlano());
			
		}
    }
    
    public MaskFormatter Mascara(String Mascara){  
        
        MaskFormatter F_Mascara = new MaskFormatter();  
        try{  
            F_Mascara.setMask(Mascara); //Atribui a mascara  
            F_Mascara.setPlaceholderCharacter('_'); //Caracter para preencimento   
        }  
        catch (Exception excecao) {  
        excecao.printStackTrace();  
        }   
        return F_Mascara;  
    }
    
    public DefaultFormatterFactory MascaraMonetario(String Mascara){  
        
    	DecimalFormat decimal = new DecimalFormat(Mascara);
    	NumberFormatter numFormatter = new NumberFormatter(decimal);
    	
    	//MaskFormatter F_Mascara = new MaskFormatter();  
        
    	numFormatter.setFormat(decimal);  
    	numFormatter.setAllowsInvalid(false);
    	DefaultFormatterFactory dff = new DefaultFormatterFactory(numFormatter);
    	
    	/*
        F_Mascara.setMask(Mascara); //Atribui a mascara
        F_Mascara.setValidCharacters("0123456789");
        F_Mascara.setAllowsInvalid(false);
        F_Mascara.setPlaceholderCharacter('0'); //Caracter para preencimento
        */   
    	return dff;  
    }   
   
}
