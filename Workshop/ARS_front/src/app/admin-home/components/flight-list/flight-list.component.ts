import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FlightServiceService } from 'src/app/services/flight-service.service';
import { Flight } from 'src/app/utilities/flight';

@Component({
  selector: 'app-flight-list',
  templateUrl: './flight-list.component.html',
  styleUrls: ['./flight-list.component.css']
})
export class FlightListComponent implements OnInit {

  flights:Flight[]=[];
flag:boolean=true;
  constructor(private flightService:FlightServiceService,
   private router:Router) { }

  ngOnInit(): void {
    this.getAllFlight();
  }
  private getAllFlight()  {
    this.flightService.getFlight().subscribe((response: Flight[])=>{
      this.flights=response;
       });
  }

  updateFlight(id:number){
    this.router.navigate(['home/login/adminHome/editFlight',id])
  }
  deleteCur(id:number){
    this.deleteFlight(id);
    alert("Deleted Succesfully");
    window.location.reload();

  }

  deleteFlight(id:number){
    this.flightService.deleteFlight(id).subscribe(data=>{
      
      this.getAllFlight();
    })
  }

  noFlightList(){
    this.flag=false;
  }
  flightList(){
    this.flag=true;
    this.router.navigate(['adminhome']);
  }
}
