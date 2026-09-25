package med.voll.api.infra;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> tratarErro404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<erro400Dto>> tratarErro400(MethodArgumentNotValidException e) {
        var erros = e.getFieldErrors().stream()
                .map(erro400Dto::new).toList();

        return ResponseEntity.badRequest().body(erros);
    }

    private record erro400Dto(String field, String defaultMessage) {
        erro400Dto(FieldError fieldError) {
            this(fieldError.getField(), fieldError.getDefaultMessage());
        }
    }

}
