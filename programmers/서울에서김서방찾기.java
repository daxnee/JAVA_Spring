
### 문제 설명
        String형 배열 seoul의 element중 "Kim"의 위치 x를 찾아, 
        "김서방은 x에 있다"는 String을 반환하는 함수, solution을 완성하세요. 
        seoul에 "Kim"은 오직 한 번만 나타나며 잘못된 값이 입력되는 경우는 없습니다.

### 제한 사항
        seoul은 길이 1 이상, 1000 이하인 배열입니다.
        seoul의 원소는 길이 1 이상, 20 이하인 문자열입니다.
        숫자에서 문자 변환 메소드는 Integer.toString()를 사용합니다.
        문자와 문자를 비교할 때는 equals()를 사용합니다.
        

### 입출력 예
        "김서방은 1에 있다"


### 아래 메소드 생성

```java
        public static String solution(String[] seoul) {
            String answer = "";
            return answer;
        }

        public static void main(String[] args) {
            String array[] = {"Jane", "Kim"};
            String result = solution(array);
            System.out.println(result);
        }

```
### 결과 소스
```java
    public String solution(String[] seoul) {
        int index = 0;
		String answer = "";
        String findWord = "Kim";
        int seoulArrLen = seoul.length;
        if(seoulArrLen >= 1 && seoulArrLen <=1000){
            for(int i=0; i<seoulArrLen; i++){
                if(seoul[i].length() >= 1 && seoul[i].length() <= 20){
                    if(seoul[i].equals(findWord)){
                        index = i;
                    }
                }
            }    
        }
		answer = "김서방은 "+Integer.toString(index)+"에 있다";
        return answer;
    }
