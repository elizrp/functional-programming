import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {

    @FunctionalInterface
    public interface StringFunc {
        String reverseString(String word);
    }

    public static void main(String[] args) {
        StringFunc lambdaStringFunction = (s) -> Stream.of(s)
                .map( word -> new StringBuilder(word)
                        .reverse())
                .collect(Collectors.joining(" "));

        System.out.println(lambdaStringFunction.reverseString("Apple is great"));
    }
}
