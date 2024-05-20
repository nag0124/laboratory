package nag.laboratory.datetime;

import java.sql.Timestamp;
import java.time.Instant;

import javax.persistence.AttributeConverter;

// JPA에서 지원하지 않는 클래스라고 해도 이 클래스를 사용해서 DB에 저장할 때 변환해 줄 수 있다.
public class InstantConverter implements AttributeConverter<Instant, Timestamp> {

    // Entity의 필드를 DB에 저장할 때 변환하는 메서드, JDBC에서는 Timestamp 타입을 사용하기에 변경해야 한다.
    @Override
    public Timestamp convertToDatabaseColumn(Instant instant) {
        if (instant == null) return null;

        return Timestamp.from(instant);
    }

    // DB의 레코드를 Entity로 변환 쓰이는 메서드
    @Override
    public Instant convertToEntityAttribute(Timestamp timestamp) {
        if (timestamp == null) return null;

        return timestamp.toInstant();
    }

}
