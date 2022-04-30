import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { DiscountService } from 'src/app/services/discount.service';
import { FlightServiceService } from 'src/app/services/flight-service.service';
import { Discount } from 'src/app/utilities/discount';

@Component({
  selector: 'app-user-search',
  templateUrl: './user-search.component.html',
  styleUrls: ['./user-search.component.css']
})
export class UserSearchComponent implements OnInit {

  flights:any;
  source:string='';
  destination:string='';
  date!:Date;
flag:boolean=false;
discounts:any=[];
  constructor(private flightService: FlightServiceService,private discountService:DiscountService,
    private router:Router) { }

  ngOnInit(): void {
    this.getAllDiscount();
  }

  private getAllDiscount(){
    this.discountService.getDiscount().subscribe((response: Discount[])=>{
      this.discounts=response;
    })
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
  bookingRedirect(id:number){
    this.router.navigate(['home/login/userHome/bookingForm',id]);
  }

}
