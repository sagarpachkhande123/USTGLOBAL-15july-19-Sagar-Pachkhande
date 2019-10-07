import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule} from '@angular/router'
import { HttpClientModule} from '@angular/common/http'
import {FormsModule} from '@angular/forms'

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { AddTaskComponent } from './add-task/add-task.component';
import { EditTaskComponent } from './edit-task/edit-task.component';
import { ShowAllComponent } from './show-all/show-all.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    PagenotfoundComponent,
    AddTaskComponent,
    EditTaskComponent,
    ShowAllComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot([
        {path:'',component:HeaderComponent}, 
        {path:'add',component:AddTaskComponent},
        {path:'edit',component:EditTaskComponent},
        {path:'show',component:ShowAllComponent},
        {path:'**',component:PagenotfoundComponent}
      
      ]),
      HttpClientModule,
      FormsModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
