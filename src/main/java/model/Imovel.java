package model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_imoveis")
public class Imovel {
	@Id
	@GeneratedValue(strategy = IDENTITY)
    private int id_imovel;
	@Column
    private Double dl_longitude;
	@Column
    private Double dl_latitude;

 
	@ManyToOne
    @JoinColumn(name = "id_usuario",nullable=false)	
    private Usuario usuario;
    

    @ManyToOne
    @JoinColumn(name = "id_cliente",nullable=false)
    private Cliente cliente;
    
	@Column
    private Date dt_cadastro;
	@Column
    private Date dt_atualizacao;
	@Column
    private String tx_referencia;
	@Column
    private String tx_referencia_auxiliar;
	@Column
    private Boolean fl_venda;
	@Column
    private Boolean fl_locacao;
	@Column
    private String tx_preco_venda;
	@Column
    private String tx_preco_locacao;
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
    private String tx_complemento;
	@Column
    private String tx_tipo;
	
	
	// @ManyToOne
    //@JoinColumn(name = "id_empreendimento",nullable=true)	
    //private Empreendimento empreendimento;
    
	@Column
    private Double dl_area_total;
    @Column
    private Double dl_area_util;
    @Column
    private String tx_area_terreno;
    @Column
    private String tx_ponto_referencia;
    
    @OneToOne(mappedBy = "imovel")
    private ImovelCaptacao captacao;
    
    @OneToOne(mappedBy = "imovel")
    private ImovelDetalhe detalhe;
    
    public Imovel(){
        this.id_imovel = 0;
        this.dl_longitude = 0.00;
        this.dl_latitude = 0.00;
        this.usuario = new Usuario();
        this.cliente = new Cliente();
        this.dt_cadastro = new Date();
        this.dt_atualizacao = new Date();
        this.tx_referencia = "";
        this.tx_referencia_auxiliar = "";
        this.fl_venda = false;
        this.fl_locacao = false;
        this.tx_preco_venda = "";
        this.tx_preco_locacao = "";
        this.tx_cep = "";
        this.tx_logradouro = "";
        this.tx_cidade = "";
        this.tx_bairro = "";
        this.in_numero = 0;
        this.tx_complemento = "";
      //  this.empreendimento = new Empreendimento();
        this.dl_area_total = 0.00;
        this.dl_area_util = 0.00;
        this.tx_area_terreno = "";
        this.tx_ponto_referencia = "";
        this.captacao = new ImovelCaptacao();
        this.detalhe = new ImovelDetalhe();
        this.tx_tipo = "";
    }

    /**
     * @return the id_imovel
     */
    public int getId_imovel() {
        return id_imovel;
    }

    /**
     * @param id_imovel the id_imovel to set
     */
    public void setId_imovel(int id_imovel) {
        this.id_imovel = id_imovel;
    }

    /**
     * @return the dl_longitude
     */
    public Double getDl_longitude() {
        return dl_longitude;
    }

    /**
     * @param dl_longitude the dl_longitude to set
     */
    public void setDl_longitude(Double dl_longitude) {
        this.dl_longitude = dl_longitude;
    }

    /**
     * @return the dl_latitude
     */
    public Double getDl_latitude() {
        return dl_latitude;
    }

