import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ContactsAndLocationsComponent } from './Components/contacts-and-locations/contacts-and-locations.component';

const routes: Routes = [
  {path: 'contacts', component: ContactsAndLocationsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
