### 220520

### 왜 클라우드를 사용할까?
```
비용절감 
애자일 
```
### devops 개발자
```
클라우드와 백엔드의 기능을 둘 다 갖고 있는 사람  
```
### MLops 개발자 (머신러닝)
```
데이터 분석 + 백엔드 

안드로이드는 html을 액티비티
```

### S3(Simple Storage Service)
```
1. 이미지, 영상 전용 서버로 많이 사용
2. 백업 서버로 많이 사용
3. 웹 호스팅(빌린다) 서버로 사용
    * 호스팅 : 홈페이지를 업로드할 공간을 빌리는 것임 
    =>S3 임대해서 내 html을 S3에 업로드 하겠다.

- 정적 웹 :  HTML, JS, Jquery만 있는 것(백엔드 소스가 없는 것) => S3에는 정적 앱만 호출할 수 있다

- 동적 웹 : 웹 프레임워크(spring boot) + 템플릿엔진(JSP)

둘의 차이점 
데이터베이스(DB)를 연동(호출) 여부의 차이점 


특징 : 저장공간 무한
가격 : 시간당 저장한 용량만큼 가격 책정
    *5GB 이하는 1년간 공짜
```

### 버킷만들기
```
1. 웹호스팅 서버로 바꾸기 : 속성 -> 맨 아래 정적 호스팅 -> 활성화  -> 인덱스 문서 이름 : index.html -> 저장 -> 웹호스팅 서버로 바뀐 것임
2. 보안 설정을 퍼블릭으로 바꾸기 : 권한 -> 퍼블릭 액세스 차단편집  - 차단 체크박스 해제 -> 저장  -> 버킷 정책 작성 
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Principal": "*",
            "Action": "s3:*",
            "Resource": "arn:aws:s3:::yangdaeun.io/*"  //뒤에 내 홈페이지 주소
        }
    ]
}


3. 저장하면 홈페이지 이름 하단에 '퍼블릭 액세스 가능' 마크 표시 확인하기


http://yangdaeun.io.s3-website.ap-northeast-2.amazonaws.com => 도메인 주소

```