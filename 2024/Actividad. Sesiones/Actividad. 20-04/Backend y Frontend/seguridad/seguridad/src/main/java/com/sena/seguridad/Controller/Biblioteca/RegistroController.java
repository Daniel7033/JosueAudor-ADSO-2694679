package com.sena.seguridad.Controller.Biblioteca;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.seguridad.Controller.ABaseController;
import com.sena.seguridad.DTO.ApiResponseDto;
import com.sena.seguridad.DTO.Biblioteca.RegistroDto;
import com.sena.seguridad.Entity.Registro;
import com.sena.seguridad.IService.Biblioteca.IRegistroService;

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