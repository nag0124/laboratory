package nag.laboratory.datetime;

import java.time.Instant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class DateTimeResponse {

    private final Instant createdTime;

}
