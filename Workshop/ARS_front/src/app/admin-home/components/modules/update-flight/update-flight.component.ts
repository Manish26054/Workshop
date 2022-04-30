import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { FlightServiceService } from 'src/app/services/flight-service.service';
import { Flight } from 'src/app/utilities/flight';

@Component({
  selector: 'app-update-flight',
  templateUrl: './update-flight.component.html',
  styleUrls: ['./update-flight.component.css']
})
export class UpdateFlightComponent implements OnInit {

  id:number=0;
  flight:Flight=new Flight();

  constructor(private flightService:FlightServiceService,
    private activeroute: ActivatedRoute,
    private router:Router) { }

    updateFlightForm=new FormGroup({
      flightId: new FormControl('', Validators.required),
      flightName:new FormControl('', Validators.required),
      source:new FormControl('', Validators.required),
      date:new FormControl('', Validators.required),
      destination:new FormControl('', Validators.required),
      departureTime:new FormControl('', Validators.required),
      arrivalTime:new FormControl('', Validators.required),
      capacity:new FormControl('', Validators.required),
      price:new FormControl('', Validators.required),
    })
  ngOnInit(): void {
    this.id=this.activeroute.snapshot.params[`id`];
    this.flightService.getFlightById(this.id).subscribe(data=>{
      this.flight=data;
    })
 }

 goToFlightList(){
  this.router.navigate(['home/login/adminHome/flightList']);
}
updateFlight(){
  this.flightService.updateFlight(this.id,this.flight).subscribe(data=>{
   
  })
}
  onSubmit(){
    this.updateFlight();
    alert("Updated Succesfully");
    this.goToFlightList();
    // window.location.reload();
    
  }
}
