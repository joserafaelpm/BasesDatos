package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the propina database table.
 * 
 */
@Entity
@Table(name="propina")
@NamedQuery(name="Propina.findAll", query="SELECT p FROM Propina p")
public class Propina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechahora;

	private float propina;

	//bi-directional many-to-one association to Camarero
	@ManyToOne
	private Camarero camarero;

	public Propina() {
	}

	public Date getFechahora() {
		return this.fechahora;
	}

	public void setFechahora(Date fechahora) {
		this.fechahora = fechahora;
	}

	public float getPropina() {
		return this.propina;
	}

	public void setPropina(float propina) {
		this.propina = propina;
	}

	public Camarero getCamarero() {
		return this.camarero;
	}

	public void setCamarero(Camarero camarero) {
		this.camarero = camarero;
	}

}