import java.util.*;

public class Tournament {
    private String tournamentName;
    
    // TODO: Gunakan List untuk urutan tim
    
    // TODO: Gunakan Map untuk quick lookup tim berdasarkan nama
    
    // TODO: Gunakan Set untuk track nama-nama tim yang sudah bertanding
    
    public Tournament(String tournamentName) {
        this.tournamentName = tournamentName;
        this.teams = new ArrayList<>();
        this.teamMap = new HashMap<>();
        this.playedTeams = new HashSet<>();
    }
    
    // TODO: Buat method registerTeam(GameTeam team)
    // Tambahkan team ke List dan Map
    
    // TODO: Buat method getTeam(String teamName) return GameTeam
    // Gunakan Map untuk lookup
    
    // TODO: Buat method recordMatch(String team1Name, String team2Name)
    // Tambahkan kedua tim ke playedTeams Set
    
    // TODO: Buat method getTotalTeams() return int
    
    // TODO: Buat method getTeamsNotPlayed() return List<String>
    // Return team yang belum bertanding (tidak ada di Set playedTeams)
    
    // TODO: Buat method getAllTeams() return List<GameTeam>
}