package com.supinfo.formation.dto;

import com.supinfo.formation.annotation.CheckEmail;
import io.swagger.annotations.ApiModel;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@ApiModel()
public class ProfesseurDto extends AbstractDto<Long> {

    private long id;
    private String nom;
    private String prenom;
    private String telephone;
    @Email
    private String email;

    @Size(max = 255)
    private String matricule;

    public ProfesseurDto() {
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getMatricule() {
        return this.matricule;
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