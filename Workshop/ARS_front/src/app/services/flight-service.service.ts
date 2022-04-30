import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable} from 'rxjs';
import { Flight } from '../utilities/flight';


@Injectable({
  providedIn: 'root'
})
export class FlightServiceService {
 
  private baseURL ="http://localhost:8081/flight"

  constructor(private http : HttpClient) { }

  getFlight():Observable<Flight[]>{
    return this.http.get<Flight[]>(`${this.baseURL}`+'/getFlight');
   }
 
   addFlight(flight:Flight): Observable<any>{
 return this.http.post(`${this.baseURL}`+'/addFlight',flight);
   }
 
   getFlightById(id:number):Observable<Flight>{
 return this.http.get<Flight>(`${this.baseURL}`+'/getFlightById/'+`${id}`);
   }
 
   updateFlight(id:number,flight:Flight):Observable<any>{
     return this.http.put(`${this.baseURL}`+'/editFlight/'+`${id}`,flight)
   }
 
   deleteFlight(id:number):Observable<any>{
     return this.http.delete(`${this.baseURL}`+'/deleteFlight/'+`${id}`);
   }
   
   searchFlight(source:string,destination:string,date:Date):Observable<any>{
   return this.http.get<any>(`${this.baseURL}`+'/searchFlight?source='+source+'&destination='+destination+'&date='+date);
   }
   
   getFlightByName(flightName:string):Observable<any>{
    return this.http.get<any>(`${this.baseURL}`+'/getFlightByName/'+flightName)
   }

   FlightByMorning():Observable<any>{
    return this.http.get<any>(`${this.baseURL}`+'/FlightByMorning')
   }
   
   FlightByNoon():Observable<any>{
    return this.http.get<any>(`${this.baseURL}`+'/FlightByNoon')
   }
   
   FlightByEvening():Observable<any>{
    return this.http.get<any>(`${this.baseURL}`+'/FlightByEvening')
   }
   
   FlightByNight():Observable<any>{
    return this.http.get<any>(`${this.baseURL}`+'/FlightByNight')
   }


}
