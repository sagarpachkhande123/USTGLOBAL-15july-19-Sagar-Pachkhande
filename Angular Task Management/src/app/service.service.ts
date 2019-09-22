import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor() { }
  tasks:any[]=[];

  getdata(data){
    this.tasks=data;
    return data;
  }
}
