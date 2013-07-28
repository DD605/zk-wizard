package be.scorgar.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import be.scorgar.demo.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
