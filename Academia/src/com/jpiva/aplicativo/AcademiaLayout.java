package com.jpiva.aplicativo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import com.jpiva.controller.ClienteController;
import com.jpiva.controller.ContratoController;
import com.jpiva.controller.ImprimeContrato;
import com.jpiva.controller.MontarContrato;
import com.jpiva.model.Cliente;
import com.jpiva.model.Contrato;


public class AcademiaLayout extends JFrame{
	
	private JFrame frame = this;
	ClienteController cc = new ClienteController();
	ContratoController ccto = new ContratoController();
	Cliente c = new Cliente();
	Contrato cto = new Contrato();
	
	String arquivoSelecionado = "";
	
	JMenuBar menuBar;
	JMenu menuSistema;
	JMenu menuImpressao;
	JMenuItem salvar;
	JMenuItem abrir;
	JMenuItem novo;
	JMenuItem impressao;
	
	
	
	JPanel painelInformacoes = new JPanel();
	JPanel painelCliente = new JPanel();
	JPanel painelControle = new JPanel();
	JPanel painelContrato = new JPanel();
	
	
	ImprimeContrato ic = new ImprimeContrato();
	MontarContrato mc = new MontarContrato();
	BuscaCliente2 frameBusca = new BuscaCliente2();
	
	
	JButton btnSalvar = new JButton("Salvar");
	JButton btnImprimir = new JButton("Imprimir");
	JButton btnBuscarCliente = new JButton("Buscar Cliente");
	JButton btnAtualizar = new JButton("Atualizar");
	
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
            
	JLabel lPathArquivo = new JLabel("");
	
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
		painelInformacoes.setLayout(new FlowLayout(FlowLayout.LEFT));
		//painelCliente.setLayout(new FlowLayout(FlowLayout.LEFT));
		painelCliente.setLayout(new GridLayout(24,2,2,2));
		//painelContrato.setLayout(new GridLayout(6,2,2,2));
		
		painelContrato.setLayout(new GridLayout(24,2,2,2));
		painelControle.setLayout(new FlowLayout(FlowLayout.CENTER));
		painelInformacoes.setSize(c.getSize());
		
		//arquivo
		
		salvar 		= new JMenuItem("Salvar");
		abrir 		= new JMenuItem("Abrir");
		novo 		= new JMenuItem("Novo");
		impressao 	= new JMenuItem("Imprimir");
		
	    menuBar = new JMenuBar();  
        menuSistema = new JMenu("Arquivo");  
        menuSistema.add(novo);  
        menuSistema.add(abrir);
        menuSistema.add(salvar);
        menuImpressao = new JMenu("Impressão");
        menuImpressao.add(impressao);
        menuBar.add(menuSistema);
        menuBar.add(menuImpressao);
		
		c.add(menuBar, BorderLayout.NORTH);
	
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
	
		txtLocalNascimento.addFocusListener(painter);
		painelCliente.add(lLocalNascimento);
		painelCliente.add(txtLocalNascimento);
		
		txtDtNascimento.addFocusListener(painter);
		painelCliente.add(lDtNascimento);
		painelCliente.add(txtDtNascimento);
		
		txtPeso.addFocusListener(painter);
		txtPeso.setFormatterFactory(MascaraMonetario("###.00")); 
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
		txtLimiteAulas.setHorizontalAlignment(JTextField.TRAILING);
		painelContrato.add(lLimiteAulas);
		painelContrato.add(txtLimiteAulas);
		
		txtLimiteSemanais.addFocusListener(painter);
		txtLimiteSemanais.setHorizontalAlignment(JTextField.TRAILING);
		painelContrato.add(lLimiteAulasSemanais);
		painelContrato.add(txtLimiteSemanais);
		
		txtDiaDePagto.addFocusListener(painter);
		txtDiaDePagto.setHorizontalAlignment(JTextField.TRAILING);
		painelContrato.add(lDiaDePagto);
		painelContrato.add(txtDiaDePagto);
		
