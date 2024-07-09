package com.jeffer.contactlistapi.services;

import com.jeffer.contactlistapi.dto.ContactDTO;
import com.jeffer.contactlistapi.entity.Contact;
import com.jeffer.contactlistapi.exeption.ResourceNotFoundException;
import com.jeffer.contactlistapi.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;


import java.time.LocalDateTime;


@AllArgsConstructor
@Service
public class ContactService {



    private final ContactRepository contactRepository;

    public Iterable<Contact> findAll() {
        return contactRepository.findAll();
    }

    public Contact findById(Integer id) {
        return contactRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    public Contact create( ContactDTO contactDTO) {
        ModelMapper mapper = new ModelMapper();
        Contact contact = mapper.map(contactDTO, Contact.class);

        contact.setFechaRegistro(LocalDateTime.now());
        return contactRepository.save(contact);
    }

    public Contact update(Integer id,
                           ContactDTO contactDTO) {
        Contact contactFromDb = findById(id);

        contactFromDb.setNombre(contactDTO.getNombre());
        contactFromDb.setTelefono(contactDTO.getTelefono());
        contactFromDb.setCorreo(contactDTO.getCorreo());
        contactFromDb.setDireccion(contactDTO.getDireccion());

        return contactRepository.save(contactFromDb);
    }

    public ResponseEntity<String> delete(Integer id) {
        Contact contactFromDb = contactRepository.findById(id).orElse(null);
        if (contactFromDb != null) {
            contactRepository.delete(contactFromDb);
            return ResponseEntity.ok("Contacto eliminado correctamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

