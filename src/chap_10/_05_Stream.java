package chap_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class _05_Stream {
    public static void main(String[] args) {
        //스트림 : 데이터가 흐름
        //스트림 생성
        int[] scores = {100, 95, 90, 85, 80};
        IntStream scoreStream = Arrays.stream(scores);

        String[] langs = {"python" ,"java" ,"javaScript" ,"c" ,"c++" ,"c#"};
        Stream<String> langStream = Arrays.stream(langs);

        List<String> langList = new ArrayList<>();
        langList = Arrays.asList("python" ,"java" ,"javaScript" ,"c" ,"c++" ,"c#");
        System.out.println(langList.size());
        Stream<String> langListStream = langList.stream();

        Stream<String> langListOfStream = Stream.of("python", "java", "javaScript", "c", "c++", "c#");

        //스트림 사용
        //중간연산 : intermediate Operation - filter, map, sorted
        //최종연산 : Terminal Operation - 한번만 사용 가능

        //90점 이상 점수 출력
        Arrays.stream(scores).filter(x -> x >= 90).forEach(x -> System.out.println(x));
        System.out.println("-------------------------------------------");

        //Arrays.stream(scores).filter(x -> x >= 90).forEach(System.out::println);

        //90점 이상인 사람의 수
        int count = (int)Arrays.stream(scores).filter(x -> x >= 90).count();
        System.out.println(count);
        System.out.println("-------------------------------------------");

        //90점 이상인 사람의 수 합
        int sum = Arrays.stream(scores).filter(x -> x>= 90).sum();
        System.out.println(sum);
        System.out.println("-------------------------------------------");

        //90점 이상 점수를 정렬
        Arrays.stream(scores).filter(x -> x >= 90).sorted().forEach(System.out::println);
        System.out.println("-------------------------------------------");

        //"python" ,"java" ,"javaScript" ,"c" ,"c++" ,"c#"
        //c로 시작하는 단어
        Arrays.stream(langs).filter(x -> x.startsWith("c")).forEach(System.out::println);
        System.out.println("-------------------------------------------");

        //java 글자 포함하는 단어
        Arrays.stream(langs).filter(x -> x.contains("java")).forEach(System.out::println);
        System.out.println("-------------------------------------------");

        //글자 길이 4 이하 정렬 후 출력
        langList.stream().filter(x-> x.length() <= 4).sorted().forEach(System.out::println);
        System.out.println("-------------------------------------------");

        //4글자 이하 단어 중 c라는 글자를 포함하는 언어
        langList.stream().filter(x -> x.length() <= 4).filter(x -> x.contains("c")).forEach(System.out::println);
        System.out.println("-------------------------------------------");

        //4글자 이하 중 c라는 글자를 포함하는 언어가 하나라도 있는지 여부
        boolean anyMath = langList.stream().filter(x-> x.length() <= 4).anyMatch(x-> x.contains("c"));
        System.out.println(anyMath);
        System.out.println("-------------------------------------------");

        //4글자 이하의 언어들은 모두 c라는 글자를 포함하는지 여부
        boolean allMatch = langList.stream().filter(x-> x.length() <= 4).allMatch(x-> x.contains("c"));
        System.out.println(allMatch);
        System.out.println("-------------------------------------------");

        // 4글자 이하의 단어 중 c라는 글자를 포함하는 언어 뒤에 어려워요 글자 함께 출려
        //map
        langList.stream()
                .filter(x-> x.length() <= 4)
                .filter(x -> x.contains("c"))
                .map(x -> x + "(어려워요)")
                .forEach(System.out::println);
        System.out.println("-------------------------------------------");

        //c라는 글자를 포함하는 언어를 대문자로 출력
        langList.stream()
                .filter(x -> x.contains("c"))
                .map(String::toUpperCase)
                .forEach(System.out::println);
        System.out.println("-------------------------------------------");

        //c라는 글자를 포함하는 단어를 대문자로 변경하여 리스트로 저장
        List<String> langListStartsWithC = langList.stream()
                .filter(x -> x.contains("c"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        langListStartsWithC.stream().forEach(System.out::println);


    }
}
