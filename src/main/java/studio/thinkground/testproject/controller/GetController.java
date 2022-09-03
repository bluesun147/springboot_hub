package studio.thinkground.testproject.controller;

import org.springframework.web.bind.annotation.*;
import studio.thinkground.testproject.dto.MemberDTO;

@RestController
@RequestMapping("api/v1/get-api") // 공통된 url
public class GetController {

    // http://localhost:8080/api/v1/get-api/hello
    @GetMapping("/hello")
    public String getHello() {
        return "hello world!!";
    }

    @GetMapping("variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        return variable;
    }

    // String 객체의 이름이 pathvariable 값과 동일하지 않을 때
    @GetMapping("variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var) {
        return var;
    }

    // http://localhost:8080/api/v1/get-api/request1?name=kim&email=aa@a.com
    @GetMapping("/request1")
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email) {
        return name + " " + email;
    }

    // http://localhost:8080/api/v1/get-api/request3?name=kim&email=aa.com&organization=tt
    @GetMapping("/request3")
    public String getRequestParam3(MemberDTO memberDTO) {
        return memberDTO.toString(); // MemberDTO(name=kim, email=aa.com, organization=tt)
    }

}
