package me.jkkim.example;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CrossWordPuzzleTest {

    @Test
    public void whenBananaAndPidzama_thenOK() {
        String a = "BANANA";
        String b = "PIDZAMA";
        List<String> expected = Arrays.asList(
                ".P....",
                ".I....",
                ".D....",
                ".Z....",
                "BANANA",
                ".M....",
                ".A...."
        );

        List<String> actual = CrossWordPuzzle.solve(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
