## 클래스 복습
1. 클래스는 필드변수(전역변수)와 메소드로 구성
2. 필드변수 앞에는 접근지정자.
    - public, private, protected, default public
3. 자바에서 클래스는 객체(==Object)다.
4. 객체는 고유한 특성과 행동을 가짐.
    
        ex)
        특성(필드변수)
        1. 학생 수
        2. 교직원 수 
        3. 학급반 수
        
        행동(메소드) : 동작
        1.수업을듣다
        2.선생님한테혼나다.
        3.교장선생님연설을듣다.


- 객체를 왜 사용할까?
    - 업무 분담을 위해서(★)
    - 일 효율성을 위해
        
        
    
## new를 사용해야 학교 클래스 안에 있는 필드 변수와 메소드 사용가능
 ```java   
       Pizza p = new Pizza();

    Class Pizza{
        public String 피자종류; // => 필드변수

        public void 피자를먹다(){
            this.피자종류 = "치즈피자";
        
        }
    }
    // *필드 변수 사용해줄 때 헷갈리지 않도록 메소드 앞에 this를 붙여줌
```

---

## 생성자

## 문제풀이 

    1. 영화관 클래스 생성
    클래스 이름은 Movie  (o)

    2. Movie 클래스에는 3개의 필드변수 존재
    2-1. String name; //영화관 이름
    2-2. String location; //영화관 위치
    2-3. int count; //직원 수 

    3. Movie 클래스에는 3개의 생성자 존재 (초기화 해줄 것)
    3-1. 디폴트 생성자
    3-2. 파라미터에 영화관 위치가 있는 생성자
    3-3. 파라미터에 모든 필드변수가 오는 생성자

    4. 일반 메소드 1개 존재
    4-1. 접근지정자가 public 리턴타입이 int 메소드 이름은 getMovie
        파라미터는 없음.

    ***디폴트생성자를 무시하고 파라미터가 있는 생성자를 만들면
    ex) public Movie(String location)
    기존의 디폴트 생성자는 없어짐. 사용하고 싶으면 만들어 놓아야 함



## 실무에서 생성자 대신 사용하는 방법★
    1. 필드변수 접근지정자에 private으로 선언
    2. 각 변수들마다 함수를 만들어 줌
    

    set 함수
	public void setPorkCutlet(String porkCutlet) {
	// void를 이용해서 필드변수를 초기화.

    - 보일러 플레이트 코드
    : set, get 같은 노가다 함수 작업을 쉽게 해줌
    단축키 : alt + shift + s 
    generate getter and setters to 
    select all




### 실무에선 생성자 대신에 뭐를 사용할까?
    1. 생성자로 필드변수 초기화 잘 안함
    2. set, get 함수 이용해서 필드변수 초기화
    3. set, get 함수가 있는 클래스에는 절대(never) 다른 함수를 정의하지 않는다.
    4-1) 두 함수를 이용할 때 클래스 이름은 클래스 이름 뒤에 VO(Value Object)를 붙인다.
    4-2) 클래스 이름 뒤에 DTO(Data Tranfer Object)를 붙인다.
    * 4-1, 4-2는 회사마다 다르니 참고하기
    
## 실무에서 표를 보고 클래스파일을 만들 줄 알아야 한다. (UML사진을 보고 파악)
    UMLUnified Modeling Language)? : 통합 모델링 언어.
    즉, 모델을 만드는 표준 언어다

    - : 접근지정자가 private 
    + : 접근지정자가 public 

    *클래스 다이어그램 그림 참고


## 소프웨어 초기 스케치 작업
    사용하는 이유?
    1. 다른 사람들과 의사소통 또는 설계 논의
    2. 전체 시스템 파악
    3. 유지보수를 위한 설계의 bach-end 문서

    