package e5.proyectoCIRSB.aportesMensuales;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import e5.proyectoCIRSB.usuarios.UsuariosEntity;

@Entity
@Table(name="aportesmensuales")
public class AportesEntity {

	
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int idAporte;
		
		private float valor; 
		private Date fecha;
		 
		 @ManyToMany(fetch=FetchType.EAGER)
		 @JoinTable(name="usuariosaportes", joinColumns=@JoinColumn(name="idAporte"), inverseJoinColumns=@JoinColumn(name="ciUsuario"))
		 private List<UsuariosEntity> usuarios; 
		 
		 @PrePersist 
		    public void prePersist() {
		    	fecha = new Date(); 
		    }
		 
		 public int getIdAporte() {
				return idAporte;
		}
		 
		public void setIdAporte(int idAporte) {
			this.idAporte = idAporte;
		}
			
		 public float getvalor() {
				return valor;
		}
		 
		public Boolean setvalor(float valor) {
			if (valor >= 0) {
				this.valor = valor;
			    return true;
			}
			else 
				return false;
		}
		
		public Date getFecha() {
			return fecha;
		}
		
		public Boolean setFecha(Date fecha) {
			int year = fecha.getYear();
			
			if (year > 2018) {
				this.fecha = fecha; 
				return true;
			} 
			else 
				return false;
		}
}
	

