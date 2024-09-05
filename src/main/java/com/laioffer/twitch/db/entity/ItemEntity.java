package com.laioffer.twitch.db.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.laioffer.twitch.external.model.Clip;
import com.laioffer.twitch.external.model.Stream;
import com.laioffer.twitch.external.model.Video;
import com.laioffer.twitch.model.ItemType;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

// 用来描述 ItemType的
// 从 twitch 里拿来的 会在这里转换
@Table("items")
    public record ItemEntity(
            @Id Long id,    // @Id = primary Key，match table里的 主键
            @JsonProperty("twitch_id") String twitchId,
            String title,
            String url,
            @JsonProperty("thumbnail_url") String thumbnailUrl,
            @JsonProperty("broadcaster_name") String broadcasterName,
            @JsonProperty("game_id") String gameId,
            @JsonProperty("item_type") ItemType type    // 我们自己定义的ItemType
    ) {

        public ItemEntity(String gameId, Video video) {
            this(null, video.id(), video.title(), video.url(), video.thumbnailUrl(), video.userName(), gameId, ItemType.VIDEO);
        }

        public ItemEntity(Clip clip) {
            this(null, clip.id(), clip.title(), clip.url(), clip.thumbnailUrl(), clip.broadcasterName(), clip.gameId(), ItemType.CLIP);
        }

        public ItemEntity(Stream stream) {
            this(null, stream.id(), stream.title(), null, stream.thumbnailUrl(), stream.userName(), stream.gameId(), ItemType.STREAM);
        }
    }

