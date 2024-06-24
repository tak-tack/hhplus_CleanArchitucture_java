package org.hhplus.cleanarchitucture.lectures.controller;

import lombok.RequiredArgsConstructor;
import org.hhplus.cleanarchitucture.lectures.model.dto.LectureDto;
import org.hhplus.cleanarchitucture.lectures.service.LectureService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lecture")
@RequiredArgsConstructor // 생성자를 받겠다고 선언했는데 생성자에서 받을때 service 이 필요함
public class LectureController {

    private final LectureService lectureService;
    /*
    - 정확하게 30명의 사용자에게만 특강을 제공할 방법을 고민해 봅니다.
    - 같은 사용자에게 여러 번의 특강 슬롯이 제공되지 않도록 제한할 방법을 고민해 봅니다.
     */
    /*
    특강 신청 API
    - TODO -
    - 특정 userId 로 선착순으로 제공되는 특강을 신청하는 API 를 작성합니다.
    - 동일한 신청자는 한 번의 수강 신청만 성공할 수 있습니다.
    - 특강은 `4월 20일 토요일 1시` 에 열리며, 선착순 30명만 신청 가능합니다.
    - 이미 신청자가 30명이 초과되면 이후 신청자는 요청을 실패합니다.
    - 어떤 유저가 특강을 신청했는지 히스토리를 저장해야한다.
    POST /lectures/apply
     */
    //private LectureDto lectureDto =new LectureDto();
    @PostMapping("/apply")
    public void specialLectureApp(/*@RequestBody LectureDto dto*/){ // 넌 void 타입이여 반환할 필요없으니 (요구사항에 userId 반환x) 근데 파람값도 필요없니?
        //LectureDto lectureDto = new LectureDto();
        //return lectureDto;

    }

    /*
    특강 신청 완료 여부 조회 API
    - 특정 userId 로 특강 신청 완료 여부를 조회하는 API 를 작성합니다.
    - 특강 신청에 성공한 사용자는 성공했음을, 특강 등록자 명단에 없는 사용자는 실패했음을 반환합니다. (true, false)
    GET /lectures/{userId}/application/
     */
    @GetMapping("{id}/application")
    public boolean specialLectureCheck(@PathVariable Long id){
        return lectureService.check(id);

    }

    /*

    특강 선택 API
    - 단 한번의 특강을 위한 것이 아닌 날짜별로 특강이 존재할 수 있는 범용적인 서비스로 변화시켜 봅니다.
    - 이를 수용하기 위해, 특강 엔티티의 경우 기존의 설계에서 변경되어야 합니다.
    - 특강의 정원은 30명으로 고정이며, 사용자는 각 특강에 신청하기전 목록을 조회해볼 수 있어야 합니다.
    - 추가로 정원이 특강마다 다르다면 어떻게 처리할것인가..? 고민해 보셔라~
    GET /lectures
     */
    @GetMapping("")
    public LectureDto specialLecutreChoice(){
        LectureDto lectureDto = new LectureDto();
        return lectureDto;
    }

}

