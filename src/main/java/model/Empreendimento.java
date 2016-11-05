package model;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_empreendimentos")
public class Empreendimento {
	@Id
	@GeneratedValue(strategy = IDENTITY)
    private int id_empreendimento;

//    @OneToOne(mappedBy = "Usuario")
//    private Usuario usuario;
    
//    @OneToMany(mappedBy = "empreendimento", targetEntity=model.Imovel.class)
 //   private List<Imovel> imoveis;
    
    @Column
    private Boolean fl_ativo;

	@Column
    private Boolean fl_edificio;
    
    @ManyToOne
    @JoinColumn(name = "id_imobiliaria",nullable=false)
    private Imobiliaria imobiliaria;
    
    @Column
    private Date dt_cadastro;
    @Column
    private String tx_administradora;
    @Column
    private String tx_nome;
    @Column
    private String tx_nome_torre;
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
    private String tx_descricao_geral;
    
    @OneToOne(mappedBy = "empreendimento")
    private EmpreendimentoDetalhe detalhe;
    
    public Empreendimento ()
    {
        this.id_empreendimento = 0;
        this.fl_ativo = false;
        this.fl_edificio = false;
        this.imobiliaria = new Imobiliaria();
        this.dt_cadastro = new Date();
        this.tx_administradora = "";
        this.tx_nome = "";
        this.tx_nome_torre = "";
        this.tx_logradouro = "";
        this.tx_cidade = "";
        this.tx_estado = "";
        this.tx_bairro = "";
        this.in_numero = 0;
        this.tx_descricao_geral = "";
        
    }

    /**
     * @return the id_empreendimento
     */
    public int getId_empreendimento() {
        return id_empreendimento;
    }

    /**
     * @param id_empreendimento the id_empreendimento to set
     */
    public void setId_empreendimento(int id_empreendimento) {
        this.id_empreendimento = id_empreendimento;
    }

    /**
     * @return the imoveis
     */
 /*   public List<Imovel> getImoveis() {
        return imoveis;
    }

    public void setImoveis(List<Imovel> imoveis) {
        this.imoveis = imoveis;
    } */

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
     * @return the fl_edificio
     */
    public Boolean getFl_edificio() {
        return fl_edificio;
    }

    /**
     * @param fl_edificio the fl_edificio to set
     */
    public void setFl_edificio(Boolean fl_edificio) {
        this.fl_edificio = fl_edificio;
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
     * @return the tx_administradora
     */
    public String getTx_administradora() {
        return tx_administradora;
    }

    /**
     * @param tx_administradora the tx_administradora to set
     */
    public void setTx_administradora(String tx_administradora) {
        this.tx_administradora = tx_administradora;
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
     * @return the tx_nome_torre
     */
    public String getTx_nome_torre() {
        return tx_nome_torre;
    }

    /**
     * @param tx_nome_torre the tx_nome_torre to set
     */
    public void setTx_nome_torre(String tx_nome_torre) {
        this.tx_nome_torre = tx_nome_torre;
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

    

    /**
     * @return the tx_descricao_geral
     */
    public String getTx_descricao_geral() {
        return tx_descricao_geral;
    }

    /**
     * @param tx_descricao_geral the tx_descricao_geral to set
     */
    public void setTx_descricao_geral(String tx_descricao_geral) {
        this.tx_descricao_geral = tx_descricao_geral;
    }


    
    public String getTx_cep() {
		return tx_cep;
	}

	public void setTx_cep(String tx_cep) {
		this.tx_cep = tx_cep;
	}

    /**
     * @return the detalhe
     */
    public EmpreendimentoDetalhe getDetalhe() {
        return detalhe;
    }

    /**
     * @param detalhe the detalhe to set
     */
    public void setDetalhe(EmpreendimentoDetalhe detalhe) {
        this.detalhe = detalhe;
    }

    public String getTx_estado() {
		return tx_estado;
	}

	public void setTx_estado(String tx_estado) {
		this.tx_estado = tx_estado;
	}
    
    
}
