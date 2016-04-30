package statistics;

import statistics.matcher.*;

public class QueryBuilder {

    private Matcher matcher;

    public QueryBuilder() {
        matcher = new And();
    }

    public QueryBuilder hasAtLeast(int value, String field) {
        matcher = new And(matcher, new HasAtLeast(value, field));
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String field) {
        matcher = new And(matcher, new HasFewerThan(value, field));
        return this;
    }

    public QueryBuilder playsIn(String team) {
        matcher = new And(matcher, new PlaysIn(team));
        return this;
    }

    public QueryBuilder not(Matcher... matchers) {
        matcher = new Not(matchers);
        return this;
    }

    public QueryBuilder oneOf(Matcher... matchers) {
        matcher = new Or(matchers);
        return this;
    }

    public Matcher build() {
        Matcher m = matcher;
        matcher = new And();
        return m;
    }
}
