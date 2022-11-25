import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Nonnull;

public class Application {

    @FunctionalInterface
    public interface StringFunc {
        String reverseString(String word);
    }

    public static void main(String[] args) {
//        System.out.println(reverseString());
        System.out.println(countNumbersGreaterThan(19));
    }

    /**
     * Prints the reversed version of a string using a functional interface and lambda function.
     *
     * @return the reversed string
     */
    public static String reverseString() {
        StringFunc lambdaStringFunction = s -> Stream.of(s)
                .map(word -> new StringBuilder(word)
                        .reverse())
                .collect(Collectors.joining(" "));

        return lambdaStringFunction.reverseString("Apple is great!");
    }

    /**
     * Prints the count of numbers greater (less) than a certain number.
     * Uses local variable syntax for lambda parameters.
     * TODO: make it for 'less' as well.
     *
     * @param number the number to compare to
     * @return the count of numbers in the list that satisfy the condition
     */
    public static int countNumbersGreaterThan(int number) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(3);
        numbers.add(15);
        numbers.add(0);
        numbers.add(64);

        AtomicInteger count = new AtomicInteger();

        numbers.forEach((@Nonnull var n) -> {
            if (n > number) {
                count.getAndIncrement();
            }
        });

        return count.get();
    }
}
