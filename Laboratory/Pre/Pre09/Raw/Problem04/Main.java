import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("========== GAME TEAM MANAGEMENT SYSTEM ==========\n");
        
        // ============== CREATE TEAMS ==============
        GameTeam team1 = new GameTeam("Dragon Slayers");
        GameTeam team2 = new GameTeam("Phoenix Rising");
        GameTeam team3 = new GameTeam("Shadow Assassins");
        
        // ============== GAMETEAM METHODS ==============
        System.out.println("--- Adding Members to Teams ---\n");
        
        // addMember() - Add members ke team1
        team1.addMember(new Player("Alice", 85));
        team1.addMember(new Player("Bob", 92));
        team1.addMember(new Player("Charlie", 78));
        team1.addMember(new Player("Diana", 88));
        System.out.println("✓ Added 4 members to " + team1.getTeamName());
        
        // addMember() - Add members ke team2
        team2.addMember(new Player("David", 90));
        team2.addMember(new Player("Eve", 95));
        team2.addMember(new Player("Frank", 82));
        System.out.println("✓ Added 3 members to " + team2.getTeamName());
        
        // addMember() - Add members ke team3
        team3.addMember(new Player("Grace", 87));
        team3.addMember(new Player("Henry", 80));
        System.out.println("✓ Added 2 members to " + team3.getTeamName());
        
        // ============== GAMETEAM - GETTERS ==============
        System.out.println("\n--- GameTeam Information ---\n");
        
        // getTeamName() + getTeamSize()
        System.out.println(team1.getTeamName() + " - Size: " + team1.getTeamSize());
        System.out.println(team2.getTeamName() + " - Size: " + team2.getTeamSize());
        System.out.println(team3.getTeamName() + " - Size: " + team3.getTeamSize());
        
        // getAllMembers()
        System.out.println("\n--- All Members in " + team1.getTeamName() + " ---");
        for (TeamMember member : team1.getAllMembers()) {
            System.out.println("  • " + member.getName() + " (Skill: " + member.getSkillLevel() + ")");
        }
        
        // getTopSkillPlayer()
        TeamMember topPlayer = team1.getTopSkillPlayer();
        System.out.println("\n--- Top Skill Player in " + team1.getTeamName() + " ---");
        System.out.println("  " + topPlayer.getName() + " - Skill Level: " + topPlayer.getSkillLevel());
        
        // getPlayersBySkillLevel()
        System.out.println("\n--- Players with Skill >= 85 in " + team1.getTeamName() + " ---");
        for (TeamMember player : team1.getPlayersBySkillLevel(85)) {
            System.out.println("  ✓ " + player.getName() + " - Skill: " + player.getSkillLevel());
        }
        
        // findMember()
        System.out.println("\n--- Finding Member ---");
        TeamMember found = team1.findMember("Bob");
        if (found != null) {
            System.out.println("  Found: " + found.getName() + " (Skill: " + found.getSkillLevel() + ")");
        }
        
        TeamMember notFound = team1.findMember("Unknown");
        System.out.println("  Searching for 'Unknown': " + (notFound != null ? "Found" : "Not Found"));
        
        // removeMember()
        System.out.println("\n--- Removing Member ---");
        System.out.println("  Before: " + team1.getTeamName() + " has " + team1.getTeamSize() + " members");
        team1.removeMember("Charlie");
        System.out.println("  After removing 'Charlie': " + team1.getTeamName() + " has " + team1.getTeamSize() + " members");
        
        // ============== TOURNAMENT METHODS ==============
        System.out.println("\n\n========== TOURNAMENT MANAGEMENT ==========\n");
        
        Tournament tournament = new Tournament("Regional Championship 2025");
        
        // registerTeam()
        System.out.println("--- Registering Teams ---");
        tournament.registerTeam(team1);
        tournament.registerTeam(team2);
        tournament.registerTeam(team3);
        System.out.println("✓ Registered 3 teams to tournament\n");
        
        // getTotalTeams()
        System.out.println("--- Tournament Info ---");
        System.out.println("Total Teams: " + tournament.getTotalTeams());
        
        // getAllTeams()
        System.out.println("\n--- All Teams in Tournament ---");
        for (GameTeam team : tournament.getAllTeams()) {
            System.out.println("  • " + team.getTeamName() + " (" + team.getTeamSize() + " members)");
        }
        
        // getTeamsNotPlayed() - sebelum ada match
        System.out.println("\n--- Teams Not Played Yet (Before Matches) ---");
        for (String teamName : tournament.getTeamsNotPlayed()) {
            System.out.println("  • " + teamName);
        }
        
        // recordMatch()
        System.out.println("\n--- Recording Matches ---");
        tournament.recordMatch("Dragon Slayers", "Phoenix Rising");
        System.out.println("✓ Match recorded: Dragon Slayers vs Phoenix Rising");
        
        tournament.recordMatch("Phoenix Rising", "Shadow Assassins");
        System.out.println("✓ Match recorded: Phoenix Rising vs Shadow Assassins");
        
        // getTeamsNotPlayed() - sesudah ada match
        System.out.println("\n--- Teams Not Played Yet (After Matches) ---");
        List<String> notPlayed = tournament.getTeamsNotPlayed();
        if (notPlayed.isEmpty()) {
            System.out.println("  (Semua team sudah bermain)");
        } else {
            for (String teamName : notPlayed) {
                System.out.println("  • " + teamName);
            }
        }
        
        // getTeam()
        System.out.println("\n--- Lookup Team ---");
        GameTeam looked = tournament.getTeam("Dragon Slayers");
        if (looked != null) {
            System.out.println("  Found: " + looked.getTeamName() + " (" + looked.getTeamSize() + " members)");
        }
        
        GameTeam notLocked = tournament.getTeam("Unknown Team");
        System.out.println("  Searching for 'Unknown Team': " + (notLocked != null ? "Found" : "Not Found"));
        
        System.out.println("\n\n========== TOURNAMENT SUMMARY ==========\n");
        
        for (GameTeam team : tournament.getAllTeams()) {
            System.out.println("[ " + team.getTeamName() + " ]");
            System.out.println("  Members: " + team.getTeamSize());
            System.out.println("  Top Player: " + team.getTopSkillPlayer().getName());
            System.out.println("  Avg Skill: " + calculateAverageSkill(team));
            System.out.println();
        }
        
        System.out.println("========================================");
    }
    
    private static double calculateAverageSkill(GameTeam team) {
        int total = 0;
        for (TeamMember member : team.getAllMembers()) {
            total += member.getSkillLevel();
        }
        return (double) total / team.getTeamSize();
    }
}
