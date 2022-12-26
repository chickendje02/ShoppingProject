package com.excercise.productservice.model.orm;

import com.excercise.productservice.model.dto.ImageDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name = "image_sherwin")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageName;

    private String typeImage;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Image)) return false;
//        Image user = (Image) o;
//        return id != null && id.equals(user.getId());
//    }
//
//    @Override
//    public int hashCode() {
//        return 24;
//    }


}
