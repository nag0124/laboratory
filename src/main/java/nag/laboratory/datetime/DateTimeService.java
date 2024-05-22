package nag.laboratory.datetime;

import java.util.List;

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

    @Transactional(readOnly = true)
    public List<DateTimeResponse> readDateTimes() {
        List<DateTime> dateTimes = dateTimeRepository.findAll();

        return DateTimeResponse.from(dateTimes);
    }

}
