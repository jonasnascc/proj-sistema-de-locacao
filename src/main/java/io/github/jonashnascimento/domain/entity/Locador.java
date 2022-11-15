package io.github.jonashnascimento.domain.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Locador extends Usuario{
    @JsonIgnore
    @OneToMany(mappedBy = "locador")
    private List<Locacao> objetosLocados;

}
