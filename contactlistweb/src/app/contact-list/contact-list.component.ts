import { Component, inject, OnInit } from '@angular/core';
import { ContactService } from '../services/contact.service';
import { DatePipe } from '@angular/common';
import { RouterModule } from '@angular/router';
import { Contact } from '../model/contac.interface';

@Component({
  selector: 'app-contact-list',
  standalone: true,
  imports: [DatePipe, RouterModule],
  templateUrl: './contact-list.component.html',
  styleUrl: './contact-list.component.css'
})
export class ContactListComponent implements OnInit{
  private contactService = inject(ContactService);

  contacts: Contact[]= [];

  loadAll(){
    this.contactService.list()
    .subscribe(contacts =>{
      this.contacts = contacts;

    });
  }

  ngOnInit(): void {
    this.loadAll();
  }

  deleteContact(contac: Contact) {
    this.contactService.delete(contac.id)
      .subscribe(()=> {
        this.loadAll();
      });
  }




}
