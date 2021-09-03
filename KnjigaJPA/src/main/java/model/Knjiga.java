package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the knjiga database table.
 * 
 */
@Entity
@NamedQuery(name="Knjiga.findAll", query="SELECT k FROM Knjiga k")
public class Knjiga implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKnjiga;

	private String autor;

	private double cena;

	private String naslov;

	private String nazivProdavnice;

	private String oblast;

	private String opis;

	private String slika;

	//bi-directional many-to-one association to Kategorija
	@OneToMany(mappedBy="knjiga")
	private List<Kategorija> kategorijas;

	//bi-directional many-to-one association to Utisak
	@OneToMany(mappedBy="knjiga")
	private List<Utisak> utisaks;

	public Knjiga() {
	}

	public int getIdKnjiga() {
		return this.idKnjiga;
	}

	public void setIdKnjiga(int idKnjiga) {
		this.idKnjiga = idKnjiga;
	}

	public String getAutor() {
		return this.autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public double getCena() {
		return this.cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public String getNaslov() {
		return this.naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getNazivProdavnice() {
		return this.nazivProdavnice;
	}

	public void setNazivProdavnice(String nazivProdavnice) {
		this.nazivProdavnice = nazivProdavnice;
	}

	public String getOblast() {
		return this.oblast;
	}

	public void setOblast(String oblast) {
		this.oblast = oblast;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getSlika() {
		return this.slika;
	}

	public void setSlika(String slika) {
		this.slika = slika;
	}

	public List<Kategorija> getKategorijas() {
		return this.kategorijas;
	}

	public void setKategorijas(List<Kategorija> kategorijas) {
		this.kategorijas = kategorijas;
	}

	public Kategorija addKategorija(Kategorija kategorija) {
		getKategorijas().add(kategorija);
		kategorija.setKnjiga(this);

		return kategorija;
	}

	public Kategorija removeKategorija(Kategorija kategorija) {
		getKategorijas().remove(kategorija);
		kategorija.setKnjiga(null);

		return kategorija;
	}

	public List<Utisak> getUtisaks() {
		return this.utisaks;
	}

	public void setUtisaks(List<Utisak> utisaks) {
		this.utisaks = utisaks;
	}

	public Utisak addUtisak(Utisak utisak) {
		getUtisaks().add(utisak);
		utisak.setKnjiga(this);

		return utisak;
	}

	public Utisak removeUtisak(Utisak utisak) {
		getUtisaks().remove(utisak);
		utisak.setKnjiga(null);

		return utisak;
	}

}