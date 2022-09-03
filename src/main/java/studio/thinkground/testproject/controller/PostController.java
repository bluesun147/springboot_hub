package studio.thinkground.testproject.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import studio.thinkground.testproject.dto.MemberDTO;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api") // 공통 적용
public class PostController {

    @PostMapping("/default")
    public String postMethod() {
        return "hello world! (post)";
    }

    // http://localhost:8080/api/v1/post-api/member
    @PostMapping("/member")
    public String postMember(@RequestBody Map<String, Object> postData) { // 여러개 넣을 수 있음
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    // http://localhost:8080/api/v1/post-api/member2
    @PostMapping("/member2")
    public String postMemberDto(@RequestBody MemberDTO memberDTO) { // post에서 dto 사용하려면 @RequestBody로 받아야 함. get은 안써도 됨.
        return memberDTO.toString();
    }
}
