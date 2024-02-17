package main.java.com.sena.servicesecurity.IRepository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import com.sena.servicesecurity.Entity.Person;

@Repository
public interface IPersonRepository extends IBaseRepository<Person, Long>{
    @Query(value = "SELECT" 
    + "id, "
    + "CONCAT(first_name, ' ', last_name) as 'Nombre completo'"
    + "FROM " 
    + "person", nativeQuery = true)
    List<IPersonDto> getListPerson();
}
