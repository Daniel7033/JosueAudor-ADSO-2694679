package com.sena.ventaautos.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "seller")
public class Seller extends ABaseEntity{
    
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;
    
    @Column(name = "second_name", length = 50, nullable = false)
    private String secondName;
    
    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;
    
    @Column(name = "phone", length = 20, nullable = false)
    private String phone;
    
    @Column(name = "email", length = 150, nullable = false)
    private String email;
    
    @Column(name = "carge", length = 50, nullable = false)
    private String carge;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getCarge() {
        return carge;
    }

    public void setCarge(String carge) {
        this.carge = carge;
    }

}
