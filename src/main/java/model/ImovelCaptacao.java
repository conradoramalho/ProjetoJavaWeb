package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_imoveis_captacao")
public class ImovelCaptacao {
	@Id
	@GeneratedValue(strategy = IDENTITY)
    private int id_imovel_captacao;
    
	@OneToOne
	@JoinColumn(name="id_imovel")
    private Imovel imovel;
	
    @Column
    private int in_ano_contrucao;
    @Column
    private int in_max_ocupantes;
    @Column
    private String tx_valor_iptu;
    @Column
    private String tx_local_chave;
    
    public ImovelCaptacao()
    {
    	this.in_ano_contrucao = 0;
    	this.in_max_ocupantes = 0;
    	this.tx_valor_iptu = "";
    	this.tx_local_chave ="";
    }

    /**
     * @return the id_imovel_captacao
     */
    public int getId_imovel_captacao() {
        return id_imovel_captacao;
    }

    /**
     * @param id_imovel_captacao the id_imovel_captacao to set
     */
    public void setId_imovel_captacao(int id_imovel_captacao) {
        this.id_imovel_captacao = id_imovel_captacao;
    }

    /**
     * @return the imovel
     */
    public Imovel getImovel() {
        return imovel;
    }

    /**
     * @param imovel the imovel to set
     */
    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    /**
     * @return the in_ano_contrucao
     */
    public int getIn_ano_contrucao() {
        return in_ano_contrucao;
    }

    /**
     * @param in_ano_contrucao the in_ano_contrucao to set
     */
    public void setIn_ano_contrucao(int in_ano_contrucao) {
        this.in_ano_contrucao = in_ano_contrucao;
    }

    /**
     * @return the in_max_ocupantes
     */
    public int getIn_max_ocupantes() {
        return in_max_ocupantes;
    }

    /**
     * @param in_max_ocupantes the in_max_ocupantes to set
     */
    public void setIn_max_ocupantes(int in_max_ocupantes) {
        this.in_max_ocupantes = in_max_ocupantes;
    }

    /**
     * @return the dl_valor_iptu
     */
    public String getTx_valor_iptu() {
        return tx_valor_iptu;
    }

    /**
     * @param dl_valor_iptu the dl_valor_iptu to set
     */
    public void setTx_valor_iptu(String tx_valor_iptu) {
        this.tx_valor_iptu = tx_valor_iptu;
    }

    /**
     * @return the tx_local_chave
     */
    public String getTx_local_chave() {
        return tx_local_chave;
    }

    /**
     * @param tx_local_chave the tx_local_chave to set
     */
    public void setTx_local_chave(String tx_local_chave) {
        this.tx_local_chave = tx_local_chave;
    }
    
}
