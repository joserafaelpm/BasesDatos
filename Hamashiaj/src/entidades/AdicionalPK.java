package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the adicional database table.
 * 
 */
@Embeddable
public class AdicionalPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ingrediente_id", insertable=false, updatable=false)
	private int ingredienteId;

	@Column(name="platillo_id", insertable=false, updatable=false)
	private int platilloId;

	public AdicionalPK() {
	}
	public int getIngredienteId() {
		return this.ingredienteId;
	}
	public void setIngredienteId(int ingredienteId) {
		this.ingredienteId = ingredienteId;
	}
	public int getPlatilloId() {
		return this.platilloId;
	}
	public void setPlatilloId(int platilloId) {
		this.platilloId = platilloId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AdicionalPK)) {
			return false;
		}
		AdicionalPK castOther = (AdicionalPK)other;
		return 
			(this.ingredienteId == castOther.ingredienteId)
			&& (this.platilloId == castOther.platilloId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.ingredienteId;
		hash = hash * prime + this.platilloId;
		
		return hash;
	}
}