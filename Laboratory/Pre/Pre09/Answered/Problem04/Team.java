public interface Team {
    void addMember(TeamMember member);
    void removeMember(String memberName);
    TeamMember findMember(String memberName);
}