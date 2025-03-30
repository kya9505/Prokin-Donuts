package repository;

import config.DBUtil;
import dto.memberDTO.MemberDTO;
import dto.memberDTO.MemberRequestDTO;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemberRepoImpl implements MemberRepo {


    Connection conn = null;
    CallableStatement cs = null;
    ResultSet rs = null;

    // 회원 등록 메서드
    @Override
    public Optional<MemberDTO> insertMember(String tableName, MemberDTO member) {
        conn = DBUtil.getConnection();

        try {

            String sql = "{call insertMember(?,?,?,?,?,?,?,?)}";
            cs = conn.prepareCall(sql);

            cs.setString(1, tableName);
            cs.setInt(2, member.getAuthorityId());
            cs.setString(3, member.getName());
            cs.setString(4, member.getPhoneNumber());
            cs.setString(5, member.getEmail());
            cs.setString(6, member.getAddress());
            cs.setString(7, member.getId());
            cs.setString(8, member.getPassword());

            //실행 성공 시 객체 반환, 실패 시 빈 optional반환
            boolean flag = cs.execute();
            return Optional.ofNullable(!flag ? member : null);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    // 회원 수정 메서드
    @Override
    public Optional<MemberDTO> updateMember(MemberDTO updateMember) {
        conn = DBUtil.getConnection();

        try {
            String sql = "{call updateMember(?,?,?,?,?,?,?)}";
            cs = conn.prepareCall(sql);


            cs.setInt(1, updateMember.getMemberNo());
            cs.setString(2, updateMember.getName());
            cs.setString(3, updateMember.getPhoneNumber());
            cs.setString(4, updateMember.getEmail());
            cs.setString(5, updateMember.getAddress());
            cs.setString(6, updateMember.getId());
            cs.setString(7, updateMember.getPassword());

            boolean flag = cs.execute();
            return Optional.ofNullable(!flag ? updateMember : null);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    //회원 삭제 메서드
    @Override
    public Optional<String> deleteMember(String memberId) {
        conn = DBUtil.getConnection();

        try {
            String sql = "{call deleteMember(?)}";
            cs = conn.prepareCall(sql);

            cs.setString(1, memberId);

            boolean flag = cs.execute();
            return Optional.ofNullable(!flag ? memberId : null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    // 회원 가입 요청 메서드
    @Override
    public Optional<MemberRequestDTO> insertRequestMember(String tableName , MemberRequestDTO member) {
        conn = DBUtil.getConnection();

        try {

            String sql = "{call insertMember(?,?,?,?,?,?,?,?)}";
            cs = conn.prepareCall(sql);

            cs.setString(1, tableName);
            cs.setInt(2, member.getAuthorityId());
            cs.setString(3, member.getName());
            cs.setString(4, member.getPhoneNumber());
            cs.setString(5, member.getEmail());
            cs.setString(6, member.getAddress());
            cs.setString(7, member.getId());
            cs.setString(8, member.getPassword());

            //실행 성공 시 객체 반환, 실패 시 빈 optional반환
            boolean flag = cs.execute();
            return Optional.ofNullable(!flag ? member : null);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


    //회원 승인 메서드
    @Override
    public  Optional<String> approvalMember(String memberId) {
        conn = DBUtil.getConnection();

        try {
            String sql = "{call Approval(?)}";
            cs = conn.prepareCall(sql);

            cs.setString(1, memberId);

            boolean flag = cs.execute();
            return Optional.ofNullable(!flag ? memberId : null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    //회원 검색 메서드
    @Override
    public <T> Optional<List<MemberDTO>> loadMember(String searchAttribute, T searchValue) {
        List<MemberDTO> loadMemberList = new ArrayList<>();
        conn = DBUtil.getConnection();
        try {
            String sql = "call searchMember(?,?)";
            cs = conn.prepareCall(sql);
            cs.setString(1, searchAttribute);

            //타입검사
            //Integer 타입일 경우
            if (searchValue instanceof Integer) {
                cs.setInt(2, (Integer) searchValue);
            } else cs.setString(2, (String) searchValue);


            rs = cs.executeQuery();

            while (rs.next()) {
                MemberDTO memberDTO = new MemberDTO();
                memberDTO.setMemberNo(rs.getInt("memberNo"));
                memberDTO.setAuthorityId(rs.getInt("authorityId"));
                memberDTO.setName(rs.getString("name"));
                memberDTO.setPhoneNumber(rs.getString("phoneNumber"));
                memberDTO.setEmail(rs.getString("email"));
                memberDTO.setAddress(rs.getString("address"));
                memberDTO.setId(rs.getString("id"));
                memberDTO.setPassword(rs.getString("password"));
                memberDTO.setLogstatus(rs.getString("logstatus"));
                loadMemberList.add(memberDTO);
            }

            // 리스트가 비었다면 Optional.empty() 반환
            return Optional.of(loadMemberList).filter(s -> !s.isEmpty());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    //전체 회원 조회 기능
    @Override
    public Optional<List<MemberDTO>> allLoadMember() {
        List<MemberDTO> allLoadMemberList = new ArrayList<>();
        conn = DBUtil.getConnection();
        try {
            String sql = "call loadMember()";
            cs = conn.prepareCall(sql);
            rs = cs.executeQuery();

            while (rs.next()) {
                MemberDTO memberDTO = new MemberDTO();
                memberDTO.setMemberNo(rs.getInt("memberNo"));
                memberDTO.setAuthorityId(rs.getInt("authorityId"));
                memberDTO.setName(rs.getString("name"));
                memberDTO.setPhoneNumber(rs.getString("phoneNumber"));
                memberDTO.setEmail(rs.getString("email"));
                memberDTO.setAddress(rs.getString("address"));
                memberDTO.setId(rs.getString("id"));
                memberDTO.setPassword(rs.getString("password"));
                memberDTO.setLogstatus(rs.getString("logstatus"));
                allLoadMemberList.add(memberDTO);
            }

            // 리스트가 비었다면 Optional.empty() 반환
            return Optional.of(allLoadMemberList).filter(s->!s.isEmpty());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    //회원 정보 확인 기능
    @Override
    public Optional<String> searchLoginfo(String findField, String searchField, String searchValue) {
        conn = DBUtil.getConnection();
        try {
            String sql = "call searchStatusMember(?,?,?)";
            cs = conn.prepareCall(sql);
            cs.setString(1, findField);
            cs.setString(2, searchField);
            cs.setString(3, searchValue);

            rs = cs.executeQuery();
            String result =  rs.getString(1);

            // result가 비었다면 Optional.empty() 반환
            return Optional.ofNullable(result).filter(s -> !s.isEmpty());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    //로그인/로그아웃 기능
    @Override
    public Optional<String> logInnOut(String memberId){
        conn = DBUtil.getConnection();
        try {
            String sql = "call logInOut(?)";
            cs = conn.prepareCall(sql);
            cs.setString(1,memberId);

            boolean flag = cs.execute();
            return Optional.ofNullable(!flag ? memberId : null);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Optional.empty();
    }

    //회원 가입 요청 조회 기능
    @Override
    public Optional<List<MemberRequestDTO>> loadRequestMemberall() {
        List<MemberRequestDTO> allLoadRequestMemberList = new ArrayList<>();
        conn = DBUtil.getConnection();
        try {
            String sql = "call loadRequestMember()";
            cs = conn.prepareCall(sql);
            rs = cs.executeQuery();
            while (rs.next()) {
                MemberRequestDTO MemberReauestDTO = new MemberRequestDTO();
                MemberReauestDTO.setName(rs.getString("name"));
                MemberReauestDTO.setPhoneNumber(rs.getString("phoneNumber"));
                MemberReauestDTO.setEmail(rs.getString("email"));
                MemberReauestDTO.setAddress(rs.getString("address"));
                MemberReauestDTO.setId(rs.getString("id"));
                MemberReauestDTO.setPassword(rs.getString("password"));
                MemberReauestDTO.setRequest(rs.getString("request"));
                allLoadRequestMemberList.add(MemberReauestDTO);
            }
            // 리스트가 비었다면 Optional.empty() 반환
            return Optional.of(allLoadRequestMemberList).filter(s->!s.isEmpty());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    //회원 가입 요청 조회 기능
    @Override
    public Optional<String> RequestMember(String id) {
        conn = DBUtil.getConnection();
        try {
            cs = conn.prepareCall("SELECT request FROM memberrequest WHERE id =?");
            cs.setString(1, id);
            rs = cs.executeQuery();
            String result = rs.getString(1);
            return Optional.ofNullable(result).filter(s -> !s.isEmpty());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }



}
