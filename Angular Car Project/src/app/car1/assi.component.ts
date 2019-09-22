import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-assi',
  templateUrl: './assi.component.html',
  styleUrls: ['./assi.component.css']
})
export class AssiComponent implements OnInit {
  
  cars=[
    {
      brand: 'Fiza',
      img: 'http://hdwpro.com/wp-content/uploads/2016/08/Awesome-Latest-Cars.jpg',
      description: 'Lorem ipsum dolor sit amet consectetur, adipisicing elit. Accusantium sed earum esse voluptates consequuntur voluptas nostrum adipisci aut dolor totam.',
    },
    {
      brand: 'Geneva Motor',
      img: 'https://cdn.pixabay.com/photo/2012/02/27/17/08/sportscar-17583__340.jpg',
      description: 'Lorem ipsum dolor sit amet consectetur, adipisicing elit. Accusantium sed earum esse voluptates consequuntur voluptas nostrum adipisci aut dolor totam.',
    },
    {
      brand: 'Bentley',
      img: 'http://hdwpro.com/wp-content/uploads/2016/08/Awesome-Latest-Cars.jpg',
      description: 'Lorem ipsum dolor sit amet consectetur, adipisicing elit. Accusantium sed earum esse voluptates consequuntur voluptas nostrum adipisci aut dolor totam.',
    },
    {
      brand: 'lamborghini',
      img: 'https://cdn.pixabay.com/photo/2012/02/27/17/08/sportscar-17583__340.jpg',
      description: 'Lorem ipsum dolor sit amet consectetur, adipisicing elit. Accusantium sed earum esse voluptates consequuntur voluptas nostrum adipisci aut dolor totam.',
    },
  
  
 
  
  ]

  carData: any='';

sendCar(car)
{
this.carData = car;
}

  constructor() { }

  ngOnInit() {
  }

}
