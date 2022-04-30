import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DiscountService } from 'src/app/services/discount.service';
import { Discount } from 'src/app/utilities/discount';

@Component({
  selector: 'app-discount-list',
  templateUrl: './discount-list.component.html',
  styleUrls: ['./discount-list.component.css']
})
export class DiscountListComponent implements OnInit {
  discounts:any=[];
  constructor(private discountService:DiscountService,
    private router: Router) { }

  ngOnInit(): void {
  this.getAllDiscount();
  }

  private getAllDiscount(){
    this.discountService.getDiscount().subscribe((response: Discount[])=>{
      this.discounts=response;
    })
  }
  
    updateDiscount(id:number){
      this.router.navigate(['home/login/adminHome/offers/editDiscount',id])
    }
  deleteCur(id:number){
    this.deleteDiscount(id);
    alert("Discount deleted")
    window.location.reload();
  }
    deleteDiscount(id:number){
      this.discountService.deleteDiscount(id).subscribe(data=>{
        this.getAllDiscount();
      })
    }
}
