import { Routes } from '@angular/router';

export const routes: Routes = [

{
    path:'',
    loadComponent: () => import('./contact-list/contact-list.component').then(m => m.ContactListComponent)

}, 
{
    path:'new',
    loadComponent: () => import('./contact-form/contact-form.component').then(m => m.ContactFormComponent)

},
{
    path:':id/edit',
    loadComponent: () => import('./contact-form/contact-form.component').then(m => m.ContactFormComponent)

}
];
