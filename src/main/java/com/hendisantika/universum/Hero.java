package com.hendisantika.universum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-mysql-testcontainer
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 9/3/22
 * Time: 08:54
 * To change this template use File | Settings | File Templates.
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Hero {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String city;

    private ComicUniversum universum;

    public Hero(String name, String city, ComicUniversum universum) {
        this.name = name;
        this.city = city;
        this.universum = universum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return Objects.equals(name, hero.name) &&
                Objects.equals(city, hero.city) &&
                universum == hero.universum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, city, universum);
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", universum=" + universum.getDisplayName() +
                '}';
    }
}
