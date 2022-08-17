package io.pragra.jpareview.dtos;

import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@Builder
@Getter
public class ErrorDto {
    private String errCode;
    private String errMessage;
    private String apiCode;
    private Instant timeStamp;
}
