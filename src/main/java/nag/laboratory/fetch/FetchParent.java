package nag.laboratory.fetch;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "parents")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class FetchParent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parent_id")
    private Long id;

    @Column
    private String name;

    @Column()
    private Integer age;

    @OneToMany(mappedBy = "parents")
    private List<FetchChild> children;

}

