package com.sena.seguridad.Service;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.seguridad.DTO.IClienteDTO;
import com.sena.seguridad.DTO.IPersonDto;
import com.sena.seguridad.Entity.Cliente;
import com.sena.seguridad.Entity.Person;
import com.sena.seguridad.IRepository.IBaseRepository;
import com.sena.seguridad.IRepository.IClienteRepository;
import com.sena.seguridad.IService.IClienteService;
import com.sena.seguridad.IService.IPersonService;

@Service
public class ClienteService extends ABaseService<Cliente> implements IClienteService{

	
	@Override
	protected IBaseRepository<Cliente, Long> getRepository(){
		return repository;
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
        
	    String codeCliente = GenerateCodeCliente(person.getId(), person.getTypeDocument(), person.getDocument(), person.getCreatedAt());
	    
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
			IPersonDto person = repository.getDocument(entity.getPersonId().getId());
			
			String type= person.getTypeDocument();
			String document = person.getDocument();
			// Obtener el año actual
			int currentYear = LocalDate.now().getYear();

			// Obtener los últimos 4 dígitos de document
			String documentSuffix = document.substring(Math.max(0, document.length() - 4));

			// Combinar los elementos para formar el código
			String code = currentYear + "-" + type + "-" + documentSuffix;
			
			entity.setCode(code);
            entity.setCreatedAt(LocalDateTime.now());
            entity.setCreatedBy((long)1); //Cuanto esté el loggin, se debe enviar el ID del usuario con Auth
            return getRepository().save(entity);
        } catch (Exception e) {
            // Captura la excepción
            throw new Exception("Error al guardar la entidad: " + e.getMessage());
        }
	}
	
	
	public List<IClienteDTO> searchClientData(String term) {
        return clienteRepository.searchClientData(term);
    }

	@Override
	public void update(Long id, Cliente entity) throws Exception {
	    Optional<Cliente> opClient = getRepository().findById(id);

	    if (opClient.isEmpty()) {
	        throw new Exception("Registro no encontrado");
	    } else if (opClient.get().getDeletedAt() != null) {
	        throw new Exception("Registro inhabilitado");
	    }

	    Cliente existingClient = opClient.get();
		Person PersonExist = existingClient.getPersonId();
	    if (!PersonExist.getDocument().equals(entity.getPersonId().getDocument())) {
	        Person person = entity.getPersonId();
			String newCode = GenerateCodeCliente(person.getId(), person.getTypeDocument(), person.getDocument(), entity.getCreatedAt());
			existingClient.setCode(newCode);
		}

		
        // Copiar propiedades desde la entidad de entrada a la existente, ignorando campos no actualizables
        String[] ignoreProperties = { "id", "createdAt", "deletedAt", "createdBy", "deletedBy", "code" };
        BeanUtils.copyProperties(entity, existingClient, ignoreProperties);
        
        // Actualizar las propiedades adicionales
        existingClient.setUpdatedAt(LocalDateTime.now());
        existingClient.setUpdatedBy((long)1); // Cuanto esté el loggin, se debe enviar el ID del usuario con Auth
        
        // Guardar la entidad actualizada
        getRepository().save(existingClient);
	}


	@Override
	public String GenerateCodeCliente(Long personId, String typeDocument, String document, LocalDateTime date) throws Exception {
		String documentDigits = document.substring(Math.max(0,document.length()  -4 ));
		String code = date.getYear() + "-" + typeDocument + "-" + documentDigits;
		return code;
	}


}
