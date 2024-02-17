package com.sena.servicesecurity.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "module")
public class Module extends ABaseEntity {

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "descriprion", length = 100, nullable = false)
    private String descriprion;

    @Column(name = "route", length = 50, nullable = false)
    private String route;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriprion() {
        return descriprion;
    }

    public void setDescriprion(String descriprion) {
        this.descriprion = descriprion;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

}
