import java.util.Objects;

public class Holding extends Client {
    private final String ceo;

    public Holding(String name, int inn, String ceo) {
        super(name, inn);
        this.ceo = ceo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Holding holding = (Holding) o;
        return Objects.equals(ceo, holding.ceo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ceo);
    }

    public String getCEO() {
        return ceo;
    }
}
