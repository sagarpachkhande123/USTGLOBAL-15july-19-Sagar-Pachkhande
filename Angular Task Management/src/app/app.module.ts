import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from "@angular/forms"; 
import {RouterModule } from '@angular/router';
import {HttpClientModule} from '@angular/common/http';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { AddtaskComponent } from './addtask/addtask.component';
import { ViewtaskComponent } from './viewtask/viewtask.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    AddtaskComponent,
    ViewtaskComponent
  ],
  imports: [
    BrowserModule
    ,FormsModule,HttpClientModule,
    RouterModule.forRoot([
      
      {path:'',component:AddtaskComponent},
      {path:'view' ,component:ViewtaskComponent},
     
      // {path:'*',component:}
     
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
