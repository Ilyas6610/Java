import java.util.Objects;

public class Owner {
    private final long ownerId;
    private final String name;
    private final String lastName;
    private final int age;

    public Owner(long ownerId, String name, String lastName, int age) {
        this.ownerId = ownerId;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return ownerId == owner.ownerId && age == owner.age && name.equals(owner.name) && lastName.equals(owner.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ownerId, name, lastName, age);
    }
}