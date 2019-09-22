import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-assi-details',
  templateUrl: './assi-details.component.html',
  styleUrls: ['./assi-details.component.css']
})
export class AssiDetailsComponent implements OnInit {
  @Input() carDetails: any = '';
  constructor() { }

  ngOnInit() {
  }

}
