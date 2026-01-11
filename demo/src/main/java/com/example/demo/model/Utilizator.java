/** Clasa pentru 331AA
 * @author Plamadeala Victor
 * @version 10 Decembrie 2025
 */


package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Utilizator")
public class Utilizator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_utilizator")
    private Integer idUtilizator;

    @Column(unique = true, nullable = false)
    private String username;

    private String parola;
    private String mail;
    private String telefon;
    private String nume;
    private String prenume;

    public Utilizator() {
    }

    public Utilizator(Integer idUtilizator, String username, String parola, String mail, String telefon, String nume, String prenume) {
        this.idUtilizator = idUtilizator;
        this.username = username;
        this.parola = parola;
        this.mail = mail;
        this.telefon = telefon;
        this.nume = nume;
        this.prenume = prenume;
    }

    public Integer getIdUtilizator() {
        return idUtilizator;
    }

    public void setIdUtilizator(Integer idUtilizator) {
        this.idUtilizator = idUtilizator;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }
}