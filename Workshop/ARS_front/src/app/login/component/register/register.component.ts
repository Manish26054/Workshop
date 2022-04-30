import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/app/utilities/user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user=new User();
  users:any;
  message!:string;
  email!:string;

  registrationForm=new FormGroup(
    {
     firstName: new FormControl('', Validators.required),
     lastName: new FormControl('', Validators.required),
     email: new FormControl('',[Validators.email,Validators.pattern("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")]),
     password: new FormControl('', Validators.required),
     contact: new FormControl('', Validators.required),
     gender:new FormControl('', Validators.required),
  }
  );
  constructor(private userService: UserService,private _route:Router) { }

  ngOnInit(): void {
   
  }
  
  formSubmit()
  {
    this.userService.registerUser(this.user).subscribe((data:any)=>{
      //success
      this.message="Registration succesfull !!!";
      setTimeout(() => {
        this._route.navigate(['/login']);
      }, 3000); 
      
    },
    //error
    (error)=>{
     console.log(error.message)
      this.message="Invalid form fillup, try again !!!";
      this._route.navigate(['/register']);
    }
    )
  };

  


}
