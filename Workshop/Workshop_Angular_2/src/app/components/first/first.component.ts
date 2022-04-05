import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-first',
  templateUrl: './first.component.html',
  styleUrls: ['./first.component.scss']
})
export class FirstComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
msg = "Hello From First!!!";
path="https://www.w3schools.com/angular/angular_intro.asp"
  getMessage(){
    return this.msg;
  }
}
