package pe.edu.cibertec.apirestdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.apirestdemo.model.ResultadoResponse;

@RestController
@RequestMapping("api/operacion")
public class OperacionController {

    @GetMapping("")
    public ResponseEntity<String> saludoRest(){
        return new ResponseEntity<>("Hola Mundo", HttpStatus.OK);
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<ResultadoResponse> saludoConParametro(@PathVariable("nombre") String nombre){
        ResultadoResponse response= ResultadoResponse.builder().respuesta(true).mensaje("Hola "+ nombre+ " Bienvenido!").build();

        return new ResponseEntity<ResultadoResponse>(response,HttpStatus.OK);
    }

    @GetMapping("/parametro")
    public ResponseEntity<ResultadoResponse> saludoConParametros(@RequestParam(value = "nombre") String nombre, //Especificando nombre del parametro
                                                                 @RequestParam(value = "apematerno", required = false, defaultValue = "sin apellido") String apellidoMaterno){
        ResultadoResponse response= ResultadoResponse.builder().respuesta(true).mensaje("Hola "+ nombre+ " " +apellidoMaterno+ " Bienvenido!").build();

        return new ResponseEntity<ResultadoResponse>(response,HttpStatus.OK);
    }
}
