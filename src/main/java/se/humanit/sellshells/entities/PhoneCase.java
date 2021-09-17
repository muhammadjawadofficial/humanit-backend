package se.humanit.sellshells.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PHONE_CASE", schema = "assignment")
@NoArgsConstructor
@AllArgsConstructor
public class PhoneCase implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "CASE_ID")
    private Integer caseId;

    @ManyToOne(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
    @JoinColumn(name="PHONE_ID")
    private Phone phoneInfo;

    @Column(name = "QUANTITY")
    private Integer quantity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonIgnore
    public Integer getCaseId() {
        return caseId;
    }

    @JsonProperty
    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public Phone getPhoneInfo() {
        return phoneInfo;
    }

    public void setPhoneInfo(Phone phoneInfo) {
        this.phoneInfo = phoneInfo;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
