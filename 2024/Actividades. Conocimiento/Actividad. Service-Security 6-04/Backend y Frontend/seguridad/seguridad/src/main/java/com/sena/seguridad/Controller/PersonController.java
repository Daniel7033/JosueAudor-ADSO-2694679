package com.sena.seguridad.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.seguridad.DTO.ApiResponseDto;
import com.sena.seguridad.DTO.IPersonDto;
import com.sena.seguridad.Entity.Person;
import com.sena.seguridad.IService.IPersonService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/person")
public class PersonController extends ABaseController<Person, IPersonService> {
    public PersonController(IPersonService service) {
        super(service, "Person");

    }

    @GetMapping("/list")
    public ResponseEntity<ApiResponseDto<List<IPersonDto>>> show() {
        try {
            List<IPersonDto> entity = service.getList();
            return ResponseEntity.ok(new ApiResponseDto<List<IPersonDto>>("Registro encontrado", entity, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(new ApiResponseDto<List<IPersonDto>>(e.getMessage(), null, false));
        }
    }

    @GetMapping("/{typeDocument}")
    public ResponseEntity<ApiResponseDto<List<IPersonDto>>> show(@PathVariable String typeDocument) {
        try {
            List<IPersonDto> entity = service.getDocumentByType(typeDocument);
            return ResponseEntity.ok(new ApiResponseDto<List<IPersonDto>>("Registro encontrado", entity, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(new ApiResponseDto<List<IPersonDto>>(e.getMessage(), null, false));
        }
    }
    
}
