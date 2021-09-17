package se.humanit.sellshells.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CASES", schema = "assignment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CaseInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private String price;

    @Column(name = "RATING")
    private String rating;

    @Column(name = "MANUFACTURER")
    private String manufacturer;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="CASE_ID")
    private List<PhoneCase> phoneCases = new ArrayList<>();

    @OneToMany
    @JoinColumn(name="TYPE_ID")
    private List<CaseImages> caseImages = new ArrayList<>();
}
