package com.hendisantika.universum;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-mysql-testcontainer
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 9/3/22
 * Time: 08:53
 * To change this template use File | Settings | File Templates.
 */
public enum ComicUniversum {
    MARVEL("Marvel"),
    DC_COMICS("DC Comic");

    private final String displayName;

    ComicUniversum(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
