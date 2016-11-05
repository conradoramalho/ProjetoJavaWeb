	package model;
	import java.util.ArrayList;
	import java.util.Date;
	import java.util.List;
	import javax.persistence.CascadeType;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.GeneratedValue;
	import static javax.persistence.GenerationType.IDENTITY;
	import javax.persistence.Id;
	import javax.persistence.OneToMany;
	import javax.persistence.Table;
	
	@Entity
	@Table(name="tb_imobiliarias")
	public class Imobiliaria {
		
		@Id
		@GeneratedValue(strategy = IDENTITY)
	    private int id_imobiliaria;
		
	    @Column
	    private String tx_razao_social;
	    @Column
	    private String tx_nome_fantasia;
	    @Column
	    private String tx_logradouro;
	    @Column
	    private String tx_bairro;
	    @Column
	    private String tx_cidade;
	    @Column
	    private String tx_telefone;
	    @Column
	    private String tx_site;
	    @Column
	    private Date dt_cadastro = new Date();
	    @Column
	    private Boolean fl_ativo = true;
	    
	    @OneToMany(mappedBy="imobiliaria",targetEntity=model.Empreendimento.class)
	    private List<Empreendimento> empreendimentos;
	    
	    @OneToMany(mappedBy="imobiliaria",targetEntity=model.Usuario.class,cascade = { CascadeType.ALL,CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	    private List<Usuario> usuarios;

		

		public Imobiliaria() {
			super();
			this.tx_razao_social = "";
			this.tx_nome_fantasia = "";
			this.tx_logradouro = "";
			this.tx_bairro = "";
			this.tx_cidade = "";
			this.tx_telefone = "";
			this.tx_site = "";
			this.dt_cadastro = new Date();
			this.fl_ativo = true;
			this.empreendimentos = new ArrayList<Empreendimento>() ;
			this.usuarios = new ArrayList<Usuario>();
		}

		public int getId_imobiliaria() {
			return id_imobiliaria;
		}

		public void setId_imobiliaria(int id_imobiliaria) {
			this.id_imobiliaria = id_imobiliaria;
		}

		public String getTx_razao_social() {
			return tx_razao_social;
		}

		public void setTx_razao_social(String tx_razao_social) {
			this.tx_razao_social = tx_razao_social;
		}

		public String getTx_nome_fantasia() {
			return tx_nome_fantasia;
		}

		public void setTx_nome_fantasia(String tx_nome_fantasia) {
			this.tx_nome_fantasia = tx_nome_fantasia;
		}

		public String getTx_logradouro() {
			return tx_logradouro;
		}

		public void setTx_logradouro(String tx_logradouro) {
			this.tx_logradouro = tx_logradouro;
		}

		public String getTx_bairro() {
			return tx_bairro;
		}

		public void setTx_bairro(String tx_bairro) {
			this.tx_bairro = tx_bairro;
		}

		public String getTx_cidade() {
			return tx_cidade;
		}

		public void setTx_cidade(String tx_cidade) {
			this.tx_cidade = tx_cidade;
		}

		public String getTx_telefone() {
			return tx_telefone;
		}

		public void setTx_telefone(String tx_telefone) {
			this.tx_telefone = tx_telefone;
		}

		public String getTx_site() {
			return tx_site;
		}

		public void setTx_site(String tx_site) {
			this.tx_site = tx_site;
		}

		public Date getDt_cadastro() {
			return dt_cadastro;
		}

		public void setDt_cadastro(Date dt_cadastro) {
			this.dt_cadastro = dt_cadastro;
		}

		public Boolean getFl_ativo() {
			return fl_ativo;
		}

		public void setFl_ativo(Boolean fl_ativo) {
			this.fl_ativo = fl_ativo;
		}

		public List<Empreendimento> getEmpreendimentos() {
			return empreendimentos;
		}

		public void setEmpreendimentos(List<Empreendimento> empreendimentos) {
			this.empreendimentos = empreendimentos;
		}

		public List<Usuario> getUsuarios() {
			return usuarios;
		}

		public void setUsuarios(List<Usuario> usuarios) {
			this.usuarios = usuarios;
		}
		
		
	    
	   
	    
	}
