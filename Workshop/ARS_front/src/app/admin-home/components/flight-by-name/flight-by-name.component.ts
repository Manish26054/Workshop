import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FlightServiceService } from 'src/app/services/flight-service.service';

@Component({
  selector: 'app-flight-by-name',
  templateUrl: './flight-by-name.component.html',
  styleUrls: ['./flight-by-name.component.css']
})
export class FlightByNameComponent implements OnInit {


  flights:any;
  flightName:string='';
  flag:boolean=false;

  constructor(private flightService:FlightServiceService,private router: Router) { }

  ngOnInit(): void {
  }
  

  getFlightByName(flightName:string){
     this.flightService.getFlightByName(flightName).subscribe(data=>{
     this.flights=data;
     console.log(this.flights);
     this.flag=!this.flag;
    })
  }
}
