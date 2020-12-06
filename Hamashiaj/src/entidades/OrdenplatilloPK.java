package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ordenplatillo database table.
 * 
 */
@Embeddable
public class OrdenplatilloPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="orden_id", insertable=true, updatable=true)
	private int ordenId;

	@Column(name="platillo_id", insertable=true, updatable=true)
	private int platilloId;

	public OrdenplatilloPK() {
	}
	public int getOrdenId() {
		return this.ordenId;
	}
	public void setOrdenId(int ordenId) {
		this.ordenId = ordenId;
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
		if (!(other instanceof OrdenplatilloPK)) {
			return false;
		}
		OrdenplatilloPK castOther = (OrdenplatilloPK)other;
		return 
			(this.ordenId == castOther.ordenId)
			&& (this.platilloId == castOther.platilloId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.ordenId;
		hash = hash * prime + this.platilloId;
		
		return hash;
	}
}