package app.mohe.member.service;

import app.mohe.member.constant.MemberConst;
import app.mohe.member.entity.Member;
import app.mohe.member.repository.MemberJpaRepository;
import app.mohe.system.utils.ChiperUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
public class MemberService {

    @Autowired
    private MemberJpaRepository memberJPARepository;

    public Member prcLogin(HttpServletRequest request, HttpServletResponse response, Member member){
        Member loginMember = findUser(member.getUSERID());
        String sPassword = member.getUSERPWD();


        return loginMember;

    }

    private Member findUser(String userid) {


        Optional<Member> user = memberJPARepository.findMemberByUSERID(userid);

        if(user.isEmpty())
            throw new IllegalStateException(userid+ "회원이 존재하지 않습니다.");
        return user.get();
    }

    public Cookie makeCookie(String uuid){

        // 로그인 성공 시 쿠키 설정
        Cookie cookie = new Cookie("token",uuid);
        cookie.setMaxAge(24 * 60 * 60); // 쿠키의 유효 기간을 1일로 설정
        cookie.setPath("/"); // 쿠키의 경로를 설정할 수 있음
        return cookie;
    }

    public boolean validateUser(Member member, String sPassword, String loginType) {

        /**
         * TODO DB에서 USER정보 가져오기
         */

        log.info("user = {}",member.toString());

        String encPassword = ChiperUtil.sha256Salt(sPassword,member.getSALT());
        log.info("encPassword = {}",encPassword);
        log.info("DB Password = {}",encPassword);
        if(encPassword.equals(member.getUSERPWD())){
            log.info("USER = {} 로그인 시간 ={}", member.getUSERID(),System.currentTimeMillis());
            member.setUSERPWD("NO_DATA");
            member.setSALT("NO_DATA");
            return true;
        }
        else{
            log.info("해당 사용자 찾을수 없음");
            return false;
        }
    }

    public void prcLogout(HttpServletRequest request) {

        HttpSession session = request.getSession(false);

//        SessionUtil.deleteSession(request.getHeader("User_id"),session);
//        Map<String,String> sessionMap = SessionUtil.getSessionMap();
//
//        if(sessionMap.containsKey(request.getHeader("User_id"))){
//            log.info("{} 세션이 존재",request.getHeader("User_id"));
//        }
    }

    public void registUser(Member member) {
        String salt = ChiperUtil.getSalt();
        String inputPassword = member.getUSERPWD();
        member.setSALT(salt);
        member.setROLE(MemberConst.USER_ROLE);
        member.setUSERPWD(ChiperUtil.sha256Salt(inputPassword,salt));
        memberJPARepository.save(member);
    }
}
