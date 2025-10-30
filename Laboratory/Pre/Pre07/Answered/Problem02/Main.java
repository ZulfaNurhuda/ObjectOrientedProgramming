public class Main {
    public static void main(String[] args) {
        ChampionDuel<Integer> integerDuel = new ChampionDuel<>("Numeric", 12, 9);
        System.out.println(integerDuel.report());

        ChampionDuel<String> stringDuel = new ChampionDuel<>("Lexicographic", "Alice", "Bob");
        System.out.println(stringDuel.report());

        Player p1 = new Player("Alice", 80);
        Player p2 = new Player("Bob", 95);
        Player p3 = new Player("Carol", 88);

        Player trainedCarol = p3.boostScore(10);
        Player headToHead = p1.faceOff(p2);

        System.out.println("Head-to-head champion between " + p1 + " and " + p2
                + " is: " + headToHead);

        System.out.println("Champion among " + p1 + ", " + p2 + ", and " + trainedCarol
                + " is: " + ChampionFinder.findChampion(p1, p2, trainedCarol));
    }
}
