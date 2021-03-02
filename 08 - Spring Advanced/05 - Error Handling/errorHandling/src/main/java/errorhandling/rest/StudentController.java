package errorhandling.rest;

import errorhandling.mvc.HelloException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class StudentController {

    @GetMapping("/student")
    public ResponseEntity<Student> getStudent(){
        //arrays
        throw new StudentNotFoundException("I could not find the student :(");
//        return ResponseEntity.notFound().build();
    }

//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ExceptionHandler({StudentNotFoundException.class})
//    public ResponseEntity<Student> handleHelloException(){
//        return ResponseEntity
//                .ok(new Student().setName("default").setAge(34));
//
//    }

}
