package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the korisnik database table.
 * 
 */
@Entity
@NamedQuery(name="Korisnik.findAll", query="SELECT k FROM Korisnik k")
public class Korisnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKorisnik;

	private String ime;

	private String password;

	private String prezime;

	private String username;

	//bi-directional many-to-one association to Tema
	@OneToMany(mappedBy="korisnik")
	private List<Tema> temas;

	//bi-directional many-to-one association to Utisak
	@OneToMany(mappedBy="korisnik")
	private List<Utisak> utisaks;

	public Korisnik() {
	}

	public int getIdKorisnik() {
		return this.idKorisnik;
	}

	public void setIdKorisnik(int idKorisnik) {
		this.idKorisnik = idKorisnik;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Tema> getTemas() {
		return this.temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}

	public Tema addTema(Tema tema) {
		getTemas().add(tema);
		tema.setKorisnik(this);

		return tema;
	}

	public Tema removeTema(Tema tema) {
		getTemas().remove(tema);
		tema.setKorisnik(null);

		return tema;
	}

	public List<Utisak> getUtisaks() {
		return this.utisaks;
	}

	public void setUtisaks(List<Utisak> utisaks) {
		this.utisaks = utisaks;
	}

	public Utisak addUtisak(Utisak utisak) {
		getUtisaks().add(utisak);
		utisak.setKorisnik(this);

		return utisak;
	}

	public Utisak removeUtisak(Utisak utisak) {
		getUtisaks().remove(utisak);
		utisak.setKorisnik(null);

		return utisak;
	}

}