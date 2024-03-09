package com.sena.ventaautos.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer extends ABaseEntity{
    
    @Column(name = "name", length = 50, nullable = false)
    private String name;
    
    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;
    
    @Column(name = "phone", length = 20, nullable = false)
    private String phone;
    
    @Column(name = "email", length = 150, nullable = false)
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    
}
