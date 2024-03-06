package metier.entities;
import java.io.Serializable;
public class Evenement implements Serializable{
private Long idEvenement;
private String nomEvenement;
private String DateEvenement;
public Evenement() {
super();
}
public Evenement(String nomEvenement, String DateEvenement) {
super();
this.nomEvenement = nomEvenement;
this.DateEvenement = DateEvenement;
}
public Long getIdEvenement() {
return idEvenement;
}
public void setIdEvenement(Long idEvenement) {
this.idEvenement = idEvenement;
}
public String getNomEvenement() {
return nomEvenement;
}
public void setNomEvenement(String nomEvenement) {
this.nomEvenement = nomEvenement;
}
public String getDateEvenement() {
return DateEvenement;
}
public void setDateEvenement(String DateEvenement) {
this.DateEvenement = DateEvenement;
}

public String toString() {
	return "Evenement [idEvenement="+ idEvenement +", nomEvenement = "+nomEvenement +" , dateEvenement= "+DateEvenement+"]";
}
}