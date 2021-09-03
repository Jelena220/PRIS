package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tema database table.
 * 
 */
@Entity
@NamedQuery(name="Tema.findAll", query="SELECT t FROM Tema t")
public class Tema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTema;

	private String nazivTeme;

	//bi-directional many-to-one association to OdgovorNaTemu
	@OneToMany(mappedBy="tema")
	private List<OdgovorNaTemu> odgovorNaTemus;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	private Korisnik korisnik;

	public Tema() {
	}

	public int getIdTema() {
		return this.idTema;
	}

	public void setIdTema(int idTema) {
		this.idTema = idTema;
	}

	public String getNazivTeme() {
		return this.nazivTeme;
	}

	public void setNazivTeme(String nazivTeme) {
		this.nazivTeme = nazivTeme;
	}

	public List<OdgovorNaTemu> getOdgovorNaTemus() {
		return this.odgovorNaTemus;
	}

	public void setOdgovorNaTemus(List<OdgovorNaTemu> odgovorNaTemus) {
		this.odgovorNaTemus = odgovorNaTemus;
	}

	public OdgovorNaTemu addOdgovorNaTemus(OdgovorNaTemu odgovorNaTemus) {
		getOdgovorNaTemus().add(odgovorNaTemus);
		odgovorNaTemus.setTema(this);

		return odgovorNaTemus;
	}

	public OdgovorNaTemu removeOdgovorNaTemus(OdgovorNaTemu odgovorNaTemus) {
		getOdgovorNaTemus().remove(odgovorNaTemus);
		odgovorNaTemus.setTema(null);

		return odgovorNaTemus;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

}