package com.sena.biblioteca.backend.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.biblioteca.backend.DTO.ApiResponseDto;
import com.sena.biblioteca.backend.DTO.RegistroDto;
import com.sena.biblioteca.backend.Entity.Registro;
import com.sena.biblioteca.backend.IService.IRegistroService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/registro")
public class RegistroController extends ABaseController<Registro, IRegistroService>{

	protected RegistroController(IRegistroService service) {
		super(service, "Registro");
		// TODO Auto-generated constructor stub
	}
    
	@GetMapping("/registros")
		public ResponseEntity<ApiResponseDto<List<RegistroDto>>> show(){
			try{
				return ResponseEntity.ok(new ApiResponseDto<List<RegistroDto>>("Datos obtenidos", service.getCantidadLibros(), true));
			} catch (Exception e){
				return ResponseEntity.internalServerError().body(new ApiResponseDto<List<RegistroDto>>(e.getMessage(), null, false));
			}
	}

}