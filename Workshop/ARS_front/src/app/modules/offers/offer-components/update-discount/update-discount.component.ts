import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { DiscountService } from 'src/app/services/discount.service';
import { Discount } from 'src/app/utilities/discount';

@Component({
  selector: 'app-update-discount',
  templateUrl: './update-discount.component.html',
  styleUrls: ['./update-discount.component.css']
})
export class UpdateDiscountComponent implements OnInit {
  id:number=0;
  discount:Discount=new Discount();
  
  updateDiscountForm=new FormGroup({
    discountId: new FormControl(),
     discountName: new FormControl(),
      discountPrice: new FormControl(),
       discountCode: new FormControl(),
})
  constructor(private discountService:DiscountService,
    private activeroute: ActivatedRoute,
    private router:Router) { }

  ngOnInit(): void {
    this.id=this.activeroute.snapshot.params[`id`];
    this.discountService.getDiscountById(this.id).subscribe(data=>{
      this.discount=data;
    })
  }
  updateDiscount(){
    this.discountService.updateDiscount(this.id,this.discount).subscribe(data=>{
      
     })
  }
  onSubmit(){
  this.updateDiscount();
  alert("updated");
  this.router.navigate(['home/login/adminHome/offers']);
  }
}
