import java.util.*;

public class GameTeam implements Team {
    private String teamName;
    
    // TODO: Gunakan List untuk menyimpan urutan anggota team
    
    // TODO: Gunakan Map untuk quick lookup member berdasarkan nama
    
    public GameTeam(String teamName) {
        this.teamName = teamName;
        this.members = new ArrayList<>();
        this.memberMap = new HashMap<>();
    }
    
    // TODO: Implement addMember
    // Tambahkan member ke List dan Map
    // Tambahkan role "Player" ke Set
    
    // TODO: Implement removeMember
    // Cari dan hapus member dari List menggunakan iterator
    // Hapus dari Map juga
    
    // TODO: Implement findMember
    // Gunakan Map untuk quick lookup
    
    // TODO: Buat method getAllMembers() return List<TeamMember>
    
    // TODO: Buat method getTeamSize() return int
    
    // TODO: Buat method getTopSkillPlayer() return TeamMember
    // Loop melalui List dan cari player dengan skill tertinggi
    
    // TODO: Buat method getPlayersBySkillLevel(int minSkill) return List<TeamMember>
    // Filter players yang skill-nya >= minSkill
    
    // TODO: Buat method getTeamName() return String
}