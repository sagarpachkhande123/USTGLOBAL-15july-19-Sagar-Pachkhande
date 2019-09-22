import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule} from '@angular/router';

import {FormsModule} from '@angular/forms'
import { AppComponent } from './app.component';
import { AssiComponent } from './assi/assi.component';
import { AssiDetailsComponent } from './assi-details/assi-details.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './home/home.component';

//import { RegisterComponent } from './register/register.component';

//import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';

@NgModule({
  declarations: [
    AppComponent,
    AssiComponent,
    AssiDetailsComponent,
    NavbarComponent,
        HomeComponent,
   
   // RegisterComponent,
    
  
  ],
  imports: [
    BrowserModule,
    FormsModule,
    
    RouterModule.forRoot([
      {path: '', component: HomeComponent },
      { path:'assi', component: AssiComponent }, 
      
     // { path: 'register', component: RegisterComponent },

     

    ])
   
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
