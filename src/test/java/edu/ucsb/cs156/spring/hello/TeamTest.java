package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void testEquals_SameObject() {
        assertTrue(team.equals(team));
    }

    @Test
    public void testEquals_NullArgument() {
        assertFalse(team.equals(null));
    }

    @Test
    public void testEquals_DifferentClass() {
        assertFalse(team.equals("not a team object"));
    }

    @Test
    public void testEquals_DifferentObject_SameContent_TT() {
        Team team1 = new Team("content-team");
        Team team2 = new Team("content-team");
        assertTrue(team1.equals(team2));
        assertTrue(team2.equals(team1));
    }

    @Test
    public void testEquals_DifferentName_FStar() {
        Team team1 = new Team("team-alpha");
        Team team2 = new Team("team-beta");
        assertFalse(team1.equals(team2));
        assertFalse(team2.equals(team1));
    }

    @Test
    public void testEquals_SameName_DifferentMembers_TF() {
        Team teamA = new Team("shared-name");
        Team teamB = new Team("shared-name");

        try {
            teamA.getClass().getMethod("addMember", String.class).invoke(teamA, "member1");
        } catch (NoSuchMethodException e) {
            throw new AssertionError("Cannot run testEquals_SameName_DifferentMembers_TF: Team class is missing an 'addMember(String)' method.", e);
        } catch (Exception e) {
            throw new RuntimeException("Failed to add member via reflection for test setup", e);
        }

        assertFalse(teamA.equals(teamB));
        assertFalse(teamB.equals(teamA));
    }

    // hashcode tests
    @Test
    public void testHashCode_contract_equalObjectsEqualHashCodes() {
        Team team1 = new Team("test-team");
        Team team2 = new Team("test-team");

        assertTrue(team1.equals(team2));
        assertTrue(team.equals(team1));

        assertEquals(team1.hashCode(), team2.hashCode());
        assertEquals(team.hashCode(), team1.hashCode());
    }

    @Test
    public void testHashCode_contract_differentObjectsPreferablyDifferentHashCodes() {
        Team team1 = new Team("test-team");
        Team team2 = new Team("another-team");

        assertFalse(team1.equals(team2));

        assertNotEquals(team1.hashCode(), team2.hashCode());
    }

    @Test
    public void testHashCode_specificValueToCheckImplementation() {
        int expectedHashCode = -1226298695;

        assertEquals(expectedHashCode, team.hashCode());
    }
}
