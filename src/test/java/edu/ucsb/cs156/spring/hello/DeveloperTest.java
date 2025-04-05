package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Jim W.", Developer.getName());
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

    @Test
    public void getGithubId_returns_correct_githubId() {
        assertEquals("jiwa310", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team  t = Developer.getTeam();
        assertEquals("s25-05", t.getName());
    }

    @Test
    public void getTeam_returns_team_with_Jim_W() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Jim W."));
    }

    @Test
    public void getTeam_returns_team_with_Austin_Q() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Austin Q."));
    }

    @Test
    public void getTeam_returns_team_with_Awin_Z() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Awin Z."));
    }

    @Test
    public void getTeam_returns_team_with_Hien_H() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Hien H."));
    }

    @Test
    public void getTeam_returns_team_with_Michael_T() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Michael T."));
    }

    @Test
    public void getTeam_returns_team_with_Vishal_S() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Vishal S."));
    }


}
