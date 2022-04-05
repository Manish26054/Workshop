import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/app/utility/Employee';

@Component({
  selector: 'app-employee-detail',
  templateUrl: './employee-detail.component.html',
  styleUrls: ['./employee-detail.component.scss']
})
export class EmployeeDetailComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  employees:Employee[]=[
    {empId:26054,empName:"Manish Sahu",email:"manish@gmail.com",designation:"Trainee",flag:true},
    {empId:26055,empName:"Amit Kulkarni",email:"amit@gmail.com",designation:"Devops",flag:true},
    {empId:26056,empName:"Pratiksha",email:"pratiksha@gmail.com",designation:"QA",flag:true},
    {empId:26057,empName:"Jasbeer",email:"jessy@gmail.com",designation:"Manager",flag:true},
    {empId:26000,empName:"Shantanu",email:"shan@gmail.com",designation:"VP",flag:true}
  ]

  toggle(employee:Employee){
    employee.flag=! employee.flag;
  }

  toDate:Date=new Date();
  currency:number=275;
  name:string="Amrendra Bahubali";
}
