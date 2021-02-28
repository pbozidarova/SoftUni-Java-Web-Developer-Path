package hateoas.web;

import hateoas.model.Course;
import hateoas.model.OrdersDto;
import hateoas.model.Student;
import hateoas.repository.OrderRepository;
import hateoas.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/students")
public class StudentsController {


    private final StudentRepository studentRepository;
    private final OrderRepository orderRepository;

    public StudentsController(StudentRepository studentRepository,
                              OrderRepository orderRepository) {
        this.studentRepository = studentRepository;
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<Student>>> getAllStudents() {
        List<EntityModel<Student>> allStudents =
                this.
                        studentRepository.
                        findAll().
                        stream().
                        map(s -> EntityModel.of(s, getStudentLinks(s))).
                        collect(toList());

        return ResponseEntity.ok(
                CollectionModel.of(allStudents,
                        linkTo(methodOn(StudentsController.class).getAllStudents()).withSelfRel()));
    }

    @GetMapping("/{id}/orders")
    public ResponseEntity<CollectionModel<EntityModel<OrdersDto>>>
    getAllOrdersByStudentId(@PathVariable(name = "id") Long studentId) {

        List<EntityModel<OrdersDto>> orders =
                orderRepository.findAllByStudentId(studentId).stream().
                        map(OrdersDto::asDto).
                        map(dto -> EntityModel.of(dto)).collect(Collectors.toList());

        return ResponseEntity.ok(
                CollectionModel.of(orders,
                        linkTo(methodOn(StudentsController.class).getAllOrdersByStudentId(studentId)).withSelfRel()));

    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Student>> getStudent(@PathVariable("id") Long id) {
        Optional<Student> courseOpt =
                this.studentRepository.findById(id);

        return courseOpt.map(
                s -> EntityModel.of(s, getStudentLinks(s))
        ).map(ResponseEntity::ok).
                orElse(ResponseEntity.notFound().build());
    }

    private Link[] getStudentLinks(Student student) {
        Link self = linkTo(methodOn(StudentsController.class).getStudent(student.getId())).withSelfRel();
        Link orders = linkTo(methodOn(StudentsController.class).getAllOrdersByStudentId(student.getId())).withRel("orders");

        return List.of(self,orders).toArray(new Link[0]);
    }
}