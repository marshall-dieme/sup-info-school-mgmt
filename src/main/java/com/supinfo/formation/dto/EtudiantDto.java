package com.supinfo.formation.dto;

import com.supinfo.formation.annotation.CheckDate;
import io.swagger.annotations.ApiModel;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

@ApiModel()
public class EtudiantDto extends AbstractDto<Long> {
    private long id;
    private String nom;
    private String prenom;
    @Size(max = 20)
    private String telephone;
    @Email
    private String email;
    @CheckDate
    private Date dateNaissance;

    public EtudiantDto() {
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Date getDateNaissance() {
        return this.dateNaissance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}