package com.hendisantika.postgresql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-mysql-testcontainer
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 3/6/23
 * Time: 13:11
 * To change this template use File | Settings | File Templates.
 */
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    @Query(value = "SELECT r FROM Restaurant r LEFT JOIN r.ratings ra GROUP BY r having avg(ra.score) >= 8")
    List<Restaurant> findTopRatedRestaurants();
}
