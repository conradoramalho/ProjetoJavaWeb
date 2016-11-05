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
@Table(name="tb_empreendimentos_detalhe")
public class EmpreendimentoDetalhe {
	@Id
	@GeneratedValue(strategy = IDENTITY)
    private int id_empreendimento_detalhe;

    @OneToOne 
    @JoinColumn(name="id_empreendimento")
    private Empreendimento empreendimento;
    
    @Column
    private Boolean fl_piscina;
    @Column
    private Boolean fl_quadra_poliesportiva;
    @Column
    private Boolean fl_playground;
    @Column
    private Boolean fl_portaria_24_horas;
    @Column
    private Boolean fl_entrada_servico;

    
    public EmpreendimentoDetalhe()
    {
    	this.fl_piscina = false;
    	this.fl_quadra_poliesportiva = false;
    	this.fl_playground = false;
    	this.fl_portaria_24_horas = false;
    	this.fl_entrada_servico = false;
    }
    
    /**
     * @return the id_empreendimento_detalhe
     */
    public int getId_empreendimento_detalhe() {
        return id_empreendimento_detalhe;
    }

    /**
     * @param id_empreendimento_detalhe the id_empreendimento_detalhe to set
     */
    public void setId_empreendimento_detalhe(int id_empreendimento_detalhe) {
        this.id_empreendimento_detalhe = id_empreendimento_detalhe;
    }

    /**
     * @return the empreendimento
     */
    public Empreendimento getEmpreendimento() {
        return empreendimento;
    }

    /**
     * @param empreendimento the empreendimento to set
     */
    public void setEmpreendimento(Empreendimento empreendimento) {
        this.empreendimento = empreendimento;
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
     * @return the fl_playground
     */
    public Boolean getFl_playground() {
        return fl_playground;
    }

    /**
     * @param fl_playground the fl_playground to set
     */
    public void setFl_playground(Boolean fl_playground) {
        this.fl_playground = fl_playground;
    }

    /**
     * @return the fl_portaria_24_horas
     */
    public Boolean getFl_portaria_24_horas() {
        return fl_portaria_24_horas;
    }

    /**
     * @param fl_portaria_24_horas the fl_portaria_24_horas to set
     */
    public void setFl_portaria_24_horas(Boolean fl_portaria_24_horas) {
        this.fl_portaria_24_horas = fl_portaria_24_horas;
    }

    /**
     * @return the fl_entrada_servico
     */
    public Boolean getFl_entrada_servico() {
        return fl_entrada_servico;
    }

    /**
     * @param fl_entrada_servico the fl_entrada_servico to set
     */
    public void setFl_entrada_servico(Boolean fl_entrada_servico) {
        this.fl_entrada_servico = fl_entrada_servico;
    }
   
    
}
