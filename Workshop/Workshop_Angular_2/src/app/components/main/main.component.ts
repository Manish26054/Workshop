import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss']
})
export class MainComponent implements OnInit {
  value:string="sometext";
  num=5;
  constructor() { }
  sayHello(){
    alert("Hii User");
  }
  showMe=true;
  ngOnInit(): void {
  }

}
