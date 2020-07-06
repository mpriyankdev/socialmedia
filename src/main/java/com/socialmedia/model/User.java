package com.socialmedia.model;

import lombok.*;

@EqualsAndHashCode
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String userId;
    private String userName;
}
