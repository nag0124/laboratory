package nag.laboratory.datetime;

import java.time.Instant;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

@MappedSuperclass // 엔티티 간의 공통 정보를 정의하기 위해 쓰인다. BaseTimeEntity를 상속 받으면 createdTime이 자동으로 엔티티에 추가된다.
@EntityListeners(AuditingEntityListener.class) // 이벤트의 종류에 따라 자동으로 이벤트를 처리한다.
@Getter
public abstract class BaseTimeEntity {

    @CreatedDate // 생성 시간을 넣어준다.
    private Instant createdTime;

}
