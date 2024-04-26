package com.sena.seguridad.Controller.Compañia;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sena.seguridad.Controller.ABaseController;
import com.sena.seguridad.DTO.ApiResponseDto;
import com.sena.seguridad.DTO.Compañia.IClienteDTO;
import com.sena.seguridad.Entity.Cliente;
import com.sena.seguridad.Entity.Person;
import com.sena.seguridad.IService.Compañia.IClienteService;

import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/cliente")
public class ClienteController extends ABaseController<Cliente, IClienteService> {

    protected ClienteController(IClienteService service) {
        super(service, "Cliente");
        // TODO Auto-generated constructor stub
    }

    @Autowired
    private IClienteService clienteService;

    @GetMapping("/list")
    public ResponseEntity<ApiResponseDto<List<IClienteDTO>>> show() {
        try {
            List<IClienteDTO> entity = clienteService.getList();
            return ResponseEntity.ok(new ApiResponseDto<List<IClienteDTO>>("Registro encontrado", entity, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(new ApiResponseDto<List<IClienteDTO>>(e.getMessage(), null, false));
        }
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<ApiResponseDto<Optional<Cliente>>> show(@PathVariable Long id) {
        try {
            Optional<Cliente> entity = service.findById(id);
            return ResponseEntity.ok(new ApiResponseDto<Optional<Cliente>>("Registro encontrado", entity, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<Optional<Cliente>>(e.getMessage(), null, false));
        }
    }

    @PostMapping("/personCliente")
    public ResponseEntity<ApiResponseDto<Cliente>> save(@RequestBody Person entity) {
        try {
            System.out.println(entity);
            return ResponseEntity
                    .ok(new ApiResponseDto<Cliente>("Datos guardados", service.savePersonCustomer(entity), true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<Cliente>(e.getMessage(), null, false));
        }
    }

    @PutMapping("/personCliente/{id}")
    public ResponseEntity<ApiResponseDto<Cliente>> update(@PathVariable Long id, @RequestBody Person entity) {
        try {
            clienteService.updatePerson(id, entity);
            return ResponseEntity
                    .ok(new ApiResponseDto<Cliente>("Datos guardados", null, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<Cliente>(e.getMessage(), null, false));
        }
    }
}
