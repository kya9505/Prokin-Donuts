package common.franchise;

/*
    사용자에게 출력할 모든 text를 미리 정의하는 enum 클래스입니다.
 */
public enum FranchiseText {
    /** 가맹점관리 헤더 */
    MENU_HEADER("\n" +
            "====================================\n" +
            "[가맹점 관리 시스템]\n" +
            "===================================="),

    /** 본사-가맹점관리 메인메뉴 */
    HQ_MENU("\n[본사 관리자 메뉴]\n" +
            "1. 가맹점 관리\n" +
            "2. 제품 관리\n" +
            "3. 발주 관리\n" +
            "4. 뒤로 가기\n"),

    /** 본사-가맹점관리 > 가맹점관리 서브메뉴 */
    HQ_FRANCHISE_MENU("\n[본사 관리자 > 가맹점 관리 메뉴]\n" +
            "1. 가맹점 등록\n" +
            "2. 가맹점 수정\n" +
            "3. 가맹점 삭제\n" +
            "4. 가맹점 전체 조회\n" +
            "5. 가맹점 상세 조회\n" +
            "6. 가맹점이 할당되지 않은 점주회원 조회\n" +
            "7. 뒤로 가기\n"),

    /** 본사-가맹점관리 > 제품관리 서브메뉴 */
    HQ_PRODUCT_MENU("\n[본사 관리자 > 제품 관리]\n" +
            "1. 신제품 등록\n" +
            "2. 제품 수정\n" +
            "3. 제품 삭제\n" +
            "4. 제품 조회\n" +
            "5. 뒤로 가기\n"),

    /** 본사-가맹점관리 > 제품관리 > 제품조회 서브메뉴 */
    HQ_PRODUCT_VIEW_MENU("\n[본사 관리자 > 제품 관리 > 제품 조회]\n" +
            "1. 전체 제품 조회\n" +
            "2. 카테고리별 조회\n" +
            "3. 제품 아이디로 조회\n" +
            "4. 뒤로 가기\n"),

    /** 본사-가맹점관리 > 발주관리 서브메뉴 */
    HQ_ORDER_MENU("\n[본사 관리자 > 발주 관리]\n" +
            "1. 전체 발주 기록 조회\n" +
            "2. 가맹점별 발주 기록 조회\n" +
            "3. 발주 요청 승인\n" +
            "4. 발주 취소 승인\n" +
            "5. 뒤로 가기\n")

    /// ////////////////////////////////////////////////////
    /// ////////////////////////////////////////////////////
    /// ////////////////////////////////////////////////////

    // 테이블 조회시 헤더 등








    ;

    private final String text;

    FranchiseText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
