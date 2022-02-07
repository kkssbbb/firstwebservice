package com.firstwebservice.firstwebservice.web.dto;

import com.firstwebservice.firstwebservice.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {  //페이지관련 컨트롤러는 모두 IndexController사용

 /*   @GetMapping("/") //머스테치 스타터로 컨트롤러에서 문자열 반환할 때 앞의 경로와 뒤의 파일 확장자는 자동으로 지정된다.
                         //앞의 경로는 src/main/resources/templates로, 뒤의 파일 확장자는 .mustache가 붙음
    public String index() {
        return "index";   //머스테치 스타터로 문자열 "index"를 반환할때 src/main/resources/templates/index.mustache로 전환되어 view Resolver가 처리한다.
    }
*/

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }



    private  final PostsService postsService;
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";

    }


}
