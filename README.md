# 키오스크 구현 과제

### 기능 목록 정의
___

> **Level 1. 조건과 반복**
- [x] 실행 시, 메뉴판(대분류) 번호 출력


- [x] 숫자를 입력 받아, 숫자에 해당하는 세부 메뉴(소분류) 출력


- [x] roof를 통해 메뉴를 선택할 수 있게 유지


- [x] `소분류` 메뉴 선택에서 `0`이 입력되면 `뒤로가기`


- [x] `대분류` 메뉴 선택에서 `0`이 입력되면 `프로그램 종료`

<br>

> **Level 2. 메소드와 클래스**
- [x] 메뉴 들의 class의 프로퍼티 및 메소드 설계 및 정의
  - `ex. name:String, price: Int, displayInfo()`


- [ ] 장바구니를 관리하는 class 추가 및 연동
  - `[출력] Hamburger 가 장바구니에 추가되었습니다.`


- [ ] 결제를 관리하는 class 추가 및 연동
  - `[출력] 아래와 같이 주문 하시겠습니까?`

<br>

> **Level 3. 상속과 컬렉션**
- [x] 레벨2의 클래스 들이 `상속 관계`를 가지도록 변경


- [ ] 대분류들의 class를 자식으로 두는 최상위 부모 Menu class 생성 및 연동


- [ ] 하나의 `List`객체로 모든 메뉴를 관리하도록 수정


- [ ] 초기 실행 시, 메인에서 init 메소드를 실행하여 메뉴들을 객체화 한 뒤 List 초기화
    - `ex. init(): 대분류 메뉴를 생성해서 List 변수에 add`

<br>

> **Level 4. 예외처리**
- [x] 잘못된 메뉴 입력 시 오류 문구 출력 후, 다시 입력할 수 있도록 `예외처리`
    - `[출력] 잘못된 번호를 입력했어요 다시 입력해주세요.`
    - `예외 처리 대상: 숫자가 아닌 모든 문자`
    - `예외 처리 대상: 범위 밖의 숫자`


- [ ] 현재 잔액을 관리하는 class 추가 및 선택한 메뉴를 구매할 수 있는 지 판단하는 메서드 구현
    - `[출력] 현재 잔액은 5.5W 으로 1.4W이 부족해서 주문할 수 없습니다.`
    - `[자유] 초기 잔액은 실행 처음에 입력받도록 할 것`


<br>

> **Level 5. 쓰레드**
- [ ] 특정 작업이 종료된 후, `3초 뒤`에 다른 작업을 수행할 수 있도록 코드 작성
    - `[자유] 특정 작업과 다른 작업은 나의 선택`


- [ ] 결제할 때 현재 시간을 비교하여 `특정 시간대`에는 결제할 수 없는 기능 문구 출력
    - `[출력] 은행 점검 시간은 오후11시 10분 ~ 오후 11시 20분이므로 결제할 수 없습니다.`
    - `[자유] 특정 시간대는 나의 선택 - 초기에 입력 받아도 되고, 지정해도 되고~`


- [ ] 결제 완료 시, 시간을 출력한다
    - `[출력] 결제를 완료했습니다. (2023-01-01 23:25:12)`


- [ ] 프로그램을 종료할 때까지 `5초 마다` 현재 주문 대기수를 실시간으로 출력
    - `[출력] 아래와 같이 주문 하시겠습니까? (현재 주문 대기수: 3)`
    - `[출력] 장바구니 목록 및 전체 주문 금액도 같이 출력`

<br>

> **Level 6. 클래스 확장성(이후 작성)**
- [ ] 제시된 아이디어 : 할인, 세트 메뉴, 수량 제한 메뉴 등

<br><br><br>