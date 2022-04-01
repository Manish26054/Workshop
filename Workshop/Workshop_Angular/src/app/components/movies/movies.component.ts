import { Component, OnInit } from '@angular/core';
import { movies } from './mock-movieData';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.scss']
})
export class MoviesComponent implements OnInit {
  
  movies=movies;
  constructor() { }

  ngOnInit(): void {
  }

}
