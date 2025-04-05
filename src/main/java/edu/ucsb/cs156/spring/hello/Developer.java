package edu.ucsb.cs156.spring.hello;

/**
 * A class with static methods to provide information about the developer.
 */

public class Developer {

    // This class is not meant to be instantiated
    // so we make the constructor private

    private Developer() {}
    
    /**
     * Get the name of the developer
     */

    public static String getName() {
        return "Jim W.";
    }

    /**
     * Get the github id of the developer
     * @return github id of the developer
     */

    public static String getGithubId() {
        return "jiwa310";
    }

    /**
     * Get the developers team
     * @return developers team as a Java object
     */
    
    public static Team getTeam() {
        Team team = new Team("s25-05");
        team.addMember("Austin Q.");
        team.addMember("Awin Z.");
        team.addMember("Hien H.");
        team.addMember("Jim W.");
        team.addMember("Michael T.");
        team.addMember("Vishal S.");
        return team;
    }
}
