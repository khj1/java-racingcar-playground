## 문자열 덧셈 계산기

---
### 프로그래밍 요구사항
1. indent depth를 2단계에서 1단계로 줄이기
2. 메소드의 크기가 최대 10 라인을 넘지 않도록 구현한다.
    - 메소드가 한 가지 일만 하도록 최대한 작게 만든다.
3. else 예약어를 사용하지 않는다.

### 기능 요구사항
1. 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야한다.
   ```java
   if (text == null) {}
   if (text.isEmpty()) {}
   ```
2. 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.
   ```java
   int number = Integer.parseInt(text);
   ```
3. 숫자 두개를 컴마로 입력할 경우 두 숫자의 합을 반환한다.
   ```java
   String[] numbers = text.split(",");
   // 앞 단계의 구분자가 없는 경우도 split()을 활용해 구현할 수 있는지 검토해 본다.
   ```
4. 구분자는 컴마 이외에 콜론을 사용할 수 있다.
   ```java
   String[] tokens= text.split(",|:");
   ```
5. '//'와 '\n' 문자 사이에 커스텀 구분자를 지정할 수 있다.
   ```java
   // java.util.regex 패키지의 Matcher, Pattern import
   Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
   if (m.find()) {
       String customDelimiter = m.group(1);
       String[] tokens= m.group(2).split(customDelimiter);
       // 덧셈 구현
   }
   ```
6. 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)