package nag.laboratory.datetime;

import java.time.Instant;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DateTimeService {

    private final DateTimeRepository dateTimeRepository;

    @Transactional
    public DateTimeResponse createDateTime() {
        DateTime dateTime = dateTimeRepository.save(new DateTime());

        return new DateTimeResponse(dateTime.getCreatedTime());
    }

}
