package ru.maxx129.models;

import lombok.*;
import ru.maxx129.forms.UserForm;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "owner")
    private List<Car> cars;

    public static User from(UserForm form) {

        return User.builder()
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .build();
    }





}
