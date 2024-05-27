package com.hendisantika.postgresql;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-mysql-testcontainer
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 3/6/23
 * Time: 13:16
 * To change this template use File | Settings | File Templates.
 */

@DataJpaTest
class RestaurantRefactoredTest extends DatabaseTest2 {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Test
    void restaurantsWithAnAverageRatingOfEight_AreTopRatedRestaurants4() {

        var topRestaurant = new Restaurant("Café Java");
        topRestaurant.rate(10);

        var normalRestaurant = new Restaurant("Jakarta Restaurant");
        normalRestaurant.rate(8);
        normalRestaurant.rate(7);

        restaurantRepository.save(topRestaurant);
        restaurantRepository.save(normalRestaurant);

        List<Restaurant> topRestaurants = restaurantRepository.findTopRatedRestaurants();
        assertEquals(1, topRestaurants.size());
        assertEquals("Café Java", topRestaurants.get(0).getName());
    }
}
