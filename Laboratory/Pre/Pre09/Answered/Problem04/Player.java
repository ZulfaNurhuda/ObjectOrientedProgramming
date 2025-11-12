public class Player implements TeamMember {
    private String name;
    private int skillLevel;
    
    public Player(String name, int skillLevel) {
        this.name = name;
        this.skillLevel = skillLevel;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public int getSkillLevel() {
        return skillLevel;
    }
    
    @Override
    public void performTask(String task) {
        System.out.println(name + " sedang melakukan task: " + task);
    }
}