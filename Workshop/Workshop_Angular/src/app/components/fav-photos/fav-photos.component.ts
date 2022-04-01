import { Component, OnInit } from '@angular/core';
import { photosUrl } from './mock-photo-data';

@Component({
  selector: 'app-fav-photos',
  templateUrl: './fav-photos.component.html',
  styleUrls: ['./fav-photos.component.scss']
})
export class FavPhotosComponent implements OnInit {

  images=photosUrl;
  constructor() { }

  ngOnInit(): void {
  }

}
