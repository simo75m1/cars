package dat3.cars.api;

import dat3.cars.dto.MemberRequest;
import dat3.cars.dto.MemberResponse;
import dat3.cars.entity.Member;
import dat3.cars.repository.MemberRepository;
import dat3.cars.service.MemberService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/members")
class MemberController {

    MemberService memberService;

    public MemberController(MemberService memberService)
    {
        this.memberService = memberService;
    }

    //Security Admin only
    @GetMapping
    List<MemberResponse> getMembers(){
        return memberService.getMembers(false);
    }
    //Security admin only
    @GetMapping(path = "/{username}")
    MemberResponse getMemberById(@PathVariable String username) throws Exception {
        return memberService.findById(username);
    }

    //Security --> Anonymous
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    MemberResponse addMember(@RequestBody MemberRequest body){
        return memberService.addMember(body);
    }
    //Security --> Admin
    @PutMapping("/{username}")
    ResponseEntity<Boolean> editMember(@RequestBody MemberRequest body, @PathVariable String username){
        return memberService.editMember(body, username);
    }
    //Security ADMIN
    @PatchMapping("/ranking/{username}/{value}")
    void setRankingForUser(@PathVariable String username, @PathVariable int value) {
        memberService.setRankingForUser(username,value);
    }

    // Security ADMIN
    @DeleteMapping("/{username}")
    void deleteMemberByUsername(@PathVariable String username) {
        memberService.deleteMemberByUsername(username);
    }
}

