import { Component, OnInit } from '@angular/core';
import { chores } from './mock-chores-list';

@Component({
  selector: 'app-chores-list',
  templateUrl: './chores-list.component.html',
  styleUrls: ['./chores-list.component.scss']
})
export class ChoresListComponent implements OnInit {

  choresList=chores;
  constructor() { }

  ngOnInit(): void {
  }

}
