package model;

import java.util.Date;
import java.util.List;

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
@Table(name="tb_clientes")
public class Cliente {
    
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id_cliente;
	@Column
    private String tx_nome;
	@Column
    private Date dt_cadastro;
	@Column(columnDefinition="date")
    private Date dt_nascimento;
	@Column
    private String tx_email;
	@Column
    private String tx_rg;
	@Column
    private String tx_cpf;
	@Column
    private String tx_renda;	
	@Column
    private String tx_cep;
	@Column
    private String tx_logradouro;
	@Column
    private String tx_cidade;
	@Column
    private String tx_bairro;
	@Column
	private String tx_estado;
	@Column
    private int in_numero;
	@Column
    private Boolean fl_ativo;
	@Column 
	private int in_tipo;
	@Column 
	private int in_tipo_telefone1;
	@Column 
	private String tx_telefone1;
	@Column 
	private int in_tipo_telefone2;
	@Column 
	private String tx_telefone2;
	@Column 
	private int in_tipo_telefone3;
	@Column 
	private String tx_telefone3;

	 

    @OneToMany(mappedBy="cliente",targetEntity=model.Imovel.class)
    private List<Imovel>imoveis;
	

	@ManyToOne
    @JoinColumn(name = "id_usuario",nullable=false)	
	private Usuario usuario;
	
    
    public Cliente ()
    {
        this.id_cliente = 0;
        this.tx_nome = "";
        this.dt_cadastro = new Date();
        this.tx_email = "";
        this.tx_rg = "";
        this.fl_ativo = true;
        this.in_tipo = 1; 
        this.in_tipo_telefone1 = 0;
        this.tx_telefone1 = "";
        this.in_tipo_telefone2 = 0;
        this.tx_telefone2 = "";
        this.in_tipo_telefone3 = 0;
        this.tx_telefone3 = "";  
    }

    /**
     * @return the id_cliente
     */
    public int getId_cliente() {
        return id_cliente;
    }

    /**
     * @param id_cliente the id_cliente to set
     */
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
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

    
    
    public String getTx_renda() {
		return tx_renda;
	}

	public void setTx_renda(String dl_renda) {
		this.tx_renda = dl_renda;
	}

	/**
     * @return the tx_logradouro
     */
    public String getTx_logradouro() {
        return tx_logradouro;
    }

    /**
     * @param tx_logradouro the tx_logradouro to set
     */
    public void setTx_logradouro(String tx_logradouro) {
        this.tx_logradouro = tx_logradouro;
    }

    /**
     * @return the tx_cidade
     */
    public String getTx_cidade() {
        return tx_cidade;
    }

    /**
     * @param tx_cidade the tx_cidade to set
     */
    public void setTx_cidade(String tx_cidade) {
        this.tx_cidade = tx_cidade;
    }
    
    /**
     * @return the tx_estado
     */
    public String getTx_estado() {
        return tx_estado;
    }

    /**
     * @param tx_estado the tx_estado to set
     */
    public void setTx_estado(String tx_estado) {
        this.tx_estado = tx_estado;
    }

    /**
     * @return the tx_bairro
     */
    public String getTx_bairro() {
        return tx_bairro;
    }

    /**
     * @param tx_bairro the tx_bairro to set
     */
    public void setTx_bairro(String tx_bairro) {
        this.tx_bairro = tx_bairro;
    }

    /**
     * @return the in_numero
     */
    public int getIn_numero() {
        return in_numero;
    }

    /**
     * @param in_numero the in_numero to set
     */
    public void setIn_numero(int in_numero) {
        this.in_numero = in_numero;
    }


    public Boolean getFl_ativo() {
		return fl_ativo;
	}

	public void setFl_ativo(Boolean fl_ativo) {
		this.fl_ativo = fl_ativo;
	}

	

	public int getIn_tipo() {
		return in_tipo;
	}

	public void setIn_tipo(int in_tipo) {
		this.in_tipo = in_tipo;
	}

	public int getIn_tipo_telefone1() {
		return in_tipo_telefone1;
	}

	public void setIn_tipo_telefone1(int in_tipo_telefone1) {
		this.in_tipo_telefone1 = in_tipo_telefone1;
	}

	public String getTx_telefone1() {
		return tx_telefone1;
	}

	public void setTx_telefone1(String tx_telefone1) {
		this.tx_telefone1 = tx_telefone1;
	}

	public int getIn_tipo_telefone2() {
		return in_tipo_telefone2;
	}

	public void setIn_tipo_telefone2(int in_tipo_telefone2) {
		this.in_tipo_telefone2 = in_tipo_telefone2;
	}

	public String getTx_telefone2() {
		return tx_telefone2;
	}

	public void setTx_telefone2(String tx_telefone2) {
		this.tx_telefone2 = tx_telefone2;
	}

	public int getIn_tipo_telefone3() {
		return in_tipo_telefone3;
	}

	public void setIn_tipo_telefone3(int in_tipo_telefone3) {
		this.in_tipo_telefone3 = in_tipo_telefone3;
	}

	public String getTx_telefone3() {
		return tx_telefone3;
	}

	public void setTx_telefone3(String tx_telefone3) {
		this.tx_telefone3 = tx_telefone3;
	}

	public List<Imovel> getImoveis() {
		return imoveis;
	}

	public void setImoveis(List<Imovel> imoveis) {
		this.imoveis = imoveis;
	} 

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	private Boolean getAtivo() {
		return fl_ativo;
	}

	private void setAtivo(Boolean fl_ativo) {
		this.fl_ativo = fl_ativo;
	}
	
	public String getTx_cep() {
		return tx_cep;
	}

	public void setTx_cep(String tx_cep) {
		this.tx_cep = tx_cep;
	}
}
