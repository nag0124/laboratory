package nag.laboratory.datetime;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class DateTimeResponse {

    private final Instant createdTime;

    private DateTimeResponse(DateTime dateTime) {
        this.createdTime = dateTime.getCreatedTime();
    }

    public static List<DateTimeResponse> from(List<DateTime> dateTimes) {
        return dateTimes.stream()
                .map(DateTimeResponse::new)
                .collect(Collectors.toUnmodifiableList());
    }

}
