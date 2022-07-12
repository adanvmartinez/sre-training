
package springrest

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletResponse;


@org.springframework.web.bind.annotation.RestController
class RestController {


    ArrayList<Student> students = new ArrayList<>();

    RestController() {
        this.students = new ArrayList<>()
        Student s1 = new Student(1, "David", "Smith", 20, "Computer Science");
        students.add(s1);
        Student s2 = new Student(2, "Bob", "Jones", 21, "Bussines Administration");
        students.add(s2);
    }
//students.add(s1);

    @RequestMapping(value="/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String home(){
        String message ="{\"message\":\"Hello from the Spring REST homepage\"}"
        return message
    }

    //@RequestMapping(value="/post", method= RequestMethod.POST)
    @PostMapping("/post")
    @ResponseBody
    public String post(@RequestBody String string){
        println(string);
        return string;
    }

    @GetMapping("/students")
    @ResponseBody
    public String students(){

        ObjectMapper mapper = new ObjectMapper()
        mapper.enable(SerializationFeature.INDENT_OUTPUT)

        String json = mapper.writeValueAsString(students)

        return json;
    }

    @PostMapping("/students")
    @ResponseBody
    public String postStudents(@RequestBody String student){

        println(student)
        ObjectMapper mapper = new ObjectMapper()
        mapper.enable(SerializationFeature.INDENT_OUTPUT)

        Student newStudent = mapper.readValue(student.toString(), Student.class)
        students.add(newStudent)

        return mapper.writeValueAsString(students);
    }

    @PutMapping("/students")
    @ResponseBody
    public String putStudents(@RequestBody String student){

        println(student)
        ObjectMapper mapper = new ObjectMapper()
        mapper.enable(SerializationFeature.INDENT_OUTPUT)

        Student newStudent = mapper.readValue(student.toString(), Student.class)
        for(Student s: students){
            if(s.getId() == newStudent.getId()){
                println(s.getId())
                s.setFname(newStudent.getFname())
                s.setLname(newStudent.getLname())
                s.setAge(newStudent.getAge())
                s.setMajor(newStudent.getMajor())
                break
            }
        }

        return mapper.writeValueAsString(students);
    }

    @DeleteMapping("/students")
    @ResponseBody
    public String deleteStudents(@RequestBody String student){

        println(student)
        ObjectMapper mapper = new ObjectMapper()
        mapper.enable(SerializationFeature.INDENT_OUTPUT)

        Student newStudent = mapper.readValue(student.toString(), Student.class)
        for(Student s: students){
            if(s.getId() == newStudent.getId()){
                println(s.getId())
                students.remove(s)
            }
        }

        return mapper.writeValueAsString(students);
    }
}
