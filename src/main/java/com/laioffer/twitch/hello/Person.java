package com.laioffer.twitch.hello;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Person(String name,
                     String company,
                     // @JsonProperty 改变return 格式，snake case
                     @JsonProperty("home_address") Address homeAddress,
                     @JsonProperty("favorite_book")Book favoriteBook
) {

}
