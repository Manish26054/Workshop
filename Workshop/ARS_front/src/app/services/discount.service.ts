import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DiscountService {
  private baseURL ="http://localhost:8081/flight"
  constructor(private http:HttpClient) { }


  getDiscount():Observable<any>{
    return this.http.get<any>(`${this.baseURL}`+'/getDiscount');
   }
 
   addDiscount(discount:any): Observable<any>{
 return this.http.post(`${this.baseURL}`+'/addDiscount',discount);
   }
 
   getDiscountById(id:number):Observable<any>{
 return this.http.get<any>(`${this.baseURL}`+'/getDiscountById/'+`${id}`);
   }
 
   updateDiscount(id:number,discount:any):Observable<any>{
     return this.http.put(`${this.baseURL}`+'/editDiscount/'+`${id}`,discount)
   }
 
   deleteDiscount(id:number):Observable<any>{
     return this.http.delete(`${this.baseURL}`+'/deleteDiscount/'+`${id}`);
   }




}
