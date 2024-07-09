package com.jeffer.contactlistapi.repository;

import com.jeffer.contactlistapi.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
