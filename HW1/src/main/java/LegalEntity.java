import java.util.Objects;

public class LegalEntity extends Client {
    private final int capital;

    public LegalEntity(String name, int inn, int capital) {
        super(name, inn);
        this.capital = capital;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LegalEntity that = (LegalEntity) o;
        return capital == that.capital;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), capital);
    }

    public int getCapital() {
        return capital;
    }
}
