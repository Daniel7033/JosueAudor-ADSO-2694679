package com.sena.servicesecurity.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "view")
public class View  extends ABaseEntity { 
	
	@Column(name = "name", length = 50, nullable = false)
    private String name;
    
    @Column(name = "route", length = 50, nullable = false)
    private String route;
    
    @Column(name = "description", length = 50, nullable = false, unique = true)
    private String description;

	@JoinTable(
        name = "module_view",
        joinColumns = @JoinColumn(name = "module_id", nullable = false),
        inverseJoinColumns = @JoinColumn(name="view_id", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Module> modules;
   
    public void addView(Module module){
        if(this.modules == null){
            this.modules = new ArrayList<>();
        }
        
        this.modules.add(module);
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
}