		txtQtdMesesPlano.addFocusListener(painter);
		txtQtdMesesPlano.setHorizontalAlignment(JTextField.TRAILING);
		painelContrato.add(lQtdMesesPlano);
		painelContrato.add(txtQtdMesesPlano);
		
		txtQtdParcela.addFocusListener(painter);
		txtQtdParcela.setHorizontalAlignment(JTextField.TRAILING);
		painelContrato.add(lQtdParcela);
		painelContrato.add(txtQtdParcela);
		
		
		txtValorParcela.addFocusListener(painter);
		txtValorParcela.setColumns(10);
		txtValorParcela.setFormatterFactory(MascaraMonetario("#,###,###.00")); 
		txtValorParcela.setHorizontalAlignment(JTextField.TRAILING);
		
		
		
		painelContrato.add(lValorParcela);
		painelContrato.add(txtValorParcela);
		painelControle.add(btnBuscarCliente);
		painelControle.add(btnAtualizar);
	    
		impressao.addActionListener(new ImprimirContrato());
		salvar.addActionListener(new SalvarContrato());
		abrir.addActionListener(new AbrirContrato());
		
		btnBuscarCliente.addActionListener(new BuscarCliente());
		btnAtualizar.addActionListener(new Atualizar());
		
		/*
		txtValorParcela.setText("100");
		txtDiaDePagto.setText("30");
		txtLimiteAulas.setText("12");
		txtLimiteSemanais.setText("3");
		txtQtdMesesPlano.setText("12");
		txtQtdParcela.setText("12");
	    */
		
		painelContrato.setSize(500, 200);
		
		painelCliente.setBorder(BorderFactory.createCompoundBorder(
				 BorderFactory.createTitledBorder("Informações do Cliente"), 
				 BorderFactory.createEmptyBorder(5,5,5,5)));
		
		painelContrato.setBorder(BorderFactory.createCompoundBorder(
				 BorderFactory.createTitledBorder("Condições do Contrato"), 
				 BorderFactory.createEmptyBorder(5,5,5,5)));
		
		
		painelInformacoes.add(painelCliente);
		painelInformacoes.add(painelContrato);
		painelInformacoes.add(lPathArquivo);
		
		c.add(painelInformacoes, BorderLayout.CENTER);
		c.add(painelControle, BorderLayout.PAGE_END);
		
