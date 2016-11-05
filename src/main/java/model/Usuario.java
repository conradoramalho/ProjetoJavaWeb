package model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = IDENTITY)
    private int id_usuario;
	
	@Column
    private String tx_nome;	
	
	@Column
	private String tx_sobrenome;

	@ManyToOne
    @JoinColumn(name = "id_imobiliaria",nullable=false)
    private Imobiliaria imobiliaria; 

    @OneToMany(mappedBy="usuario",targetEntity=model.Imovel.class)
    private List<Imovel> imoveis;
    
    @OneToMany(mappedBy="usuario",targetEntity=model.Cliente.class,cascade = { CascadeType.ALL,CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    private List<Cliente> clientes;
    
    @Column
    private Boolean fl_ativo;
    @Column
    private String tx_email;
    @Column
    private String tx_senha;
    @Column
    private String tx_creci;
    @Column
    private String tx_telefone;
    @Column
    private String tx_celular;
    @Column
    private String tx_cpf;
    @Column
    private String tx_cnpj;
    @Column
    private String tx_rg;
    @Column
    private Date dt_cadastro;
	@Column(columnDefinition="date")
    private Date dt_nascimento;
    @Column
    private String tx_descricao;
    
    public Usuario ()
    {
        this.id_usuario = 0;
        this.tx_sobrenome = "";
        this.tx_nome = "";
        this.imobiliaria = new Imobiliaria();
        this.fl_ativo = true;
        this.tx_email = "";
        this.tx_senha = "";
        this.tx_creci = "";
        this.tx_telefone = "";
        this.tx_celular = "";
        this.tx_cpf = "";
        this.tx_cnpj = "";
        this.tx_rg = "";
        this.dt_cadastro = new Date();
        this.dt_nascimento =  new Date();
        this.tx_descricao = "";
    }

    /**
     * @return the id_usuario
     */
    public int getId_usuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    /**
     * @return the tx_nome
     */
    public String getTx_nome() {
        return tx_nome;
    }

    /**
     * @param tx_nome the tx_nome to set
     */
    public void setTx_nome(String tx_nome) {
        this.tx_nome = tx_nome;
    }

    /**
     * @return the imobiliaria
     */
    public Imobiliaria getImobiliaria() {
        return imobiliaria;
    }

    /**
     * @param imobiliaria the imobiliaria to set
     */
    public void setImobiliaria(Imobiliaria imobiliaria) {
        this.imobiliaria = imobiliaria;
    }

    /**
     * @return the fl_ativo
     */
    public Boolean getFl_ativo() {
        return fl_ativo;
    }

    /**
     * @param fl_ativo the fl_ativo to set
     */
    public void setFl_ativo(Boolean fl_ativo) {
        this.fl_ativo = fl_ativo;
    }

    /**
     * @return the tx_email
     */
    public String getTx_email() {
        return tx_email;
    }

    /**
     * @param tx_email the tx_email to set
     */
    public void setTx_email(String tx_email) {
        this.tx_email = tx_email;
    }

    /**
     * @return the tx_senha
     */
    public String getTx_senha() {
        return tx_senha;
    }

    /**
     * @param tx_senha the tx_senha to set
     */
    public void setTx_senha(String tx_senha) {
        this.tx_senha = tx_senha;
    }

    /**
     * @return the tx_creci
     */
    public String getTx_creci() {
        return tx_creci;
    }

    /**
     * @param tx_creci the tx_creci to set
     */
    public void setTx_creci(String tx_creci) {
        this.tx_creci = tx_creci;
    }

    /**
     * @return the tx_telefone
     */
    public String getTx_telefone() {
        return tx_telefone;
    }

    /**
     * @param tx_telefone the tx_telefone to set
     */
    public void setTx_telefone(String tx_telefone) {
        this.tx_telefone = tx_telefone;
    }

    /**
     * @return the tx_celulartx_nome
     */
    public String getTx_celular() {
        return tx_celular;
    }

    /**
     * @param tx_celular the tx_celular to set
     */
    public void setTx_celular(String tx_celular) {
        this.tx_celular = tx_celular;
    }

    /**
     * @return the tx_cpf
     */
    public String getTx_cpf() {
        return tx_cpf;
    }

    /**
     * @param tx_cpf the tx_cpf to set
     */
    public void setTx_cpf(String tx_cpf) {
        this.tx_cpf = tx_cpf;
    }

    /**
     * @return the tx_cnpj
     */
    public String getTx_cnpj() {
        return tx_cnpj;
    }

    /**
     * @param tx_cnpj the tx_cnpj to set
     */
    public void setTx_cnpj(String tx_cnpj) {
        this.tx_cnpj = tx_cnpj;
    }

    /**
     * @return the tx_rg
     */
    public String getTx_rg() {
        return tx_rg;
    }

    /**
     * @param tx_rg the tx_rg to set
     */
    public void setTx_rg(String tx_rg) {
        this.tx_rg = tx_rg;
    }

    /**
     * @return the dt_cadastro
     */
    public Date getDt_cadastro() {
        return dt_cadastro;
    }

    /**
     * @param dt_cadastro the dt_cadastro to set
     */
    public void setDt_cadastro(Date dt_cadastro) {
        this.dt_cadastro = dt_cadastro;
    }

    /**
     * @return the dt_nascimento
     */
    public Date getDt_nascimento() {
        return dt_nascimento;
    }

    /**
     * @param dt_nascimento the dt_nascimento to set
     */
    public void setDt_nascimento(Date dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    /**
     * @return the tx_descricao
     */
    public String getTx_descricao() {
        return tx_descricao;
    }

    /**
     * @param tx_descricao the tx_descricao to set
     */
    public void setTx_descricao(String tx_descricao) {
        this.tx_descricao = tx_descricao;
    }
    
    public List<Imovel> getImoveis() {
        return imoveis;
    }

   
    public void setImoveis(List<Imovel> imoveis) {
        this.imoveis = imoveis;
    }  
    
    public String getTx_sobrenome() {
		return tx_sobrenome;
	}

	public void setTx_sobrenome(String tx_sobrenome) {
		this.tx_sobrenome = tx_sobrenome;
	}
    
    
}
