package service;

import dto.InboundDTO;
import dto.ProductDTO;

import java.util.Date;
import java.util.List;

public interface InboundService {

    // [입고 검수 Service]

    /**
     * 입고(승인) 고지서를 반환하는 service
     * findByApprovedStatus 사용
     *
     * @return 입고승인 리스트
     */
    List<InboundDTO> getApprovalInboundList();

    /**
     * 입고(승인) ok 되면 입고 완료! service
     * @param inboundId 입고 아이디
     */
    void completedInbound(int inboundId);

    // [입고 요청 Service]
    /**
     * 입고 요청시 상품 Menu 정보
     */
    List<ProductDTO> getProductMenu();

    /**
     * 입고 요청 등록
     */
    void registerInbound(List<ProductDTO> inboundList);


    // [입고 요청 수정 Service]
    /**
     * 입고 요청 리스트 출력(요청, 승인 상태인 경우에만 가능)
     */
    List<InboundDTO> getInboundList();

    /**
     * 입고 요청 수정 ID 입력, 변경 데이터 update
     */
    void updateInboundInfo(int inboundId, List<ProductDTO> inboundList);

    /**
     * 입고 예정 날짜 확인 후 수정 및 취소 가능 여부 판단
     * 입고ID -> 입고 상세 테이블의 예정입고일 확인
     */
    boolean checkInboundDate(int inboundId);

    // [입고 요청 취소 Service]
    /**
     * 입고ID 입력시 입고 요청 취소
     */
    void deleteInboundInfo(int inboundId);

    // [입고 고지서 출력 Service]

    /**
     * 입고 요청, 승인 상태 고지서 출력
     *  getInboundList() 메서드 사용
     */

    /**
     * 입고 ID 입력시 입고 상세 정보 출력
     * 반환 DTO는 추후 수정 예정
     */
    List<ProductDTO> getInboundDetail(int inboundId);

    // [입고 현황 조회 Service]

    /**
     * 입고 테이블 정보 출력
     */
    List<InboundDTO> getAllInboundInfo();

    /**
     * 기간별 입고현황 조회
     * 기간 입력시 기간별 입고현황 리스트 출력
     * DTO 추후 수정
     */
    List<InboundDTO> getDateInboundInfo(Date start_date, Date end_date);

    /**
     * 월별 입고 현황 조회 -> 추후 개발
     */


}
