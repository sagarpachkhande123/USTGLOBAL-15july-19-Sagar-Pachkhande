import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TaskserviceService {

  constructor(private http : HttpClient) { }

  taskInfo:any[] = [];

  sendData(data) {
    return this.http.post('http://localhost:4047/task/add',data);
  }

  getData(){
    return this.http.get('http://localhost:4047/task/get-all').subscribe(resData =>{
      console.log(resData);
      this.taskInfo = resData.tasks;
      console.log(this.taskInfo);
    },err=>{
      console.log(err);
    })
  }
  
  updateData(data) {
    return this.http.put('http://localhost:4047/task/modify',data);
  }

  deleteData(data) {
    return this.http.delete(`http://localhost:4047/task/remove/${data}`,data);
  }
}

