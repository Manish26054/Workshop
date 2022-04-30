import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { DiscountService } from 'src/app/services/discount.service';
import { Discount } from 'src/app/utilities/discount';

@Component({
  selector: 'app-add-discount',
  templateUrl: './add-discount.component.html',
  styleUrls: ['./add-discount.component.css']
})
export class AddDiscountComponent implements OnInit {

  discount:Discount=new Discount();
  constructor(private discountService: DiscountService,private router:Router) { }

  ngOnInit(): void {
  }
 
 
 
  discountForm=new FormGroup({
    discountId: new FormControl(),
     discountName: new FormControl(),
      discountPrice: new FormControl(),
       discountCode: new FormControl(),
})

saveDiscount(){
  this.discountService.addDiscount(this.discount).subscribe(data=>{
console.log(data);
  })
}       


onSubmit(){
this.saveDiscount();
console.log(this.discount);
alert("Discount Added");
window.location.reload();
};

}
