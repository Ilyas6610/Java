import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class MyGarage implements Garage {

    private final Map<Owner, Set<Car>> ownerCarMap = new HashMap<>();
    private final Map<Car, Owner> carOwnerMap = new TreeMap<>(
            Comparator.comparingInt(Car::getPower));
    private final Set<Owner> ownerSet = new HashSet<>();
    private final Map<String, Set<Car>> brandCarsMap = new HashMap<>();
    private final Map<BigInteger, Car> idCarMap = new HashMap<>();
    private final Set<Car> carSet = new TreeSet<>(
            Comparator.comparingInt(Car::getMaxVelocity));
    public Collection<Owner> allCarsUniqueOwners() {
        return ownerSet;
    }

    /**
     * Complexity should be less than O(n)
     */
    public Collection<Car> topThreeCarsByMaxVelocity() {
        ArrayList<Car> cars = new ArrayList<>();
        Iterator<Car> it = carSet.iterator();
        for (int i = 0; i < 3; i++) {
            if (!it.hasNext())
                break;
            cars.add(it.next());
        }
        return cars;
    }

    /**
     * Complexity should be O(1)
     */
    public Collection<Car> allCarsOfBrand(String brand) {
        return brandCarsMap.get(brand);
    }

    /**
     * Complexity should be less than O(n)
     */
    public Collection<Car> carsWithPowerMoreThan(int power) {
        return carOwnerMap.keySet().stream().filter(c -> c.getPower() > power).collect(Collectors.toSet());
    }

    /**
     * Complexity should be O(1)
     */
    public Collection<Car> allCarsOfOwner(Owner owner) {
        return ownerCarMap.get(owner);
    }

    /**
     * @return mean value of owner age that has cars with given brand
     */
    public int meanOwnersAgeOfCarBrand(String brand) {
        Set<Car> cars = brandCarsMap.get(brand);
        int res = 0, owners = 0;
        for (Car car : cars) {
            owners++;
            res += carOwnerMap.get(car).getAge();
        }
        return res / owners;
    }

    /**
     * @return mean value of cars for all owners
     */
    public int meanCarNumberForEachOwner() {
        int cars = 0, owners = 0;
        for (Set<Car> s : ownerCarMap.values()) {
            owners++;
            cars += s.size();
        }
        return cars / owners;
    }

    /**
     * Complexity should be less than O(n)
     *
     * @return removed car
     */
    public Car removeCar(int carId) {
        Car car = idCarMap.get(BigInteger.valueOf(carId));
        Owner owner = carOwnerMap.get(car);
        ownerCarMap.get(owner).remove(car);
        brandCarsMap.get(car.getBrand()).remove(car);
        carOwnerMap.remove(car);
        carSet.remove(car);
        idCarMap.remove(car.getCarId());
        return car;
    }

    /**
     * Complexity should be less than O(n)
     */
    public void addCar(Car car, Owner owner) {
        if (!ownerCarMap.containsKey(owner)) {
            ownerCarMap.put(owner, new HashSet<>());
        }
        ownerCarMap.get(owner).add(car);
        carOwnerMap.put(car, owner);
        ownerSet.add(owner);
        if (!brandCarsMap.containsKey(car.getBrand())) {
            brandCarsMap.put(car.getBrand(), new HashSet<>());
        }
        brandCarsMap.get(car.getBrand()).add(car);
        idCarMap.put(BigInteger.valueOf(car.getCarId()), car);
        carSet.add(car);
    }
}
