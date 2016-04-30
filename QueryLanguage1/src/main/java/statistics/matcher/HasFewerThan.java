package statistics.matcher;

import statistics.Player;

import java.lang.reflect.Method;

public class HasFewerThan implements Matcher {

    private String field;
    private int value;

    public HasFewerThan(int value, String field) {
        this.field = "get"+Character.toUpperCase(field.charAt(0)) + field.substring(1, field.length());
        this.value = value;
    }

    @Override
    public boolean matches(Player p) {
        try {
            Method method = p.getClass().getMethod(field);
            int playerValue = (Integer) method.invoke(p);
            return playerValue <= value;
        } catch (Exception e) {
            System.out.println(e);
            throw new IllegalStateException("Player does not have field " + field.substring(3, field.length()).toLowerCase());
        }
    }
}
