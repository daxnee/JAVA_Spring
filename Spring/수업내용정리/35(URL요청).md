### 220510


### Controller 

`url을 요청받는 2가지 방법`

1. Restful
2. QueryString


### `1. Restful`
---
```
 Restful : 주소(URL)를 의미있게 네이밍을 하는 방법
			 주소만 보고도 이것이 무엇인지 짐작가게 네이밍을 해야한다.
			 ex) localhost:8080/emp/empno/7000 : emp테이블에 empno가 7000인 사람

    /emp/empno/7000
    /emp/job/manager/sal/2500
    @PathVariable : {} 값을 파라미터에 대입
```

2. `RESTful 규칙`
```
1. 주소 이름은 동사 x -> 명사로 작성
	/members/insert (x)
    /members/no/123 (o)

2. 주소 이름은 소문자 o, 대문자 x

3. 복수(그룹)를 의미할 때는 복수명사 사용
    /members(o)
    /member (x)

4.  /리소스명/리소스ID/관계가 있는 다른 리소스
  	/students/1/phone 

 	핸드폰을 소유하고 있는 학생 조회 (리소스 간에 연관 관계가 있는 경우)
	 - /students/phone
	
	특정 학생의 핸드폰을 조회
	 - /students/1/phone

	
	ex)
    1) 130번 고객의 주문 리스트 조회
    /client/130/orderList
    /client/130/order/list
    /client/130/order-list

    2) 20번 번호를 가진 유저의 핸드폰 고유 번호는 AA123
    /user/20/phone/AA123

    3) 사원번호가 7000 사원의 사수번호는 3000
    방법1 : /emp/7000/mgr/3000
    방법2 : /emp/empno/7000/mgr/mgrno/3000

    *주소에서는 _(언더바) 사용하면 안됨

5. 마지막 주소에는 / 를 붙이지 않음
    www.naver.com/naver/news/ (x)
	www.naver.com/naver/news (O)

	ex) @PatchMapping("/emp")
```

### `2. QueryString` 
---
```java
1. QueryString : 검색(필터링)할 때 많이 사용 ex) 게시판

2.  쿼리스트링으로 @GetMapping

	// 쿼리스트링은 @RequestParam("url주소의 변수명")으로 값을 받음.
	// region=kr kr을 region에 대입하겠다라는 의미.
	// localhost:8080/tier?region=kr&name=daeun
	@GetMapping("/tier")
	public String calltier(@RequestParam("region") String region, @RequestParam("name") String name) {
		return region + ","+name;
	}

// postman 출력값 : kr, daeun


//ex1) 게시판
// 주소 : http://localhost:8080/tier?region=kr

```java
// tier?region=kr : region이라는 변수에 kr을 대입하겠다.
	@GetMapping("/tier")
	public String callTier(@RequestParam("region") String region) {
		return region;
	}


 
//ex2) 예제1에 이름 추가

http://localhost:8080/tier?region=kr&name=daeun 

```java
	@GetMapping("/tier") // 검색할 때 많이 사용
	public String callTier(@RequestParam("region") String region, @RequestParam("name") String name) {
		return region+", "+name;
	}

    //postman url :  http://localhost:8080/tier?region=kr&name=다은
```

---

### `테이블 조회시 쿼리문 조건 주기 (limit / between)`
```
limit : 결과를 다 갖고와서 자른거 (ordert by뒤에 옴)
between : 결과 갖고 오기 전에 특정 범위만 가져옴  (where 조건에 씀)
    where : 조건을 줘서 데이터를 잘랐다는 의미

* 웬만해선 limit을 사용하긴 함
```

---

### 0510 문제1번 리뷰
### 1. emp에 없는 부서번호(40)를 찾아서 @postMapping으로  해당 부서번호로 insert하기 (mapper가 2개로 설정되어 있음)

`step0. UserVO에 상속 설정하기 (dept데이터를 써야하니까)`
```java
public class EmpVO extends DeptVO { // 이러면 deptVO의 필드변수를 사용할 수 있음
private int empno; 
//* 필드변수의 디폴트는 int =0 / String = null인 것을 잊지 말기(set해야 값이 들어감)
}

```

`step1. sql 쿼리문 짜서 xml에 설정하기`
```sql 
-- insert하는 쿼리
	INSERT INTO emp
	(
		empno,
		ename,
		deptno,
		hiredate
	) 
	VALUES
	(
		#{empno},
		#{ename},
		#{deptno},
		now()
	)
	</insert>


-- emp에 부서번호 없는 데이터 select하는 쿼리
	select 
		d.deptno
	from emp as e 
		right join dept as d 
		ON e.DEPTNO = d.DEPTNO 
	where 
		e.deptno is null 
```
##### ` * 여기서 잠깐, 왜 return 타입을 list<EmpVO>가 아닌 EmpVO로 할까?`
```
1. 쿼리문의 출력값이 단일행이다 (현재 내 DB는 다중행이긴 함 40 ,60)
   그래서 클래스로 타입을 받아주는 것임

2. int,String보다 empvo로 받아야 범용성이 좋아짐 
   그 후에 서비스가 안정화되면 int나 String으로 바꿔주면 됨
```

`step2. mapper 메소드 만들기 ` 
```java
public EmpVO selectDeptNo(); // 부서번호가 40번인 목록을 출력
public int insertEmp(EmpVO empVO); // 데이터 insert하는 목적
```
`step3. service 로직짜기`
```java
	@Transactional(rollbackFor = {Exception.class})
	public int setEmpInfo(EmpVO vo) { //
		
		//1. 없는 부서번호(40)를 찾아주는 작업
		EmpVO empVO = empMapper.selectDeptNo();
		int deptNo = empVO.getDeptno(); // 부서번호 40인 애들을 변수에 대입
		vo.setDeptno(deptNo);
		// --- deptNo(40)을 vo에 set해준다. why? EmpVO에서 갖고 온 필드변수 deptno는 현재 디폴트 값이 0이니까 set해줘야 함 

		//2. insert 해야함
		int rows = empMapper.insertEmp(empVO); 
		// insertEmp(insert하는 메소드)에 객체 넣어줌
		// 몇 행 insert 되었는지 리턴 
		return rows;
	}
```
`step4. postman에 데이터 입력하기`
```
post -> body -> raw 

{
    "ename": "다으니",
    "empno" : 1122,
    "deptno" : 40
}

출력값 :  emp에 없는 부서번호로 insert가 된다(디비버 데이터)
```
---

### `pk로 조회하는건 무조건 단일행 == list 일수가 없다!`
```
ex) 주민번호, 핸드폰번호로 조회하면 1명만 나오는 것!

pk가 아닌 다른 컬럼으로 조회했다면 list로 받으면 된다.
```

### `delete할때 주의점(where)`
```
delete시 pk설정하지 않으면 where 조건에 해당되는 컬럼들이 전부 다 지워진다.

```





--- 