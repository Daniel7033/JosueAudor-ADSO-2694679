package com.sena.seguridad.Service;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
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
	@Lazy
    private final IPersonService personService;

    public ClienteService(@Lazy IPersonService personService, IClienteRepository repository) {
        this.repository = repository;
		this.personService = personService;
    }
	
	@Override
	public Cliente savePersonCustomer(Person entity) throws Exception {
	    Person person = personService.save(entity);
        Cliente entityCliente = new Cliente();
		System.out.println("persn " + entity.getTypeDocument());
	    String codeCliente = GenerateCodeCliente(person.getId(), entity.getTypeDocument(), person.getDocument());
	    entityCliente.setCode(codeCliente);
	    entityCliente.setPersonId(person);
	    entityCliente.setState(entity.getState());
	    entityCliente.setCreatedAt(LocalDateTime.now());
	    entityCliente.setCreatedBy((long) 1);
	    Cliente cliente = repository.save(entityCliente);
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
			String newCode = GenerateCodeCliente(person.getId(), person.getTypeDocument(), person.getDocument());
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
	public String GenerateCodeCliente(Long personId, String typeDocument, String document) throws Exception {

		Optional<Person> personOptional = personService.findById(personId);
		
		if (personOptional.isPresent()) {
			Person person = personOptional.get();
			
			if (document.length() >= 4) {
				String documentDigits = document.substring(Math.max(0, document.length() - 4));
				
				LocalDateTime creationDate = person.getCreatedAt();
				int year = creationDate.getYear();
				
				// Combinar los elementos para formar el código
				String code = year + "-" + typeDocument + "-" + documentDigits;
				return code;
			} else {
				throw new IllegalArgumentException("Document length is less than 4 characters");
			}
		} else {
			throw new IllegalArgumentException("Person with id " + personId + " not found");
		}
	}
	
	@Override
	public List<IClienteDTO> getList() {
		return repository.getList();
	}

	@Override
	public Cliente findByPersonId(Long personId) throws Exception {
		return repository.findByPersonId(personId);
	}

	@Override
	public void updatePerson(Long personId, Person entity) throws Exception {
		//Obtener el Id de la persona con la que se relaciona
		Optional<Person> op = personService.findById(personId);
		//----------------------------------------------------------------
	    if (op.isEmpty()) {
            throw new Exception("Registro no encontrado");
        } else if (op.get().getDeletedAt() != null) {
            throw new Exception("Registro inhabilitado");
        }
		//----------------------------------------------------------
        LocalDateTime createdAt = op.get().getCreatedAt();

	    Person entityUpdate = op.get();

        String[] ignoreProperties = { "id", "createdAt", "deletedAt", "createdBy", "deletedBy" };
        BeanUtils.copyProperties(entity, entityUpdate, ignoreProperties);
        entityUpdate.setUpdatedAt(LocalDateTime.now());
        entityUpdate.setUpdatedBy((long)1); //Cuanto esté el loggin, se debe enviar el ID del usuario con Auth
        personService.save(entityUpdate);

        //Enlisto todo Cliente en el objeto data
        List<Cliente> data = all();

        
        Long idPerson = personId;
        Long clienteId = null;

        for (Cliente customers : data) {
            if (customers.getPersonId().getId().equals(idPerson)) {
                clienteId = customers.getId();
                // Actualizar el código de cliente
                String codeCustomer = GenerateCodeCliente(entityUpdate.getId(), entityUpdate.getTypeDocument(), entityUpdate.getDocument());
                // Obtener el cliente de la base de datos
                Optional<Cliente> customerOpt = repository.findById(clienteId);
                if (customerOpt.isPresent()) {
                    Cliente customer = customerOpt.get();
                    customer.setCode(codeCustomer);
                    repository.save(customer);
                } else {
                    throw new Exception("No se encontró el cliente con el ID: " + clienteId);
                }

                break; // Salir del bucle una vez que se haya encontrado el cliente
            }
        }
	}



}
