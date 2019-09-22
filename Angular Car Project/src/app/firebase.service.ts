import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {map} from 'rxjs/operators';
// import { User } from './users/user';

@Injectable({
  providedIn: 'root'
})
export class FirebaseService {
 
  
  constructor(public http: HttpClient
    ) { }

users=[];

  

  ngDoCheck()
          {
              // this.getData();
          }
    }