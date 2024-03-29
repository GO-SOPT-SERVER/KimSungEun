package sopt.org.SecondSeminar.controller.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sopt.org.SecondSeminar.controller.user.dto.request.RegisterRequestDto;
import sopt.org.SecondSeminar.service.user.UserService;

import static sopt.org.SecondSeminar.SecondSeminarApplication.userList;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public String register(@RequestBody final RegisterRequestDto request){

        // 서비스 계층에 유저를 등록하는 메서드를 호출
        Long userId = userService.register(request);
        System.out.println(userList.get(userId.intValue()-1).toString());
        return "유저 등록이 완료됐습니다";
    }

    @GetMapping("/user/{userId}")
    public String getOne(@PathVariable final Long userId){
        System.out.println("요청 유저 아이디: "+userId);
        // 서비스 계층에서 유저 아이디로 유저를 찾는 메서드 호출
        System.out.println(userService.getOne(userId).toString());
        return "유저 조회 성공";
    }

    @GetMapping("/user/search")
    public String search(@RequestParam final String name){
        System.out.println("유저 이름 검색 인자: "+name);
        System.out.println(userService.search(name).toString());
        return "유저 검색 성공";
    }
}
