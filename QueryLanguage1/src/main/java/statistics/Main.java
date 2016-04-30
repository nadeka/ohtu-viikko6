package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
        QueryBuilder query = new QueryBuilder();
        Matcher m = query.hasAtLeast(40, "assists").hasFewerThan(70, "goals").playsIn("PHI").build();
        Matcher m2 = query.playsIn("PHI").playsIn("COL").build();

        Matcher m3 = query.oneOf(m, m2).build();
        
        for (Player player : stats.matches(m3)) {
            System.out.println( player );
        }
    }
}
