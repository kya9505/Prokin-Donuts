package vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
/** 창고 테이블 */
public class WarehouseVO {
    /** 창고 아이디 */
    private String warehouseId;
    /** 주소 */
    private String address;
    /** 담당 관리자 */
    private String manager;
    /** 창고이름 */
    private String warehouseName;
    /** 생성일 */
    private Date createDate;
    /** 수용한도 */
    private int capacityLimit;
    /** 회원번호 */
    private String memberNo;
    /** 권한 아이디 */
    private String authorityId;
}
