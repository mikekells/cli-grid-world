package uk.co.kellsnet;

public class Entity {

    private final char glyph;
    private final Position position;

    public Entity(char glyph, Position position) {
        this.glyph = glyph;
        this.position = position;
    }

    public char getGlyph() {
        return glyph;
    }

    public Position getPosition() {
        return position;
    }

}
