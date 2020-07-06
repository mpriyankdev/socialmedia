package com.socialmedia.model;

import lombok.*;

import java.time.OffsetDateTime;

@EqualsAndHashCode
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    private String postId;
    private OffsetDateTime postTime;
    private String content;


}
