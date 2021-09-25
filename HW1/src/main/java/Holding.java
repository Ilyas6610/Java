import java.util.Objects;

public class Holding extends Client {
    private final String CEO;

    public Holding(String name, int inn, String CEO) {
        super(name, inn);
        this.CEO = CEO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Holding holding = (Holding) o;
        return Objects.equals(CEO, holding.CEO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), CEO);
    }

    public String getCEO() {
        return CEO;
    }
}
