package com.sena.seguridad.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.seguridad.DTO.IClienteDTO;
import com.sena.seguridad.Entity.Cliente;
import com.sena.seguridad.Entity.Person;
import com.sena.seguridad.IRepository.IBaseRepository;
import com.sena.seguridad.IRepository.IClienteRepository;
import com.sena.seguridad.IService.IClienteService;
import com.sena.seguridad.IService.IPersonService;

@Service
public class ClienteService extends ABaseService<Cliente> implements IClienteService{

	@Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
	
	@Autowired
	
	private IClienteRepository repository;
	
	@Autowired
	private IPersonService personService;

	@Autowired
	private IClienteRepository clienteRepository;
	
	
	@Override
	public Cliente savePersonCustomer(Person entity) throws Exception {
	    Person person = personService.save(entity);
	    
        Cliente entityCliente = new Cliente();
        
	    String codeCliente = GenerateCodeCliente(person.getId());
	    
	    entityCliente.setCode(codeCliente);
	    entityCliente.setPersonId(person);
	    entityCliente.setState(true);
	    entityCliente.setCreatedAt(LocalDateTime.now());
	    entityCliente.setCreatedBy((long) 1);
	    
	    Cliente cliente = save(entityCliente);
	    
	    return cliente;
	}
	
	
	@Override
	public Cliente save(Cliente entity) throws Exception {
	    try {
	       
    		String codeCliente = GenerateCodeCliente(entity.getPersonId().getId());
	        entity.setCode(codeCliente);
	        entity.setCreatedAt(LocalDateTime.now());
	        entity.setCreatedBy((long) 1); // Cuando esté el logging, se debe enviar el ID del usuario con Auth
	        return getRepository().save(entity);
	    } catch (Exception e) {
	        // Captura la excepción
	        throw new Exception("Error al guardar la entidad: " + e.getMessage());
	    }
	}
	
	public String GenerateCodeCliente(Long person) throws Exception{
		Optional<Person> personId = personService.findById(person);
		
		if(personId == null) {
			throw new Exception("Error al consultar la persona: " + personId);
		}
		
		String document = personId.get().getDocument();
		String numeroDocumento =  document.substring(Math.max(0,document.length()  -4 ));
		String code = LocalDateTime.now().getYear() + "-" + personId.get().getTypeDocument() + "-" + numeroDocumento;
		
		return code;
		
	}
	
	public List<IClienteDTO> searchClientData(String term) {
        return clienteRepository.searchClientData(term);
    }

	
	@Override
	protected IBaseRepository<Cliente, Long> getRepository(){
		return repository;
	}
	
	@Override
	public void update(Long id, Cliente entity) throws Exception {
	    Optional<Cliente> op = getRepository().findById(id);

	    if (op.isEmpty()) {
	        throw new Exception("Registro no encontrado");
	    } else if (op.get().getDeletedAt() != null) {
	        throw new Exception("Registro inhabilitado");
	    }

	    Long personId = entity.getPersonId().getId();
	    String document = repository.getDocument(personId);
	    String documentType = repository.getDocument(personId); // Obtiene el tipo de documento de la base de datos
	    if (documentType == null) {
	        throw new Exception("No se pudo obtener el tipo de documento para la persona con ID: " + personId);
	    }

	    // Obtener los primeros 4 dígitos del documento
	    String documentDigits = document.substring(0, Math.min(document.length(), 4));

	    // Obtener el año actual
	    int currentYear = LocalDate.now().getYear();

	    // Combinar los elementos para formar el código
	    String code = currentYear + "-" + documentType + "-" + documentDigits;

	    Cliente entityUpdate = op.get();

	    String[] ignoreProperties = { "id", "createdAt", "deletedAt", "createdBy", "deletedBy" };
	    BeanUtils.copyProperties(entity, entityUpdate, ignoreProperties);
	    entityUpdate.setCode(code);
	    entityUpdate.setUpdatedAt(LocalDateTime.now());
	    entityUpdate.setUpdatedBy((long) 1); // Cuando esté el logging, se debe enviar el ID del usuario con Auth
	    getRepository().save(entityUpdate);
	}
}
