package com.sena.seguridad.Service;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.sena.seguridad.DTO.IPersonDto;
import com.sena.seguridad.Entity.Cliente;
import com.sena.seguridad.Entity.Person;
import com.sena.seguridad.IRepository.IBaseRepository;
import com.sena.seguridad.IRepository.IPersonRepository;
import com.sena.seguridad.IService.IClienteService;
import com.sena.seguridad.IService.IPersonService;

@Service
public class PersonService extends ABaseService<Person> implements IPersonService {

	@Override
	protected IBaseRepository<Person, Long> getRepository() {
		return repository;
	}

	private final IPersonRepository repository;
	@Lazy
	private final IClienteService serviceCliente;

	public PersonService(IPersonRepository repository, @Lazy IClienteService serviceCliente) {
		this.repository = repository;
		this.serviceCliente = serviceCliente;
	}

	@Override
	public List<IPersonDto> getList() {
		return repository.getList();
	}

	@Override
	public List<IPersonDto> getDocumentByType(String typeDocument) throws Exception {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getDocumentByType'");
	}

	@Override
	public void updatePersonCliente(Long id, Person person) throws Exception {

		repository.save(person);
		String codeCustomer = serviceCliente.GenerateCodeCliente(id, person.getTypeDocument(),
				person.getDocument());
		Cliente customer = serviceCliente.findByPersonId(id);
		customer.setCode(codeCustomer);
		serviceCliente.update(customer.getId(), customer);
	}

}
