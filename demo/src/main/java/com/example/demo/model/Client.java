/** Clasa pentru 331AA
 * @author Plamadeala Victor
 * @version 10 Decembrie 2025
 */

package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Integer idClient;

    private String nume;
    private String prenume;

    @Column(unique = true, nullable = false, length = 13)
    private String cnp;

    @OneToMany(mappedBy = "cumparator")
    private List<Masina> masini;

    public Client() {
    }

    public Client(Integer idClient, String nume, String prenume, String cnp) {
        this.idClient = idClient;
        this.nume = nume;
        this.prenume = prenume;
        this.cnp = cnp;
    }

    // 3. Gettere și Settere
    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
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

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public List<Masina> getMasini() {
        return masini;
    }

    public void setMasini(List<Masina> masini) {
        this.masini = masini;
    }
}