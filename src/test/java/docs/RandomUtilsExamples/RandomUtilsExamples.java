package docs.RandomUtilsExamples;

import org.junit.jupiter.api.Test;

import static utils.RandomUtils.getRandomString;

public class RandomUtilsExamples {

    @Test
    void randomUtilsExamples(){
        System.out.println("Random string of 10 letters: " + getRandomString(10));
    }
}
