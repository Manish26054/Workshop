import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FlightServiceService } from 'src/app/services/flight-service.service';

@Component({
  selector: 'app-flight-by-departure',
  templateUrl: './flight-by-departure.component.html',
  styleUrls: ['./flight-by-departure.component.css']
})
export class FlightByDepartureComponent implements OnInit {


  flights:any;
  flag:boolean=false;

  constructor(private flightService:FlightServiceService,
    router:Router) { }

  ngOnInit(): void {
  }

    FlightByMorning(){
       this.flightService.FlightByMorning().subscribe(data=>{
       this.flights=data;
       this.flag=!this.flag;
            })
      }
     
    FlightByNoon(){
        this.flightService.FlightByNoon().subscribe(data=>{
        this.flights=data;
        this.flag=!this.flag;
            })
      }

    FlightByEvening(){
        this.flightService.FlightByEvening().subscribe(data=>{
        this.flights=data;
        this.flag=!this.flag;
            })
      }
              
   FlightByNight(){
        this.flightService.FlightByNight().subscribe(data=>{
        this.flights=data;
        this.flag=!this.flag;
            })
      }

}
