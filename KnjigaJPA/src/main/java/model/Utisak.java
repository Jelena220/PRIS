package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the utisak database table.
 * 
 */
@Entity
@NamedQuery(name="Utisak.findAll", query="SELECT u FROM Utisak u")
public class Utisak implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUtisak;

	private String tekst;

	//bi-directional many-to-one association to Knjiga
	@ManyToOne
	private Knjiga knjiga;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	private Korisnik korisnik;

	public Utisak() {
	}

	public int getIdUtisak() {
		return this.idUtisak;
	}

	public void setIdUtisak(int idUtisak) {
		this.idUtisak = idUtisak;
	}

	public String getTekst() {
		return this.tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	public Knjiga getKnjiga() {
		return this.knjiga;
	}

	public void setKnjiga(Knjiga knjiga) {
		this.knjiga = knjiga;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

}