    /**
     * @param dl_latitude the dl_latitude to set
     */
    public void setDl_latitude(Double dl_latitude) {
        this.dl_latitude = dl_latitude;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

     
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

     
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
     * @return the dt_atualizacao
     */
    public Date getDt_atualizacao() {
        return dt_atualizacao;
    }

    /**
     * @param dt_atualizacao the dt_atualizacao to set
     */
    public void setDt_atualizacao(Date dt_atualizacao) {
        this.dt_atualizacao = dt_atualizacao;
    }

    /**
     * @return the tx_referencia
     */
    public String getTx_referencia() {
        return tx_referencia;
    }

    /**
     * @param tx_referencia the tx_referencia to set
     */
    public void setTx_referencia(String tx_referencia) {
        this.tx_referencia = tx_referencia;
    }

    /**
     * @return the tx_referencia_auxiliar
     */
    public String getTx_referencia_auxiliar() {
        return tx_referencia_auxiliar;
    }

    /**
     * @param tx_referencia_auxiliar the tx_referencia_auxiliar to set
     */
    public void setTx_referencia_auxiliar(String tx_referencia_auxiliar) {
        this.tx_referencia_auxiliar = tx_referencia_auxiliar;
    }

    /**
     * @return the fl_venda
     */
    public Boolean getFl_venda() {
        return fl_venda;
    }

    /**
     * @param fl_venda the fl_venda to set
     */
    public void setFl_venda(Boolean fl_venda) {
        this.fl_venda = fl_venda;
    }

    /**
     * @return the fl_locacao
     */
    public Boolean getFl_locacao() {
        return fl_locacao;
    }

    /**
     * @param fl_locacao the fl_locacao to set
     */
    public void setFl_locacao(Boolean fl_locacao) {
        this.fl_locacao = fl_locacao;
    }


    /**
     * @return the dl_preco_venda
     */
    public String getTx_preco_venda() {
        return tx_preco_venda;
    }

    /**
     * @param dl_preco_venda the dl_preco_venda to set
     */
    public void setTx_preco_venda(String tx_preco_venda) {
        this.tx_preco_venda = tx_preco_venda;
    }

    /**
     * @return the dl_preco_locacao
     */
    public String getTx_preco_locacao() {
        return tx_preco_locacao;
    }

    /**
     * @param dl_preco_locacao the dl_preco_locacao to set
     */
    public void setTx_preco_locacao(String tx_preco_locacao) {
        this.tx_preco_locacao = tx_preco_locacao;
    }

    /**
     * @return the tx_cep
     */
    public String getTx_cep() {
        return tx_cep;
    }

    /**
     * @param tx_cep the tx_cep to set
     */
    public void setTx_cep(String tx_cep) {
        this.tx_cep = tx_cep;
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

    /**
     * @return the tx_complemento
     */
    public String getTx_complemento() {
        return tx_complemento;
    }

    /**
     * @param tx_complemento the tx_complemento to set
     */
    public void setTx_complemento(String tx_complemento) {
        this.tx_complemento = tx_complemento;
    }

    
    
    /**
     * @return the empreendimento
     */
    
   /* public Empreendimento getEmpreendimento() {
        return empreendimento;
    }

   
    public void setEmpreendimento(Empreendimento empreendimento) {
        this.empreendimento = empreendimento;
    }
    
*/
    /**
     * @return the dl_area_total
     */
    public Double getDl_area_total() {
        return dl_area_total;
    }

    /**
     * @param dl_area_total the dl_area_total to set
     */
    public void setDl_area_total(Double dl_area_total) {
        this.dl_area_total = dl_area_total;
    }

    /**
     * @return the dl_area_util
     */
    public Double getDl_area_util() {
        return dl_area_util;
    }

    /**
     * @param dl_area_util the dl_area_util to set
     */
    public void setDl_area_util(Double dl_area_util) {
        this.dl_area_util = dl_area_util;
    }

    /**
     * @return the tx_area_terreno
     */
    public String getTx_area_terreno() {
        return tx_area_terreno;
    }

    /**
     * @param tx_area_terreno the tx_area_terreno to set
     */
    public void setTx_area_terreno(String tx_area_terreno) {
        this.tx_area_terreno = tx_area_terreno;
    }

    /**
     * @return the tx_ponto_referencia
     */
    public String getTx_ponto_referencia() {
        return tx_ponto_referencia;
    }

    /**
     * @param tx_ponto_referencia the tx_ponto_referencia to set
     */
    public void setTx_ponto_referencia(String tx_ponto_referencia) {
        this.tx_ponto_referencia = tx_ponto_referencia;
    }

    /**
     * @return the captacao
     */
    public ImovelCaptacao getCaptacao() {
        return captacao;
    }

    /**
     * @param captacao the captacao to set
     */
    public void setCaptacao(ImovelCaptacao captacao) {
        this.captacao = captacao;
    }

    /**
     * @return the detalhe
     */
    public ImovelDetalhe getDetalhe() {
        return detalhe;
    }

    /**
     * @param detalhe the detalhe to set
     */
    public void setDetalhe(ImovelDetalhe detalhe) {
        this.detalhe = detalhe;
    }
    public String getTx_tipo() {
		return tx_tipo;
	}

	public void setTx_tipo(String tx_tipo) {
		this.tx_tipo = tx_tipo;
	}
}
