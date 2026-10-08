package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    public void equals_returns_true_if_same_obj() {
       assertTrue(team.equals(team), "equals() error on same object");
    }

    @Test
    public void equals_returns_false_if_not_instance() {
        String test = "test";
        assertTrue(!team.equals(test), "equals() error on not an instance");
    }

    @Test
    public void equals_returns_correct_on_diff_name_and_members() {
        Team team1 = new Team("test-team");
        Team team2 = new Team("test-team2");
        assertTrue(team.equals(team1), "equals() error on same name and members");
        assertTrue(!team.equals(team2), "equals() error on diff name and same members");
        team1.addMember("Guy");
        assertTrue(!team.equals(team1), "equals() error on same name and diff members");
    }

    @Test
    public void hashCode_returns_correct() {
        Team team1 = new Team("test-team");
        Team team2 = new Team("test-team");
        team1.addMember("Guy");
        team2.addMember("Guy");
        assertEquals(team1.hashCode(), team2.hashCode());  

        int result = team1.hashCode();
        int expectedResult = -1226228742;
        assertEquals(expectedResult, result);
    }
}
