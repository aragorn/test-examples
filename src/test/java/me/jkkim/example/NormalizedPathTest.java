package me.jkkim.example;

import org.junit.Test;

import static me.jkkim.example.NormalizedPath.solve;
import static org.assertj.core.api.Assertions.assertThat;

public class NormalizedPathTest {

    @Test
    public void testRelativePaths_Already_Normalized() {
        assertThat(solve("a")).isEqualTo("a");
        assertThat(solve("a/b/c/d")).isEqualTo("a/b/c/d");
        assertThat(solve("..")).isEqualTo("..");
        assertThat(solve("../a.txt")).isEqualTo("../a.txt");
        assertThat(solve("../../b.txt")).isEqualTo("../../b.txt");
    }

    @Test
    public void testRelativePaths_Easy() {
        assertThat(solve("a/b/../b/c/d")).isEqualTo("a/b/c/d");
        assertThat(solve("./a")).isEqualTo("a");
        assertThat(solve(".././a")).isEqualTo("../a");
        assertThat(solve("./../a.txt")).isEqualTo("../a.txt");
        assertThat(solve("../c/d/../../b.txt")).isEqualTo("../b.txt");
    }

    @Test
    public void testRelativePaths_Tricky() {
        assertThat(solve("")).isEqualTo("");
        assertThat(solve(".")).isEqualTo("");
        assertThat(solve("./././././././")).isEqualTo("");
    }

    @Test
    public void testCase1() {
        assertThat(solve("/home/user")).isEqualTo("/home/user");
        assertThat(solve("/home/user/")).isEqualTo("/home/user");
        assertThat(solve("../david/work")).isEqualTo("../david/work");
    }

    @Test
    public void testCase2() {
        assertThat(solve("/home/user/../david/work")).isEqualTo("/home/david/work");
        assertThat(solve("/home/user/.m2/cache")).isEqualTo("/home/user/.m2/cache");
        assertThat(solve("/home/user//.m2///cache//")).isEqualTo("/home/user/.m2/cache");
    }

    @Test
    public void testCase3() {
        assertThat(solve("/home/user/.cache./13../57../90")).isEqualTo("/home/user/.cache./13../57../90");
        assertThat(solve("/home/user/.cache./13../../../24.././../../david/57/90")).isEqualTo("/home/david/57/90");
        assertThat(solve("/home/user/.cache./13/.../..../")).isEqualTo("/home/user/.cache./13/.../....");
        assertThat(solve("/home/user/.cache./13/.../..../24/./../../david/57/90")).isEqualTo("/home/user/.cache./13/.../david/57/90");
        assertThat(solve("/tmp/../home/ubuntu")).isEqualTo("/home/ubuntu");
        assertThat(solve("/tmp/../home/./ubuntu")).isEqualTo("/home/ubuntu");
        assertThat(solve("/tmp/v/a/../..")).isEqualTo("/tmp");
        assertThat(solve("/./././.")).isEqualTo("/");
    }

    @Test
    public void testCase4() {
        assertThat(solve("")).isEqualTo("");
        assertThat(solve(".")).isEqualTo("");
        assertThat(solve("/home/user/../../../../../../../tmp/david")).isEqualTo("/tmp/david");
        assertThat(solve("path/to/file/../../../")).isEqualTo("");
    }

}
