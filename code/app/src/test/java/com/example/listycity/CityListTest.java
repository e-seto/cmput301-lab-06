package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Whitehorse", "Yukon");
        City notCity = new City("Hoiping", "Canton");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertFalse(cityList.hasCity(notCity));
        assertTrue(cityList.hasCity(city));
    }

    @Test
    void testDelete() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        cityList.delete(mockCity());
        assertEquals(0, cityList.getCities().size());
        assertFalse(cityList.getCities().contains(mockCity()));
    }

    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();
        cityList.delete(mockCity());
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(mockCity());
        });
    }

    @Test
    void testCountCities() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());
        City city1 = new City("Winnipeg", "Manitoba");
        cityList.add(city1);
        assertEquals(2, cityList.countCities());
        City city2 = new City("Vancouver", "British Columbia");
        City city3 = new City("Iqaluit", "Nunavut");
        cityList.add(city2);
        cityList.add(city3);
        assertEquals(4, cityList.countCities());
        cityList.delete(mockCity());
        assertEquals(3, cityList.countCities());
        cityList.delete(city1);
        cityList.delete(city2);
        cityList.delete(city3);
        assertEquals(0, cityList.countCities());
    }
}
