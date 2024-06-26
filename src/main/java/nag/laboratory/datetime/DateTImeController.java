package nag.laboratory.datetime;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/date-time")
@RequiredArgsConstructor
public class DateTImeController {

    private final DateTimeService dateTimeService;

    @PostMapping
    public ResponseEntity<DateTimeResponse> createDateTime() {
        DateTimeResponse response = dateTimeService.createDateTime();

        return ResponseEntity.ok()
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<DateTimeResponse>> readDateTimes() {
        List<DateTimeResponse> responses = dateTimeService.readDateTimes();

        return ResponseEntity.ok()
                .body(responses);
    }

}
