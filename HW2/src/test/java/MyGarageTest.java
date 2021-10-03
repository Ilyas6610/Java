import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyGarageTest {

    @Test
    public void testAllCarsUniqueOwners() {
        Garage garage = new MyGarage();
        Set<Owner> ans = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            Car car = new Car(i, "" + i % 5, "" + i, (i + 1) * 20, (i + 2) * 20, i);
            Owner owner = new Owner(i, "owner " + i, "owner -" + i % 20, i % 20 + 20);
            ans.add(owner);
            garage.addCar(car, owner);
        }
        assertEquals(ans, garage.allCarsUniqueOwners());
    }

    @Test
    public void testTopThreeCarsByMaxVelocity() {
        Garage garage = new MyGarage();
        ArrayList<Car> ans = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Car car = new Car(i, "" + i % 5, "" + i, (i + 1) * 20, (i + 2) * 20, i);
            Owner owner = new Owner(i, "owner " + i, "owner -" + i % 20, i % 20 + 20);
            if (i > 96) {
                ans.add(car);
            }
            garage.addCar(car, owner);
        }
        Collections.reverse(ans);
        assertEquals(ans, garage.topThreeCarsByMaxVelocity());
    }

    @Test
    public void testAllCarsOfBrand() {
        Garage garage = new MyGarage();
        Set<Car> ans = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            Car car = new Car(i, "" + i % 5, "" + i, (i + 1) * 20, (i + 2) * 20, i);
            Owner owner = new Owner(i, "owner " + i, "owner -" + i % 20, i % 20 + 20);
            if (i % 5 == 0) {
                ans.add(car);
            }
            garage.addCar(car, owner);
        }
        assertEquals(ans, garage.allCarsOfBrand("0"));
    }

    @Test
    public void testCarsWithPowerMoreThan() {
        Garage garage = new MyGarage();
        Set<Car> ans = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            Car car = new Car(i, "" + i % 5, "" + i, (i + 1) * 20, (i + 2) * 20, i);
            Owner owner = new Owner(i, "owner " + i, "owner -" + i % 20, i % 20 + 20);
            if ((i + 2) * 20 > 100) {
                ans.add(car);
            }
            garage.addCar(car, owner);
        }
        assertEquals(ans, garage.carsWithPowerMoreThan(100));
    }

    @Test
    public void testAllCarsOfOwner() {
        Garage garage = new MyGarage();
        Set<Car> ans = new HashSet<>();
        Owner o = new Owner(0, "owner 0", "owner -0", 20);
        for (int i = 0; i < 100; i++) {
            Car car = new Car(i, "" + i % 5, "" + i, (i + 1) * 20, (i + 2) * 20, i);
            Owner owner = new Owner(i % 10, "owner " + i % 10, "owner -" + i % 10, i % 10 + 20);
            if (owner.equals(o))
                ans.add(car);
            garage.addCar(car, owner);
        }
        assertEquals(ans, garage.allCarsOfOwner(o));
    }

    @Test
    public void testMeanOwnersAgeOfCarBrand() {
        Garage garage = new MyGarage();
        int x = 0, num = 0;
        for (int i = 0; i < 100; i++) {
            Car car = new Car(i, "" + i % 5, "" + i, (i + 1) * 20, (i + 2) * 20, i);
            Owner owner = new Owner(i, "owner " + i, "owner -" + i % 20, i % 20 + 20);
            if (i % 5 == 0) {
                x += owner.getAge();
                num++;
            }
            garage.addCar(car, owner);
        }
        assertEquals(x / num, garage.meanOwnersAgeOfCarBrand("0"));
    }

    @Test
    public void testMeanCarNumberForEachOwner() {
        Garage garage = new MyGarage();
        for (int i = 0; i < 100; i++) {
            Car car = new Car(i, "" + i % 5, "" + i, (i + 1) * 20, (i + 2) * 20, i);
            Owner owner = new Owner(i % 10, "owner " + i % 10, "owner -" + i % 10, i % 10 + 20);
            garage.addCar(car, owner);
        }
        assertEquals(10, garage.meanCarNumberForEachOwner());
    }

    @Test
    public void testRemoveCar() {

        Garage garage = new MyGarage();
        garage.addCar(new Car(0, "Brand", "model", 100, 100, 1),
                new Owner(1, "Ivan", "Ivanov", 20));
        Car car = garage.removeCar(0);
        assertEquals(new Car(0, "Brand", "model", 100, 100, 1), car);
    }
}
