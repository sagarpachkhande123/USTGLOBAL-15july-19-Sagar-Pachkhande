import { Component, OnInit } from '@angular/core';
import { ServiceService } from '../service.service';

@Component({
  selector: 'app-addtask',
  templateUrl: './addtask.component.html',
  styleUrls: ['./addtask.component.css']
})
export class AddtaskComponent implements OnInit {

  constructor(private service: ServiceService) { }
  adddata(formdata){
  this.service.tasks.push(formdata);
    
    console.log(formdata)
  }

  ngOnInit() {
  }

}
