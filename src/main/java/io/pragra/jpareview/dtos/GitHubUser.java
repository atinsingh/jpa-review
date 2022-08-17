package io.pragra.jpareview.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.Instant;

@Data
public class GitHubUser {
    private Long id;
    private String login;
    @JsonProperty("avatar_url")
    private String avatarUrl;
    private String name;
    private String location;
    @JsonProperty("created_at")
    private Instant createdAt;
}
