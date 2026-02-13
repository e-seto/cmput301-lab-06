package com.example.listycity;

import java.util.Objects;

/**
 * This is class that defines a City
 */
public class City implements Comparable<City>{
    private String city;
    private String province;

    City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * This returns the name of the city
     * @return
     *      String of the city name
     */
    String getCityName() {
        return this.city;
    }

    /**
     * This returns the name of the province the city is in
     * @return
     *      String of the province name
     */
    String getProvinceName() {
        return this.province;
    }

    /**
     * This compares a city to another city to establish an ordering (by city name)
     * @param c
     *      City to compare to
     * @return
     *      Negative int if the city is less than, 0 if equal, positive int if greater than
     */
    @Override
    public int compareTo(City c) {
        City city = (City) c;
        return this.city.compareTo(city.getCityName());
    }

    /**
     * This makes it so that a city equals another city if they have the same city and province
     * @param o
     *      the reference object with which to compare.
     * @return
     *      True if city object has same city and province, False otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        City city1 = (City) o;
        return Objects.equals(city, city1.city) && Objects.equals(province, city1.province);
    }

    /**
     * This generates a hash for a city based off the city name and province
     * @return
     *      hash of of the city as an int
     */
    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }
}