		setSize(800,800);
		setVisible(true);
	
		
	}
	
	public void preencherFormularioCliente(Cliente cs){
		if( cs != null){
			txtAluno.setText(cs.getAluno());
			txtRepresentante.setText(cs.getRepresentante());
			txtEndereco.setText(cs.getEndereco());
			txtNumero.setText(cs.getNumero());
			txtComplemento.setText(cs.getComplemento());
			txtBairro.setText(cs.getBairro());
			txtCidade.setText(cs.getCidade());
			txtCep.setText(cs.getCep());
			txtFone1.setText(cs.getFone1());
			txtFone2.setText(cs.getFone2());
			txtLocalNascimento.setText(cs.getLocalNascimento());
			
			SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy");
			txtDtNascimento.setText(sdf1.format(cs.getDtNascimento()));
			
			
			DecimalFormat df = new DecimalFormat("0.##");
			txtPeso.setText(df.format(cs.getPeso()));
			
			txtAltura.setText(String.valueOf(cs.getAltura()));
			txtEscolaridade.setText(cs.getEscolaridade());
			txtProfissao.setText(cs.getProfissao());
			txtLocalTrabalho.setText(cs.getLocalTrabalho());
			txtEnderecoTrab.setText(cs.getEnderecoTrabalho());
			txtNumeroTrab.setText(cs.getNumeroTrabalho());
			txtRg.setText(cs.getRg());
			txtCpf.setText(cs.getCpf());
			txtPai.setText(cs.getNomePai());
			txtMae.setText(cs.getNomeMae());
		}
		
	}
	
	public void preecherFormularioContrato(Contrato ctos){
		if( ctos != null){
			txtLimiteAulas.setText(String.valueOf(ctos.getLimiteDeAulas()));
			txtLimiteSemanais.setText(String.valueOf(ctos.getLimiteDeAulasSemanais()));
			txtDiaDePagto.setText(String.valueOf(ctos.getDiaDePagto()));
			txtQtdMesesPlano.setText(String.valueOf(ctos.getQtdMesesPlano()));
			txtQtdParcela.setText(String.valueOf(ctos.getQtdParcela()));
			
			NumberFormat nf = NumberFormat.getInstance();
			System.out.println(nf.format(ctos.getValorParcela()));
			txtValorParcela.setText(nf.format(ctos.getValorParcela()));
			
			
			
		}
		
	}
	
	private Contrato lerFormulario(){
		
		
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
		c.setLocalNascimento(txtLocalNascimento.getText());
					
		SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy");
		try {
			c.setDtNascimento(sdf1.parse(txtDtNascimento.getText()));
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null, "Data esta incorreta");
			e1.printStackTrace();
		}
		
		String peso = txtPeso.getText().replace(",", ".");		
		c.setPeso(Double.parseDouble(peso));
		
		
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
		
		NumberFormat nf = NumberFormat.getInstance();
		try {
			cto.setValorParcela(nf.parse(txtValorParcela.getText()).doubleValue());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Calendar cData = Calendar.getInstance();  
        Calendar cHoje= Calendar.getInstance();  
        cData.setTime(c.getDtNascimento());  
        cData.set(Calendar.YEAR, cHoje.get(Calendar.YEAR));  
        int idade = cData.after(cHoje) ? -1 : 0;  
        cData.setTime(c.getDtNascimento());
        idade += cHoje.get(Calendar.YEAR) - cData.get(Calendar.YEAR);  
        c.setIdade(idade);
        return cto;		
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
    
    class SalvarContrato implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			if(txtCpf.getText().equals("___.___.___-__") || txtAluno.getText().equals("")){
				JOptionPane.showMessageDialog(null,"Não há CPF ou nome do Aluno",
                        "Registro não foi Salvo", JOptionPane.ERROR_MESSAGE, null);	
			}else{
				Contrato cto = new Contrato();
				cto = lerFormulario();
				cc.salvaCliente(cto.getCliente());
				ccto.salvarContrato(cto, arquivoSelecionado);
			}
		}
    }
    
	class ImprimirContrato implements ActionListener{
			
		public void actionPerformed(ActionEvent e){
			
			Contrato cto = new Contrato();
			cto = lerFormulario();
			
			ic.setNome("contrato");
			ic.setContrato(cto);
			ic.imprimirContratoPdf();
			
		}
    }
	
	class Atualizar implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						
						
						c = frameBusca.getClienteSelecionado();
						preencherFormularioCliente(c);
						
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});			
		}
    }
	
	class AbrirContrato implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JFileChooser fileChooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivo JSON ","json", "json");
			fileChooser.setFileFilter(filter);
			int opcao = fileChooser.showOpenDialog(frame);
			
			
			if(opcao == JFileChooser.APPROVE_OPTION){
				arquivoSelecionado=fileChooser.getSelectedFile().getAbsolutePath();
				lPathArquivo.setText(arquivoSelecionado);
				Contrato ctosel = ccto.getContrato(arquivoSelecionado);
				preencherFormularioCliente(ctosel.getCliente());
				preecherFormularioContrato(ctosel);
				
			}else if(opcao == JFileChooser.CANCEL_OPTION){
								
			}
		}
		
	}
	
	class BuscarCliente implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						frameBusca.setVisible(true);
						frameBusca.abrirBuscaCliente2();
						//Cliente cliente = frame.getClienteSelecionado();
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
		}
    }    
}
