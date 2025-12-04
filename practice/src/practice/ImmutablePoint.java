package practice;
public final class ImmutablePoint {
    private final int x;
    private final int y;

    public ImmutablePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    // returns a new instance instead of mutating
    public ImmutablePoint moveBy(int dx, int dy) {
        return new ImmutablePoint(x + dx, y + dy);
    }

    @Override
    public String toString() {
        return "ImmutablePoint{" + "x=" + x + ", y=" + y + '}';
    }
}

