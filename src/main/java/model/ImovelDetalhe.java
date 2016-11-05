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
@Table(name="tb_imoveis_detalhes")
public class ImovelDetalhe {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
    private int id_imovel_detalhe;

    @OneToOne
    @JoinColumn(name="id_imovel")
    private Imovel imovel;
   
    @Column
    private Boolean fl_piscina;
    @Column
    private Boolean fl_quadra_poliesportiva;
    @Column
    private Boolean fl_mobiliado;
    @Column
    private Boolean fl_agua;
    @Column
    private Boolean fl_energia;
    @Column
    private Boolean fl_internet;
    @Column
    private Boolean fl_tv_a_cabo;    
    @Column
    private Boolean fl_gas;
    
    public ImovelDetalhe()
    {
      this.fl_agua = false;
      this.fl_energia = false;
      this.fl_gas = false;
      this.fl_internet = false;
      this.fl_mobiliado =false;
      this.fl_piscina = false;
      this.fl_quadra_poliesportiva = false;
      this.fl_tv_a_cabo = false;
    }

    /**
     * @return the id_imovel_detalhe
     */
    public int getId_imovel_detalhe() {
        return id_imovel_detalhe;
    }

    /**
     * @param id_imovel_detalhe the id_imovel_detalhe to set
     */
    public void setId_imovel_detalhe(int id_imovel_detalhe) {
        this.id_imovel_detalhe = id_imovel_detalhe;
    }

    /**
     * @return the fl_piscina
     */
    public Boolean getFl_piscina() {
        return fl_piscina;
    }

    /**
     * @param fl_piscina the fl_piscina to set
     */
    public void setFl_piscina(Boolean fl_piscina) {
        this.fl_piscina = fl_piscina;
    }

    /**
     * @return the fl_quadra_poliesportiva
     */
    public Boolean getFl_quadra_poliesportiva() {
        return fl_quadra_poliesportiva;
    }

    /**
     * @param fl_quadra_poliesportiva the fl_quadra_poliesportiva to set
     */
    public void setFl_quadra_poliesportiva(Boolean fl_quadra_poliesportiva) {
        this.fl_quadra_poliesportiva = fl_quadra_poliesportiva;
    }

    /**
     * @return the fl_mobiliado
     */
    public Boolean getFl_mobiliado() {
        return fl_mobiliado;
    }

    /**
     * @param fl_mobiliado the fl_mobiliado to set
     */
    public void setFl_mobiliado(Boolean fl_mobiliado) {
        this.fl_mobiliado = fl_mobiliado;
    }

    /**
     * @return the fl_agua
     */
    public Boolean getFl_agua() {
        return fl_agua;
    }

    /**
     * @param fl_agua the fl_agua to set
     */
    public void setFl_agua(Boolean fl_agua) {
        this.fl_agua = fl_agua;
    }

    /**
     * @return the fl_energia
     */
    public Boolean getFl_energia() {
        return fl_energia;
    }

    /**
     * @param fl_energia the fl_energia to set
     */
    public void setFl_energia(Boolean fl_energia) {
        this.fl_energia = fl_energia;
    }

    /**
     * @return the fl_internet
     */
    public Boolean getFl_internet() {
        return fl_internet;
    }

    /**
     * @param fl_internet the fl_internet to set
     */
    public void setFl_internet(Boolean fl_internet) {
        this.fl_internet = fl_internet;
    }

    /**
     * @return the fl_tv_a_cabo
     */
    public Boolean getFl_tv_a_cabo() {
        return fl_tv_a_cabo;
    }

    /**
     * @param fl_tv_a_cabo the fl_tv_a_cabo to set
     */
    public void setFl_tv_a_cabo(Boolean fl_tv_a_cabo) {
        this.fl_tv_a_cabo = fl_tv_a_cabo;
    }
    
    /**
     * @return the fl_gas
     */
    public Boolean getFl_gas() {
        return fl_gas;
    }

    /**
     * @param fl_gas the fl_gas to set
     */
    public void setFl_gas(Boolean fl_gas) {
        this.fl_gas = fl_gas;
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
    
    
}
