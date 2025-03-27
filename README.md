
<div align="left">
    <img src="https://capsule-render.vercel.app/api?type=wave&color=FFF5E1&height=180&text=Prokin’%20Donuts%20WMS&animation=&fontColor=8B4513&fontSize=70" />
</div>

<div align="left">
    <h2 style="border-bottom: 1px solid #d8dee4; color: #282d33;"> 프로젝트 소개 </h2>
    <div style="font-weight: 700; font-size: 15px; text-align: center; color: #282d33;">
        <h3> Prokin' Donuts  WMS</h3>
        <p>건강한 도넛 브랜드 ‘Prokin Donuts’을 창설하고, 소매점 운영과 통합 재고 관리를 위한 WMS(Warehouse Management System)를 개발합니다.</p>
    </div>
</div> <br>

<div align="left">
    <h2 style="border-bottom: 1px solid #d8dee4; color: #282d33;"> 🎯 목표 </h2>
    <div style="font-weight: 700; font-size: 15px; text-align: center; color: #282d33;">
        <h3>✨ 식품 재고의 효율적 관리 및 자동화</h3>
        <p>자동화된 시스템을 통해 재고를 실시간으로 추적하고 관리하며, 재고 과잉이나 부족을 예방하고 운영 효율을 높입니다.</p>
        <h3>🛠️ 소매 점포 발주 시스템 제공</h3>
        <p>간편한 발주 시스템을 통해 각 점포의 필요한 재고를 빠르고 효율적으로 주문할 수 있도록 지원합니다.</p>
        <h3>🐬 소비자 구매 패턴 파악</h3>
        <p>발주된 데이터를 기반으로 소비자 구매 패턴을 분석하여, 창고별 재고 최적화 및 맞춤형 마케팅 전략 수립이 가능합니다.</p>
    </div>
</div> <br>

<div align="left">
    <h2 style="border-bottom: 1px solid #d8dee4; color: #282d33;"> 👥 팀원 소개 </h2>
    <div style="font-weight: 700; font-size: 15px; text-align: center; color: #282d33;">
        <p>박건희 - 팀장 | 창고 관리, 가맹점 관리</p>
        <p>고윤아 - 서기(Notion) | 회원 관리, 로그인</p>
        <p>최문규 - Git Hub | 입고 관리</p>
        <p>명채 정(정명채) - ERD | 출고 관리</p>
    </div>
</div> <br>

<div align="left">
    <h2 style="border-bottom: 1px solid #d8dee4; color: #282d33;"> 🎯 주요 기능 </h2>
    <div style="font-weight: 700; font-size: 15px; text-align: center; color: #282d33;">
        🔑 로그인 및 인증 - 시스템에 접근할 수 있는 사용자를 구분하고 인증하여 보안을 강화합니다.<br>
        🧑‍💻 회원 관리 - 회원의 등록, 수정, 삭제, 조회 기능을 통해 시스템 사용자를 관리합니다.<br>
        🏢 창고 관리 - 창고별 도넛 재고를 관리하고, 입출고 내역을 추적할 수 있습니다.<br>
        🚚 입고 관리 - 본사 및 가맹점에서 창고로 입고되는 도넛을 관리하며, 입고된 재고를 자동 반영합니다.<br>
        📝 출고 관리 - 도넛의 출고 현황을 관리하며, 재고에서 출고된 도넛을 자동으로 반영합니다.<br>
        🍩 재고 관리 - 재고 추가, 수정, 삭제, 조회 기능을 통해 도넛의 재고 상태를 실시간으로 관리합니다.<br>
        📦 가맹점 발주 - 가맹점에서 필요한 도넛의 수량을 손쉽게 주문하고, 발주 관리가 가능합니다.<br>
        ❌ 시스템 종료 - 시스템 종료 기능을 통해 사용자가 종료할 수 있도록 합니다.<br>
       </div> <br>

<div align="left">
    <h2 style="border-bottom: 1px solid #d8dee4; color: #282d33;"> 🛠 기술 스택 </h2>
    <div style="text-align: center;">
        <img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=Java&logoColor=white">
        <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=MySQL&logoColor=white">
        <img src="https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=Git&logoColor=white">
        <img src="https://img.shields.io/badge/Github-181717?style=for-the-badge&logo=Github&logoColor=white">
        <img src="https://img.shields.io/badge/Notion-000000?style=for-the-badge&logo=Notion&logoColor=white">
        <img src="https://img.shields.io/badge/Slack-4A154B?style=for-the-badge&logo=Slack&logoColor=white">
        <img src="https://img.shields.io/badge/Discord-5865F2?style=for-the-badge&logo=Discord&logoColor=white">
    </div>
</div>
</div> <br>
<div align="left">
    <h2 style="border-bottom: 1px solid #d8dee4; color: #282d33;"> 📁 프로젝트 폴더 구조 </h2>
</div>

