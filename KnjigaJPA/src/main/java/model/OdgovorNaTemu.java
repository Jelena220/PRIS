package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the odgovor_na_temu database table.
 * 
 */
@Entity
@Table(name="odgovor_na_temu")
@NamedQuery(name="OdgovorNaTemu.findAll", query="SELECT o FROM OdgovorNaTemu o")
public class OdgovorNaTemu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idOdgovorNaTemu;

	private String tekst;

	//bi-directional many-to-one association to Tema
	@ManyToOne
	private Tema tema;

	public OdgovorNaTemu() {
	}

	public int getIdOdgovorNaTemu() {
		return this.idOdgovorNaTemu;
	}

	public void setIdOdgovorNaTemu(int idOdgovorNaTemu) {
		this.idOdgovorNaTemu = idOdgovorNaTemu;
	}

	public String getTekst() {
		return this.tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	public Tema getTema() {
		return this.tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

}