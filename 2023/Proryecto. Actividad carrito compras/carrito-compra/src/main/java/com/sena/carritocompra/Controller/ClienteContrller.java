package com.sena.carritocompra.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import com.sena.carritocompra.Entity.Cliente;
import com.sena.carritocompra.IService.IClienteService;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("v1/api/cliente")
public class ClienteContrller {
	@Autowired
	private IClienteService service;
	
	@GetMapping
	public List<Cliente> findAll() {
		return service.findAll();
	}
	
	@GetMapping("{id}")
	public Optional<Cliente> findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public Cliente save(@RequestBody Cliente cliente) {
		return service.save(cliente);
	}
	
	@PutMapping("{id}")
	public void save(@RequestBody Cliente cliente, @PathVariable  Long id) {
		service.update(cliente, id);
	}
	
	@PutMapping("deleted-at/{id}")
	public void deletedAt(@PathVariable  Long id) {
		service.deletedAt(id);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable  Long id) {
		service.delete(id);
	}
}
