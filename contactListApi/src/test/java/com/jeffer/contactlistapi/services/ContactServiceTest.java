package com.jeffer.contactlistapi.services;

import static org.assertj.core.api.Assertions.*;
import com.jeffer.contactlistapi.entity.Contact;
import com.jeffer.contactlistapi.repository.ContactRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class ContactServiceTest {

    @Autowired
    ContactRepository contactRepository;

    private Contact contact1;

    @BeforeEach
    void setup(){
        contact1 = new Contact("camilo", 21654621, "guzman@rubias19.com", "carrera");


    }

    @DisplayName("test para guardar un contacto")
    @Test
    void TestGuardarContac(){
        Contact contact = new Contact("jeffe", 3265416, "vergao1995@hot.com","carrera15");

        Contact contactGuardado = contactRepository.save(contact);

        assertThat(contactGuardado).isNotNull();
        assertThat(contactGuardado.getId()).isGreaterThan(0);
    }

    @DisplayName("test para listar contacto")
    @Test
    void listarContact(){
        Contact contact2 = new Contact("jefferson usley", 3265416, "vergao1995@hot.com","carrera15");
        contactRepository.save(contact1);
        contactRepository.save(contact2);

        List<Contact> listaContact = contactRepository.findAll();


        assertThat(listaContact).isNotNull();
        assertThat(listaContact.size()).isEqualTo(2);


    }

    @DisplayName("test para obtener contacto por id")
    @Test
    void TestObtenerContact(){
        contactRepository.save(contact1);

        Contact contactBD = contactRepository.findById(contact1.getId()).get();

        assertThat(contactBD).isNotNull();

    }
}

