/** Clasa pentru 331AA
 * @author Plamadeala Victor
 * @version 10 Decembrie 2025
 */

package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Masina")
public class Masina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_masina")
    private Integer idMasina;

    private String marca;
    private String model;

    @Column(name = "an_fabricatie")
    private Integer anFabricatie;

    private Integer km;
    private Double pret;

    @ManyToOne
    @JoinColumn(name = "id_cumparator")
    private Client cumparator;

    public Masina() {}

    public Masina(Integer idMasina, String marca, String model, Integer anFabricatie, Integer km, Double pret, Client cumparator) {
        this.idMasina = idMasina;
        this.marca = marca;
        this.model = model;
        this.anFabricatie = anFabricatie;
        this.km = km;
        this.pret = pret;
        this.cumparator = cumparator;
    }

    public Integer getIdMasina() { return idMasina; }
    public void setIdMasina(Integer idMasina) { this.idMasina = idMasina; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public Integer getAnFabricatie() { return anFabricatie; }
    public void setAnFabricatie(Integer anFabricatie) { this.anFabricatie = anFabricatie; }
    public Integer getKm() { return km; }
    public void setKm(Integer km) { this.km = km; }
    public Double getPret() { return pret; }
    public void setPret(Double pret) { this.pret = pret; }
    public Client getCumparator() { return cumparator; }
    public void setCumparator(Client cumparator) { this.cumparator = cumparator; }
}