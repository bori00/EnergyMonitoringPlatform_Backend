package ro.tuc.ds2020.entities;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="person")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
public class Person {
    @Id
    @GeneratedValue
//    @GeneratedValue(generator = "uuid2")
//    @GenericGenerator(name = "uuid2", strategy = "uuid2")
//    @Type(type = "uuid-binary")
    private Long id;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "email_address", nullable = false)
    private String emailAddress;

    @Column(name = "password", nullable = false)
    private String password;

    public Long getId() {
        return id;
    }

    public Person(String userName, String emailAddress, String password) {
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person user = (Person) o;

        return id != null ? id.equals(user.id) : user.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}