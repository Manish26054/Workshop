import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { FlightServiceService } from '../services/flight-service.service';

@Component({
  selector: 'app-flight-home',
  templateUrl: './flight-home.component.html',
  styleUrls: ['./flight-home.component.css']
})
export class FlightHomeComponent implements OnInit {
  flights:any;
  source:string='';
  destination:string='';
  date!:Date;
flag:boolean=false;








  constructor(private flightService: FlightServiceService,
    private router:Router) { }

  ngOnInit(): void {

  }
  searchForm=new FormGroup({

    source:new FormControl('',Validators.required),
    destination:new FormControl('',Validators.required),
    date:new FormControl('',Validators.required),
  
  })
Search(){
    console.log(this.source);
    console.log(this.destination);
    console.log(this.date);
    this.flightService.searchFlight(this.source,this.destination,this.date).subscribe((data)=>{
      console.log(data)
      this.flights=data;
      this.flag=true;
    })
    
  }
  loginRedirect(){
    this.router.navigate(['home/login']);
  }
}
