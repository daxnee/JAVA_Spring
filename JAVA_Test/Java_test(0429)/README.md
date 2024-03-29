1. 메소드 리턴,이름,파라미터 타입 작성.

```java
    public int getCount(List<Object> list){
        return 0;
    }
    //리턴 타입 : int
    //메소드 이름: getCount
    //파라미터 타입 : ArrayList
```

2. 메소드 리턴,이름,파라미터 타입 작성.

```java
    public void insertData(Map<String, Object> map){

    }
    //리턴 타입 : void (없음)
    //메소드 이름: insertData
    //파라미터 타입 : HashMap
```

3. 메소드 리턴,이름,파라미터 타입 작성.

```java
    public List<Object> list insertData(String str){
        return null;
    }
    //리턴 타입 : List<Object>
    //메소드 이름: insertData
    //파라미터 타입 : String
```

4. 오버라이딩(Overriding)과 오버로딩(Overloading)이 무엇인지 간략히 기술하시오.
```
오버라이딩 : 서브클래스에서 슈퍼클래스에 있는 메소드를 재정의 하는 것.
오버로딩 : 메소드 이름은 같으나 파라미터값이 다른 것.
```

5. 추상클래스와 Interface(인터페이스)에 차이점을 간략히 기술하시오.
```
추상클래스 : 추상메소드와 일반메소드를 정의할 수 있다. 
Interface : 인터페이스를 상속 받을 경우 extends가 아닌 implements를 사용함.

추상클래스와 다르게 Interface는 다중상속이 가능하다.
```

6. 상속에 대해 아는 내용을 간략히 기술하시오.
```
슈퍼클래스에서 메소드를 서브클래스에서 *재정의*하여 사용하는 기능을 말한다.
```

7. 생성자에 대해 아는 내용을 간략히 기술하시오.
```
*초기화*를 목적으로 하는 기능이다. 리턴타입이 없으며 new를 통해 호출해야 한다.
오버로딩으로 다용하게 사용 가능함.
 
```

8. 컬렉션에 대해 아는 내용을 간략히 기술하시오.
```

컬렉션은 값의 길이를 정하지 않아도 되는 배열을 말한다.
```

9. 아래 코드를 보고 예상되는 결과는?

```java
    class A{

        public static int count;
        public int temp;

    }
    class B{

        main(){

            A a1 = new A();
            a1.count = 10;
            a1.temp = 20;

            A a2 = new A();
            a2.count = 20;
            a2.temp = 20;

            System.out.println(a1.count); // 답 : 20
            System.out.println(a1.temp); // 답 : 20
    // count는 static이기 때문에 값을 공유한다. 
    // 첫번째 a1.count에 10을 대입해도 두번째 a2.count에 20을 대입했기 때문에 a1, a2의 값을 같다(공유됨)
            System.out.println(a2.count); // 답 : 20 
            System.out.println(a2.temp); // 답 : 20
        }
    }

```

10. 아래 코드를 보고 예상되는 결과는?

```java
    class A{
        public int money;
    }
    class B{
        public A getInstance(){
            A a = new A();
            return a;
        }
    }
    class C{
        main(){
            B b = new B();
            A a = b.getInstance();
            a.money = 1000;
            a = b.getInstance();
            a.money = a.money + 1000;
            System.out.println(a.money); // 답 : 1000
        }
    }
```
11. getter, setter을 이용하지 않고 필드변수 값을 초기화 하는 방법을 아래 코드로 작성하시오.

```java
class A{
    private String name;
    private int age;
    public A(Stirng name, int age){
    this.name = name;
    this.age = age;
    }
}

```
