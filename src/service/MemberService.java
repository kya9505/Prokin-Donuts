package service;

import dto.MemberDTO;

import java.util.List;
import java.util.Optional;

public interface MemberService {   /*

    /* [회원 등록 기능]
    * repo의 add메서드 호출하여 데이터를 저장
    */
    MemberDTO addMember(MemberDTO member);

    /*
     * [회원 수정 기능]
     * repo의 updateMember 호출하여 해당 아이디의 회원정보 update
     */
    MemberDTO updateMember(MemberDTO updateMember);


    /*
     * [회원 삭제 기능]
     * repo의 loadMember 호출하여 아이디를 전달해 정보 조회 후
     * repo의 deleteMember 호출하여 해당 아이디의 회원정보 delete
     */
    MemberDTO deleteMember(String memberNo);

    /*
     * [회원 가입 기능]
     * repo의 requestMember 호출하여 데이터를 저장
     */
    MemberDTO requestMember(MemberDTO member);

    /*
    [회원아이디 중복검사 기능]
    repo의 searchLoginfo를 호출 해당 아이디가 존재하는지 확인
     */
    MemberDTO checkId (String memberNo);

    /*
    [회원아이디 간편조회 기능]
    repo의 loadMember 호출해 해당 아이디의 아이디/이름/이메일 등 확인
     */
    MemberDTO searchSimple (String memberNo);

    /*
    [회원아이디 상세조회 기능]
    repo의 loadMember 호출해 해당 아이디의 모든 회원정보 확인
     */
    MemberDTO searchDitail (String memberNo);

    /*
      [권한별 조회 기능]
      repo의 loadMember 호출해 해당 권한의 회원정보 확인
       */
    MemberDTO searchAuthority (String authority);

    /*
    [전체 회원 조회기능]
    repo의 allLoadMember 호출해 해당 아이디의 모든 회원정보 확인
     */
    List<MemberDTO> searchAll();


    /*
     * [아이디 찾기 기능]
     * searchLoginfo 호출
     * 이메일로 아이디를 찾을 수 있다.
     */
    String findId(String memberEmail);

    /*
     * [비밀번호 찾기 기능]
     * searchLoginfo 호출
     * 아이디로 비밀번호를 찾을 수 있다.
     */
    String findPassword(String memberNo);

    /*
     * [인증번호 생성 기능]
     * 이메일을 입력받고 -> 2차에서 이메일 발송까지 구현 예정
     * 랜덤한 인증번호 6자리를 생성한다.
     */
    String randomNumber (String memberEmail);

    /*
     * [인증번호 유효왁인 기능]
     * 사용자가 입력한 인증번호가 유효한지 확인한다.
     */
    boolean checkRandomNumber (String randomNumber);

    /*
     * [회원 승인 기능]
     * repo의 approvalMember 호출하여 해당  가맹점주의 가입상태를 승인으로 변경
     */
    MemberDTO approvalMember(String memberNo);

}
