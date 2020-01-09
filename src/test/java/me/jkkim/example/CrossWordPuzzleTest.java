package me.jkkim.example;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CrossWordPuzzleTest {

    @Test
    public void BANANA_PIDZAMA() {
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

    @Test
    public void MAMA_TATA() {
        String a = "MAMA";
        String b = "TATA";
        List<String> expected = Arrays.asList(
                ".T..",
                "MAMA",
                ".T..",
                ".A.."
        );

        List<String> actual = CrossWordPuzzle.solve(a, b);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void REPUBLIKA_HRVATSKA() {
        String a = "REPUBLIKA";
        String b = "HRVATSKA";
        List<String> expected = Arrays.asList(
                "H........",
                "REPUBLIKA",
                "V........",
                "A........",
                "T........",
                "S........",
                "K........",
                "A........"
        );

        List<String> actual = CrossWordPuzzle.solve(a, b);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void NOCOMMON_ABABABABABAB() {
        String a = "NOCOMMON";
        String b = "ABABABABAB";
        List<String> expected = Arrays.asList(
                "........",
                "........",
                "........",
                "........",
                "........",
                "........",
                "........",
                "........",
                "........",
                "........"
        );

        List<String> actual = CrossWordPuzzle.solve(a, b);
        assertThat(actual).isEqualTo(expected);
    }

}
