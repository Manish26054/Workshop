import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-offers',
  templateUrl: './offers.component.html',
  styleUrls: ['./offers.component.css']
})
export class OffersComponent implements OnInit {

  flag:boolean=false;
  constructor() { }

  ngOnInit(): void {
  }
showAdd(){
  this.flag=! this.flag;
  
}
}
