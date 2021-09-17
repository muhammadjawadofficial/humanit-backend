package se.humanit.sellshells.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "CASE_IMAGES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CaseImages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TYPE")
    private String type;

    @Lob
    @Column(name = "DATA")
    private byte[] data;

    @Column(name = "TYPE_NAME")
    private String typeName;

    @Column(name = "TYPE_ID")
    private Integer typeId;

    public CaseImages(String name, String type, byte[] data, String typeName, Integer typeId) {
        this.name = name;
        this.type = type;
        this.data = data;
        this.typeName = typeName;
        this.typeId = typeId;
    }
}
