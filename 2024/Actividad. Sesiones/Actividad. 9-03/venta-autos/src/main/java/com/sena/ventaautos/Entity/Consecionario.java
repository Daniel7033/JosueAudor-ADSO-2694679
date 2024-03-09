package com.sena.ventaautos.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "consecionario")
public class Consecionario extends ABaseEntity{
    
    @Column(name = "name", length = 50, nullable = false)
    private String name;
    
    @Column(name = "address", length = 50, nullable = false)
    private String address;
    
    @Column(name = "phone", length = 20, nullable = false)
    private String phone;
    
    @Column(name = "email", length = 150, nullable = false)
    private String email;
    
    @Column(name = "numer_workes", nullable = false)
    private Integer numerWorkes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getNumerWorkes() {
        return numerWorkes;
    }

    public void setNumerWorkes(Integer numerWorkes) {
        this.numerWorkes = numerWorkes;
    }

    
}
