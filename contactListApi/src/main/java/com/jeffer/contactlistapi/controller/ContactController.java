package com.jeffer.contactlistapi.controller;


import com.jeffer.contactlistapi.dto.ContactDTO;
import com.jeffer.contactlistapi.entity.Contact;
import com.jeffer.contactlistapi.services.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/api/contacts")
public class ContactController {


    private final ContactService contactService;


    @GetMapping
    public Iterable<Contact> list() {
        return contactService.findAll();
    }

    @GetMapping("{id}")
    public Contact get(@PathVariable Integer id) {
        return contactService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Contact create(@Validated @RequestBody ContactDTO contactDTO) {
        return contactService.create(contactDTO);

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("{id}")
    public Contact update(@PathVariable Integer id,
                          @Validated @RequestBody ContactDTO contactDTO) {
            return contactService.update(id, contactDTO);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        contactService.delete(id);

    }

    }