```plaintext
/Prokin-Donuts
│── .github
│── .idea
│── out
│── src
│   ├── common            # 공통 기능 모음 (각 도메인별 폴더 포함)
│   │   ├── franchise
│   │   ├── inbound
│   │   ├── inventory
│   │   ├── login
│   │   ├── member
│   │   ├── order
│   │   ├── warehouse
│   │   ├── util          # 유틸리티 클래스 모음
│   ├── config            # 설정 관련 (DB 설정 등)
│   │   ├── dbinfo.properties
│   │   ├── DBUtil.java
│   │   ├── DiConfig.java
│   ├── controller        # 컨트롤러 계층
│   ├── dto               # DTO (Data Transfer Object)
│   ├── repository        # Repository 계층 (DB 연동)
│   ├── service           # 서비스 계층 (비즈니스 로직)
│   ├── vo
```
<div align="left">
    <h2 style="border-bottom: 1px solid #d8dee4; color: #282d33;"> 🎮 실행 방법 </h2>
    <div style="font-weight: 700; font-size: 15px; text-align: center; color: #282d33;">
        1️⃣ Java 17+ & MySQL 설치<br>
        2️⃣ database.sql 실행<br>
        3️⃣ 프로그램 실행<br>
        mvn compile exec:java -Dexec.mainClass="com.prokindonut.Main"<br>
        4️⃣ CLI 메뉴 선택<br><br>
        ====================================<br>
[로그인 시스템]<br>
====================================<br>
1. 로그인<br>
2. 회원가입 요청<br>
3. 아이디찾기<br>
4. 비밀번호찾기<br>
5. 로그아웃<br>

메뉴를 선택하세요("exit"입력 시 종료):_ <br>
    </div>
</div> <br>

<div align="left">
    <h2 style="border-bottom: 1px solid #d8dee4; color: #282d33;"> 👥 권한에 따른 메뉴 </h2>
    <div style="font-weight: 700; font-size: 15px; text-align: center; color: #282d33;">
        <p><strong>본사 관리자:</strong> 본사 관리자는 전체 시스템을 관리할 수 있습니다. 도넛 재고 추가, 수정, 삭제, 조회 및 가맹점 발주 관리, 창고 재고 확인 등이 가능합니다.</p>
        <p><strong>창고 관리자:</strong> 창고 관리자는 창고 내 재고를 관리할 수 있습니다. 도넛 재고 추가, 수정, 삭제, 조회 및 창고 재고 확인 기능을 사용할 수 있습니다.</p>
        <p><strong>가맹점주:</strong> 가맹점주는 자신의 점포 재고를 관리하고 발주할 수 있습니다. 도넛 재고 조회 및 창고 재고 확인 기능을 사용할 수 있습니다.</p>
    </div>
</div> <br>

## 일정

| 구분       | 기간     | 활동                                                     | 비고                       |
|------------|----------|----------------------------------------------------------|----------------------------|
| **사전 기획**  | 3/18     | 기획서, 요구사항 정의서, 상세 기능 명세서, 유즈 케이스 작성 | 프로젝트 목적 정의           |
| **설계**      | 3/19     | 플로우차트, ER 다이어그램, 패키지/클래스 다이어그램 작성     | 프로젝트 로직 작성           |
| **구현**      | 3/19~3/21| MVC 패턴 적용, DB 프로시저, 트리거 등 작성                | 협업 툴 사용                 |
| **발표 준비**  | 3/21     | 산출물 정리, 성과 분석, 발표 자료 작성, 시연 영상 촬영     |                            |
| **총 개발 기간**| 3/12~3/21| (총 4일)                                                 |                            | 


## 회고 및 피드백
#### 🔹 기능 개선 및 추가
- **바코드 시스템 도입**
- **식품 유통기한 데이터 추가**
- **예외 처리 강화**
- **정규 표현식 적용**
- **인증 번호 이메일 발송**

#### 🔹 데이터베이스 및 시스템 구조
- **DB 구축을 우선순위로 진행** (클라우드 DB 활용)
- **member request 필드명 오타 수정** (`phonNumber → phoneNumber`)

#### 🔹 개발 및 코드 품질
- **기능을 축소하더라도 완성도를 높이기** (핵심 기능 선정)
- **중간중간 단위 테스트 및 코드 테스트 수행** (최종 머지가 아닌 지속적 점검)
- **각자의 PR에 대한 코드 리뷰 진행**

#### 🔹 발표 및 문서화
- **발표 시 각 과정의 행동 원리와 이유 설명**
- **아이디어 공유 및 코드 설명 시간을 갖기**
- **아이디어는 적극적으로 내되, 회의 시간을 효율적으로 활용** <br>

<div align="left">
    <h2 style="border-bottom: 1px solid #d8dee4; color: #282d33;"> 👥 기여 방법 (팀원 전용) </h2>
    <div style="font-weight: 700; font-size: 15px; text-align: center; color: #282d33;">
        이 프로젝트는 팀원들만 기여할 수 있습니다.<br>
        1. 기능 추가 전 팀원과 논의<br>
        2. feature/기능명 브랜치 생성 후 개발<br>
        3. dev 브랜치로 PR 후 코드 리뷰<br>
        4. 승인되면 main 브랜치에 병합<br>
        5. 커밋 메시지 형식:<br>
        [feat] 발주 자동화 기능 추가<br>
        [fix] 재고 조회 오류 수정
    </div>
</div> <br> <br>

<div align="left">
    <h2 style="border-bottom: 1px solid #d8dee4; color: #282d33;"> 📜 라이선스 </h2>
    <div style="font-weight: 700; font-size: 15px; text-align: center; color: #282d33;">
        🔒 팀원 전용 프로젝트입니다. 외부 사용은 제한됩니다.
    </div>
</div> <br>

<div align="left">
    <h2 style="border-bottom: 1px solid #d8dee4; color: #282d33;"> 📌 Notion 페이지 </h2>
    <a href="https://small-ragdoll-a57.notion.site/Prokin-Donuts-1b83a719d3508047953eeda89caeec14?pvs=4" target="_blank">
        <img src="https://img.shields.io/badge/Notion-000000?style=for-the-badge&logo=Notion&logoColor=white">
    </a><br> 
    Click on to go Notion!
</div>
