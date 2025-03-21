package com.giuaky.ktragiuakyapi.Entity;

import com.giuaky.ktragiuakyapi.Product;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;




// Ten:Nguyen Hoai Tan
// MSSV: 22110413
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @Column(length = 255)
    private String description;

    @Column(length = 512)
    private String images;


    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> productList;
}
