import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { FlightServiceService } from 'src/app/services/flight-service.service';
import { Flight } from 'src/app/utilities/flight';

@Component({
  selector: 'app-flight-add',
  templateUrl: './flight-add.component.html',
  styleUrls: ['./flight-add.component.css']
})
export class FlightAddComponent implements OnInit {

  flight:Flight=new Flight();
//  flight!:any;
  flightForm=new FormGroup({

    flightId:new FormControl('', Validators.required),
    flightName:new FormControl('', Validators.required),
    source:new FormControl('', Validators.required),
    date:new FormControl('', Validators.required),
    destination:new FormControl('', Validators.required),
    departureTime:new FormControl('', Validators.required),
    arrivalTime:new FormControl('', Validators.required),
    capacity:new FormControl('', Validators.required),
    price:new FormControl('', Validators.required),
  })
  constructor(private flightService: FlightServiceService,private router:Router) { }

  ngOnInit(): void {
  }


  // get flightName(){
  //   return this.flight.get('flightName');
  // }









  saveFlight(){
    this.flightService.addFlight(this.flight).subscribe(data=>{
      console.log(data);
      
    });
    console.log(this.flight);
            }

            goToFlightList(){
              this.router.navigate(['home/login/adminHome/flightList']);
            }
            onSubmit(){
              // console.table(this.flight.value);
              this.saveFlight();
             alert("Flight Added Succesfully");
             this.goToFlightList();
      };
}
