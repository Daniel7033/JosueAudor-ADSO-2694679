package com.sena.seguridad.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.seguridad.DTO.IPersonDto;
import com.sena.seguridad.Entity.Person;
import com.sena.seguridad.IRepository.IBaseRepository;
import com.sena.seguridad.IRepository.IPersonRepository;
import com.sena.seguridad.IService.IPersonService;


@Service
public class PersonService extends ABaseService<Person> implements IPersonService{
	
	@Autowired
	private IPersonRepository repository;

    @Override
	protected IBaseRepository<Person, Long> getRepository() {
		return repository;
	}
	
    @Override
    public List<IPersonDto> getList() {
        return repository.getList();
    }

    @Override
	public List<IPersonDto> getDocumentByType(String typeDocument) throws Exception {
	    return repository.getDocumentByType(typeDocument);
	}
	
}
