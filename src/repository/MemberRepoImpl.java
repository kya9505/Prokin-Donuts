package repository;

import dto.MemberDTO;

import java.util.List;
import java.util.Optional;

public class MemberRepoImpl implements MemberRepo {
    @Override
    public MemberDTO addMember(MemberDTO member) {
        return null;
    }

    @Override
    public Optional<MemberDTO> updateMember(String memberNo, MemberDTO updatemember) {
        return Optional.empty();
    }

    @Override
    public Optional<MemberDTO> deleteMember(String memberNo) {
        return Optional.empty();
    }

    @Override
    public boolean requestMember(MemberDTO member) {
        return false;
    }

}
